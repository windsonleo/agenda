package com.tecsoluction.agenda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//
//@SpringBootApplication(scanBasePackages = "com.tecsoluction.agenda")
//@EntityScan(basePackages = { "com.tecsoluction.agenda.entidade" })
//@EnableJpaRepositories(basePackages = { "com.tecsoluction.agenda.dao" })
//@ComponentScan(basePackages = {"com.tecsoluction.agenda.controller"})
//@Import({MyWebMvcConfigurerAdapter.class,MyWebSecurityConfigurerAdapter.class})
@SpringBootApplication
public class AgendaApplication {


//extends SpringBootServletInitializer {
//
//	
//	
//	
//	
//	
//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//        return application.sources(AgendaApplication.class);
//    }
//    
    
    
    
//    @Bean(name="dataSource")
//    @Primary
//    public  javax.sql.DataSource dataSource() {
//   
////        DriverManagerDataSource dataSource = new DriverManagerDataSource();
////        dataSource.setDriverClassName("org.postgresql.Driver");
////        dataSource.setUrl("jdbc:postgresql://ec2-184-73-159-137.compute-1.amazonaws.com:5432/d2imdq1tlu3415");
////        dataSource.setUsername("sbiymdvltaunnx");
////        dataSource.setPassword("a8cfe732a24937cda48d29b651645a84a3efc82966051a0f1b7a29e19a9af16c");
//        
//        
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//        dataSource.setUrl("jdbc:mysql://localhost:3306/azzar?useSSL=true");
//        dataSource.setUsername("root");
//        dataSource.setPassword("123456");
//
//    	return dataSource;
//    }
    
    
    
//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
//
//
//        LocalContainerEntityManagerFactoryBean lcemfb
//                = new LocalContainerEntityManagerFactoryBean();
//
//        lcemfb.setDataSource(dataSource());
//        lcemfb.setPackagesToScan(new String[] {"com.tecsoluction.azar.entidade"});
//
//        lcemfb.setPersistenceUnitName("PU-AZAR");
//
//        HibernateJpaVendorAdapter va = new HibernateJpaVendorAdapter();
//        lcemfb.setJpaVendorAdapter(va);
//        va.setDatabase(Database.MYSQL);
////        va.setDatabase(Database.POSTGRESQL);
//
//        va.setGenerateDdl(true);
//        va.setShowSql(true);
//        va.setDatabasePlatform("org.hibernate.dialect.MySQL5InnoDBDialect");
////        va.setDatabasePlatform("org.hibernate.dialect.PostgreSQLDialect");
//        Properties ps = new Properties();
//        ps.put("spring.jpa.properties.hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
////        ps.put("spring.jpa.properties.hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
//        ps.put("spring.jpa.hibernate.ddl-auto", "create-drop");
//        
////        ps.put("spring.session.store-type", "jdbc");
//        
//		ps.put("useSSL","false");
////		ps.put("security.basic.enabled","false");
//
//		
//		ps.put("spring.jpa.properties.hibernate.format_sql","true");
//		ps.put("spring.datasource.validationQuery","SELECT 1");
//		ps.put("spring.thymeleaf.cache","false");
//		ps.put("security.basic.enabled","false");
//		ps.put("spring.thymeleaf.encoding","UTF-8");
//
//		
//        lcemfb.setJpaProperties(ps);
//
//        lcemfb.afterPropertiesSet();
//
//        return lcemfb;
//
//    }
//    
//    @Bean
//    public PlatformTransactionManager transactionManager(){
//
//        JpaTransactionManager tm = new JpaTransactionManager();
//
//        tm.setEntityManagerFactory(
//                this.entityManagerFactory().getObject() );
//
//        return tm;
//
//    }
//    
    
//    @Autowired
//    private HttpEncodingProperties httpEncodingProperties;
//
//    @Bean
//    public OrderedCharacterEncodingFilter characterEncodingFilter() {
//        OrderedCharacterEncodingFilter filter = new OrderedCharacterEncodingFilter();
//        filter.setEncoding(this.httpEncodingProperties.getCharset().name());
//        filter.setForceEncoding(this.httpEncodingProperties.isForce());
//        filter.setOrder(Ordered.HIGHEST_PRECEDENCE);
//        return filter;
//    }
    
    
//    @Bean
//    public HttpSessionEventPublisher httpSessionEventPublisher() {
//        return new HttpSessionEventPublisher();
//    }
//    
//    @Bean
//    public FilterRegistrationBean myFilterBean() {
//      final FilterRegistrationBean filterRegBean = new FilterRegistrationBean();
//      filterRegBean.setFilter(new FilterSecurityInterceptor());
//      filterRegBean.addUrlPatterns("/*");
//      filterRegBean.setEnabled(Boolean.TRUE);
//      filterRegBean.setName("Meu Filter");
//      filterRegBean.setAsyncSupported(Boolean.TRUE);
//      return filterRegBean;
//    }
//    
	public static void main(String[] args) {
		SpringApplication.run(AgendaApplication.class, args);
	}
}
