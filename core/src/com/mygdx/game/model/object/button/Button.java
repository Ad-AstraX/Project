package com.mygdx.game.model.object.button;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.model.WorldObject;
import com.mygdx.game.view.Main;

/**
 * The abstract parent class for all Buttons. It can check if the mouse is hovering over the button and if the button
 * was clicked.
 */
public abstract class Button extends WorldObject {
    /** The textures that the buttons switch between */
    protected String[] textures;
    public Button(String[] textures, Vector2 position, Vector2 size) {
        super(textures[0], position, size);
        this.textures = textures;
    }

    protected boolean mouseOnButton () {
        return Main.getMousePosition().x > this.position.x && Main.getMousePosition().x < this.position.x + this.size.x &&
                Main.getMousePosition().y > this.position.y && Main.getMousePosition().y < this.position.y + this.size.y;
    }

    protected boolean mouseClicked() {
        return mouseOnButton() && Gdx.input.justTouched();
    }

    public abstract boolean checkForInteraction();
}