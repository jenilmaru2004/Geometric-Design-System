import java.util.ArrayList;
import java.util.List;

public class CompShape extends AbstractShape implements CollisionDetector {
    private List<AbstractShape> shapes;

    public CompShape() {
        this.shapes = new ArrayList<>();
    }

    public void addShape(AbstractShape shape) {
        shapes.add(shape);
    }

    public void removeShape(AbstractShape shape) {
        shapes.remove(shape);
    }

    public CompShapeIterator getIterator() {
        return new CompShapeIterator(this);
    }

    public List<AbstractShape> getShapes() {
        return shapes;
    }
    @Override
    public boolean intersect(Point s) {
        for (AbstractShape shape : shapes) {
            if (shape instanceof CollisionDetector && ((CollisionDetector) shape).intersect(s)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean intersect(LineSeg s) {
        for (AbstractShape shape : shapes) {
            if (shape instanceof CollisionDetector && ((CollisionDetector) shape).intersect(s)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean intersect(Rectangle s) {
        for (AbstractShape shape : shapes) {
            if (shape instanceof CollisionDetector && ((CollisionDetector) shape).intersect(s)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean intersect(Circle s) {
        for (AbstractShape shape : shapes) {
            if (shape instanceof CollisionDetector && ((CollisionDetector) shape).intersect(s)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean intersect(CompShape s) {
        for (AbstractShape shape : shapes) {
            if (shape instanceof CollisionDetector && ((CollisionDetector) shape).intersect(s)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean intersect(AbstractShape s) {
        for (AbstractShape shape : shapes) {
            if (shape instanceof CollisionDetector && 
                ((CollisionDetector) shape).intersect(s)) {
                return true;
            }
        }
        return false;
    }

}
