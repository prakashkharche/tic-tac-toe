package com.games.resources;

import com.games.exception.StoreException;
import com.games.service.TicTacToeService;
import com.google.inject.Inject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * Created by prakash.vijay on 06/03/17.
 */
@Path("/")
public class TicTacToeResource {

    private TicTacToeService ticTacToeService;

    @Inject
    public TicTacToeResource(TicTacToeService ticTacToeService) {
        this.ticTacToeService = ticTacToeService;
    }

    @GET
    public void init() throws StoreException {
        ticTacToeService.init();
    }
}
