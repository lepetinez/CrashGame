package lepetinez.crashgame;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * Created by Pc on 14.01.2018.
 */

public class Obstacle implements GameObject {

    private Rect obstacle;
    private int color;

    public Obstacle (Rect rectangle, int color){
        this.obstacle = rectangle;
        this.color = color;
    }

    public boolean collision(Player player){
        return obstacle.contains(player.getPlayer().left, player.getPlayer().top)
                || obstacle.contains(player.getPlayer().right,player.getPlayer().top)
                || obstacle.contains(player.getPlayer().left,player.getPlayer().bottom)
                || obstacle.contains(player.getPlayer().right,player.getPlayer().bottom)
                ;
    }

    @Override
    public void draw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(this.color);
        canvas.drawRect(this.obstacle,paint);
    }

    @Override
    public void update() {

    }
}
