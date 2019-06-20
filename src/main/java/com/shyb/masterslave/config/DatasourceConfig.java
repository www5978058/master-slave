package com.shyb.masterslave.config;

import com.shyb.masterslave.datasource.DbType;
import com.shyb.masterslave.datasource.DynamicDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wzh
 * @date 2019/6/11 - 10:32
 */
@Configuration
public class DatasourceConfig {

    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource.datasource-user")
    public DataSource dataSourceUser() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.datasource-user-read")
    public DataSource dataSourceUserRead() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.datasource-order")
    public DataSource dataSourceOrder() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.datasource-order-read")
    public DataSource dataSourceOrderRead() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public DynamicDataSource dynamicDataSource(@Qualifier("dataSourceUser") DataSource dataSourceUser,
                                               @Qualifier("dataSourceUserRead") DataSource dataSourceUserRead,
                                               @Qualifier("dataSourceOrder") DataSource dataSourceOrder,
                                               @Qualifier("dataSourceOrderRead") DataSource dataSourceOrderRead) {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        Map<Object, Object> targetDataSource = new HashMap<Object, Object>();
        targetDataSource.put(DbType.DATASOURCE_USER,dataSourceUser);
        targetDataSource.put(DbType.DATASOURCE_USER_READ,dataSourceUserRead);
        targetDataSource.put(DbType.DATASOURCE_ORDER,dataSourceOrder);
        targetDataSource.put(DbType.DATASOURCE_ORDER_READ,dataSourceOrderRead);
        dynamicDataSource.setTargetDataSources(targetDataSource);
        dynamicDataSource.setDefaultTargetDataSource(dataSourceUser);
        return dynamicDataSource;
    }
}
