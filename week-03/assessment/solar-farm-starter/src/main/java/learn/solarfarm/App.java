package learn.solarfarm;

import learn.solarfarm.data.SolarPanelFileRepository;
import learn.solarfarm.data.SolarPanelRepository;
import learn.solarfarm.domain.SolarPanelService;
import learn.solarfarm.ui.ConsoleIO;
import learn.solarfarm.ui.Controller;
import learn.solarfarm.ui.TextIO;
import learn.solarfarm.ui.View;

public class App {
    public static void main(String[] args) {
    // TODO: Manual dependency injection
        // create objects we need
        // create repository // Data - Interface --> Class
        SolarPanelRepository repository = new SolarPanelFileRepository("./data/solarfarm.txt");
        // create service // Domain
        SolarPanelService service = new SolarPanelService(repository); // inject repository into service

        TextIO io = new ConsoleIO();
        View view = new View(io);

        // run controller
        Controller controller = new Controller(view, service); // inject view and service into controller
        controller.run();

        // "view by section" and solarpanel sections work - then build on them
        //Hey General! You need to Generate equals and hashcode for SolarPanelResult if you want to directly compare results in unit tests.

    }
}
