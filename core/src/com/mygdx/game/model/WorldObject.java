package com.mygdx.game.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.GdxRuntimeException;

public abstract class WorldObject {
    protected boolean isAnimation;
    Animation<TextureRegion> animation;
    protected Texture texture;
    protected Vector2 position;
    protected Vector2 size;

    public WorldObject(String texturePath, Vector2 position, Vector2 size) {
        try { this.texture = new Texture("Textures/" + texturePath); }
        catch(GdxRuntimeException e) { this.texture = new Texture("Textures/fallbackTexture.png"); }
        this.position = position;
        this.size = size;
    }
    public WorldObject(String texturePath, int cols, int rows, float frameDuration, Vector2 position) {
        try { this.texture = new Texture("Textures/" + texturePath); }
        catch(GdxRuntimeException e) { this.texture = new Texture("Textures/fallbackTexture.png"); }

        TextureRegion[][] tmp = TextureRegion.split(texture, texture.getWidth()/cols,texture.getHeight()/rows);
        TextureRegion[] frames = new TextureRegion[cols * rows];
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                frames[index++] = tmp[i][j];
            }
        }
        animation = new Animation<>(frameDuration, frames);
        isAnimation = true;

        this.position = position;
        this.size = new Vector2(animation.getKeyFrames()[0].getRegionWidth(), animation.getKeyFrames()[0].getRegionHeight());
        System.out.println(size.x);
    }

    // All Getters
    public Texture getTexture() {
        return texture;
    }
    public Vector2 getPosition() {
        return position;
    }
    public Vector2 getSize() {
        return size;
    }
    public boolean isAnimation() {
        return isAnimation;
    }

    public Animation<TextureRegion> getAnimation() {
        return animation;
    }

    // All Setters
    public void setTexture(String texture) {
        try {
            this.texture.dispose();
            this.texture = new Texture("Textures/" + texture);
        } catch(GdxRuntimeException e) {
            this.texture = new Texture("Textures/fallbackTexture.png");
        }
    }
    public void setPosition(Vector2 position) {
        this.position = position;
    }
    public void setSize(Vector2 size) {
        this.size = size;
    }
    public void setIsAnimation(boolean animation) {
        isAnimation = animation;
    }
}
