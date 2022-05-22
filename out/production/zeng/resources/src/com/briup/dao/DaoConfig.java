package com.briup.dao;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:dateSource.properties")
@MapperScan("com.briup.dao")
public class DaoConfig {
    @Value("${jdbc.driverClassName}")
    private String driverClassName;
    @Value("${jdbc.url)")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("#{jdbc.password")
    private String password;

    //    配置数据源
    @Bean
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
        dataSource.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:XE");
        dataSource.setUsername("briup");
        dataSource.setPassword("briup");
        dataSource.setInitialSize(5);
        dataSource.setMaxActive(10);
        return dataSource;
    }

    //    配置SqlsessionFactoryBean
    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean() {
        PathMatchingResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource((dataSource()));
        sqlSessionFactoryBean.setTypeAliasesPackage("com.briup.bean");

        sqlSessionFactoryBean.setMapperLocations(resourcePatternResolver.getResource("classpath:com/briup/mapper/*Mapper.xml"));
        return sqlSessionFactoryBean;
    }

        @Bean
        public DataSourceTransactionManager dataSourceTransactionManager () {
            DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
            transactionManager.setDataSource(dataSource());
            return transactionManager;
        }

}
