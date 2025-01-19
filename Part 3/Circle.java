public class Circle extends AbstractShape implements CollisionDetector {
    private Point center;
    private float radius;
    private static int numberOfInstances;

    public Circle() {
        try{
        numberOfInstances++;

        if (this.radius <= 0){
            throw new ShapeArgumentException();
        }
    }
        catch (ShapeArgumentException e){
            System.out.println("ShapeArgumentException in constructing Circle");
        }
    }

    public Circle(Point center, float radius) {
        super();

        try{
        this.center = center;
        this.radius = radius;
        numberOfInstances++;

        if (this.radius <= 0){
            throw new ShapeArgumentException();
        }
    }
        catch (ShapeArgumentException e){
            System.out.println("ShapeArgumentException in constructing Circle");
        }
    }

    public Point getCenter() {
        return center;
    }

    public float getRadius() {
        return radius;
    }

    public static int getNumOfInstances() {
        return numberOfInstances;
    }

    @Override
    public boolean intersect(Point s) {
        float distance = (float) Math.sqrt((s.getX() - center.getX())*(s.getX() - center.getX()) + (s.getY() - center.getY())*(s.getY() - center.getY()));
        return distance <= radius;
    }

    @Override
public boolean intersect(LineSeg s) {
    // Vector from A (begin of the line segment) to P (circle's center)
    float apx = center.getX() - s.getBegin().getX();
    float apy = center.getY() - s.getBegin().getY();

    // Vector from A to B
    float abx = s.getEnd().getX() - s.getBegin().getX();
    float aby = s.getEnd().getY() - s.getBegin().getY();

    // Magnitude of AB vector
    float abMagnitude = abx * abx + aby * aby;

    // The projection of AP onto AB
    float dot = apx * abx + apy * aby;

    // Projected point lies on the line segment if t is between 0 and 1
    float t = dot / abMagnitude;

    // Calculate the point E on the line segment that is the closest to the circle's center
    float ex, ey;
    if (t < 0.0f) {
        // Closest point is A (begin of the line segment)
        ex = s.getBegin().getX();
        ey = s.getBegin().getY();
    } else if (t > 1.0f) {
        // Closest point is B (end of the line segment)
        ex = s.getEnd().getX();
        ey = s.getEnd().getY();
    } else {
        ex = t * abx + s.getBegin().getX();
        ey = t * aby + s.getBegin().getY();
    }

    // Vector from E to P
    float epx = center.getX() - ex;
    float epy = center.getY() - ey;

    // Magnitude of EP vector
    float epMagnitude = epx * epx + epy * epy;

    // If the distance from E to the center is less than or equal to the circle's radius squared, they intersect or are tangent
    return epMagnitude <= radius * radius;
}

    @Override
public boolean intersect(Rectangle s) {
    // Check if circle's center is inside the rectangle
    if (center.getX() >= s.getLeft() && center.getX() <= s.getRight() &&
        center.getY() >= s.getBottom() && center.getY() <= s.getTop()) {
        return true;
    }
    
    // Find the nearest point on the rectangle to the circle's center
    float nearestX = Math.max(s.getLeft(), Math.min(center.getX(), s.getRight()));
    float nearestY = Math.max(s.getBottom(), Math.min(center.getY(), s.getTop()));
    
    float deltaX = center.getX() - nearestX;
    float deltaY = center.getY() - nearestY;
    
    return (deltaX * deltaX + deltaY * deltaY) < (radius * radius);        
}

    @Override
    public boolean intersect(Circle s) {
        float distance = (float) Math.sqrt(Math.pow(center.getX() - s.getCenter().getX(), 2) + Math.pow(center.getY() - s.getCenter().getY(), 2));
        return distance < (radius + s.getRadius());
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
