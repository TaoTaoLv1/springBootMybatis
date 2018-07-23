package com.ywt;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringDatasourceConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource creatDatasource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        return druidDataSource;
    }
}
