package me.border.chess.piece;

import me.border.chess.game.Team;
import me.border.chess.ui.Field;

import java.util.List;

public class Bishop extends Piece {

    public Bishop(Team team, Field field){
        super(team, PieceType.BISHOP, field);
    }

    @Override
    public List<Field> getAccessibleFields() {
        return null;
    }
}
