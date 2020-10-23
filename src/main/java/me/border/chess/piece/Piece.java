package me.border.chess.piece;

import javafx.scene.image.ImageView;
import me.border.chess.game.Team;
import me.border.chess.ui.Field;
import me.border.chess.ui.FieldPosition;
import me.border.chess.ui.Game;
import me.border.chess.utils.Helper;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract class for all chess pieces.
 */
public abstract class Piece {

    protected Team team;
    protected PieceType type;
    protected Field field;
    protected FieldPosition pos;
    private ImageView image;
    private String name;

    /**
     * Construct a piece with the given team, type, and if applicable, field.
     *
     * @param team The team the piece is on
     * @param type The type of the piece
     * @param field The field the piece is on (Can be null)
     */
    public Piece(Team team, PieceType type, Field field){
        this.team = team;
        this.type = type;
        this.name = team.toString().toLowerCase() + "-" + type.toString().toLowerCase();
        this.image = Helper.getPieceImage(this);
        if (field != null){
            this.field = field;
            this.pos = field.getFieldPos();
            field.setPiece(this, true);
        }
    }

    /**
     * Move the piece to the given field
     *
     * @param field The field to move the piece to
     * @param graphic Whether to simulate it or not
     * @return Whether the Piece was successfully moved
     */
    public Piece move(Field field, boolean graphic){
        Piece killedPiece = field.getPiece();
        field.setPiece(this, graphic);
        if (this.field != null) {
            this.field.setPiece(null, graphic);
        }
        FieldPosition oldPos = pos;
        pos = field.getFieldPos();
        setField(field);
        Piece postPiece = postTurnAction(Game.getBoard().getField(oldPos), field, graphic);

        return killedPiece == null ? postPiece : killedPiece;
    }

    /**
     * Check if this piece can move to the given field
     *
     * @param field Field to check against
     * @return Whether it can move to the given field
     */
    public boolean canMoveTo(Field field){
        return canMove() && getAllAccessibleFields().contains(field);
    }

    /**
     * Check if this piece can move at the current turn
     *
     * @return Whether it can move at the current turn
     */
    public boolean canMove(){
        return Game.getBoard().getCurrentTeam() == getTeam();
    }

    /**
     * Get all accessible fields on the board
     *
     * @return A list of all accessible fields on the board
     */
    public List<Field> getAllAccessibleFields() {
        List<Field> fields = getAccessibleFields();
        King king = Game.getBoard().getKing(team);
        if (king != null) {
            List<Field> trueFields = new ArrayList<>();
            Field oldField = field;
            for (Field to : fields) {
                //simulate move to that field
                Piece killedFigure = move(to, false);
                Game.getBoard().recalculateAttackedFields();
                boolean check = king.isCheck();
                if (!check) {
                    trueFields.add(to);
                }
                //revert move
                move(oldField, false);
                if (killedFigure != null) {
                    killedFigure.getField().setPiece(killedFigure, false);
                }
                Game.getBoard().recalculateAttackedFields();
            }
            fields = trueFields;
        }
        return fields;
    }

    /**
     *
     *
     * @param oldField
     * @param newField
     * @param graphic
     * @return
     */
    public Piece postTurnAction(Field oldField, Field newField, boolean graphic) {
        return null;
    }

    /**
     * Get accessible fields for this piece
     *
     * @return A list of all the accessible fields for this piece
     */
    public abstract List<Field> getAccessibleFields();

    // ********************************** //
    //      SELF EXPLANATORY SETTERS
    // ********************************** //
    public void setField(Field field){
        this.field = field;
    }


    // ********************************** //
    //      SELF EXPLANATORY GETTERS
    // ********************************** //
    public String getName(){
        return name;
    }

    public ImageView getImage(){
        return image;
    }

    public Field getField(){
        return field;
    }

    public FieldPosition getPos(){
        return pos;
    }

    public PieceType getType(){
        return type;
    }

    public Team getTeam(){
        return team;
    }
}
