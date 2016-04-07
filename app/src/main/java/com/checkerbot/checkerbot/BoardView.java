package com.checkerbot.checkerbot;

        import android.content.Context;
        import android.graphics.Canvas;
        import android.graphics.Color;
        import android.graphics.Paint;
        import android.graphics.Rect;
        import android.view.View;

public class BoardView extends View {

    private Square[][] board;
    private Paint paint;
    private int width;
    private int height;

    public BoardView(Context context) {
        super(context);
        this.createBoard();
        paint = new Paint();
    }

    private void createBoard() {
        board= new Square[8][8];
        //set colors of square
        int start = Color.BLACK;
        for(int r=0;r<board.length;r++){
            if(start==Color.BLACK){
                start=Color.WHITE;
            }
            if(start==Color.WHITE){
                start=Color.BLACK;
            }
            for(int c=0;c<board[r].length;c++){
                //board[r][c]
            }
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        this.drawBG(canvas);
        this.drawBoard(canvas);
    }

    private void drawBoard(Canvas canvas) {
    }

    private void drawBG(Canvas canvas) {
        paint.setColor(Color.WHITE);
        canvas.drawRect(new Rect(0,0,width,height),paint);
    }

    public void setDim(int width, int height) {
        this.width=width;
        this.height=height;
    }
}