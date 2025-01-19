public class LineSeg extends AbstractShape implements CollisionDetector{
    private Point begin;
    private Point end;
    private static int numberOfInstances;

    public LineSeg() {
        try { 
        numberOfInstances++;

        if (this.begin == this.end){
            throw new ShapeArgumentException();
        }
    }
        catch (ShapeArgumentException e){
            System.out.println("ShapeArgumentException in constructing LineSeg");
        }
        
    }

    public LineSeg(Point begin, Point end) {
        
        super();
        try { 
        this.begin = begin;
        this.end = end;
        numberOfInstances++;

        if (this.begin.getX()==this.end.getX() && this.begin.getY()==this.end.getY()){
            throw new ShapeArgumentException();
        }
    }
        catch (ShapeArgumentException e){
            System.out.println("ShapeArgumentException in constructing LineSeg");
        }
        
    }

    public Point getBegin() {
        return begin;
    }

    public Point getEnd() {
        return end;
    }

    public static int getNumOfInstances() {
        return numberOfInstances;
    }

    @Override
    public boolean intersect(Point s) {
        float d1 = distance(s, begin);
        float d2 = distance(s, end);
        float lineLength = distance(begin, end);
    
        return d1 + d2 == lineLength;
    }
    
    private float distance(Point a, Point b) {
        return (float) Math.sqrt((a.getX() - b.getX())*(a.getX() - b.getX()) + (a.getY() - b.getY())*(a.getY() - b.getY()));
    }

  
    @Override
public boolean intersect(LineSeg s) {
    Point p1 = begin;
    Point p2 = end;
    Point q1 = s.getBegin();
    Point q2 = s.getEnd();

    // Calculate vectors
    float dx1 = p2.getX() - p1.getX();
    float dy1 = p2.getY() - p1.getY();
    float dx2 = q2.getX() - q1.getX();
    float dy2 = q2.getY() - q1.getY();

    // Calculate determinants
    float det = dx1 * dy2 - dx2 * dy1;

    if (det == 0) {
        // Lines are parallel
        // Check for collinearity by using the cross product
        if ((p1.getX() - q1.getX()) * dy1 - (p1.getY() - q1.getY()) * dx1 != 0) {
            return false; // not collinear
        }

        // Check for overlap using dot product
        float dot1 = dx1 * (q1.getX() - p1.getX()) + dy1 * (q1.getY() - p1.getY());
        float dot2 = dx1 * (q2.getX() - p1.getX()) + dy1 * (q2.getY() - p1.getY());

        if ((dot1 < 0 && dot2 < 0) || (dot1 > dx1 * dx1 + dy1 * dy1 && dot2 > dx1 * dx1 + dy1 * dy1)) {
            return false; // no overlap
        }

        return true;
    } else {
        // Lines are not parallel, check for intersection within the bounds of both line segments
        float t1 = (dx2 * (p1.getY() - q1.getY()) + dy2 * (q1.getX() - p1.getX())) / det;
        float t2 = (dx1 * (q1.getY() - p1.getY()) + dy1 * (p1.getX() - q1.getX())) / -det;

        return (t1 >= 0 && t1 <= 1 && t2 >= 0 && t2 <= 1);
    }
}

@Override
public boolean intersect(Rectangle s) {
    // Define the four edges of the rectangle
    LineSeg topEdge = new LineSeg(new Point(s.getLeft(), s.getTop()), new Point(s.getRight(), s.getTop()));
    LineSeg bottomEdge = new LineSeg(new Point(s.getLeft(), s.getBottom()), new Point(s.getRight(), s.getBottom()));
    LineSeg leftEdge = new LineSeg(new Point(s.getLeft(), s.getTop()), new Point(s.getLeft(), s.getBottom()));
    LineSeg rightEdge = new LineSeg(new Point(s.getRight(), s.getTop()), new Point(s.getRight(), s.getBottom()));
    
    // Check for intersection with each edge of the rectangle
    if (this.intersect(topEdge) || this.intersect(bottomEdge) || this.intersect(leftEdge) || this.intersect(rightEdge)) {
        return true;
    }

    // Check if one of the endpoints of the line segment is inside the rectangle
    Point start = this.getBegin(); // Assuming you have a getStart method
    Point end = this.getEnd(); // Assuming you have a getEnd method

    if (start.getX() >= s.getLeft() && start.getX() <= s.getRight() && start.getY() >= s.getBottom() && start.getY() <= s.getTop()  &&  end.getX() >= s.getLeft() && end.getX() <= s.getRight() && end.getY() >= s.getBottom() && end.getY() <= s.getTop()) {
        return true;
    }

    return false;
}
    
    @Override
public boolean intersect(Circle s) {
    // Vector from A (begin) to P (circle's center)
    float apx = s.getCenter().getX() - begin.getX();
    float apy = s.getCenter().getY() - begin.getY();

    // Vector from A (begin) to B (end)
    float abx = end.getX() - begin.getX();
    float aby = end.getY() - begin.getY();

    // Magnitude of AB vector
    float abMagnitude = abx * abx + aby * aby;

    // The projection of AP onto AB
    float dot = apx * abx + apy * aby;

    // Project point lies on the line segment if t is between 0 and 1
    float t = dot / abMagnitude;

    // Calculate the point E on line segment that is the closest to circle's center
    float ex, ey;
    if (t < 0.0f) {
        // Closest point is A
        ex = begin.getX();
        ey = begin.getY();
    } else if (t > 1.0f) {
        // Closest point is B
        ex = end.getX();
        ey = end.getY();
    } else {
        ex = t * abx + begin.getX();
        ey = t * aby + begin.getY();
    }

    // Vector from E to P
    float epx = s.getCenter().getX() - ex;
    float epy = s.getCenter().getY() - ey;

    // Magnitude of EP vector
    float epMagnitude = epx * epx + epy * epy;

    // If the distance from E to the center is less than or equal to the circle's radius squared, they intersect or are tangent
    return epMagnitude <= s.getRadius() * s.getRadius();
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
