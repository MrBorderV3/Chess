package me.border.chess.piece;

import me.border.chess.game.Team;
import me.border.chess.ui.Field;

import java.util.List;

public class Rook extends Piece {

    public Rook(Team team, Field field){
        super(team, PieceType.ROOK, field);
    }

    @Override
    public List<Field> getAccessibleFields() {
        return null;
    }
}
