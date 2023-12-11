package com.mygdx.game.control;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.model.Game;

public class GameController {
    private final Game game;
    private final PlayerController playerController1;
    private final PlayerController playerController2;
    private final CustomerController customerController;
    private final OrderController orderController;
    private final WorldController worldController;

    public GameController(float roundLength, int payGoal, float customerSpawnChance) {
        game = new Game(roundLength, payGoal, customerSpawnChance);
        playerController1 = new PlayerController(new Vector2(2, 0));
        playerController2 = new PlayerController(new Vector2(-2, 0));

        customerController = new CustomerController();
        orderController = new OrderController(new RecipeController());
        worldController = new WorldController();
    }

    public void mainLoop(float dt) {
        tickTime(dt);

        // TODO: Get correct input for players
        playerController1.UpdateInput(dt, Vector2.Zero, false, false);
        playerController2.UpdateInput(dt, Vector2.Zero, false, false);

        tickGenCustomer();
    }

    public void tickTime(float dt) {
        game.timeLeftLastFrame = game.timeLeft;
        game.timeLeft -= dt;
    }

    public void tickGenCustomer() {
        if (Math.floor(game.timeLeft) == Math.floor(game.timeLeftLastFrame))
            return;

        if (Math.random() * 100 < game.customerSpawnChance)
            return;

        System.out.println("Spawned Customer");
    }
}
