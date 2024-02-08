package com.trainning.module1.practical.task.datasource;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class H2DatabaseConfig {
    @Bean
    @ConditionalOnProperty(name = "custom.datasource.enabled", havingValue = "true", matchIfMissing = true)
    public DataSource h2DatabaseBeanConfig(DataSourceProperties dsp){
        return DataSourceBuilder
                .create()
                .driverClassName(dsp.getDriverClassName())
                .url(dsp.getUrl())
                .username(dsp.getUsername())
                .password(dsp.getPassword())
                .build();
    }

}
