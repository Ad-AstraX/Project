package com.mygdx.game.model.object.holdable;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.model.Player;
import com.mygdx.game.model.WorldObject;
import com.mygdx.game.model.datastructures.Stack;
import com.mygdx.game.model.object.holdable.ingredient.Ingredient;

/**
 * Class which represents a plate. One  can stack cut and cooked (if necessary) ingredients on it
 */
public class Plate extends WorldObject implements IHoldable {
    private Stack<Ingredient> ingredients;
    private boolean pickedUp;
    public Plate(Vector2 position) {
        super("plate.png", position, new Vector2(20, 20));
    }

    /**
     * Adds an Ingredient to the stack of ingredients on the plate
     * <p>
     * @param ingredient the ingredient to be added to the stack
     */
    public void addIngredient(Ingredient ingredient){
        if (ingredient != null) {
            ingredients.push(ingredient);
        }
    }

    @Override
    public boolean pickup(Player player) {
        if (player != null){
            pickedUp = true;
            position.set(new Vector2(player.getPosition()).add(new Vector2(5, 5)));
            return true;
        }
        return false;
    }

    // All Getters
    public boolean getPickedUp() {
        return pickedUp;
    }
    public Stack<Ingredient> getIngredients() {
        return ingredients;
    }
    @Override
    public String getSubclassTypeName() {
        return this.getClass().getTypeName();
    }
    @Override
    public WorldObject getCopy() {
        return new Plate(this.position);
    }
}
