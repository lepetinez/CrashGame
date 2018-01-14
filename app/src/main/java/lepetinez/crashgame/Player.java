package lepetinez.crashgame;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;

/**
 * Created by lepetinez on 03.01.2018.
 */

public class Player implements GameObject {
    private Rect player;
    private int playerColor;

    Player(Rect player, int playerColor) {
        this.player = player;
        this.playerColor = playerColor;
    }

    @Override
    public void draw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(this.playerColor);
        canvas.drawRect(this.player,paint);

    }

    @Override
    public void update() {

    }

    void update(Point point) {
        this.player.set(point.x - player.width() / 2, point.y - player.height() / 2, point.x + player.width() / 2, point.y + player.height() / 2);

    }
}
