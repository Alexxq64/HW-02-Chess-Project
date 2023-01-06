public class Rook extends ChessPiece{
    public Rook(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        return (((line == toLine ) || (column == toColumn))
                && !((line == toLine ) && (column == toColumn))
                && checkPos(toLine) && checkPos(toColumn) && checkPos(line) && checkPos(column) );
    }

    boolean checkPos(int i){
        return  (i >= 0 && i <= 7);
    }

    @Override
    public String getSymbol() {
        return "R";
    }
}

