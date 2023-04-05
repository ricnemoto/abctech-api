package br.com.fiap.abctechapi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.abctechapi.entity.Assistance;
import br.com.fiap.abctechapi.repository.AssistanceRepository;
import br.com.fiap.abctechapi.service.AssistanceService;


@Service
public class AssistanceServiceImpl implements AssistanceService {

    private final AssistanceRepository assistanceRepository;

    @Autowired
    public AssistanceServiceImpl(AssistanceRepository assistanceRepository) {
        this.assistanceRepository = assistanceRepository;
    }

    @Override
    public List<Assistance> getAssists() {   
        return this.assistanceRepository.findAll();
    }
}
