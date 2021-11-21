package com.egg.connections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "shopEntityManagerFactory",transactionManagerRef = "shopTransactionManager",
        basePackages = {"com.egg.connections.shop.repo"})
public class PostgreConfig {

    @Autowired
    private Environment env;

    @Primary
    @Bean(name = "shopDataSource")
    public DataSource shopDataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(env.getProperty("postgre.datasource.url"));
        dataSource.setUsername(env.getProperty("postgre.datasource.username"));
        dataSource.setPassword(env.getProperty("postgre.datasource.password"));
        dataSource.setDriverClassName(env.getProperty("postgre.datasource.driver-class-name"));

        return dataSource;
    }

    @Primary
    @Bean(name = "shopEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(){
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(shopDataSource());
        em.setPackagesToScan("com.egg.connections.shop.models");

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);

        Map<String,Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", env.getProperty("postgre.jpa.hibernate.ddl-auto"));
        properties.put("hibernate.show-sql", env.getProperty("postgre.jpa.show-sql"));
        properties.put("hibernate.dialect", env.getProperty("postgre.jpa.database-platform"));
        em.setJpaPropertyMap(properties);

        return  em;
    }

    @Primary
    @Bean(name = "shopTransactionManager")
    public PlatformTransactionManager transactionManager(){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactoryBean().getObject());

        return  transactionManager;
    }
}
