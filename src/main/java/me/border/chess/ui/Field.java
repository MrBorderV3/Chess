package me.border.chess.ui;

import javafx.scene.control.Label;
import me.border.chess.piece.Piece;

/**
 * This class represents a chess field on the board
 */
public class Field extends Label {

    private FieldPosition pos;
    private Board board = Game.getBoard();
    private Piece piece;

    public Field(FieldPosition pos){
        this.pos = pos;
    }

    // ********************************** //
    //      SELF EXPLANATORY SETTERS
    // ********************************** //
    public void setPiece(Piece piece, boolean graphic) {
        this.piece = piece;
        if (graphic) {
            if (piece == null) {
                setGraphic(null);
            } else {
                setGraphic(piece.getImage());
            }
        }
    }

    // ********************************** //
    //      SELF EXPLANATORY GETTERS
    // ********************************** //
    public Piece getPiece(){
        return piece;
    }

    public FieldPosition getFieldPos() {
        return pos;
    }
}
