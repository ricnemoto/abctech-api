package br.com.fiap.abctechapi.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.beans.propertyeditors.InputStreamEditor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HealthCheckController {
    

    @GetMapping
    public ResponseEntity<String> status() {
        return ResponseEntity.ok("Up");
    }

    @GetMapping("/version")
    public ResponseEntity<String> version() throws IOException {
        Properties properties = new Properties();

        InputStream is = getClass().getClassLoader().getResourceAsStream("application.yml");

        properties.load(is);

        return ResponseEntity.ok(properties.getProperty("build_name") + " - "  + properties.getProperty("build_version"));
    }
}
