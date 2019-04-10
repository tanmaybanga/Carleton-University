/**
 * Created by Imran Juma on 2017-03-06.
 */

import javafx.scene.paint.Color;

public class VerticalGamePiece extends GamePiece {
    public VerticalGamePiece(int h, Color c, int x, int y) {
        super(1, h, c, x, y);
    }

    public boolean canMoveDownIn(GameBoard b)
    {
        if ((this .topLeftY == 0) || (b.pieceAt(topLeftX,topLeftY-1) != null)){

            return false;
        }

        return true;
    }
    public boolean canMoveUpIn(GameBoard b)
    {
        if (((this.topLeftY + this.height-1) == GameBoard.HEIGHT) || ((b.pieceAt(topLeftX + 1 + width - 1,topLeftY + 1 + height -1) != null))){

            return false;
        }

        return true;
    }
}

