package zucgame;

/**
 * Classe di riferimento per tutti gli oggetti grafici disegnabili sullo schermo
 */
public abstract class GraphicObject implements Drawable{
    protected float x;
    protected float y;
    protected float width;
    protected float height;
    protected float offsetX = 0;
    protected float offsetY = 0;

    public GraphicObject(){}

    public GraphicObject(float width, float height){

    }

    /**
     *
     * @param x
     */
    public void setX(float x) {
        this.x = x;
    }

    /**
     *
     * @param y
     */
    public void setY(float y) {
        this.y = y;
    }

    /**
     *
     * @param width
     */
    public void setWidth(float width) {
        this.width = width;
    }

    /**
     *
     * @param height
     */
    public void setHeight(float height) {
        this.height = height;
    }

    /**
     *
     * @param offsetX
     */
    public void setOffsetX(float offsetX) {
        this.offsetX = offsetX;
    }

    /**
     *
     * @param offsetY
     */
    public void setOffsetY(float offsetY) {
        this.offsetY = offsetY;
    }

    /**
     * Tutti i get per le variabili
     * @return
     */
    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getHeight() {
        return height;
    }

    public float getWidth() {
        return width;
    }

    public float getOffsetX() {
        return offsetX;
    }

    public float getOffsetY() {
        return offsetY;
    }
}
