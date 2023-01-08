public class Bishop extends ChessPiece{

// moving direction of this chess piece
    int[][] vectors = {{1, 1},{1, -1},{-1, 1}, {-1, -1}};

    public Bishop(String color) {
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


    @Override
    public String getSymbol() {
        return "B";
    }
}

