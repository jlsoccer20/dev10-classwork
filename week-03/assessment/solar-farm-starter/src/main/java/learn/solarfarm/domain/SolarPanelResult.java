package learn.solarfarm.domain;

import learn.solarfarm.models.SolarPanel;

import java.util.ArrayList;
import java.util.List;
// provide controller with more detailed information of CRUD operations
public class SolarPanelResult {
    private final ArrayList<String> messages = new ArrayList<>();
    private SolarPanel solarPanel;


    public List<String> getErrorMessages() {
        return new ArrayList<>(messages);
    }

    public void addErrorMessage(String message) {
        messages.add(message);
    }

    public void addErrorMessage(String format, Object... args) {
        messages.add(String.format(format, args));
    }

    public boolean isSuccess() {
        // If an error message exists, the operation failed.
        return messages.size() == 0;
        // no news is good news

    }

    public SolarPanel getSolarPanel() {
        return solarPanel;
    }

    public void setSolarPanel(SolarPanel solarPanel) {
        this.solarPanel = solarPanel;
    }

    public List<String> getMessages() {
        return new ArrayList<>(messages);
    }
}
