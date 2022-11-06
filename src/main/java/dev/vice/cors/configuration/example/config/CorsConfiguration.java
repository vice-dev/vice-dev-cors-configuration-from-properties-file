package dev.vice.cors.configuration.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration {
	
	@Autowired
	CorsProperties corsProperties;
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		System.out.println(corsProperties);
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				corsProperties.getMappings().forEach(mapping->{
					CorsRegistration reg = registry.addMapping(mapping.get("path"));
					if (mapping.get("allowedOrigins") !=null && !mapping.get("allowedOrigins").isBlank()) {
						reg.allowedOrigins(mapping.get("allowedOrigins"));
					}
					if (mapping.get("allowedMethods") !=null && !mapping.get("allowedMethods").isBlank()) {
						reg.allowedMethods(mapping.get("allowedMethods"));
					}
					if (mapping.get("allowedHeaders") !=null && !mapping.get("allowedHeaders").isBlank()) {
						reg.allowedHeaders(mapping.get("allowedHeaders"));
					}
					if (mapping.get("allowedOriginPatterns") !=null && !mapping.get("allowedOriginPatterns").isBlank()) {
						reg.allowedOriginPatterns(mapping.get("allowedOriginPatterns"));
					}
					if (mapping.get("allowCredentials") !=null && !mapping.get("allowCredentials").isBlank()) {
						reg.allowCredentials(Boolean.parseBoolean(mapping.get("allowCredentials")));
					}
				});
			}
		};
	}
}
