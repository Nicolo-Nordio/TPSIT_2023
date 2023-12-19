package com.mygdx.demo;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import zucgame.Drawable;
import zucgame.Parameters;

public class Level implements Drawable {
    private String name;
    private float length;
    private float speed;

    private float bx; //back-ground x


    private float width;
    private float height;

    private Texture spacePicture;

    // Aggiungere
    private Rebel rebel;

    /**
     * Costruttore classe 'Level' che setta i vari parametri incluse tutte le Texture del livello
     */
    Level(String name, float height) {
        super();

        this.name = name;
        this.length = 0;
        this.speed = -0.03f;
        this.bx = 0;

        this.height = height;
        this.width = height * Parameters.getAspectRatio();

        this.spacePicture = new Texture("Graphics_HD/BackGround.png");

        this.rebel = null;
    }

    /**
     * Getter e setter dell'oggetto 'knight'
     *
     * @return
     */
    public Rebel getRebel() {
        return rebel;
    }

    public void setRebel(Rebel rebel) {
        this.rebel = rebel;
    }

    /**
     * Getter della velocità
     *
     * @return
     */
    public float getSpeed() {
        return speed;
    }

    /**
     * Setta la velocità
     * Gestisce il fenomeno della parallasse
     *
     * @param speed
     */
    public void setSpeed(float speed) {
        this.speed = speed;
        if (bx <= -width) bx = bx + width;
    }

    /**
     * Getter di 'name'
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Metodo che disegna la Texture per il livello
     * La disegna due volte per far si che scorrono sullo schermo
     *
     * @param sb
     */
    @Override
    public void draw(SpriteBatch sb) {

        sb.draw(spacePicture, bx, 0, width, height);
        sb.draw(spacePicture, bx + width, 0, width, height);

        rebel.draw(sb);
    }

    /**
     * Metodo che setta la velocità
     */
    public void update() {
        bx += this.speed * 0.01f;
        setSpeed(speed);
    }
}

