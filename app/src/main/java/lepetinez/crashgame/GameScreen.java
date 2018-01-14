package lepetinez.crashgame;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.MotionEvent;
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
        player = new Player(new Rect(100,100,200,200),Color.rgb(255,0,0));
        playerPoint = new Point(150,150);
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

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_MOVE:
                playerPoint.set((int)event.getX(),(int)event.getY());

        }
        return true;
    }

    public void update() {
        player.update(playerPoint);

    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        canvas.drawColor(Color.WHITE);
        player.draw(canvas);
    }
}

