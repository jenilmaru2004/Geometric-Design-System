public interface CollisionDetector {
    public boolean intersect(Point point);
    public boolean intersect(LineSeg line);
    public boolean intersect(Rectangle rect);
    public boolean intersect(Circle circle);
    public boolean intersect(CompShape compshape);
    public boolean intersect(AbstractShape s); 
}
