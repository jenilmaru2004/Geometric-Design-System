public class Rectangle extends AbstractShape implements CollisionDetector {
    private float left;
    private float right;
    private float top;
    private float bottom;
    private static int numberOfInstances;

    public Rectangle() {
        try{
        numberOfInstances++;

        if (this.left >= this.right || this.bottom >= this.top){
            throw new ShapeArgumentException();
        }
    }

        catch(ShapeArgumentException e){
        System.out.println("ShapeArgumentException in constructing Rectangle");
        }
    }

    public Rectangle(float left, float right, float top, float bottom) {
        super();
        try{
        this.left = left;
        this.right = right;
        this.top = top;
        this.bottom = bottom;
        numberOfInstances++;

        if (this.left >= this.right || this.bottom >= this.top){
            throw new ShapeArgumentException();
        }
    }

        catch(ShapeArgumentException e){
        System.out.println("ShapeArgumentException in constructing Rectangle");
        }
    }

    public float getLeft() {
        return left;
    }

    public float getRight() {
        return right;
    }

    public float getTop() {
        return top;
    }

    public float getBottom() {
        return bottom;
    }

    public static int getNumOfInstances() {
        return numberOfInstances;
    }


    @Override
    public boolean intersect(Point s) {
        return s.getX() >= left && s.getX() <= right && s.getY() <= top && s.getY() >= bottom;
    }


    @Override
    public boolean intersect(LineSeg s) {
        // Check if either end point of the segment is inside the rectangle
        if (intersect(s.getBegin()) || intersect(s.getEnd())) {
            return true;
        }
    
        // Check intersection with each side of the rectangle
        LineSeg topSide = new LineSeg(new Point(left, top), new Point(right, top));
        LineSeg bottomSide = new LineSeg(new Point(left, bottom), new Point(right, bottom));
        LineSeg leftSide = new LineSeg(new Point(left, top), new Point(left, bottom));
        LineSeg rightSide = new LineSeg(new Point(right, top), new Point(right, bottom));
    
        return s.intersect(topSide) || s.intersect(bottomSide) || s.intersect(leftSide) || s.intersect(rightSide);
    }

    @Override
    public boolean intersect(Rectangle s) {
        // Check if rectangles overlap on the x-axis and y-axis
        return left < s.getRight() && right > s.getLeft() && top > s.getBottom() && bottom < s.getTop();
    }

    public boolean intersect(Circle s) {
        // Check if the circle's center is inside the rectangle
        if (s.getCenter().getX() >= left && s.getCenter().getX() <= right && 
            s.getCenter().getY() >= bottom && s.getCenter().getY() <= top) {
            return true;
        }
    
        // Find the nearest point in the rectangle to the circle's center
        float nearestX = Math.max(left, Math.min(s.getCenter().getX(), right));
        float nearestY = Math.max(bottom, Math.min(s.getCenter().getY(), top));
    
        // Calculate distance from the circle's center to the nearest point
        float deltaX = s.getCenter().getX() - nearestX;
        float deltaY = s.getCenter().getY() - nearestY;
    
        // Change from "<=" to "<" to make sure tangent circles aren't considered intersecting
        return (deltaX * deltaX + deltaY * deltaY) < (s.getRadius() * s.getRadius());
    }
    
        @Override
    public boolean intersect(AbstractShape s) {
        if (s instanceof Point) {
            return intersect((Point) s);
        } else if (s instanceof LineSeg) {
            return intersect((LineSeg) s);
        } else if (s instanceof Rectangle) {
            return intersect((Rectangle) s);
        } else if (s instanceof Circle) {
            return intersect((Circle) s);
        } else if (s instanceof CompShape) {
            return intersect((CompShape) s);
        }
        return false;
    }
    
    @Override
    public boolean intersect(CompShape compShape) {
        for (AbstractShape shape : compShape.getShapes()) {
            if (shape instanceof CollisionDetector && 
                ((CollisionDetector) shape).intersect(this)) {
                return true;
            }
        }
        return false;
    }


    
    
}
