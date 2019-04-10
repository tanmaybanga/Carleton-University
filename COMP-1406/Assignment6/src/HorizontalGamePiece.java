/**
 * Created by Imran Juma on 2017-03-06.
 */


import javafx.scene.paint.Color;

public class HorizontalGamePiece extends GamePiece {
    public HorizontalGamePiece (int w, Color c, int x, int y) {
        super (w,1, c, x, y);
    }

    // Moving Left
    // We did not enter the 5x5 Grid here because we used the width code
        public boolean canMoveLeftIn (GameBoard b) {
        if (topLeftX == 0)
            return false;
        else if(b.pieceAt(topLeftX, topLeftY) != null)
            return false;
        else
            return true;
    }

    // Moving Right
    // We did not enter the 5x5 Grid here because we used the width code
    public boolean canMoveRightIn(GameBoard b) {
        for (int x = 5; x < GameBoard.WIDTH; x++) {
            if (((this.topLeftX + this.width - 1) == GameBoard.WIDTH) || ((b.pieceAt(topLeftX + 1 + width - 1, topLeftY) != null))) {
                return false;
            }
        }
        return true;
    }

}

