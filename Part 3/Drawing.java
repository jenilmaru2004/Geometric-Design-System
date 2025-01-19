public class Drawing {

    private static Drawing instance;
    private AbstractShape shape;

    private Drawing() {
    }

    public static Drawing getInstance() {
        if (instance == null) {
            instance = new Drawing();
        }
        return instance;
    }

    public AbstractShape getShape() {
        return shape;
    }

    public void setShape(AbstractShape shape) {
        this.shape = shape;
    }
}
