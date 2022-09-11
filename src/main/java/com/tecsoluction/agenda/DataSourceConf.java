package com.tecsoluction.agenda;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;




@Configuration
public class DataSourceConf {
	
	
	@Bean
    public DataSource dataSource() {
           
//        local
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("org.postgresql.Driver");
//        dataSource.setUrl("jdbc:postgresql://localhost:5432/agenda");
//        dataSource.setUsername("postgres");        
//        dataSource.setPassword("");
		
		//heroku
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("org.postgresql.Driver");
//        dataSource.setUrl("jdbc:postgresql://ec2-107-21-98-165.compute-1.amazonaws.com:5432/dfgl4a8isctde5");
//        dataSource.setUsername("bqjzlolhzrclji");        
//        dataSource.setPassword("c3759f8eefef3cead926283838213cba78beb65cf84343d516e8f7debb0c2289");

		 DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName("org.postgresql.Driver");
	        dataSource.setUrl("jdbc:postgresql://ec2-54-209-165-105.compute-1.amazonaws.com:5432/daemfr8rdmb08f");
	        dataSource.setUsername("cxkeiovufxnqic");        
	        dataSource.setPassword("a99f155c076eb5f333a0e86538e7e498563922bbd84108ea622893c6bd65177b");

    	return dataSource;
    }
	
	
	
    
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(){


        LocalContainerEntityManagerFactoryBean lcemfb
                = new LocalContainerEntityManagerFactoryBean();

        lcemfb.setDataSource(dataSource());
        lcemfb.setPackagesToScan(new String[] {"com.tecsoluction.agenda.entidade"});

        lcemfb.setPersistenceUnitName("PU-AGENDA");

        HibernateJpaVendorAdapter va = new HibernateJpaVendorAdapter();
        lcemfb.setJpaVendorAdapter(va);
        va.setDatabase(Database.POSTGRESQL);

        va.setGenerateDdl(true);
        va.setShowSql(true);
        va.setDatabasePlatform("org.hibernate.dialect.PostgreSQLDialect");
        Properties ps = new Properties();
        ps.put("spring.jpa.properties.hibernate.dialect", "org.hibernate.dialect.PostgreSQL95Dialect");
        ps.put("spring.jpa.hibernate.ddl-auto", "create");
		ps.put("useSSL","false");
		ps.put("spring.thymeleaf.encoding","UTF-8");
		ps.put("spring.jpa.properties.hibernate.format_sql","true");
		ps.put("spring.datasource.validationQuery","SELECT 1");
		ps.put("spring.thymeleaf.cache","false");
		ps.put("security.basic.enabled","false");

		
        lcemfb.setJpaProperties(ps);

        lcemfb.afterPropertiesSet();

        return lcemfb;

    }
    
    @Bean
    public PlatformTransactionManager transactionManager(){

        JpaTransactionManager tm = new JpaTransactionManager();

        tm.setEntityManagerFactory(
                this.entityManagerFactory().getObject() );

        return tm;

    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
        return new PersistenceExceptionTranslationPostProcessor();
    }


}
