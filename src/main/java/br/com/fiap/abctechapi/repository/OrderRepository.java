package br.com.fiap.abctechapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.abctechapi.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    
}
