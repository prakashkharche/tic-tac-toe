package com.games.store;

import com.games.entity.Game;
import com.games.exception.StoreException;
import com.google.common.collect.Maps;

import java.util.Map;

/**
 * Created by prakash.vijay on 05/03/17.
 */
public class MapStore<T extends Game> implements GameStore<T>{

    private Map<String, T> idGameMap;

    public MapStore() {
        idGameMap = Maps.newConcurrentMap();
    }

    @Override
    public T getGame(String id) throws StoreException {
        return idGameMap.get(id);
    }

    @Override
    public void saveGame(T game) throws StoreException {
        idGameMap.put(game.uuid, game);
    }
}
