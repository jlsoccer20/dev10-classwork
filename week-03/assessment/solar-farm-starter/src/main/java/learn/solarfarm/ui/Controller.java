package learn.solarfarm.ui;

import learn.solarfarm.data.DataAccessException;
import learn.solarfarm.domain.SolarPanelResult;
import learn.solarfarm.domain.SolarPanelService;
import learn.solarfarm.models.SolarPanel;

import java.util.List;
// brains of the UI
// needs view and service - dependencies
public class Controller {
    private final View view;
    private final SolarPanelService service;

    public Controller(View view, SolarPanelService service) {
        this.view = view;
        this.service = service;
    }

    // similar to board game
    public void run() {
        view.displayHeader("Welcome to Solar Farm");
        try {
            runApp(); // we catch errors here
        } catch (DataAccessException ex) {
            view.displayErrors(List.of(ex.getMessage()));
        }
        // exit
        view.displayMessage("Goodbye!");
    }

    private void runApp() throws DataAccessException {
        for (int option = view.chooseMenuOption(); // index is option
             option > 0; // operate as long as user chooses more than 0
             option = view.chooseMenuOption()) {

            // switch on what the user wants to do
            switch (option) {
                case 1:
                    findSolarPanelsBySection();
                    break;
                case 2:
                    addSolarPanel();
                    break;
                case 3:
                    updateSolarPanel();
                    break;
                case 4:
                    deleteSolarPanel();
                    // TODO: complete delete
                    // delete this line
                    // DO NOT DO PRINT LINES HERE
                    System.out.println("NOT IMPLEMENTED");
                    break;
            }
        }
    }

    private void findSolarPanelsBySection() throws DataAccessException {

        // look at this side by side with "view", user wants to see a certain section
        view.displayHeader("Find Panels by Section");
        String section = view.getSection();
        List<SolarPanel> solarPanels = service.findBySection(section);
        if (solarPanels.isEmpty()) {
            view.displayMessage("There are no panels in this section.");
        } else {
            view.displaySolarPanels(section, solarPanels);
        }
    }

    private void addSolarPanel() throws DataAccessException {
        SolarPanel solarPanel = view.addSolarPanel();
        // pass solar panel to service
        SolarPanelResult result = service.create(solarPanel);
        if (result.isSuccess()) {
            view.displayMessage("[Success]%nPanel %s added.", result.getSolarPanel().getKey());
        } else {
            view.displayErrors(result.getErrorMessages());
        }
    }

    //TODO: locate by row and column
    // use existing solar panel, what section row and column
    private void updateSolarPanel() throws DataAccessException {
        view.displayHeader("Update a Panel");
        view.getSection();
        view.getRow();
        view.getColumn();
        SolarPanel sp = SolarPanelService.findByKey(); // this is static?
        if (sp != null){
            SolarPanel updatedSolarPanel = view.updateSolarPanel(sp);
            SolarPanelResult result = service.update(updatedSolarPanel);
            if (result.isSuccess()){
                view.displayMessage("[Success]%n Solar panel %s successfully updated.", sp.getTitle());
            } else {
                view.displayErrors(result.getErrorMessages());
            }
        }

        // Not yet finished
        // TODO: grab the section, row, and column from the view.
        // TODO: use the service to fetch a solar panel by its key (section, row, column).
        // TODO: complete update
    }

    private void deleteSolarPanel() throws DataAccessException{
        view.displayHeader("Delete a panel");
        SolarPanel sp = view.displaySolarPanels(service.findAll());
        if (sp != null){
            SolarPanelResult result = service.deleteById(sp.getId());
            if (result.isSuccess()){
                view.displayMessage("[Success]%n Solar panel %s successfully deleted.", sp.getId()); // get section? row and column?
            } else{
                view.displayMessage(result.getMessages()); // Not sure what to do here
            }
        }
    }
}
