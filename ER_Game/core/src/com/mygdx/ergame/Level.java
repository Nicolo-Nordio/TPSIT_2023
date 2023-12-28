package com.mygdx.ergame;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import zucgame.Drawable;
import zucgame.Parameters;

public class Level implements Drawable {
    private String name;
    private float length;
    private float speed;

    private float bx; //back-ground x
    private float mx; //middle-ground x
    private float fx; //for-ground x

    private float width;
    private float height;

    private Texture skyPicture;
    private Texture bgPicture;
    private Texture mgPicture;
    private Texture fgPicture;
    private Texture gPicture;

    private Knight knight;

    private GameObject[] objects;

    /**
     * Costruttore classe 'Level' che setta i vari parametri incluse tutte le Texture del livello
     */
    Level(String name, float height) {
        super();

        this.name = name;
        this.length = 0;
        this.speed = -0.03f;
        this.fx = 0;
        this.mx = 0;
        this.bx = 0;

        this.height = height;
        this.width = height * Parameters.getAspectRatio();

        this.skyPicture = ResourceLoader.getTexture(ResourceEnum.SKY_LEVEL);
        this.bgPicture = ResourceLoader.getTexture(ResourceEnum.BG_LEVEL);
        this.mgPicture = ResourceLoader.getTexture(ResourceEnum.MG_LEVEL);
        this.fgPicture = ResourceLoader.getTexture(ResourceEnum.FG_LEVEL);
        this.gPicture = ResourceLoader.getTexture(ResourceEnum.G_LEVEL);

        this.knight = null;

        this.objects = new GameObject[100];
        for (int i = 0; i < 10; i++) {
            this.objects[i] = new Coin();
            this.objects[i].setX(4 + (float)(Math.random() * 3 * i));
            this.objects[i].setY(0.5f);
            this.objects[i].setVelocity(this.speed, 0);
        }
    }

    /**
     * Getter e setter dell'oggetto 'knight'
     *
     * @return
     */
    public Knight getKnight() {
        return knight;
    }

    public void setKnight(Knight knight) {
        this.knight = knight;
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
     * Metodo che disegna le vari Texture per il livello
     * Le disegna due volte per far si che scorrono sullo schermo
     *
     * @param sb
     */
    @Override
    public void draw(SpriteBatch sb) {
        sb.draw(skyPicture, 0, 0, width, height);

        sb.draw(bgPicture, bx, 0, width, height);
        sb.draw(bgPicture, bx + width, 0, width, height);

        sb.draw(mgPicture, mx, 0, width, height);
        sb.draw(mgPicture, mx + width, 0, width, height);

        sb.draw(fgPicture, fx, 0, width, height);
        sb.draw(fgPicture, fx + width, 0, width, height);

        if (!knight.isWalking()) {
            for (GameObject gameObject : objects) {
                if (gameObject != null) gameObject.draw(sb);
            }
        }

        knight.draw(sb); //Messo in questo spazio per far si che sia dietro il 'gPicture'

        sb.draw(gPicture, fx, 0, width, height);
        sb.draw(gPicture, fx + width, 0, width, height);
    }

    /**
     * Metodo che fa 'update()' del cavaliere
     */
    public void update() {
        knight.update();

        // I frame si spostano solo se il cavaliere non sta camminando
        if (!knight.isWalking()) {
            for(int i=0; i<objects.length; i++) {
                GameObject gameObject = objects[i];
                if (gameObject != null) {
                    gameObject.update();
                    if(knight.collidesWith(gameObject)) {
                        knight.manageCollisionWith(gameObject);
                        gameObject.manageCollisionWith(knight);
                        objects[i] = null;
                    }
                }
            }

            fx += this.speed;
            if (fx <= -width) fx = fx + width;

            mx += this.speed * 0.5f;
            if (mx <= -width) mx = mx + width;

            bx += this.speed * 0.25f;
            if (bx <= -width) bx = bx + width;
        }
    }
}
