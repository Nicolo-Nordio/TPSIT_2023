package com.mygdx.ergame;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import zucgame.AnimatedSprite;
import zucgame.GraphicObject;

public class Knight extends GraphicObject {
    enum KNIGHT_STATE {
        IDLE,
        WALK,
        RUN,
        JUMP
    }

    private AnimatedSprite sprite;
    private Texture[] animIdle;
    private Texture[] animWalk;
    private Texture[] animRun;
    private Texture[] animJump;
    private boolean isWalk = false;
    private boolean isRun = false;
    private boolean isJump = false;
    private KNIGHT_STATE state;
    private Vector2 velocity;
    private int framesSkip = 0;

    /**
     * Costruttore che attribuisce le animazioni alle variabili
     */
    Knight() {
        super();

        animIdle = ResourceLoader.getAnimation(ResourceEnum.KN_IDLE);
        animWalk = ResourceLoader.getAnimation(ResourceEnum.KN_WALK);
        animRun = ResourceLoader.getAnimation(ResourceEnum.KN_RUN);
        animJump = ResourceLoader.getAnimation(ResourceEnum.KN_JUMP);

        sprite = new AnimatedSprite(animIdle);
        sprite.setWidth(3);
        sprite.setOffsetX(-1.5f);
        sprite.setOffsetY(-0.5f);

        state = KNIGHT_STATE.IDLE;
        isWalk = false;
        isRun = false;
        isJump = false;

        velocity = new Vector2(0, 0);

        entryWalk();
    }

    /**
     * Vari setter
     */
    @Override
    public void setX(float x) {
        super.setX(x);
        sprite.setX(x);
    }

    @Override
    public void setY(float y) {
        super.setY(y);
        sprite.setY(y);
    }

    public void setWalk(boolean walk) {
        isWalk = walk;
    }

    public void setRun(boolean run) {
        isRun = run;
    }

    public void setJump(boolean jump) {
        isJump = jump;
    }

    /**
     * Settaggio velocità che usa il polimorfismo verticale
     *
     * @param velocity
     */
    public void setVelocity(Vector2 velocity) {
        this.velocity.x = velocity.x;
        this.velocity.y = velocity.y;
    }

    public void setVelocity(float vx, float vy) {
        velocity.x = vx;
        velocity.y = vy;
    }

    /**
     * Metodo che verifica se il cavaliere sta camminando
     *
     * @return
     */
    public boolean isWalking() {
        return state == KNIGHT_STATE.WALK;
    }

    /**
     * Metodo che verifica se il cavaliere sta correndo
     *
     * @return
     */
    public boolean isRunning() {
        return state == KNIGHT_STATE.RUN;
    }

    /**
     * Metodo che verifica se il cavaliere sta saltando
     *
     * @return lo stato del cavaliere a 'JUMP' solo se y >= 0 [per differenziare da isFalling()]
     */
    public boolean isJumping() {
        return state == KNIGHT_STATE.JUMP && velocity.y >= 0;
    }

    /**
     * Metodo per verificare se il cavaliere sta atterrando dopo aver saltato
     *
     * @return lo stato del cavaliere a 'JUMP' ma solo se y <= 0 [per differenziare da isJumping()]
     */
    public boolean isFalling() {
        return state == KNIGHT_STATE.JUMP && velocity.y <= 0;
    }


    /**
     * Restituisce una copia della velocità del knight nel momento in cui ho fatto richiesta
     *
     * @return nuovo vettore però con gli stessi attributi di 'velocity'
     */
    public Vector2 getVelocity() {
        return new Vector2(velocity);
    }

    /**
     * Metodo che disegna la texture
     *
     * @param sb
     */
    @Override
    public void draw(SpriteBatch sb) {
        sprite.draw(sb);
    }

    /**
     * Questo metodo viene chiamato periodicamente per aggiornare la posizione del cavaliere sullo schermo
     * e per gestire le varie situazioni in cui il cavaliere si trova (Idle, Walk)
     */
    public void update() {
        switch (state) {
            case IDLE:
                if (isWalk) {
                    entryWalk();
                    doWalk();
                } else {
                    doIdle();
                }
                break;

            case WALK:
                if (isRun) {
                    entryRun();
                    doRun();
                } else {
                    doWalk();
                }
                break;

            case RUN:
                if (isJump) {
                    entryJump();
                    doJump();
                } else {
                    doRun();
                }
                break;

            case JUMP:
                if (isRun) {
                    entryRun();
                    doRun();
                } else {
                    doJump();
                }
                break;

            default:
                entryIdle();
                doIdle();
                break;
        }
    }

    /**
     * Metodo che setta 'state' 'animation' 'velocity'
     * SOLO quando entra in modalità idle
     */
    private void entryIdle() {
        state = KNIGHT_STATE.WALK;
        sprite.setAnimation(animWalk);
        velocity.x = 0.01f;
        framesSkip = 0;
        isWalk = false;
    }

    /**
     * Metodo che fa 'update()' dello sprite [lo fa star fermo]
     */
    private void doIdle() {
        if (framesSkip % 2 == 0) {
            sprite.update();
            framesSkip++;
        } else {
            framesSkip = 0;
        }
    }

    /**
     * Metodo che setta 'state' 'animation' 'velocity'
     * SOLO quando entra in modalità camminata
     */
    private void entryWalk() {
        state = KNIGHT_STATE.WALK;
        sprite.setAnimation(animWalk);
        velocity.x = 0.01f;
        framesSkip = 0;
        isWalk = false;
    }

    /**
     * Metodo che fa 'update()' dello sprite [lo fa camminare]
     * e fa muovere lo sprite nell'asse x
     */
    private void doWalk() {
        if (framesSkip % 2 == 0) {
            sprite.update();
            framesSkip++;
        } else {
            framesSkip = 0;
        }
        setX(x + velocity.x);
    }

    /**
     * Metodo che setta 'state' 'animation' 'velocity'
     * SOLO quando entra in modalità corsa
     */
    private void entryRun() {
        state = KNIGHT_STATE.RUN;
        sprite.setAnimation(animRun);
        velocity.x = 0;
        framesSkip = 0;
        isRun = false;
    }

    /**
     * Metodo che fa 'update()' dello sprite [lo fa correre]
     * e fa muovere lo sprite nell'asse x
     */
    private void doRun() {
        if (framesSkip % 2 == 0) {
            sprite.update();
            framesSkip++;
        } else {
            framesSkip = 0;
        }
    }

    /**
     * Metodo che setta 'state' 'animation' 'velocity'
     * SOLO quando entra in modalità salto
     */
    private void entryJump() {
        state = KNIGHT_STATE.JUMP;
        sprite.setAnimation(animJump);
        velocity.y = 0.3f;
        framesSkip = 0;
        isJump = false;
    }

    /**
     * Metodo che fa 'update()' dello sprite [lo fa saltare]
     * e fa muovere lo sprite nell'asse y
     */
    private void doJump() {
        if (framesSkip % 2 == 0) {
            sprite.update();
            framesSkip++;
        } else {
            framesSkip = 0;
        }
        velocity.y += -0.02f;
        setY(y + velocity.y);
    }
}
