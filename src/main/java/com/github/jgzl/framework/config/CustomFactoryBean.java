package com.github.jgzl.framework.config;

import org.springframework.beans.factory.FactoryBean;

public class CustomFactoryBean implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        return null;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }
}
