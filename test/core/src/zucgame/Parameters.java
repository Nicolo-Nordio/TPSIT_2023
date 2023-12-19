package zucgame;

public class Parameters {
    private static float aspectRatio;
    private static float inverseAspectRatio;

    /**
     * @param width
     * @param height
     */
    public static void setAspectRatio(float width, float height) {
        aspectRatio = width / height;
        inverseAspectRatio = height / width;
    }

    /**
     * Ritorna il rapporto tra larghezza e altezza dello schermo (aspectRatio)
     * @return
     */
    public static float getAspectRatio(){
        return aspectRatio;
    }

    public static float getInverseAspectRatio() {
        return inverseAspectRatio;
    }
}
