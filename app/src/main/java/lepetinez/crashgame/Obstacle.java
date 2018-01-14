package lepetinez.crashgame;

import android.graphics.Canvas;
import android.graphics.Rect;

/**
 * Created by Pc on 14.01.2018.
 */

public class Obstacle implements GameObject {

    private Rect rectangle;
    private int color;

    public Obstacle (Rect rectangle, int color){
        this.rectangle = rectangle;
        this.color = color;
    }

    @Override
    public void draw(Canvas canvas) {

    }

    @Override
    public void update() {

    }
}
