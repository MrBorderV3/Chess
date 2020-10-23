package me.border.chess.piece;

import me.border.chess.game.Team;
import me.border.chess.ui.Field;

import java.util.List;

public class King extends Piece {

    public King(Team team, Field field){
        super(team, PieceType.KING, field);
    }

    @Override
    public List<Field> getAccessibleFields() {
        return null;
    }

    /**
     * Get if this king is at check
     *
     * @return Whether this king is at check
     */
    public boolean isCheck(){
        // do stuff
    }

    /**
     * Get if this king is at checkmate
     *
     * @return Whether this king is at checkmate
     */
    public boolean isCheckMate(){
        // do stuff
    }

    /**
     * Get if this king is at stalemate
     *
     * @return Whether this king is at stalemate
     */
    public boolean isStaleMate(){
        // do stuff
    }
}
