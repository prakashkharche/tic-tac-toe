package com.games.entity;

import java.util.UUID;

/**
 * Created by prakash.vijay on 24/08/16.
 */
public abstract class Game {
    public String uuid;

    public Game() {
        this.uuid = UUID.randomUUID().toString();
    }
}
