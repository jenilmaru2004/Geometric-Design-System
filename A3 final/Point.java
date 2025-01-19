public class Point extends AbstractShape implements CollisionDetector{
    private float x = 0;
    private float y = 0;
    private static int numberOfInstances;

    public Point() {
        numberOfInstances++;
    }

    public Point(float x, float y) {
        super();
        this.x = x;
        this.y = y;
        numberOfInstances++;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public static int getNumOfInstances() {
        return numberOfInstances;
    }

    @Override
    public boolean intersect(Point s) {
        float a = s.getX();
        float b = s.getY();
        return x==a && y==b;
    }

    @Override
    public boolean intersect(LineSeg s) {
            Point p1 = s.getBegin();
            Point p2 = s.getEnd();
            
            // Calculate the distance from the point to the line
            float numerator = Math.abs((p2.getY() - p1.getY()) * this.x - (p2.getX() - p1.getX()) * this.y + p2.getX() * p1.getY() - p2.getY() * p1.getX());
            float denominator = (float) Math.sqrt(Math.pow(p2.getY() - p1.getY(), 2) + Math.pow(p2.getX() - p1.getX(), 2));
            float distance = numerator / denominator;

            if (distance != 0) {
                return false; // Point is not on the line
            }
        
            // Check if point is within the bounds of the line segment
            return this.x >= Math.min(p1.getX(), p2.getX()) && this.x <= Math.max(p1.getX(), p2.getX()) &&
                this.y >= Math.min(p1.getY(), p2.getY()) && this.y <= Math.max(p1.getY(), p2.getY());
    }

    @Override
    public boolean intersect(Rectangle s) {
        //return x >= s.getLeft() && x <= s.getRight() && y >= s.getTop() && y <= s.getBottom();
        return this.x >= s.getLeft() && this.x <= s.getRight() && this.y >= s.getBottom() && this.y <= s.getTop();

    }

    @Override
    public boolean intersect(Circle s) {
        float distance = (float) Math.sqrt(Math.pow(x - s.getCenter().getX(), 2) + Math.pow(y - s.getCenter().getY(), 2));
        return distance <= s.getRadius();
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
