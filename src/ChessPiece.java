public abstract class ChessPiece {

    boolean[][] testCB = new boolean[8][8];

    String color;
    boolean check = true;

    public ChessPiece(String color) {
        this.color = color;
    }
//    public boolean theSameColor(ChessBoard chessBoard){
//        return color == chessBoard.board;
//    }
    public abstract String getColor();
    public abstract boolean canMoveToPosition(
            ChessBoard chessBoard, int line, int column, int toLine, int toColumn);
    public abstract String getSymbol();

    void fillPossibleMoves(int[][] vectors, ChessBoard cb, int line, int column) {
        for (int[] v: vectors) {
            System.out.println("Vector: " + v[0] + " " + v[1]);
            for (int i = line + v[0], j = column + v[1]; (checkPos(i) && checkPos(j)); i += v[0], j += v[1]) {
                if (cb.board[i][j] == null) {
                    System.out.println(i + " " + j);
                    testCB[i][j] = true;}
                else if (this.color != cb.board[i][j].getColor()) {
                    System.out.println(i + " " + j);
                    testCB[i][j] = true;
                    break;
                }
                else break;
            }
        }
        System.out.println(line + " " + column);
        System.out.println("  0 1 2 3 4 5 6 7");
        for (int i = 7; i >= 0; i--) {
            System.out.print(i);
            for (int j = 0; j < 8; j++) {
                if (i == line && j == column) System.out.print(" X");
                else if (testCB[i][j]) System.out.print(" O");
                else System.out.print(" -");
            }
            System.out.println();
        }
    }

    boolean checkPos(int i){
        return  (i >= 0 && i <= 7);
    }

}
