package learn.interfaces.music;

import learn.interfaces.power.PowerSource;

public class Ipod implements MusicPlayer{
    private PowerSource powerSource;

    public Ipod(PowerSource powerSource) {
        this.powerSource = powerSource;
    }

    @Override
    public void play() {
        System.out.println("Play current song on the playlist.");


    }

    @Override
    public void pause() {

    }

    @Override
    public void stop() {

    }

    @Override
    public int nextSong() {
        return 0;
    }

    @Override
    public int previousSong() {
        return 0;
    }

    @Override
    public void setVolume(int volume) {

    }
}
