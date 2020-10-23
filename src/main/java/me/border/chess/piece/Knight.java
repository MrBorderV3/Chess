package me.border.chess.piece;

import me.border.chess.game.Team;
import me.border.chess.ui.Field;

import java.util.List;

public class Knight extends Piece {

    public Knight(Team team, Field field){
        super(team, PieceType.KNIGHT, field);
    }

    @Override
    public List<Field> getAccessibleFields() {
        return null;
    }
}
