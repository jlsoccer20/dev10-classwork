package learn.field_agent.controllers;

import learn.field_agent.data.SecurityClearanceRepository;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
@AutoConfigureMockMvc
public class SecurityClearanceControllerTest {
    @MockBean
    SecurityClearanceRepository repository;
}
