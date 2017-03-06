package com.games.service;

import com.games.entity.Player;
import com.games.entity.Result;
import com.games.entity.tictactoe.Position;
import com.games.entity.tictactoe.TicTacToe;
import com.games.exception.StoreException;
import com.games.store.GameStore;
import com.games.store.MapStore;

import javax.websocket.Session;
import java.util.UUID;

/**
 * Created by prakash.vijay on 24/08/16.
 */
public class TicTacToeService {
    private static GameStore<TicTacToe> ticTacToeGameStore = new MapStore<>();


    public TicTacToe init() throws StoreException {
        String player1Id = "p1";
        System.out.println("Player 1 is :" + player1Id);
        Player player1 = new Player(player1Id, "Prakash");

        String player2Id = "p2";
        System.out.println("Player 2 is :" + player1Id);
        Player player2 = new Player(player2Id, "Robin");
        TicTacToe ticTacToe = TicTacToe.newGame(3, player1, player2);
        System.out.println("Game Id : " + ticTacToe.uuid);

        ticTacToeGameStore.saveGame(ticTacToe);
        return ticTacToe;

    }

    public void assignSession(String gameId, String playerId, Session session) throws StoreException {
        TicTacToe game = ticTacToeGameStore.getGame(gameId);
        game.getPlayer(playerId).session = session;
    }

    public Result mark(String gameId, String playerId, Position position) throws StoreException {
        TicTacToe ticTacToe = ticTacToeGameStore.getGame(gameId);
        return ticTacToe.getPlayer(playerId).mark(position);
    }

    public TicTacToe get(String gameId) throws StoreException {
        return ticTacToeGameStore.getGame(gameId);
    }
}
