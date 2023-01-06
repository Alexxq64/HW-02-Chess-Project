public class Horse extends ChessPiece{

    public Horse(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }


    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
//        return (((Math.abs(line - toLine ) + (Math.abs(column - toColumn)) == 3
//                && !((line == toLine) && (column == toColumn)))
//                && checkPos(toLine) && checkPos(toColumn)));
//        boolean theSameColor = this.color == chessBoard.nowPlayerColor();
        if (!checkPos(toLine) || !checkPos(toColumn)) return false;
//        if ((line == toLine) && (column == toColumn)) return false;
        if (Math.abs(line - toLine ) + Math.abs(column - toColumn) == 3) {
            if (chessBoard.board[toLine][toColumn] == null) return true;
            else if (this.color != chessBoard.board[toLine][toColumn].getColor())  return true;
        }
        return false;
    }

    boolean checkPos(int i){
        return  (i >= 0 && i <= 7);
    }

    @Override
    public String getSymbol() {
        return "H";
    }
}
