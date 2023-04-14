package br.com.fiap.abctechapi.application.dto;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDto {

    @NotNull
    private Long operatorId;

    @NotEmpty
    private List<Long> services;

    @Valid
    private OrderLocationDto start;

    @Valid
    private OrderLocationDto end;
    
}