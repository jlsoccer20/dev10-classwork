package learn.rps.players;
import java.util.Random;
public class CpuPlayer implements Player{


    private final Random random = new Random(); // 0-2

    private final int id = random.nextInt(2048) + 2048;

    @Override
    public String getName(){
        return String.format("CPU #%s", id);
    }
    @Override
    public int go(){
        return random.nextInt(3) + 1; // 0-2 + 1
    }


}
