public abstract class ChessPiece {

// all possible moves of this chess piece in this position (bishop, rook and queen only)
    boolean[][] possibleMoves = new boolean[8][8];

    void cleanPossibleMoves(){
        for (int i = 0; i < 8 ; i++) {
            for (int j = 0; j < 8; j++) {
                possibleMoves[i][j] = false;
            }
        }
    }

    String color;
    boolean check = true;

    public ChessPiece(String color) {
        this.color = color;
    }
    public abstract String getColor();
    public abstract boolean canMoveToPosition(
            ChessBoard chessBoard, int line, int column, int toLine, int toColumn);
    public abstract String getSymbol();


    void fillPossibleMoves(int[][] vectors, ChessBoard cb, int line, int column) {
// passing by each possible direction until the end of the board or to next chess piece
// and fulfilling the possibleMoves
        cleanPossibleMoves();
        for (int[] v: vectors) {
            for (int i = line + v[0], j = column + v[1]; (checkPos(i) && checkPos(j)); i += v[0], j += v[1]) {
                if (cb.board[i][j] == null) {
                    possibleMoves[i][j] = true;}
                else if (this.color != cb.board[i][j].getColor()) {
                    possibleMoves[i][j] = true;
                    break;
                }
                else break;
            }
        }
    }

    boolean checkPos(int i){
        return  (i >= 0 && i <= 7);
    }

}
