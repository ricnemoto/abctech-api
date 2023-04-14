package br.com.fiap.abctechapi.service;

import java.util.List;

import br.com.fiap.abctechapi.entity.Order;

public interface OrderService {
    
  public void saveOrder(Order order, List<Long> assistesId) throws Exception;
}
