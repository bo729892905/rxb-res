package com.rxb.res.aliyun.oss;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import com.aliyun.oss.ClientConfiguration;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.Bucket;
import com.aliyun.oss.model.CannedAccessControlList;
import com.aliyun.oss.model.OSSObjectSummary;
import com.aliyun.oss.model.ObjectListing;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectResult;

public class OSSClientTest {

	public static void main(String[] args) throws FileNotFoundException{
		
		String accessKeyId="nS6RPhAEx1M2gC6k";
		String secretAccessKey="wrOZDHCq2NOx03sc0AVtgw5T4rjV4s";
		String endpoint="http://oss-cn-beijing.aliyuncs.com";
		
		//新建ClientConfigration实例，配置代理地址为本地9090端口
		ClientConfiguration config=new ClientConfiguration();
		config.setProxyHost("127.0.0.1");
		config.setProxyPort(9090);
		
		//设置用户名和密码
		config.setProxyUsername("username");
		config.setProxyPassword("password");
		
		// 设置HTTP最大连接数为10
		config.setMaxConnections(10);

		// 设置TCP连接超时为5000毫秒
		config.setConnectionTimeout(5000);

		// 设置最大的重试次数为3
		config.setMaxErrorRetry(3);

		// 设置Socket传输数据超时的时间为2000毫秒
		config.setSocketTimeout(2000);
		
		OSSClient client=new OSSClient(endpoint, accessKeyId, secretAccessKey);
		//OSSClient client=new OSSClient(endpoint, accessKeyId, secretAccessKey,config);
		
		//client.createBucket("renxiaobo");
		//client.createBucket("rxb");
		client.setBucketAcl("rxb",CannedAccessControlList.PublicReadWrite);
		
		// 获取用户的Bucket列表
		List<Bucket> buckets = client.listBuckets();
		
		// 遍历Bucket
		for (Bucket bucket : buckets) {
		    System.out.println(bucket.getName());
		}
		
		//putObject(client,"rxb","test3.jpg","d:/test.jpg");
		//client.deleteObject("rxb", "test3.jpg");
		
		// 获取指定bucket下的所有Object信息
	    ObjectListing listing = client.listObjects("rxb");

	    // 遍历所有Object
	    for (OSSObjectSummary objectSummary : listing.getObjectSummaries()) {
	        System.out.println(objectSummary.getKey());
	    }
	}
	
	public static void putObject(OSSClient client,String bucketName, String key, String filePath) throws FileNotFoundException {
	    // 获取指定文件的输入流
	    File file = new File(filePath);
	    InputStream input = new FileInputStream(file);
	    
	    // 创建上传Object的Metadata
	    ObjectMetadata meta = new ObjectMetadata();
	    // 必须设置ContentLength
	    meta.setContentLength(file.length());
	    meta.setContentType("image/jpeg");

	    // 上传Object.
	    PutObjectResult result = client.putObject(bucketName, key, input, meta);

	    // 打印ETag
	    System.out.println(result.getETag());
	}

}
