package com.wangzhao.springboot.config;

import com.wangzhao.springboot.component.LoginHandlerInterceptor;
import com.wangzhao.springboot.component.MyLocaleResolver;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//使用WebMvcConfigurerAdapter可以来扩展SpringMVC的功能
//@EnableWebMvc
@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //浏览器发送 haha 请求，来到 success 页面
        registry.addViewController("/haha").setViewName("success");

    }

    @Bean
    //将组件注册在容器中，才能起作用
    //所有的WebMvcConfigurerAdapter组件都会在一起起作用
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {

                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
            }

            //注册拦截器
            public void addInterceptors(InterceptorRegistry registry){
                //静态资源：*.css,*.js
                //SpringBoot 已经做好了静态资源映射
                /*registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/","/index.html","/user/login");*/
            }
        };

        return adapter;
    }

    @Bean
    public LocaleResolver localeResolver(){


        return new MyLocaleResolver();
    }
}

