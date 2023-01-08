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
        ChessPiece cp = chessBoard.board[toLine][toColumn];
// if "to Position" on the next chessboard cell
        if ((Math.abs(line - toLine) <= 1 && Math.abs(column - toColumn) <= 1)
// if "to Position" is not the same chessboard cell
                && !((line == toLine) && (column == toColumn))
// if "to Position" is within the chessboard
                && checkPos(toLine) && checkPos(toColumn)
// if "to Position" is empty or there is a chess-piece of opposite color and it is not defended
                && (cp == null || (cp.getColor() != color && !isDefended(chessBoard, toLine, toColumn))))
// if "to Position" is not under attack of any chess-piece of opposite color - return true
            if (!isUnderAttack(chessBoard, toLine, toColumn)) return true;
        return false;
    }

    boolean checkPos(int i){
        return  (i >= 0 && i <= 7);
    }

    @Override
    public String getSymbol() {
        return "K";
    }

    boolean isDefended(ChessBoard board, int line, int column){
        ChessBoard imagineCB = new ChessBoard();
        imagineCB = board;
        ChessPiece cp;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
// invert color to use method canMoveToPosition
                cp = imagineCB.board[i][j];
// if any chess-piece of the same color
                if (cp != null && cp.getColor() != color) {
// can move to the position (line, column) - this position is defended
                    cp.color = cp.getColor() == "White" ? "Black" : "White";
                    if (cp.canMoveToPosition(board, i, j, line, column)) return true;
                    cp.color = cp.getColor() == "White" ? "Black" : "White";
                }
            }
        }
        return false;
    }

    public boolean  isUnderAttack(ChessBoard board, int line, int column){
        ChessPiece cp;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                cp = board.board[i][j];
// if any chess-piece of opposite color
                if (cp != null && cp.getColor() != color)
// can move to the position (line, column) - this position is under attack
                    if (cp.canMoveToPosition(board, i, j, line, column)) return true;
            }
        }
        return false;
    }
}
