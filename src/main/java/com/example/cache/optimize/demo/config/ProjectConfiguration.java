package com.example.cache.optimize.demo.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
public class ProjectConfiguration {
    @Bean
    public DataSource getDataSource() {
        /**
         * spring.datasource.url=jdbc:mysql://localhost:3306/vivo?serverTimezone=GMT%2B8
         * spring.datasource.username=root
         * spring.datasource.password=root
         * spring.datasource.driver-class-name=com.mysql.jdbc.Driver
         * spring.datasource.type=com.alibaba.druid.pool.DruidDataSource
         */
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("com.mysql.jdbc.Driver");
        dataSourceBuilder.url("jdbc:mysql://localhost:3306/vivo?serverTimezone=GMT%2B8");
        dataSourceBuilder.username("root");
        dataSourceBuilder.password("root");
        dataSourceBuilder.type(DruidDataSource.class);

        DruidDataSource build =(DruidDataSource)dataSourceBuilder.build();
        try {
            build.addFilters("stat,log4j");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return build;

    }
}
