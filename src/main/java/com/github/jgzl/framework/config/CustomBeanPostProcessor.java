package com.github.jgzl.framework.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author lihaifeng,li7hai26@gmail.com
 * <p>{@link com.github.jgzl.framework.config.CustomBeanFactoryPostProcessor}
 * <p><h1>{@code StringUtils.isNotEmpty("1234")}</h1>
 * @since 1.8
 * @version 1.0
 */
@Slf4j
@Component
public class CustomBeanPostProcessor implements BeanPostProcessor {

    /** 重量{@value QUANTITY} */
    private static final Integer QUANTITY = 1;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        log.info("自定义CustomBeanPostProcessor的postProcessBeforeInitialization-->{}:{}",bean,beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log.info("自定义CustomBeanPostProcessor的postProcessAfterInitialization-->{}:{}",bean,beanName);
        return bean;
    }
}
