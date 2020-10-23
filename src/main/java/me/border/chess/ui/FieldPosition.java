package me.border.chess.ui;

/**
 * This class represents the coordinates of a field (Its X and Y on the board)
 */
public class FieldPosition {

    private int x, y;

    public FieldPosition(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }
}
