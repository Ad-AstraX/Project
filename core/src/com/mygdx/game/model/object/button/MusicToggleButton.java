package com.mygdx.game.model.object.button;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.view.Main;

public class MusicToggleButton extends Button {
    private boolean toggleOn = true;
    public MusicToggleButton(Vector2 position, Vector2 size) {
        super(new String[] {"Buttons/musicOn.png", "Buttons/musicOnSelected.png", "Buttons/musicOff.png", "Buttons/musicOffSelected.png"}, position, size);
    }

    @Override
    public boolean checkForInteraction() {
        if (mouseOnButton()) {
            if (!this.texture.toString().equals("Textures/" + textures[1]) && toggleOn) this.setTexture(textures[1]);
            else if (!this.texture.toString().equals("Textures/" + textures[3]) && !toggleOn) this.setTexture(textures[3]);
            if (mouseClicked()) {
                toggleOn = !toggleOn;
                if (Main.getMusic().isPlaying()) Main.getMusic().pause();
                else Main.getMusic().play();
                return true;
            }
        } else {
            if (!this.texture.toString().equals("Textures/" + textures[0]) && toggleOn) this.setTexture(textures[0]);
            else if (!this.texture.toString().equals("Textures/" + textures[2]) && !toggleOn) this.setTexture(textures[2]);
        }
        return false;
    }
}