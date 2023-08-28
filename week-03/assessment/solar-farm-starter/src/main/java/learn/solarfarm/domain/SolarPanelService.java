package learn.solarfarm.domain;

import learn.solarfarm.data.DataAccessException;
import learn.solarfarm.data.SolarPanelRepository;
import learn.solarfarm.models.SolarPanel;

import java.time.Year;
import java.util.List;
// service is like the bouncer at the club
// protecting data layer from anyone getting in
// if you want to create something, you have to pass rules
// if you want to update something, you have to pass these rules

public class SolarPanelService {
    public final static int MAX_ROW_COLUMN = 250;

    private final SolarPanelRepository repository;

    public SolarPanelService(SolarPanelRepository repository) {
        this.repository = repository;
    }

    public static int getMaxInstallationYear() {
        return Year.now().getValue();
    }

    public List<SolarPanel> findBySection(String section) throws DataAccessException {
        return repository.findBySection(section); // here's the data for that section
    }

    public SolarPanel findByKey(String section, int row, int column) throws DataAccessException {
        return repository.findByKey(section, row, column); // here's the data for that section row and column
    }

    public SolarPanelResult create(SolarPanel solarPanel) throws DataAccessException {
        SolarPanelResult result = validate(solarPanel);

        if (solarPanel != null && solarPanel.getId() > 0) {
            result.addErrorMessage("SolarPanel `id` should not be set.");
        }

        if (result.isSuccess()) {
            solarPanel = repository.create(solarPanel);
            result.setSolarPanel(solarPanel);
        }

        return result;
    }

    // TODO: add an update method
    // This is the "Domain", so do validation here (using solarPanel == null), etc.
    public SolarPanelResult update(SolarPanel panel) throws DataAccessException{

        SolarPanelResult result = validate(panel);
        if (!result.isSuccess()){
            return result;
        }

        if (panel.getId() <= 0){
            result.addErrorMessage("Panel ID is required.");
            return result;
        }

        boolean success = repository.update(panel);
        if (!success){
            result.addErrorMessage("Could not update panel ID " + panel.getId());
        }

        return result;
    }
    // TODO: add a delete method (possibly deleteById?)
    public SolarPanelResult deleteById(int solarPanelId) throws DataAccessException {
        SolarPanelResult result = new SolarPanelResult();
        boolean success = repository.deleteById(solarPanelId);
        if(!success) {
            result.addErrorMessage("Could not delete solar panel ID " + solarPanelId);
        }
        return result;
    }

    private SolarPanelResult validate(SolarPanel solarPanel) throws DataAccessException {
        SolarPanelResult result = new SolarPanelResult();

        if (solarPanel == null) {
            result.addErrorMessage("SolarPanel cannot be null.");
            return result;
        }

        if (solarPanel.getSection() == null || solarPanel.getSection().isBlank()) {
            result.addErrorMessage("SolarPanel `section` is required.");
        }

        // 251 should fail validation, but 250 should be ok
        if (solarPanel.getRow() < 1 || solarPanel.getRow() > MAX_ROW_COLUMN) {
            result.addErrorMessage("SolarPanel `row` must be a positive number less than or equal to %s.", MAX_ROW_COLUMN);
        }

        if (solarPanel.getColumn() < 1 || solarPanel.getColumn() > MAX_ROW_COLUMN) {
            result.addErrorMessage("SolarPanel `column` must be a positive number less than or equal to %s.", MAX_ROW_COLUMN);
        }

        // must be in the past
        if (solarPanel.getYearInstalled() > getMaxInstallationYear()) {
            result.addErrorMessage("SolarPanel `yearInstalled` must be in the past.");
        }

        if (solarPanel.getMaterial() == null) {
            result.addErrorMessage("SolarPanel `material` is required.");
        }

        // If everything is successful so far, then check if the combined values
        // of **Section**, **Row**, and **Column** are unique (i.e. the natural key).
        if (result.isSuccess()) {
            SolarPanel existingSolarPanel = repository.findByKey(solarPanel.getSection(),
                    solarPanel.getRow(), solarPanel.getColumn()); // see if there is an existing solar panel with these rows and columns

            // If an existing panel was found for the provided **Section**, **Row**, and **Column** values
            // add an error message if the id values don't match (i.e. they're not the same record).
            if (existingSolarPanel != null && existingSolarPanel.getId() != solarPanel.getId()) {
                result.addErrorMessage("SolarPanel `section`, `row`, and `column` must be unique.");
            }
        }

        return result;
    }

    public Object findAll() throws DataAccessException {
        return repository.findAll();
    }
}
