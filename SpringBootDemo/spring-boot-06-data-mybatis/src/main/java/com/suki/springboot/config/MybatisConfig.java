package com.suki.springboot.config;


import org.apache.ibatis.session.Configuration;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class MybatisConfig {

    @Bean
    public ConfigurationCustomizer configurationCustomizer(){
        return new ConfigurationCustomizer() {
            @Override
            public void customize(Configuration configuration) {
                // 针对数据库和javabean 如数据库中xxx_xx就可以对应javabean中xxxXX
                configuration.setMapUnderscoreToCamelCase(true);  // 开启驼峰命名法
            }
        };
    }

}
