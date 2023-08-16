package learn.interfaces;

import learn.interfaces.music.Ipod;
import learn.interfaces.music.MusicPlayer;
import learn.interfaces.music.RecordPlayer;
import learn.interfaces.power.PowerSource;
import learn.interfaces.power.TwelveVoltBattery;
import learn.interfaces.power.Battery;
import learn.interfaces.power.USOutlet;

public class App {
    public static void main(String[] args) {

        MusicPlayer[] musicPlayers = {
            new RecordPlayer(new USOutlet()),
            new RecordPlayer(new Battery(1.5)),
            new RecordPlayer(new TwelveVoltBattery()),
            new Ipod(new Battery(9.0)),
            new RecordPlayer(new Battery(0)),
            new RecordPlayer(null)
        };

        for (MusicPlayer player: musicPlayers){
            player.play();
        }
//
//
//        PowerSource twelveVolt = new Battery(12.0);
//        PowerSource usOutlet = new USOutlet();
//
//
//        MusicPlayer recordPlayer = new RecordPlayer(usOutlet);
//        MusicPlayer ipod = new Ipod(twelveVolt);
//
//        MusicPlayer[] musicPlayers = new MusicPlayer[2];
//        musicPlayers[0] = recordPlayer;
//        musicPlayers[1] = ipod;
//
//        for (MusicPlayer player : musicPlayers){
//            player.play();
//        }
    }
}
