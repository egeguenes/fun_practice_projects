package piece;

import main.GamePanel;
import main.Type;

public class Pawn extends Piece {

    public Pawn(int color, int col, int row) {
        super(color, col, row);

        type = Type.PAWN;
        if (color == GamePanel.WHITE) image = getImage("/piece/w-pawn");
        else image = getImage("/piece/b-pawn");
    }

    public boolean canMove(int targetCol, int targetRow) {
        if (isWithinBoard(targetCol, targetRow) && !isSameSquare(targetCol, targetRow)) {
            // define the move value based on the color -> white goes up, black goes down
            int moveValue;
            if (color == GamePanel.WHITE) {
                moveValue = -1;
            } else {
                moveValue = 1;
            }

            hittingP = getHittingP(targetCol, targetRow);

            // can move 1 square
            if (targetCol == preCol && targetRow == preRow+moveValue && hittingP == null) {
                return true;
            }

            // can move 2 sqaures if hasnt moved
            if (targetCol == preCol && targetRow == preRow+(moveValue*2) && hittingP == null && !hasMoved && !pieceIsOnStraightLine(targetCol, targetRow)) {
                return true;
            }

            // can take the diagonal piece
            if (Math.abs(targetCol - preCol) == 1 && targetRow == preRow+moveValue && hittingP != null && hittingP.color != this.color) {
                return true;
            }

            // En passant
            if (Math.abs(targetCol - preCol) == 1 && targetRow == preRow+moveValue) {
                for (Piece piece : GamePanel.simPieces) {
                    if (piece.col == targetCol && piece.row == targetRow && piece.twoStepped) {
                        hittingP = piece;
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
