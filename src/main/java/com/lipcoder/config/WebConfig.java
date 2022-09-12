package com.lipcoder.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * .xml의 역할을 대신하는 클래스이다.
 * 해당 정보에 따라 스프링 설정이 세팅된다.
 */
public class WebConfig
        //extends AbstractAnnotationConfigDispatcherServletInitializer
    {

    //@Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    //@Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }

    //@Override
    protected String[] getServletMappings() {
        return null;
    }
}
