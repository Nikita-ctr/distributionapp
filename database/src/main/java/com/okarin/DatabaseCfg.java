package com.okarin;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource({"classpath:db.properties"})
public class DatabaseCfg {

    @Value( "${spring.datasource.url}" )
    private String jdbcUrl;

    @Value( "${spring.datasource.driver-class-name}" )
    private String jdbcClassName;

    @Value( "${spring.datasource.username}" )
    private String username;

    @Value( "${spring.datasource.password}" )
    private String password;

//    @Bean
//    @Profile("!test")
//    public DataSource getDataSource() {
//        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
//        dataSourceBuilder.driverClassName(jdbcClassName);
//        dataSourceBuilder.url(jdbcUrl);
//        dataSourceBuilder.username(username);
//        dataSourceBuilder.password(password);
//        return dataSourceBuilder.build();
//    }
}