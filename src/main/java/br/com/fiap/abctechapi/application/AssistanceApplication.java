package br.com.fiap.abctechapi.application;

import java.util.List;

import br.com.fiap.abctechapi.application.dto.AssistsResponseDTO;

public interface AssistanceApplication {
    
    public List<AssistsResponseDTO> getAssists();
}
