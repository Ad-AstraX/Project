package com.mygdx.game.model;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.model.object.holdable.IHoldable;

public class Player extends WorldObject {
    public static final int MOVEMENT_SPEED = 100;
    private IHoldable hand;

    public Player(Vector2 position) {
        super("badlogic.jpg", position, new Vector2(1f, 1f));
    }

    public IHoldable getHand() {
        return hand;
    }
}
