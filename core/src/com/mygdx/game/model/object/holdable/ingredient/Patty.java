package com.mygdx.game.model.object.holdable.ingredient;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.model.Player;
import com.mygdx.game.model.WorldObject;

/**
 * Class which represents a Meat patty
 */
public class Patty extends Ingredient implements ICookable {
    private boolean isCooked;
    public Patty() {
        super("Ingredients/patty.png", Vector2.Zero, Vector2.Zero);
    }

    public Patty(Vector2 position) {
        super("Ingredients/patty.png", position, new Vector2(20, 20));
    }

    @Override
    public void cook() {
        isCooked = true;
    }
    @Override
    public boolean pickup(Player player) {
        return false;
    }

    // All Getters
    @Override
    public String getSubclassTypeName() {
        return this.getClass().getTypeName();
    }
    public boolean isCooked() {
        return isCooked;
    }
    @Override
    public WorldObject getCopy() {
        return new Patty(this.position);
    }
}
