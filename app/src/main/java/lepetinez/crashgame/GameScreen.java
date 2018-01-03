package lepetinez.crashgame;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by lepetinez on 10.12.2017.
 */

public class GameScreen extends SurfaceView implements SurfaceHolder.Callback {
    private MainThread gameThread;

    private Player player;
    private Point playerPoint;

    public GameScreen(Context context) {
        super(context);
        getHolder().addCallback(this);

        gameThread = new MainThread(getHolder(), this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        gameThread = new MainThread(getHolder(), this);
        gameThread.setRunning(true);
        gameThread.start();

    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

        boolean retry = true;
        while (true) {
            try {
                gameThread.setRunning(false);
                gameThread.join();
            } catch (Exception e) {
                e.printStackTrace();
            }
            retry = false;
        }
    }

    public void update(){
        player.update(playerPoint);

    }
    @Override
    public void draw(Canvas canvas) {

        super.draw(canvas);
        player.draw(canvas);
    }
}

