package br.com.fiap.abctechapi.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.abctechapi.entity.Assistance;
import br.com.fiap.abctechapi.entity.Order;
import br.com.fiap.abctechapi.repository.AssistanceRepository;
import br.com.fiap.abctechapi.repository.OrderRepository;
import br.com.fiap.abctechapi.service.OrderService;

@Service
public class OrderServiceImpl  implements OrderService {

     private final AssistanceRepository assistanceRepository;
     private final OrderRepository orderRepository;


    @Autowired
    public OrderServiceImpl(AssistanceRepository assistanceRepository, OrderRepository orderRepository) {
        this.assistanceRepository = assistanceRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public void saveOrder(Order order, List<Long> assistesId) throws Exception{
        ArrayList<Assistance> list = new ArrayList<>();
        assistesId.forEach((id) -> {
            Assistance assistance = assistanceRepository.findById(id).orElseThrow();
            list.add(assistance);
        });
        if(list.isEmpty()) {
            throw new Exception();
        }
        order.setAssists(list);
        orderRepository.save(order);
    }
    
}
