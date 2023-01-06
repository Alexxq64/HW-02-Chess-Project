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
        return ((Math.abs(line - toLine) <= 1 && Math.abs(column - toColumn) <= 1)
                && !((line == toLine) && (column == toColumn))
                && checkPos(toLine) && checkPos(toColumn));
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
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                cp = board.board[i][j];
                if ((cp != null) && (cp.getColor() != this.getColor()) &&
                    (cp.canMoveToPosition(board, i, j, line, column))) return true;
            }
        }
        return false;
    }
}
