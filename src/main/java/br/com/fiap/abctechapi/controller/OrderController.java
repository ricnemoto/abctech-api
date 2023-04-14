package br.com.fiap.abctechapi.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.abctechapi.application.dto.OrderDto;

@RequestMapping("/order")
@RestController
public class OrderController {
    

    @PostMapping
    public ResponseEntity<String> create(@Valid @RequestBody OrderDto orderDto) {
        return ResponseEntity.ok().build();
    }
}
