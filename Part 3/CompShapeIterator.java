public class CompShapeIterator {
    private CompShape compShape;
    private int currentIndex;

    public CompShapeIterator(CompShape compShape) {
        this.compShape = compShape;
        this.currentIndex = 0;
    }

    public void first() {
        currentIndex = 0;
    }

    public void next() {
        if (!isDone()) {
            currentIndex++;
        }
    }

    public boolean isDone() {
        return currentIndex >= compShape.getShapes().size();
    }

    public AbstractShape getCurrentShape() {
        if (isDone()) {
            throw new IllegalStateException("Index out of bounds.");
        }
        return compShape.getShapes().get(currentIndex);
    }

}



