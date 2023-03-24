package br.com.fiap.abctechapi.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.InputStreamEditor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.abctechapi.util.VersionComponent;

@RestController
@RequestMapping("/")
public class HealthCheckController {
    
    private final VersionComponent versionComponent;

    public HealthCheckController(@Autowired VersionComponent versionComponent) {
        this.versionComponent = versionComponent;        
    }
    

    @GetMapping
    public ResponseEntity<String> status() {
        return ResponseEntity.ok("Up");
    }

    @GetMapping("/version")
    public ResponseEntity<String> version() throws IOException {

        return ResponseEntity.ok(this.versionComponent.getVersion());
    }
}
