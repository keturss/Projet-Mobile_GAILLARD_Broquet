package fr.iut63.towerdefense.UI.view;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;

import fr.iut63.towerdefense.model.gamelogic.GameManager;
import fr.iut63.towerdefense.model.gameloop.ILoopListener;

/**
 * Essaie GameView
 */
public class GameView extends View implements ILoopListener {
    public GameManager world;

    private final double layoutWidth;
    private final double layoutHeight;


    public GameView(Context context, GameManager world, double layoutWidth, double layoutHeight) {
        super(context);
        this.layoutWidth = layoutWidth;
        this.layoutHeight = layoutHeight;
        this.world = world;
    }

    @Override
    protected void onLayout(boolean b, int left, int top, int right, int bottom ) {

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        return true;
    }


    protected void onDraw(Canvas c) {
        super.onDraw(c);

    }

    @Override
    public void update(int timer) {
        postInvalidate();
    }

}
