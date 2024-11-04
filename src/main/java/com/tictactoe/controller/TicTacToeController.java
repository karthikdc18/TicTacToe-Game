package com.tictactoe.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.tictactoe.service.TicTacToe;

@RestController
@RequestMapping("/api/tictactoe")
public class TicTacToeController {

    @Autowired
    private TicTacToe game;

    @GetMapping("/board")
    public char[][] getBoard() {
        return game.getBoard();
    }

    @GetMapping("/move")
    public String makeMove(@RequestParam int row, @RequestParam int col) {
        return game.makeMove(row, col);
    }

    @PostMapping("/reset")
    public String resetGame() {
        game.resetGame();
        return "Game reset!";
    }
}
