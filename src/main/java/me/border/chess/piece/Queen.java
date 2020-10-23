package me.border.chess.piece;

import me.border.chess.game.Team;
import me.border.chess.ui.Field;

import java.util.List;

public class Queen extends Piece {

    public Queen(Team team, Field field){
        super(team, PieceType.QUEEN, field);
    }

    @Override
    public List<Field> getAccessibleFields() {
        return null;
    }
}
