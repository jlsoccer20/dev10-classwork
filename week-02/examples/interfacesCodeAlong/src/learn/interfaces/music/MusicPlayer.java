package learn.interfaces.music;

public interface MusicPlayer {
    void play();
    void pause();
    void stop();

    int nextSong();
    int previousSong();

    void setVolume(int volume);


}
