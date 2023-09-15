package learn.solarfarm.controllers;

import learn.solarfarm.domain.SolarPanelResult;
import learn.solarfarm.domain.SolarPanelService;
import learn.solarfarm.models.SolarPanel;

import java.util.List;

@RestController
@RequestMapping("/api/panels")
public class SolarPanelController {
    private final SolarPanelService service;

    public SolarPanelController(SolarPanelService service){
        this.service = service;
    }

    @GetMapping("/{section")
    public List<SolarPanel> findBySection(@PathVariable String section){
        return service.findBySection(section);
    }

    @PutMapping("/{id}")
    // lets us send HTTP status, along with optional body, if error messages can send that
    // also other errors, payload with request
    // ? lets us send different data types with our ResponseEntity
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody SolarPanel solarPanel){
        // Make sure the id matches
        if (id != solarPanel.getId()){
            return ResponseEntity<>(HttpStatus.CONFLICT);
        }

        // Ask our service to try to update
        SolarPanelResult result = service.update(solarPanel);
        // send back the response --
        // if success 204 No content
        if (result.isSuccess()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        // Validation 400 Bad Request
        // Solar Panel doesnt exist 404
    }

}
