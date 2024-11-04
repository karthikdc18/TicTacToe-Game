package com.tictactoe.service;



import org.springframework.stereotype.Service;

@Service
public class TicTacToe {
    private char[][] board;
    private char currentPlayer;

    public TicTacToe() {
        resetGame();
    }

    public void resetGame() {
        board = new char[3][3];
        currentPlayer = 'X'; // X always starts first
    }

    public char[][] getBoard() {
        return board;
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public String makeMove(int row, int col) {
        if (row < 0 || row > 2 || col < 0 || col > 2 || board[row][col] != 0) {
            return "Invalid move";
        }
        board[row][col] = currentPlayer;
        String result = checkWinner();
        if (result.equals("No winner")) {
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X'; // Switch player
        }
        return result;
    }

    private String checkWinner() {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != 0 && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return board[i][0] + " wins!";
            }
            if (board[0][i] != 0 && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                return board[0][i] + " wins!";
            }
        }
        // Check diagonals
        if (board[0][0] != 0 && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return board[0][0] + " wins!";
        }
        if (board[0][2] != 0 && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return board[0][2] + " wins!";
        }
        // Check for a draw
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 0) {
                    return "No winner";
                }
            }
        }
        return "It's a draw!";
    }
}
