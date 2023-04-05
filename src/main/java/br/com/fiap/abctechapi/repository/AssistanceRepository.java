package br.com.fiap.abctechapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.abctechapi.entity.Assistance;

@Repository
public interface AssistanceRepository extends JpaRepository<Assistance, Long> {
    
}
