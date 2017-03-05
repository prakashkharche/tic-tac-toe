package com.games.store;

import com.games.entity.GameEnvironment;
import com.games.exception.StoreException;

/**
 * Created by prakash.vijay on 24/08/16.
 */
public interface GameEnvironmentStore<T extends GameEnvironment> {
    T getGameEnvironment(String id) throws StoreException;
    void addGameEnvironment(T game) throws StoreException;
}
