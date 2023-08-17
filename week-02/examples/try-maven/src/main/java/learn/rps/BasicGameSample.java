package learn.rps;


import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.dsl.components.ProjectileComponent;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class BasicGameSample extends GameApplication {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    protected void initSettings(GameSettings settings){
        settings.setWidth(800);
        settings.setHeight(600);
        settings.setTitle("BasicGameSample");
    }

    @Override
    protected void initGame(){
        FXGL.entityBuilder()
                .at(150,150)
                .view(new Rectangle(40,40, Color.BLUE))
                .with(new ProjectileComponent(new Point2D(1,1), 125))
                .buildAndAttach();
    }


}
