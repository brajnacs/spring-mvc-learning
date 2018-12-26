package com.ith.betta.web.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses(){
        return new Class[] {WebMvcConfig.class, SecurityConfig.class, JPAConfig.class, RepositoryConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses(){
        return new Class[] {WebMvcConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
}
