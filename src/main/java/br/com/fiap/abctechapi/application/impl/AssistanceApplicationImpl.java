package br.com.fiap.abctechapi.application.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.fiap.abctechapi.application.AssistanceApplication;
import br.com.fiap.abctechapi.application.dto.AssistsResponseDTO;
import br.com.fiap.abctechapi.service.AssistanceService;

@Component
public class AssistanceApplicationImpl implements AssistanceApplication {
    
    private final AssistanceService assistanceService;

    @Autowired
    public AssistanceApplicationImpl(AssistanceService assistanceService) {
        this.assistanceService = assistanceService;
    }

    @Override
    public List<AssistsResponseDTO> getAssists() {
       List<AssistsResponseDTO> assistsDtos = this.assistanceService.getAssists()
       .stream()
       .map(o -> new AssistsResponseDTO(o.getId(), o.getName(), o.getDescription()))
       .collect(Collectors.toList());
       return assistsDtos;
    }

    


}
