package br.com.fiap.abctechapi.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.stereotype.Component;

@Component
public class VersionComponent {
    
    private final Properties properties;

    public VersionComponent() throws IOException {
        properties = new Properties();
        InputStream is = getClass().getClassLoader().getResourceAsStream("application.yml");
        properties.load(is);
    }

    public String getVersion() {
        
        return properties.getProperty("build_name") + " - " + properties.getProperty("build_version");
    }
}
