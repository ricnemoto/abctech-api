package br.com.fiap.abctechapi.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.abctechapi.entity.Assistance;
import br.com.fiap.abctechapi.entity.Order;
import br.com.fiap.abctechapi.handler.exception.MaximumAssistException;
import br.com.fiap.abctechapi.handler.exception.MinimumAssistsRequiredException;
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
            Optional<Assistance> assistance = assistanceRepository.findById(id);
            assistance.ifPresent(list::add);
        });

        if(list.isEmpty()) {
            throw new MinimumAssistsRequiredException("Error nas assistências", "Não encontramos nenhuma assistência valida.");
        }else if(list.size() > 15) {
            throw new MaximumAssistException("Error nas assistências", "Não permitido enviar mais que 15 assistências.");
        }
        order.setAssists(list);
        orderRepository.save(order);
    }
    
}
