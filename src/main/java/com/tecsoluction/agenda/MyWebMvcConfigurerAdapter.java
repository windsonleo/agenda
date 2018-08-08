//package com.tecsoluction.agenda;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.EnableAspectJAutoProxy;
//import org.springframework.context.annotation.Import;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//
//
//@EnableWebMvc
//@Configuration
//@Import({ThymeleafeConf.class})
//public class MyWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter {
//	
//	
//	
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//       
//    	registry.addResourceHandler("/resources/**").addResourceLocations("classpath:/resources/");
//        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
//        registry.addResourceHandler("/templates/**").addResourceLocations("classpath:/templates/");
//        registry.addResourceHandler("/public/**").addResourceLocations("classpath:/templates/public/");
////        registry.addResourceHandler("/web/**").addResourceLocations("classpath:/static/web/");
//        registry.addResourceHandler("**/favicon.png").addResourceLocations("classpath:/img/favicon.png");
//        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/");
////        registry.addResourceHandler("/build/**").addResourceLocations("classpath:/static/web/build/");
////        registry.addResourceHandler("/vendors/**").addResourceLocations("classpath:/static/web/vendors/");      
////        registry.addResourceHandler("/audio/**").addResourceLocations("classpath:/static/audio/");
//        registry.addResourceHandler("/error/**").addResourceLocations("classpath:/templates/error/");
//        registry.addResourceHandler("/css/**").addResourceLocations("classpath:/static/css/");
//        registry.addResourceHandler("/js/**").addResourceLocations("classpath:/static/js/");
//        registry.addResourceHandler("*/sass/**").addResourceLocations("classpath:/static/sass/");
//
//    	
//    }
//
//}
