package com.rxb.res.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectResult;

@Controller
public class TestController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private final static String BUCKET_NAME="rxb";

	@RequestMapping(value = "test", method = RequestMethod.GET)
	public ModelAndView test() {
		Subject subject = SecurityUtils.getSubject();
		String userInfo = (String) subject.getSession().getAttribute("userInfo");

		logger.debug(userInfo);

		return new ModelAndView("test");
	}

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public ModelAndView login() {
		SecurityUtils.getSecurityManager().logout(SecurityUtils.getSubject());

		UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");
		Subject subject = SecurityUtils.getSubject();
		subject.login(token);
		subject.getSession().setAttribute("userInfo", "zhang");

		logger.debug("登录成功！");

		return new ModelAndView("login");
	}

	@RequestMapping(value = "converter", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> testConverter() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("username", "admin");
		map.put("age", 24);
		return map;
	}

	@RequestMapping("download")
	public ResponseEntity<byte[]> download() throws IOException {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		headers.setContentDispositionFormData("attachment", "dict.txt");
		byte[] b = "hello".getBytes();

		return new ResponseEntity<byte[]>(b, headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "download1", produces = { "application/octet-stream;charset=utf-8" })
	public @ResponseBody byte[] download1(HttpServletResponse response) throws IOException {
		response.setHeader("Content-Disposition", "attachment;filename=dict.txt");
		byte[] b = "hello".getBytes();
		return b;
	}

	@RequestMapping(value = "pic", produces = { "image/jpeg" })
	public void pic(HttpServletResponse response) {
		String accessKeyId = "nS6RPhAEx1M2gC6k";
		String secretAccessKey = "wrOZDHCq2NOx03sc0AVtgw5T4rjV4s";
		String endpoint = "http://oss-cn-beijing.aliyuncs.com";
		OSSClient client = new OSSClient(endpoint, accessKeyId, secretAccessKey);
		OSSObject object = client.getObject("rxb", "test1.jpg");

		InputStream input = null;
		OutputStream output = null;
		try {
			input = object.getObjectContent();
			output = response.getOutputStream();
			byte[] buffer = new byte[4096];
			int n = 0;
			while (-1 != (n = input.read(buffer))) {
				output.write(buffer, 0, n);
				output.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (input != null) {
					input.close();
				}
				if (output != null) {
					output.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@RequestMapping(value = "pic1", produces = { "image/jpeg" })
	public @ResponseBody byte[] pic1() {
		OSSClient client = getClient();
		OSSObject object = client.getObject("rxb", "test1.jpg");

		InputStream input = null;
		ByteArrayOutputStream output = null;
		try {
			input = object.getObjectContent();
			output = new ByteArrayOutputStream();
			byte[] buffer = new byte[4096];
			int n = 0;
			while (-1 != (n = input.read(buffer))) {
				output.write(buffer, 0, n);
				output.flush();
			}
			return output.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
			return new byte[0];
		} finally {
			try {
				if (input != null) {
					input.close();
				}
				if (output != null) {
					output.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@RequestMapping(value = "upload", method = RequestMethod.POST)
	public void upload(@RequestParam MultipartFile file, HttpServletResponse response) {
		String contentType = file.getContentType();
		response.setContentType(contentType);
		InputStream input = null;
		OutputStream output = null;
		try {
			OSSClient client = getClient();
			putObject(client,file);
			input = file.getInputStream();
			output = response.getOutputStream();
			byte[] buffer = new byte[4096];
			int n = 0;
			while (-1 != (n = input.read(buffer))) {
				output.write(buffer, 0, n);
				output.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (input != null) {
					input.close();
				}
				if (output != null) {
					output.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public @ResponseBody String testConverter(Map<String,Object> map) {
		return "success";
	}
	
	private OSSClient getClient(){
		String accessKeyId="nS6RPhAEx1M2gC6k";
		String secretAccessKey="wrOZDHCq2NOx03sc0AVtgw5T4rjV4s";
		String endpoint="http://oss-cn-beijing.aliyuncs.com";
		OSSClient client=new OSSClient(endpoint, accessKeyId, secretAccessKey);
		return client;
	}
	
	private void putObject(OSSClient client,MultipartFile file) throws IOException {
	    // 获取指定文件的输入流
	    InputStream input = file.getInputStream();
	    
	    // 创建上传Object的Metadata
	    ObjectMetadata meta = new ObjectMetadata();
	    // 必须设置ContentLength
	    meta.setContentLength(file.getSize());
	    meta.setContentType(file.getContentType());
	    
	    String originalFilename=file.getOriginalFilename();
		logger.debug(originalFilename+"图片上传阿里云...");
		String suffix=originalFilename.substring(originalFilename.lastIndexOf(".")+1);
	    
	    String key=(new Date().getTime())+"."+suffix;

	    // 上传Object.
	    PutObjectResult result = client.putObject(BUCKET_NAME, key, input, meta);
	    logger.debug(originalFilename+" "+result.getETag()+" 图片上传成功！");
	}
}
