package com.mygdx.ergame;

import com.badlogic.gdx.graphics.Texture;

/**
 * La classe descrive il cavaliere protagonista del progetto. Gestisce sia le informazioni
 * di gioco, sia le informazioni relative all'animazione del personaggio
 */
public class Knight extends GameObject {
    /**
     * Gli stati di gioco in cui si può trovare il cavaliere
     */
    enum KNIGHT_STATE {
        IDLE,
        WALK,
        RUN,
        JUMP
    }

    private Texture[] animIdle;
    private Texture[] animWalk;
    private Texture[] animRun;
    private Texture[] animJump;
    private boolean isWalk = false;
    private boolean isRun = false;
    private boolean isJump = false;
    private KNIGHT_STATE state;

    private int framesSkip = 0;

    /**
     * Imposta tutti i parametri del cavaliere ai valori di default
     */
    Knight() {
        super();

        animIdle = ResourceLoader.getAnimation(ResourceEnum.KN_IDLE);
        animWalk = ResourceLoader.getAnimation(ResourceEnum.KN_WALK);
        animRun = ResourceLoader.getAnimation(ResourceEnum.KN_RUN);
        animJump = ResourceLoader.getAnimation(ResourceEnum.KN_JUMP);

        sprite.setAnimation(animIdle);
        sprite.setWidth(3);
        sprite.setOffsetX(-1.5f);
        sprite.setOffsetY(-0.5f);

        setRadius(0.4f);
        setBarycenter(0.1f, 0.4f);

        state = KNIGHT_STATE.IDLE;
        isWalk = false;
        isRun = false;
        isJump = false;

        entryWalk();
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
     * Questo metodo viene chiamato periodicamente per aggiornare la posizione del cavaliere sullo schermo
     * e per gestire le varie situazioni in cui il cavaliere si trova (Idle, Walk)
     */
    public void update() {
        switch (state) {
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
        }
    }

    /**
     * Gestisce l'ingresso nello stato WALK
     */
    private void entryWalk() {
        state = KNIGHT_STATE.WALK;
        sprite.setAnimation(animWalk);
        velocity.x = 0.01f;
        framesSkip = 0;
        isWalk = false;
    }

    /**
     * Gestisce il comportamento nello stato WALK
     */
    private void doWalk() {
        if (framesSkip % 2 == 0) {
            sprite.update();
            framesSkip++;
        } else {
            framesSkip = 0;
        }
        updatePhysic();
    }

    /**
     * Gestisce l'ingresso nello stato RUN
     */
    private void entryRun() {
        state = KNIGHT_STATE.RUN;
        sprite.setAnimation(animRun);
        velocity.x = 0;
        framesSkip = 0;
        setVelocity(0, 0);
        setAcceleration(0, 0);

        isRun = false;
    }

    /**
     * Gestisce il comportamento nello stato RUN
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
     * Gestisce l'ingresso nello stato JUMP
     */
    private void entryJump() {
        state = KNIGHT_STATE.JUMP;
        sprite.setAnimation(animJump);
        velocity.y = 0.12f;
        framesSkip = 0;
        isJump = false;
        acceleration.y = -0.005f;
    }

    /**
     * Gestisce il comportamento nello stato JUMP
     */
    private void doJump() {
        if (framesSkip % 2 == 0) {
            sprite.update();
            framesSkip++;
        } else {
            framesSkip = 0;
        }
        updatePhysic();
    }

    @Override
    public void manageCollisionWith(GameObject obj) {
        if (obj instanceof Coin) {
            System.out.println("Ho trovato una moneta!!");
        }
    }

}
