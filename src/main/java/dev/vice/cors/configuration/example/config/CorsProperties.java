package dev.vice.cors.configuration.example.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="vice.dev.cors")
public class CorsProperties {
	
	private List<HashMap<String, String>> mappings = new ArrayList<HashMap<String, String>>();

	public List<HashMap<String, String>> getMappings() {
		return mappings;
	}

	public void setMappings(List<HashMap<String, String>> mappings) {
		this.mappings = mappings;
	}

	@Override
	public String toString() {
		return "CorsProperties [mappings=" + mappings + "]";
	}
	
	
	

}
