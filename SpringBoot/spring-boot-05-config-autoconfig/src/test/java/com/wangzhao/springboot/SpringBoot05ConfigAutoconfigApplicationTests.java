package com.wangzhao.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest

public class SpringBoot05ConfigAutoconfigApplicationTests {

    @Autowired
    WebApplicationContext applicationContext;

    @Test
    public void contextLoads() {
        System.out.println(applicationContext);
        String[] names = applicationContext.getBeanDefinitionNames();
        System.out.println(names.length);

        for(String name : names){
            System.out.println(name);
        }
    }

}
