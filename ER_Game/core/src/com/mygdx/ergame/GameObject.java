package com.mygdx.ergame;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import zucgame.AnimatedSprite;
import zucgame.GraphicObject;

public abstract class GameObject extends GraphicObject {
    /**
     * L'AnimatedSprite che disegnamo sullo schermo per rappresentare il cavaliere
     */
    protected AnimatedSprite sprite;

    /**
     * La velocità dell'oggetto sul'asse x e sull'asse y
     */
    protected Vector2 velocity;

    /**
     * Il baricentro dell'oggetto rispetto alla posizione dell'oggetto
     */
    protected Vector2 barycenter;

    /**
     * L'accelerazione a cui è sottoposto l'oggetto
     */
    protected Vector2 acceleration;

    protected float radius;

    GameObject(){
        super();

        sprite = new AnimatedSprite();
        velocity = new Vector2(0, 0);
        acceleration = new Vector2(0, 0);
        barycenter = new Vector2(0, 0);
        radius = 0;

        ResourceLoader.getTexture(ResourceEnum.BUBBLE);
    }


    /**
     * Imposta la posizione sull'asse X dell'oggetto
     * @param x
     */
    @Override
    public void setX(float x) {
        super.setX(x);
        sprite.setX(x);
    }

    /**
     * Imposta la posizione sull'asse Y dell'oggetto
     * @param y
     */
    @Override
    public void setY(float y) {
        super.setY(y);
        sprite.setY(y);
    }

    /**
     * Ritorna la velocità di un oggetto
     * @return una copia della velocità dell'oggetto
     */
    public Vector2 getVelocity() {
        return new Vector2(velocity);
    }

    /**
     * Imposta la velocità dell'oggetto
     * @param v vettore contenente la velocità lungo i due assi di riferimento
     */
    public void setVelocity(Vector2 v) {
        velocity.x = v.x;
        velocity.y = v.y;
    }

    /**
     * Imposta la velocità dell'oggetto
     * @param vx
     * @param vy
     */
    public void setVelocity(float vx, float vy) {
        velocity.x = vx;
        velocity.y = vy;
    }

    /**
     * La posizione del baricentro nelle coordinate del mondo
     * @return
     */
    public Vector2 getWorldBarycenter(){
        return new Vector2(x + barycenter.x, y + barycenter.y);
    }

    /**
     * Ritorna il baricentro di un oggetto
      * @return una copia del baricentro dell'oggetto
     */
    public Vector2 getBarycenter() {
        return new Vector2(barycenter);
    }

    /**
     * Imposta il baricentro dell'oggetto
     * @param b vettore contenente il baricentro lungo i due assi di riferimento
     */
    public void setBarycenter(Vector2 b) {
        barycenter.x = b.x;
        barycenter.y = b.y;
    }

    /**
     * Imposta il baricentro dell'oggetto
     * @param bx
     * @param by
     */
    public void setBarycenter(float bx, float by) {
        barycenter.x = bx;
        barycenter.y = by;
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float r) {
        radius = r;
    }

    /**
     * Ritorna l'accelerazione di un oggetto
     * @return una copia dell'accelerazione dell'oggetto
     */
    public Vector2 getAcceleration() {
        return new Vector2(acceleration);
    }

    /**
     * Imposta l'accelerazione dell'oggetto
     * @param a vettore contenente l'accelerazione lungo i due assi di riferimento
     */
    public void setAcceleration(Vector2 a) {
        acceleration.x = a.x;
        acceleration.y = a.y;
    }

    /**
     * Imposta l'accelerazione dell'oggetto
     * @param ax
     * @param ay
     */
    public void setAcceleration(float ax, float ay) {
        acceleration.x = ax;
        acceleration.y = ay;
    }

    /**
     * Aggiorna la fisica dell'oggetto
     */
    protected void updatePhysic(){
        velocity.x += acceleration.x;
        velocity.y += acceleration.y;
        setX(x + velocity.x);
        setY(y + velocity.y);
    }

    public abstract void update();

    /**
     * Disegna l'AnimatedSprite
     * @param sb lo sprite batch da usare per disegnare
     */
    @Override
    public void draw(SpriteBatch sb) {
        sprite.draw(sb);

        Vector2 pb = getWorldBarycenter();
        sb.draw(ResourceLoader.getTexture(ResourceEnum.BUBBLE), pb.x-radius, pb.y-radius, radius*2, radius*2);
    }

    public boolean collidesWith(GameObject obj){
        Vector2 pA = this.getWorldBarycenter();
        Vector2 pB = obj.getWorldBarycenter();
        return pA.dst(pB) < (this.getRadius() + obj.getRadius());
    }

    public abstract void manageCollisionWith(GameObject obj);

}
