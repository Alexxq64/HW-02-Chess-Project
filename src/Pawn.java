public class Pawn extends ChessPiece{

    public Pawn(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        int direction = getColor() == "White" ? 1 : -1;
        int initialLine = getColor() == "White" ? 1 : 6;
        int prohibitedLine = getColor() == "White" ? 0 : 7;
        if (!checkPos(line) || !checkPos(toLine) || !checkPos(column) || !checkPos(toColumn)) return false;
        if (line == prohibitedLine || toLine == prohibitedLine) return false;
        if (line == initialLine && column == toColumn && (toLine - line) * direction == 2 &&
            chessBoard.board[line + direction][column] == null &&
            chessBoard.board[toLine][column] == null)
            return true;
        if (line + direction == toLine && column  == toColumn
            && chessBoard.board[toLine][column] == null) return true;
        for (int j = -1; j <= 1; j +=2) {
            if (line + direction == toLine && (column + j)  == toColumn
                && chessBoard.board[toLine][column + j] != null
                && chessBoard.board[toLine][column + j].getColor() != color) return true;
        }
            return false;
    }

    boolean checkPos(int i){
        return  (i >= 0 && i <= 7);
    }

    @Override
    public String getSymbol() {
        return "P";
    }
}

