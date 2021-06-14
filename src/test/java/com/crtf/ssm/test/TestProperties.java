package com.crtf.ssm.test;

import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author crtf
 * @version V1.0
 * @className TestProperties
 * @description
 * @date 21.6.12 23:44
 */
public class TestProperties {

    @Test
    public void test() throws IOException {
        Properties properties = new Properties();

        properties.setProperty("key","value");
        properties.put("log.path","D:\\Learn\\Study\\Java\\SpringAndSpringMVCAndMyBatis\\SpringAndSpringMVCAndMyBatis\\log");
        properties.storeToXML(new FileOutputStream(
                new File("D:\\Learn\\Study\\Java\\SpringAndSpringMVCAndMyBatis\\SpringAndSpringMVCAndMyBatis\\src\\main\\resources\\config.xml"),
                false),"crtf");
    }

    @Test
    public void test0(){
        System.out.println(new File("./log").getAbsolutePath());
    }
}

