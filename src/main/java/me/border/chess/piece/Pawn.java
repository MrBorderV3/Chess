package me.border.chess.piece;

import me.border.chess.game.Team;
import me.border.chess.ui.Field;

import java.util.List;

public class Pawn extends Piece {

    public Pawn(Team team, Field field){
        super(team, PieceType.PAWN, field);
    }

    @Override
    public List<Field> getAccessibleFields() {
        return null;
    }
}
