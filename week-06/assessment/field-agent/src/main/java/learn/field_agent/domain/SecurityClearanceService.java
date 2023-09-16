package learn.field_agent.domain;

import learn.field_agent.data.SecurityClearanceRepository;
import learn.field_agent.models.Agent;
import learn.field_agent.models.SecurityClearance;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SecurityClearanceService {
    private final SecurityClearanceRepository repository;
    public SecurityClearanceService(SecurityClearanceRepository repository){this.repository = repository;}

    public List<SecurityClearance> findAll(){return repository.findAll();}

    public SecurityClearance findById(int securityClearanceId) { return repository.findById(securityClearanceId);}

    public Result<SecurityClearance> add(SecurityClearance securityClearance){
        Result<SecurityClearance> result = validate(securityClearance);
        if(!result.isSuccess()){
            return result;
        }
        if(securityClearance.getSecurityClearanceId() != 0) {
            result.addMessage("securityClearanceId cannot be set for 'add' operation", ResultType.INVALID);
            return result;
        }

        securityClearance = repository.add(securityClearance);
        result.setPayload(securityClearance);
        return result;
    }

    // TODO: update()

    public boolean deleteById(int securityClearanceId) {
        return repository.deleteById(securityClearanceId);
    }


    private Result<SecurityClearance> validate(SecurityClearance securityClearance){
        Result<SecurityClearance> result = new Result<>();
        if (securityClearance == null){
            result.addMessage("securityClearance cannot be null", ResultType.INVALID);
            return result;
        }

        if(Validations.isNullOrBlank(securityClearance.getName())){
            result.addMessage("name is required", ResultType.INVALID);
        }

        /*
        if(securityClearance.getSecurityClearanceId() <1 || securityClearance.getSecurityClearanceId() > 10){
            result.addMessage("securityClearanceId must be between 1 and 10", ResultType.INVALID);
        }
         */

        return result;

    }
}
