package com.rxb.res.web.controller;

import com.rxb.res.common.util.OSSObjectUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
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

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

@Controller
public class TestController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value = "test", method = RequestMethod.GET)
	public ModelAndView test() {
		Subject subject = SecurityUtils.getSubject();
		String userInfo = (String) subject.getSession().getAttribute("userInfo");

		logger.debug(userInfo);

		return new ModelAndView("test");
	}

	@RequiresPermissions("converter")
	@RequestMapping(value = "converter")
	public @ResponseBody Map<String, Object> testConverter() {
		Map<String, Object> map = new HashMap<>();
		map.put("username", "admin");
		map.put("age", 24);
		return map;
	}

	@RequestMapping("download")
	public ResponseEntity<byte[]> download() throws IOException {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		String name = new String("测试".getBytes(),"iso-8859-1");
		headers.setContentDispositionFormData("attachment", name + ".txt");
		byte[] b = "hello!你好".getBytes();

		return new ResponseEntity<>(b, headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "download1", produces = { "application/octet-stream;charset=utf-8" })
	public @ResponseBody byte[] download1(HttpServletResponse response) throws IOException {
		String name = new String("测试".getBytes(),"iso-8859-1");
		response.setHeader("Content-Disposition", "attachment;filename=\""+name+".txt\"");
		return "hello".getBytes();
	}

	@RequiresPermissions("permission:upload")
	@RequestMapping(value = "upload", method = RequestMethod.POST)
	public void upload(@RequestParam MultipartFile file, HttpServletResponse response) {
		String contentType = file.getContentType();
		response.setContentType(contentType);
		InputStream input = null;
		OutputStream output = null;
		try {
			String key= OSSObjectUtil.getInstance().uploadFile("rxb",file);
			response.setHeader("Content-Disposition", "inline;filename="+key);
			input = file.getInputStream();
			output = response.getOutputStream();
			byte[] buffer = new byte[4096];
			int n;
			while (-1 != (n = input.read(buffer))) {
				output.write(buffer, 0, n);
				output.flush();
			}
		} catch (Exception e) {
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
		map.put("name", "tom");
		return "success";
	}
}
