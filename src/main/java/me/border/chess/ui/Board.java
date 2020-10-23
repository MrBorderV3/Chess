package me.border.chess.ui;

import javafx.scene.layout.GridPane;
import me.border.chess.game.Team;
import me.border.chess.piece.King;
import me.border.chess.piece.Piece;

import java.util.*;

/**
 * This class represents the chess board
 */
public class Board extends GridPane {

    private Map<FieldPosition, Field> fieldMap = new HashMap<>();
    private Map<Team, Set<Field>> attackedFields = new HashMap<>();
    private Set<Piece> pieces = new HashSet<>();

    // These two refs will track both kings
    private King whiteKing;
    private King blackKing;

    private int turn = 1;

    /**
     * Recalculate the attacked fields
     */
    public void recalculateAttackedFields(){
        resetAttackedFields();
        for (Field f : fieldMap.values()){
            if (f.getPiece() != null) {
                if (f.getPiece().getTeam() == Team.WHITE) {
                    attackedFields.get(Team.WHITE).addAll(f.getPiece().getAccessibleFields());
                } else {
                    attackedFields.get(Team.BLACK).addAll(f.getPiece().getAccessibleFields());
                }
            }
        }
    }

    /**
     * Reset all the attacked fields
     */
    private void resetAttackedFields() {
        attackedFields.put(Team.BLACK, new HashSet<>());
        attackedFields.put(Team.WHITE, new HashSet<>());
    }

    /**
     * Clear the board
     */
    public void clear(){
        for (Field field : fieldMap.values()){
            field.setPiece(null, true);
        }

        resetAttackedFields();
        pieces.clear();
        turn = 1;
    }

    /**
     * Test the current game state as to whether its at check/checkmate/stalemate
     */
    public void gameStateTest(){
        King king = getKing(getCurrentTeam());
        if (king != null) {
            if (king.isCheck()) {
                if (king.isCheckMate()) {
                    // Display winner
                    return;
                } else {
                    // Display must defend
                    return;
                }
            } else if (king.isStaleMate()) {
                // Display draw
                return;
            }
        }
    }

    // ********************************** //
    //      SELF EXPLANATORY GETTERS
    // ********************************** //
    public Set<Piece> getPieces(){
        return pieces;
    }

    public Set<Piece> getPieces(Team team){
        Set<Piece> teamPieces = new HashSet<>();
        for (Piece piece : pieces){
            if (piece.getTeam().equals(team)){
                teamPieces.add(piece);
            }
        }

        return teamPieces;
    }

    public Set<Field> getAllAccessibleFields(Team team) {
        return attackedFields.get(team);
    }

    public King getKing(Team team){
        return team == Team.WHITE ? whiteKing : blackKing;
    }

    public Field getField(FieldPosition position){
        return fieldMap.get(position);
    }

    public int getTurn() {
        return turn;
    }

    public Team getCurrentTeam(){
        return turn % 2 == 0 ? Team.BLACK : Team.WHITE;
    }
}
