package com.itliusir.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.core.task.SimpleAsyncTaskExecutor;

/**
 * 事件Demo
 *
 * @author liugang
 * @since 2018-08-28
 */
@Slf4j
@SpringBootApplication
public class SpringEventDemoApplication {

    /**
     * 配置异步线程池
     *
     * @author liugang 2018-08-29
     */
    @Bean
    public SimpleAsyncTaskExecutor simpleAsyncTaskExecutor() {
        return new SimpleAsyncTaskExecutor();
    }

    /**
     * 配置Spring事件使用异步线程池
     *
     * @author liugang 2018-08-29
     */
    @Bean(name = AbstractApplicationContext.APPLICATION_EVENT_MULTICASTER_BEAN_NAME)
    public SimpleApplicationEventMulticaster simpleApplicationEventMulticaster(ConfigurableListableBeanFactory configurableListableBeanFactory) {
        SimpleApplicationEventMulticaster simpleApplicationEventMulticaster = new SimpleApplicationEventMulticaster(configurableListableBeanFactory);
        simpleApplicationEventMulticaster.setTaskExecutor(simpleAsyncTaskExecutor());
        return simpleApplicationEventMulticaster;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringEventDemoApplication.class, args);
    }
}
