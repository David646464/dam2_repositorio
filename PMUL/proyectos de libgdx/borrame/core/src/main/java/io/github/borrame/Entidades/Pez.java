package io.github.borrame.Entidades;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class Pez {
    //Variable a borrar
    Rectangle rectangle = null;

    public float x, y;
    public float velocidad;
    public boolean seMueveDerecha;
    public TextureRegion randFish;
    public int numSprites;
    public int currentSprite;
    public TextureRegion[] animation;
    public float ancho;
    public float alto;
    public boolean isAnimated = false;

    public Pez(float x, float y, float velocidad, boolean seMueveDerecha, TextureRegion randFish, int fishtype) {
        this.x = x;
        this.y = y;
        this.velocidad = velocidad;
        this.seMueveDerecha = seMueveDerecha;
        this.randFish = setFish(randFish, fishtype);
        System.out.println("Pez creado");
        ancho = this.randFish.getRegionWidth();
        alto = this.randFish.getRegionHeight();
    }

    private TextureRegion setFish(TextureRegion randFish, int fishtype) {
        if (fishtype == 1) {
            numSprites = 6;
            animation = splitTexture(randFish, randFish.getRegionWidth() / 3, randFish.getRegionHeight() / 2);
            System.out.println(animation.length);
            return animation[0];
        } else if (fishtype == 2) {
            numSprites = 4;
            animation = splitTexture(randFish, randFish.getRegionWidth() / 4, randFish.getRegionHeight());
            System.out.println(animation.length);
            return animation[0];
        } else if (fishtype == 3) {
            System.out.println("Pez azul");
            numSprites = 1;
            animation = splitTexture(randFish, randFish.getRegionWidth(), randFish.getRegionHeight());
            System.out.println(animation.length);
            return animation[0];
        } else {
            return randFish;
        }
    }

    public TextureRegion[] splitTexture(TextureRegion texture, int tileWidth, int tileHeight) {
        TextureRegion region = new TextureRegion(texture);
        TextureRegion[][] textureRegions = region.split(tileWidth, tileHeight);
        TextureRegion[] regions = new TextureRegion[numSprites];
        int index = 0;
        for (int i = 0; i < textureRegions.length; i++) {
            for (int j = 0; j < textureRegions[i].length; j++) {
                if (index == numSprites) {
                    break;
                }

                regions[index] = textureRegions[i][j];
                index++;
            }
        }
        return regions;
    }

    public void actualiza(float delta) {
        if (seMueveDerecha) {
            x += velocidad * delta;
        } else {
            x -= velocidad * delta;
        }
    }

    public void dibuja(SpriteBatch sb) {
        if (numSprites > 1) {
            isAnimated = true;
            currentSprite = (int) (System.currentTimeMillis() / 100) % numSprites;
            randFish = animation[currentSprite];
            if (!seMueveDerecha) {
                sb.draw(randFish, x, y, ancho, alto);
            } else {
                sb.draw(randFish, x + ancho, y, -ancho, alto);
            }
        } else {
            if (!seMueveDerecha) {
                sb.draw(randFish, x, y, ancho, alto);
            } else {
                sb.draw(randFish, x + ancho, y, -ancho, alto);
            }
        }
        //Borrar
        Texture texture = new Texture("Rojo.png");
        Texture texture2 = new Texture("Verde.png");
        sb.draw(texture,rectangle.getX(),rectangle.getY(),rectangle.getWidth(),rectangle.getHeight());
        sb.draw(texture2,x,y+alto - 15,ancho,5);
    }


    //Borrar
    public void setRectangle(Rectangle rectPez) {
        this.rectangle = rectPez;
    }
}
