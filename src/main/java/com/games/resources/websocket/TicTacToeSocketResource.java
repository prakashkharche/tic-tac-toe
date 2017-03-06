package com.games.resources.websocket;

import com.games.entity.Result;
import com.games.entity.tictactoe.Position;
import com.games.entity.tictactoe.TicTacToe;
import com.games.exception.StoreException;
import com.games.service.TicTacToeService;
import com.games.store.GameStore;
import com.games.store.MapStore;
import com.google.inject.Inject;

import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

/**
 * Created by prakash.vijay on 06/03/17.
 */
@ServerEndpoint(value = "/tic-tac-toe/{gameId}/player/{playerId}")
public class TicTacToeSocketResource {

    private TicTacToeService ticTacToeService;

    public TicTacToeSocketResource() {
        ticTacToeService = new TicTacToeService();
    }

    @OnOpen
    public void start(final Session session, @PathParam("gameId") String gameId, @PathParam("playerId") String playerId) throws StoreException {
        ticTacToeService.assignSession(gameId, playerId, session);
        session.getAsyncRemote().sendText("welcome");
    }

    @OnMessage
    public void playerMarked(final Session session, @PathParam("gameId") String gameId, @PathParam("playerId") String playerId, String position) throws StoreException {
        int row = Integer.valueOf(position.split(",")[0]);
        int column = Integer.valueOf(position.split(",")[1]);
        Result result = ticTacToeService.mark(gameId, playerId, new Position(row, column));
        TicTacToe ticTacToe = ticTacToeService.get(gameId);
        if (result == Result.WON) {
            ticTacToe.getPlayer(playerId).session.getAsyncRemote().sendText(result.name());
            ticTacToe.getOtherPlayer(playerId).session.getAsyncRemote().sendText(Result.LOST.name());
            return;
        }
        if (result == Result.DRAW) {
            ticTacToe.getPlayer(playerId).session.getAsyncRemote().sendText(Result.DRAW.name());
            ticTacToe.getOtherPlayer(playerId).session.getAsyncRemote().sendText(Result.DRAW.name());
            return;
        }
        ticTacToe.getPlayer(playerId).session.getAsyncRemote().sendText(result.name());
        ticTacToe.getOtherPlayer(playerId).session.getAsyncRemote().sendText(result.name());
    }
}
