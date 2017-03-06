package com.games.store;

import com.games.entity.Game;
import com.games.exception.StoreException;

/**
 * Created by prakash.vijay on 24/08/16.
 */
public interface GameStore<T extends Game> {
    T getGame(String id) throws StoreException;
    void saveGame(T game) throws StoreException;
}
