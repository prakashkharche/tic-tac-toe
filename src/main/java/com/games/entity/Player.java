package com.games.entity;

import com.games.entity.tictactoe.Mark;
import com.games.entity.tictactoe.Position;
import com.games.entity.tictactoe.TicTacToe;

import javax.websocket.Session;

/**
 * Created by prakash.vijay on 05/08/16.
 */
public class Player {
    public String uuid;
    public String name;
    public Mark mark;
    public Session session;

    private TicTacToe game;

    public Player(String uuid, String name) {
        this.uuid = uuid;
        this.name = name;
    }

    public Result mark(Position position) {
        return game.markCell(position, mark);
    }

    public void setGame(TicTacToe game) {
        this.game = game;
    }
}
