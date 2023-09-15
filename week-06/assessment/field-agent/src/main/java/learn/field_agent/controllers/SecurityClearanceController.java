package learn.field_agent.controllers;

import learn.field_agent.domain.SecurityClearanceService;
import learn.field_agent.models.SecurityClearance;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/securityClearance")
public class SecurityClearanceController {
    private final SecurityClearanceService service;

    public SecurityClearanceController(SecurityClearanceService service) {
        this.service = service;
    }

    @GetMapping
    public List<SecurityClearance> findAll(){return service.findAll();}

    @GetMapping("/{securityClearanceId}")
    public SecurityClearance findById(@PathVariable int securityClearanceId){return service.findById(securityClearanceId);}

    // TODO add()

    // TODO update()

    // TODO deleteById()
}
