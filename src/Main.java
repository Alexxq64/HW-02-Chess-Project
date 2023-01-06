public class Main {
    public static void main(String[] args) {
        ChessBoard chbr = new ChessBoard();
        chbr.printBoard();

        int posL = 6;
        int posC = 1;
        ChessPiece p = new Bishop("White");
        System.out.println(p.getSymbol() + " " + p.getColor() + " " + posL + " " + posC );
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (p.canMoveToPosition(chbr, posL, posC, i, j))
                    System.out.println(posL + " " + posC + "      " + i + " " + j);;

            }
        }

        p = new Pawn("Black");
        System.out.println(p.getSymbol() + " " + p.getColor() + " " + posL + " " + posC );
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (p.canMoveToPosition(chbr, posL, posC, i, j))
                    System.out.println(posL + " " + posC + "      " + i + " " + j);;

            }
        }
        p = new King("Black");
        System.out.println(p.getSymbol() + " " + p.getColor() + " " + posL + " " + posC );
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (p.canMoveToPosition(chbr, posL, posC, i, j))
                    System.out.println(posL + " " + posC + "      " + i + " " + j);;

            }
        }
    }
}