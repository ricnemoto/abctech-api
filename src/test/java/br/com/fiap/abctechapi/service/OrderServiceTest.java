package br.com.fiap.abctechapi.service;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import br.com.fiap.abctechapi.entity.Assistance;
import br.com.fiap.abctechapi.entity.Order;
import br.com.fiap.abctechapi.handler.exception.MaximumAssistException;
import br.com.fiap.abctechapi.handler.exception.MinimumAssistsRequiredException;
import br.com.fiap.abctechapi.repository.AssistanceRepository;
import br.com.fiap.abctechapi.repository.OrderRepository;
import br.com.fiap.abctechapi.service.impl.OrderServiceImpl;

@SpringBootTest
public class OrderServiceTest {
    

    @MockBean
    private AssistanceRepository assistanceRepository;

    @MockBean
    private OrderRepository orderRepository;

    private OrderService orderService;

    @BeforeEach
    public void init() {
      MockitoAnnotations.openMocks(this);   
      orderService = new OrderServiceImpl(assistanceRepository, orderRepository);
      Mockito.when(assistanceRepository.findById(Mockito.any()))
            .thenReturn(Optional.of(new Assistance(1L, "Test", "Test Description"))
      );
    }

    @Test
    public void create_order_error_min_assist() {
      Order newOrder = new Order();        
      newOrder.setOperatorId(1234L);
      Assertions.assertThrows(MinimumAssistsRequiredException.class, () -> orderService.saveOrder(newOrder, List.of()));
      Mockito.verify(orderRepository, Mockito.times(0)).save(newOrder);
    }

    @Test
    public void create_order_error_max_assist() {
      Order newOrder = new Order();
      newOrder.setOperatorId(1234L);
      Assertions.assertThrows(MaximumAssistException.class, () -> orderService.saveOrder(newOrder, List.of(1L, 2L, 3L, 4L, 5L,6L, 7L, 1L, 2L, 3L, 4L, 5L,6L, 7L, 1L,2L)));
      Mockito.verify(orderRepository, Mockito.times(0)).save(newOrder);
    }

    @Test
    public void create_order() {
      Order order = new Order();
      order.setOperatorId(1234L);
      Mockito.verify(orderRepository, Mockito.times(0)).save(order);
    }
}
