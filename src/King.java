public class King extends ChessPiece{

    public King(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        cleanPossibleMoves();
        for (int i = line - 1; i <= line + 1; i++) {
            if (!checkPos(i)) continue;
            for (int j = column - 1; j <= column + 1 ; j++) {
                if (!checkPos(j)) continue;
                if (!isUnderAttack(chessBoard, i, j)) {
                    if (chessBoard.board[i][j] == null) possibleMoves[i][j] = true;
                    else if ((color) != chessBoard.board[i][j].getColor()) possibleMoves[i][j] = true;
                } 
            }
        }
        return possibleMoves[toLine][toColumn];
//        return ((Math.abs(line - toLine) <= 1 && Math.abs(column - toColumn) <= 1)
//                && !((line == toLine) && (column == toColumn))
//                && checkPos(toLine) && checkPos(toColumn));
// check out if in the "to position" there is a chess piece of the same color
// check out if in the "to position" the king will not be under attack
    }

    boolean checkPos(int i){
        return  (i >= 0 && i <= 7);
    }

    @Override
    public String getSymbol() {
        return "K";
    }

    boolean isUnderAttack(ChessBoard board, int line, int column){
        ChessPiece cp;
        int k = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (k == 64) return false;
                k++;
                cp = board.board[i][j];
                if ((cp != null) && (cp.getColor() != this.getColor()) &&
                    (cp.canMoveToPosition(board, i, j, line, column))) return true;
            }
        }
        return false;
    }
}
