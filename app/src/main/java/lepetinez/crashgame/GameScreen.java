package lepetinez.crashgame;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.MainThread;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by Pc on 10.12.2017.
 */

public class GameScreen extends SurfaceView implements SurfaceHolder.Callback {
    private MainThread gameThread;

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
                thread.setRunning(false);
                thread.join();
            } catch (Exception e) {
                e.printStackTrace();
            }
            retry = false;
        }
    }
    @Override
    public void draw(Canvas canvas) {

        super.draw(canvas);
    }
}

