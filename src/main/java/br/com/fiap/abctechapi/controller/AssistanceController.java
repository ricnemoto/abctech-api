package br.com.fiap.abctechapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.abctechapi.application.AssistanceApplication;
import br.com.fiap.abctechapi.application.dto.AssistsResponseDTO;

@RequestMapping("/assists")
@RestController
public class AssistanceController {
        
    private final AssistanceApplication assistanceApplication;

    @Autowired
    public AssistanceController(AssistanceApplication assistanceApplication) {
        this.assistanceApplication = assistanceApplication;
    }

    @GetMapping
    public ResponseEntity<List<AssistsResponseDTO>> getAssists() {
        return ResponseEntity.ok(assistanceApplication.getAssists());
    }
}
