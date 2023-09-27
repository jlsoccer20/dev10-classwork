package learn.field_agent.domain;

import learn.field_agent.data.SecurityClearanceRepository;
import learn.field_agent.models.SecurityClearance;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class SecurityClearanceServiceTest {
    @Autowired
    SecurityClearanceService service;
    @MockBean
    SecurityClearanceRepository repository;


    @Test
    void shouldFindSecurityClearance(){ // findByIdTest()
        SecurityClearance expected = makeSecurityClearance();
        when(repository.findById(1)).thenReturn(expected);
        SecurityClearance actual = service.findById(1);
        assertEquals(expected, actual);
    }

    // Build findAllTest()

    SecurityClearance makeSecurityClearance(){
        // (1, 'Secret')
        SecurityClearance securityClearance = new SecurityClearance();
        securityClearance.setSecurityClearanceId(1);
        return securityClearance;
    }
}
