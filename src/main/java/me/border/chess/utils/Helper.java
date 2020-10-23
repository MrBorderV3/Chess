package me.border.chess.utils;

import javafx.scene.image.ImageView;
import me.border.chess.piece.Piece;
import me.border.utilities.utils.URLUtils;


public class Helper {

    public static ImageView getImage(String urlPath){
        return new ImageView(URLUtils.getURL(urlPath).toString());
    }

    public static ImageView getPieceImage(Piece piece){
        return getImage("/images/" + piece.getName() + ".png");
    }
}
