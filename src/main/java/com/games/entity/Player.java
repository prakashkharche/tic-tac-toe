package com.games.entity;

import com.games.entity.tic_tac_toe.Mark;

/**
 * Created by prakash.vijay on 05/08/16.
 */
public class Player {
    public String uuid;
    public String name;
    public Mark mark;

    public Player(String uuid, String name) {
        this.uuid = uuid;
        this.name = name;
    }
}
