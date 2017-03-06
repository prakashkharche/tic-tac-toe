package com.games.store;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.games.core.JsonConverter;
import com.games.entity.Game;
import com.games.exception.StoreException;
import com.google.inject.Inject;
//import redis.clients.jedis.Jedis;

import java.io.IOException;

/**
 * Created by prakash.vijay on 24/08/16.
 */
//public class RedisGameStore<T extends Game> implements GameStore<T> {
//
//    private Jedis jedis;
//
//    @Inject
//    public RedisGameStore(Jedis jedis) {
//        this.jedis = jedis;
//    }
//
//    public T getGame(String id) throws StoreException {
//        String gameEnvString = jedis.get(id);
//        Class<T> tClass = null;
//        try {
//            return JsonConverter.fromJson(gameEnvString, tClass);
//        } catch (IOException e) {
//            e.printStackTrace();
//            throw new StoreException("Unable to get game environment");
//        }
//    }
//
//    public void saveGame(T gameEnvironment) throws StoreException {
//        try {
//            String envJson = JsonConverter.toJson(gameEnvironment);
//            jedis.set(gameEnvironment.uuid, envJson);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//            throw new StoreException("Unable to save game environment");
//        }
//    }
//}
