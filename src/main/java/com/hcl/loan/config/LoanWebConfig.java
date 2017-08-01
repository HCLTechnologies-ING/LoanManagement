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

import com.hcl.loan.dao.impl.LoanApprovalDAOImpl;
import com.hcl.loan.service.impl.LoanApprovalServiceImpl;

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
	 public LoanApprovalServiceImpl getLoanApprovalService() {
		 return new LoanApprovalServiceImpl();
	 }
	 
	 @Bean
	 public LoanApprovalDAOImpl getLoanApprovalDAO() {
		 return new LoanApprovalDAOImpl(getDataSource());
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
	        dataSource.setUrl("jdbc:mysql://localhost:3306/lms");
	        dataSource.setUsername("root");
	        dataSource.setPassword("Welcome0!");
	         
	        return dataSource;
	    }
	     

}
