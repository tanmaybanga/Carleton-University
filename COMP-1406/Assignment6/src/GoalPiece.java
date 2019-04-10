/**
 * Created by Imran Juma on 2017-03-06.
 */


import javafx.scene.paint.Color;

public class GoalPiece extends HorizontalGamePiece {
    public GoalPiece(int x, int y) {
        super(2, Color.RED, x, y);
    }
    public boolean canMoveRightIn(GameBoard b) {
        for (int x = 0; x < GameBoard.WIDTH; x++){
            if (((this.topLeftX + this.width-1) == getTopLeftX())){
                return true;
            }
        }
        return false;
    }
}

