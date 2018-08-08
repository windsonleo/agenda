//package com.tecsoluction.agenda;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.ViewResolver;
//import org.thymeleaf.spring5.SpringTemplateEngine;
//import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
//import org.thymeleaf.spring5.view.ThymeleafViewResolver;
//import org.thymeleaf.templateresolver.ITemplateResolver;
//
//@Configuration
//public class ThymeleafeConf  {
//	
//    private static final String UTF8 = "UTF-8";
//    
//
//	   @Bean
//	    public ViewResolver viewResolver() {
//	        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
//	        resolver.setTemplateEngine(templateEngine());
//	        resolver.setCharacterEncoding(UTF8);
//	        return resolver;
//	    }
//	  
//	    private SpringTemplateEngine templateEngine() {
//	      
//	    	SpringTemplateEngine engine = new SpringTemplateEngine();
//	        engine.setTemplateResolver(templateResolver());
//	        return engine;
//	    }
//	  
//	    private ITemplateResolver templateResolver() {
//	        SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
//	        resolver.setPrefix("classpath:/templates/");
//	        resolver.setTemplateMode("HTML5");
////	        resolver.setOrder(1);
//	        return resolver;
//	    }
//
//
//
//}
