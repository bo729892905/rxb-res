package com.rxb.res.common.util;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectResult;
import com.rxb.res.common.SystemConfig;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Date;

/**
 * 阿里云OSS工具类
 * Created by rxb on 2016/1/17.
 */
public class OSSObjectUtil {
    private OSSClient client;

    private OSSObjectUtil() {
        client =  new OSSClient(SystemConfig.endpoint, SystemConfig.accessKeyId, SystemConfig.secretAccessKey);
    }

    private static class LazyHolder {
        private final static OSSObjectUtil INSTANCE = new OSSObjectUtil();
    }

    public static OSSObjectUtil getInstance() {
        return LazyHolder.INSTANCE;
    }

    public String uploadFile(String key, String bucketName, String contentType, File file)
            throws OSSException, ClientException, FileNotFoundException {
        ObjectMetadata objectMeta = new ObjectMetadata();
        objectMeta.setContentLength(file.length());
        objectMeta.setContentType(contentType);

        InputStream input = new FileInputStream(file);

        PutObjectResult putObjectResult = client.putObject(bucketName, key, input, objectMeta);
        return putObjectResult.getETag();
    }

    public String uploadFile(String bucketName, MultipartFile file) throws IOException {
        // 获取指定文件的输入流
        InputStream input = file.getInputStream();

        // 创建上传Object的Metadata
        ObjectMetadata meta = new ObjectMetadata();
        // 必须设置ContentLength
        meta.setContentLength(file.getSize());
        meta.setContentType(file.getContentType());

        String originalFilename = file.getOriginalFilename();
        String suffix = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);

        String key = (new Date().getTime()) + "." + suffix;

        // 上传Object.
        client.putObject(bucketName, key, input, meta);
        return key;
    }
}