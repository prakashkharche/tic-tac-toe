package com.games;

import com.games.app.config.GameConfiguration;
import com.games.app.module.GameModule;
import com.games.resources.websocket.TicTacToeSocketResource;
import com.hubspot.dropwizard.guice.GuiceBundle;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.websockets.WebsocketBundle;

import javax.websocket.server.ServerEndpointConfig;

/**
 * Created by prakash.vijay on 05/03/17.
 */
public class GameApplication extends Application<GameConfiguration>{

    private GuiceBundle<GameConfiguration> guiceBundle;

    public static void main(String[] args) throws Exception {
        new GameApplication().run(args);
    }
    public void run(GameConfiguration gameConfiguration, Environment environment) throws Exception {
    }

    @Override
    public void initialize(Bootstrap<GameConfiguration> bootstrap) {
        this.guiceBundle = GuiceBundle.<GameConfiguration>newBuilder()
                .addModule(new GameModule())
                .enableAutoConfig(getClass().getPackage().getName())
                .setConfigClass(GameConfiguration.class)
                .build();
        bootstrap.addBundle(guiceBundle);
        bootstrap.addBundle(new WebsocketBundle(TicTacToeSocketResource.class));
    }
}
