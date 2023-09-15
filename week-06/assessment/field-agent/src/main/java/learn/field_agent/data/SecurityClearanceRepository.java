package learn.field_agent.data;

import learn.field_agent.models.SecurityClearance;

import java.util.List;

public interface SecurityClearanceRepository { // see AgentRepository
    List<SecurityClearance> findAll();

    SecurityClearance findById(int securityClearanceId);

    // TODO: add();

    // TODO: update();

    // TODO: deleteById();
}
