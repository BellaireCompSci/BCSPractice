package uva;

import java.util.Scanner;

public class CheckTheCheck {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        char[][] board;
        board = readBoard();
        int gameNum = 1;
        while (!isEmpty(board)) {
            System.out.printf("Game #%d: %s\n", gameNum,
                              getResult(board));
            gameNum++;
            board = readBoard();
        }
    }
    
    private static String getResult(char[][] board) {
        boolean isInCheck = false;
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[i].length; j++) {
                // white pieces are uppercase
                // black pieces are lowercase
                boolean isWhite = Character.isUpperCase(board[i][j]);
                switch (Character.toUpperCase(board[i][j])) {
                    case 'P':
                        isInCheck |= pawnChecks(board, i, j, isWhite);
                        break;
                    case 'R':
                        isInCheck |= rookChecks(board, i, j, isWhite);
                        break;
                    case 'B':
                        isInCheck |= bishopChecks(board, i, j, isWhite);
                        break;
                    case 'Q':
                        isInCheck |= queenChecks(board, i, j, isWhite);
                        break;
                    case 'K':
                        isInCheck |= kingChecks(board, i, j, isWhite);
                        break;
                    case 'N':
                        isInCheck |= knightChecks(board, i, j, isWhite);
                        break;
                }
                if (isInCheck) {
                    if (isWhite) return "black king is in check.";
                    else return "white king is in check.";
                }
            }
        }
        return "no king is in check.";
    }
    
    private static char[][] readBoard() {
        char[][] board = new char[8][8];
        for (int i=0; i<board.length; i++) {
            String row = in.nextLine();
            for (int j=0; j<board[i].length; j++) {
                board[i][j] = row.charAt(j);
            }
        }
        in.nextLine();
        return board;
    }
    
    private static boolean isEmpty(char[][] board) {
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[i].length; j++) {
                if (board[i][j] != '.') {
                    return false;
                }
            }
        }
        return true;
    }
    
    private static boolean isPieceAt(char[][] board, int i, int j) {
        if (i<0 || i>board.length-1) return false;
        if (j<0 || j>board[i].length-1) return false;
        if (board[i][j] == '.') return false;

        return true;
    }
    
    private static boolean isKingAt(char[][] board, int i, int j, boolean isWhite) {
        if (!isPieceAt(board, i, j)) return false;
        
        if (isWhite) return board[i][j] == 'K';
        else return board[i][j] == 'k';
    }
    
    private static boolean pawnChecks(char[][] board, int i, int j, boolean isWhite) {
        if (isWhite)
            return isKingAt(board, i+1, j-1, !isWhite) || isKingAt(board, i+1, j+1, !isWhite);
        else return isKingAt(board, i-1, j-1, !isWhite) || isKingAt(board, i-1, j+1, !isWhite);

    }
    
    private static boolean rookChecks(char[][] board, int i, int j, boolean isWhite) {
        // down
        for (int n=1; n<8; n++) {
            if (isPieceAt(board, i+n, j)) {
                if (isKingAt(board, i+n, j, !isWhite)) return true;
                else break;
            }
        }
        // up
        for (int n=1; n<8; n++) {
            if (isPieceAt(board, i-n, j)) {
                if (isKingAt(board, i-n, j, !isWhite)) return true;
                else break;
            }
        }
        // right
        for (int n=1; n<8; n++) {
            if (isPieceAt(board, i, j+n)) {
                if (isKingAt(board, i, j+n, !isWhite)) return true;
                else break;
            }
        }
        // left
        for (int n=1; n<8; n++) {
            if (isPieceAt(board, i, j-n)) {
                if (isKingAt(board, i, j-n, !isWhite)) return true;
                else break;
            }
        }
        return false;
    }
    
    private static boolean bishopChecks(char[][] board, int i, int j, boolean isWhite) {
        // up-left
        for (int n=1; n<8; n++) {
            if (isPieceAt(board, i-n, j-n)) {
                if (isKingAt(board, i-n, j-n, !isWhite)) return true;
                else break;
            }
        }
        // up-right
        for (int n=1; n<8; n++) {
            if (isPieceAt(board, i-n, j+n)) {
                if (isKingAt(board, i-n, j+n, !isWhite)) return true;
                else break;
            }
        }
        // down-left
        for (int n=1; n<8; n++) {
            if (isPieceAt(board, i+n, j-n)) {
                if (isKingAt(board, i+n, j-n, !isWhite)) return true;
                else break;
            }
        }
        // down-right
        for (int n=1; n<8; n++) {
            if (isPieceAt(board, i+n, j+n)) {
                if (isKingAt(board, i+n, j+n, !isWhite)) return true;
                else break;
            }
        }
        return false;
    }
    
    private static boolean queenChecks(char[][] board, int i, int j, boolean isWhite) {
        return rookChecks  (board, i, j, isWhite) ||
               bishopChecks(board, i, j, isWhite);
    }
    
    private static boolean kingChecks(char[][] board, int i, int j, boolean isWhite) {
        for (int n=-1; n<=1; n++) {
            for (int m=-1; m<=1; m++) {
                if (isKingAt(board, i+n, j+n, !isWhite)) return true;
            }
        }
        return false;
    }
    
    private static boolean knightChecks(char[][] board, int i, int j, boolean isWhite) {
        for (int n = -1; n<=1; n+=2) {
            for (int m=-2; m<=2; m+= 4) {
                if (isKingAt(board, i+n, j+m, !isWhite) ||
                    isKingAt(board, i+m, j+n, !isWhite)) return true;
            }
        }
        return false;
    }
}
