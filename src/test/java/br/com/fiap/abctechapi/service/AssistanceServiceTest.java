package br.com.fiap.abctechapi.service;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import br.com.fiap.abctechapi.entity.Assistance;
import br.com.fiap.abctechapi.repository.AssistanceRepository;
import br.com.fiap.abctechapi.service.impl.AssistanceServiceImpl;


@SpringBootTest
public class AssistanceServiceTest {

    private AssistanceService assistanceService;

    @MockBean
    private AssistanceRepository assistanceRepository;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        assistanceService = new AssistanceServiceImpl(assistanceRepository);
    }

    @Test
    public void test_lista_assistance() {
        Mockito.when(assistanceRepository.findAll())
            .thenReturn(
                List.of(new Assistance(1L, "Test", "Test description"))
            );
        List<Assistance> list = assistanceService.getAssists();
        Assertions.assertNotNull(list);
        Assertions.assertEquals(list.size(), 1);
        
    }
}
