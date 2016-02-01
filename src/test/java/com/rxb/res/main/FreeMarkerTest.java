package com.rxb.res.main;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.util.*;

/**
 * Created by rxb on 2016/1/30.
 */
public class FreeMarkerTest {
    private Configuration config;
    private Template template;
    private Map<String, Object> map = new HashMap<>();

    @Before
    public void init() throws IOException {
        config = new Configuration(Configuration.VERSION_2_3_23);
        String path = this.getClass().getResource("/").getPath().replaceAll("%20"," ");
        File file = new File(path+"template");
        config.setDirectoryForTemplateLoading(file);
    }

    /**
     * 通过String来创建模版对象，并执行插值处理
     * @throws IOException
     * @throws TemplateException
     */
    @Test
    public void testString() throws IOException, TemplateException {
        template = new Template(null, new StringReader("用户名：${user};URL：    ${url};姓名： 　${name}"), null);
        map.put("user", "tom123");
        map.put("url", "www.baidu.com");
        map.put("name", "百度");
    }

    /**
     * 通过文件来创建模版对象，并执行插值操作
     * @throws IOException
     * @throws TemplateException
     */
    @Test
    public void testFile() throws IOException, TemplateException {
        template = config.getTemplate("test.ftl");
        map.put("user", "tom123");
        map.put("url", "www.baidu.com");
        map.put("name", "百度");
    }

    @Test
    public void testList() throws IOException {
        template = config.getTemplate("list.ftl");
        List<String> itemList = Arrays.asList("hello", "world");
        map.put("itemList",itemList);
    }

    @Test
    public void testMap() throws IOException {
        template = config.getTemplate("map.ftl");

        Map<String, Object> user = new HashMap<>();
        user.put("name", "李四");

        Map<String, Object> data = new HashMap<>();
        data.put("age", 10);
        data.put("birthday", new Date());
        user.put("data", data);

        map.put("user", user);
    }

    @After
    public void print() throws IOException, TemplateException {
        if (template != null) {
            template.process(map, new OutputStreamWriter(System.out));
        }
    }
}
