package com.mygdx.game.model.object.workstation;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.model.object.holdable.IHoldable;
import com.mygdx.game.model.object.holdable.Plate;
import com.mygdx.game.model.object.holdable.ingredient.Cuttable;

/**
 * This class represents a cuttingboard which can cut cuttable Objects
 */
public class Cuttingboard extends Processable {

    public Cuttingboard(Vector2 position) {
        super(new String[] {"Interactables/cuttingboard.png", "Interactables/cuttingboardSelected.png"}, position, new Vector2(130, 160), 5);
    }

    /** Method is called whenever player wishes to cut an uncut Cuttable object on this Cuttingboard */
    @Override
    public void interact() {
        IHoldable playerHand = interactionPartner.getHand();
        if ((currentIngredient == null && playerHand instanceof Cuttable && !((Cuttable) playerHand).isCut()) ||
                ((playerHand == null || playerHand instanceof Plate) && currentIngredient != null && progressBar == null)){
            super.interact();
        }
    }
}
