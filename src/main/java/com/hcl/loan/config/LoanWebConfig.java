package com.hcl.loan.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.hcl.loan.dao.LoanDisbursmentDaoImpl;
import com.hcl.loan.dao.LoanRequestDAOImpl;
import com.hcl.loan.service.LoanDisbursmentServiceImpl;
import com.hcl.loan.service.LoanRequestServiceImpl;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.hcl.loan.controller")
public class LoanWebConfig {
	
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }
	
	 @Bean
	    public ViewResolver viewResolver() {
	        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
	        viewResolver.setViewClass(JstlView.class);
	        viewResolver.setPrefix("/WEB-INF/views/");
	        viewResolver.setSuffix(".jsp");
	 
	        return viewResolver;
	    }
	 
	 @Bean
	 public LoanDisbursmentServiceImpl getLoanDisbursementService() {
		 return new LoanDisbursmentServiceImpl();
	 }
	 
	 @Bean
	 public LoanDisbursmentDaoImpl getLoanDisbursementDAO() {
		 return new LoanDisbursmentDaoImpl(getDataSource());
	 }
	 
	 @Bean(name = "messageSource")
	    public ReloadableResourceBundleMessageSource getMessageSource() {
	        ReloadableResourceBundleMessageSource resource = new ReloadableResourceBundleMessageSource();
	        resource.setBasename("classpath:dbconfig");
	        resource.setDefaultEncoding("UTF-8");
	        return resource;
	    }
	 
	 @Bean
	    public DataSource getDataSource() {
	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	        dataSource.setUrl("jdbc:mysql://localhost:3306/mydb");
	        dataSource.setUsername("root");
	        dataSource.setPassword("");
	         
	        return dataSource;
	    }  
	 
	 @Bean
	 public LoanRequestServiceImpl getLoanRequestService() {
		 return new LoanRequestServiceImpl();
	 }
	 
	 @Bean
	 public LoanRequestDAOImpl getLoanRequestDAO() {
		 return new LoanRequestDAOImpl(getDataSource());
	 }
	 

}

