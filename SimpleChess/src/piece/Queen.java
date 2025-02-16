package piece;

import main.GamePanel;
import main.Type;

public class Queen extends Piece {

    public Queen(int color, int col, int row) {
        super(color, col, row);

        type = Type.QUEEN;
        if (color == GamePanel.WHITE) image = getImage("/piece/w-queen");
        else image = getImage("/piece/b-queen");
    }

    public boolean canMove(int targetCol, int targetRow) {
        if (isWithinBoard(targetCol, targetRow) && !isSameSquare(targetCol, targetRow)) {

            // checking rook behaviour
            if (targetRow == preRow || targetCol == preRow) {
                if (isValidSquare(targetCol, targetRow) && !pieceIsOnStraightLine(targetCol, targetRow)) {
                    return true;
                }
            }

            // checking bishop behaviour
            if (Math.abs(targetRow - preRow) == Math.abs(targetCol- preCol)) {
                if (isValidSquare(targetCol, targetRow) && !pieceIsOnDiagonalLine(targetCol, targetRow)) {
                    return true;
                }
            }
        }

        return false;
    }
}
