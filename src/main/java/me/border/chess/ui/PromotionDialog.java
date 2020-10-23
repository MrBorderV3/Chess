package me.border.chess.ui;

import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import me.border.chess.piece.*;

/**
 * Dialog class for the dialog when transforming a pawn to a different kind of piece when reaching the end of the other side of the field.
 */
public class PromotionDialog extends Dialog<Piece> {

    private Piece selectedFigure;

    public PromotionDialog(Pawn pawn) {
        setTitle("Promote Pawn " + pawn.getTeam().toString());
        setResultConverter(f -> selectedFigure);
        HBox hbox = new HBox();
        hbox.getChildren().add(new CandidateLabel(new Queen(pawn.getTeam(), null)));
        hbox.getChildren().add(new CandidateLabel(new Knight(pawn.getTeam(), null)));
        hbox.getChildren().add(new CandidateLabel(new Rook(pawn.getTeam(), null)));
        hbox.getChildren().add(new CandidateLabel(new Bishop(pawn.getTeam(), null)));
        getDialogPane().setContent(hbox);
    }


    /**
     * Inner label class for possible candidates
     */
    private static class CandidateLabel extends Label {

        Piece piece;

        private CandidateLabel(Piece piece){
            setGraphic(piece.getImage());
            this.piece = piece;
            setOnMouseReleased(this::onMouseReleased);
        }

        private void onMouseReleased(MouseEvent e){

        }
    }
}
