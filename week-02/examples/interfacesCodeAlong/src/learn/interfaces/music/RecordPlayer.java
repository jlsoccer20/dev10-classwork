package learn.interfaces.music;

import learn.interfaces.power.PowerSource;

public class RecordPlayer implements MusicPlayer{
    private PowerSource powerSource;
    public RecordPlayer(PowerSource powerSource){
        this.powerSource = powerSource;
    }
    @Override
    public void play(){
        if (powerSource == null||powerSource.getVolts()<= 0 ){
            System.out.println("No power.");
        } else if (powerSource.getVolts() == 120.0){
            System.out.println("Needle Drops on the record, turntable spins.");
        } else {
            System.out.println("Needle Drops, turntable spins strangely, sounds weird.");
        }
    }

    @Override
    public void pause(){
        System.out.println("Needle stopped.");
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
