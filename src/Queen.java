public class Queen extends ChessPiece{

// moving direction of this chess piece
    int[][] vectors = {{1, 1}, {1, -1}, {-1, 1}, {-1, -1}, {0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public Queen(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        fillPossibleMoves(vectors, chessBoard, line, column);
        return possibleMoves[toLine][toColumn];
    }

    boolean checkPos(int i){
        return  (i >= 0 && i <= 7);
    }

    @Override
    public String getSymbol() {
        return "Q";
    }
}

