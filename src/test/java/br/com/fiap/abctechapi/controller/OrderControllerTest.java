package br.com.fiap.abctechapi.controller;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.fiap.abctechapi.application.dto.OrderDto;
import br.com.fiap.abctechapi.application.dto.OrderLocationDto;
import br.com.fiap.abctechapi.entity.Assistance;
import br.com.fiap.abctechapi.repository.AssistanceRepository;

@SpringBootTest
@AutoConfigureMockMvc
public class OrderControllerTest {
    
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AssistanceRepository assistanceRepository;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        Mockito.when(assistanceRepository.findById(Mockito.any())).thenReturn(Optional.of(new Assistance(1L, "Test", "Test Description")));
    }

    @Test
    void testCreate() throws Exception {
        OrderDto orderDto = new OrderDto();
        orderDto.setOperatorId(1234L);
        orderDto.setServices(List.of(1L));
        orderDto.setStart(new OrderLocationDto(1.0, 2.0, Calendar.getInstance().getTime()));
        orderDto.setEnd(new OrderLocationDto(1.0, 2.0, Calendar.getInstance().getTime()));

        this.mockMvc.perform(MockMvcRequestBuilders.post("/order")
            .content(new ObjectMapper().writeValueAsString(orderDto))
            .contentType(MediaType.APPLICATION_JSON))
        .andDo(MockMvcResultHandlers.print())
        .andExpect(MockMvcResultMatchers.status().isOk());

    }
}
