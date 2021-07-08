package com.meghna.homeshopping;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.meghna.homeshopping.security.AppProperties;

@SpringBootApplication
public class HomeShoppingApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomeShoppingApplication.class, args);
	}
	@Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder()
    {
    	return new BCryptPasswordEncoder();
    }
	@Bean
	public SpringApplicationContext springApplicationContext() {
		return new SpringApplicationContext();
	}
	@Bean(name="AppProperties")
	public AppProperties getAppProperties() {
		return new AppProperties();
	}
	@Bean
	public WebMvcConfigurer corsConfigurer() {
	    return new WebMvcConfigurer() {
	        @Override
	        public void addCorsMappings(CorsRegistry registry) {
	            registry.addMapping("/**")
	                    .allowedOrigins("*").allowedMethods("GET", "POST","PUT", "DELETE").exposedHeaders("Authorization");
	        }
	    
	};

	
	}
}
 