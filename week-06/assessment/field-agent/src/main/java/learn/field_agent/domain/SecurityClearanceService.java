package learn.field_agent.domain;

import learn.field_agent.data.SecurityClearanceRepository;
import learn.field_agent.models.SecurityClearance;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SecurityClearanceService {
    private final SecurityClearanceRepository repository;
    public SecurityClearanceService(SecurityClearanceRepository repository){this.repository = repository;}

    // TODO: findAll()
    //  see AgentService
    //public List<SecurityClearance> findAll(){return repository.findAll();}

    public SecurityClearance findById(int securityClearanceId) { return repository.findById(securityClearanceId);}

    // TODO: add()

    // TODO: update()

    // TODO: deleteById()

    // TODO: validate()
}
