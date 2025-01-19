import org.junit.*;

public class A2Test{

    @Test
    public void testPointIntersectPoint() {
    
    //case 1
    Point p1 = new Point(7f, 7f);
    Point p2 = new Point(7f, 7f);

    //case 2
    Point p3 = new Point(7f, 7f);
    Point p4 = new Point(4f, 7f);

    Assert.assertEquals(true, p1.intersect(p2));
    Assert.assertEquals(false, p3.intersect(p4));


    }

    @Test
    public void testPointIntersectLineSeg() {

        //case 1
        Point p1 = new Point(6f, 5f);
		LineSeg l1 = new LineSeg(new Point(3,3),new Point(9,3));

        //case 2
		Point p2 = new Point(6f, 3f);
		LineSeg l2 = new LineSeg(new Point(3,3),new Point(9,3));
        
        //case 3
		Point p3 = new Point(3f, 3f);
		LineSeg l3 = new LineSeg(new Point(3,3),new Point(9,3));

        //case 4
		Point p4 = new Point(2f, 3f);
		LineSeg l4 = new LineSeg(new Point(3,3),new Point(9,3));

        Assert.assertEquals(false, p1.intersect(l1));
        Assert.assertEquals(true, p2.intersect(l2));
        Assert.assertEquals(true, p3.intersect(l3));
        Assert.assertEquals(false, p4.intersect(l4));
        

    }

    @Test
    public void testPointIntersectRectangle() {

        //case 1
        Point p1 = new Point(6, 5);
		Rectangle r1 = new Rectangle(4,12,7,3);

        //case 2
		Point p2 = new Point(4, 5);
		Rectangle r2 = new Rectangle(4,12,7,3);

        //case 3
		Point p3 = new Point(2, 5);
		Rectangle r3 = new Rectangle(4,12,7,3);

        //case 4
		Point p4 = new Point(4, 3);
		Rectangle r4 = new Rectangle(4,12,7,3);

        Assert.assertEquals(true, p1.intersect(r1));
        Assert.assertEquals(true, p2.intersect(r2));
        Assert.assertEquals(false, p3.intersect(r3));
        Assert.assertEquals(true, p4.intersect(r4));
    }

    @Test
    public void testPointIntersectCircle() {

        //case 1
        Point p1 = new Point(6, 5);
		Circle c1 = new Circle(new Point(7,6), 3);

        //case 2
		Point p2 = new Point(4, 6);
		Circle c2 = new Circle(new Point(7,6), 3);

        //case 3
		Point p3 = new Point(3, 4);
		Circle c3 = new Circle(new Point(7,6), 3);

        Assert.assertEquals(true, p1.intersect(c1));
        Assert.assertEquals(true, p2.intersect(c2));
        Assert.assertEquals(false, p3.intersect(c3));

    }
    
    @Test
    public void testLineSegIntersectPoint() {
        // Same as Point.intersect(LineSeg) which has already been tested. 
    }

    @Test
    public void testLineSegIntersectLineSeg() {

        //case 1
        LineSeg l1 = new LineSeg(new Point(3,3),new Point(7,7));
		LineSeg l2 = new LineSeg(new Point(3,7),new Point(7,3));

        //case 2
		LineSeg l3 = new LineSeg(new Point(3,3),new Point(7,7));
		LineSeg l4 = new LineSeg(new Point(3,3),new Point(7,7));

        //case 3
		LineSeg l5 = new LineSeg(new Point(3,3),new Point(7,7));
		LineSeg l6 = new LineSeg(new Point(5,3),new Point(9,7));

        //case 4
		LineSeg l7 = new LineSeg(new Point(3,3),new Point(7,7));
		LineSeg l8 = new LineSeg(new Point(5,5),new Point(9,9));

        //case 5
		LineSeg l9 = new LineSeg(new Point(3,3),new Point(7,3));
		LineSeg l10 = new LineSeg(new Point(7,3),new Point(12,3));

        //case 6
		LineSeg l11 = new LineSeg(new Point(3,5),new Point(8,5));
		LineSeg l12 = new LineSeg(new Point(6,5),new Point(6,1));

        Assert.assertEquals(true, l1.intersect(l2));
        Assert.assertEquals(true, l3.intersect(l4));
        Assert.assertEquals(false, l5.intersect(l6));
        Assert.assertEquals(true, l7.intersect(l8));
        Assert.assertEquals(true, l9.intersect(l10));
        Assert.assertEquals(true, l11.intersect(l12));
    }

    @Test
    public void testLineSegIntersectRectangle() {

        //case 1
        LineSeg l1 = new LineSeg(new Point(7,4),new Point(9,6));
		Rectangle r1 = new Rectangle(4,12,7,3);

        //case 2
		LineSeg l2 = new LineSeg(new Point(8,8),new Point(10,10));
		Rectangle r2 = new Rectangle(4,12,7,3);

        //case 3
		LineSeg l3 = new LineSeg(new Point(4,4),new Point(4,6));
		Rectangle r3 = new Rectangle(4,12,7,3);

        //case 4
		LineSeg l4 = new LineSeg(new Point(7,6),new Point(9,8));
		Rectangle r4 = new Rectangle(4,12,7,3);

        //case 5
		LineSeg l5 = new LineSeg(new Point(12,5),new Point(15,5));
		Rectangle r5 = new Rectangle(4,12,7,3);

        Assert.assertEquals(true, l1.intersect(r1));
        Assert.assertEquals(false, l2.intersect(r2));
        Assert.assertEquals(true, l3.intersect(r3));
        Assert.assertEquals(true, l4.intersect(r4));
        Assert.assertEquals(true, l5.intersect(r5));

    }

    @Test
    public void testLineSegIntersectCircle() {

        //case 1
        LineSeg l1 = new LineSeg(new Point(6,5),new Point(8,7));
		Circle c1 = new Circle(new Point(7,6), 3);

        //case 2
		LineSeg l2 = new LineSeg(new Point(11,5),new Point(13,7));
		Circle c2 = new Circle(new Point(7,6), 3);

        //case 3
		LineSeg l3 = new LineSeg(new Point(4,4),new Point(4,8));
		Circle c3 = new Circle(new Point(7,6), 3);

        //case 4
		LineSeg l4 = new LineSeg(new Point(10,6),new Point(13,6));
		Circle c4 = new Circle(new Point(7,6), 3);

        //case 5
		LineSeg l5 = new LineSeg(new Point(6,7),new Point(9,10));
		Circle c5 = new Circle(new Point(7,6), 3);

        Assert.assertEquals(true, l1.intersect(c1));
        Assert.assertEquals(false, l2.intersect(c2));
        Assert.assertEquals(true, l3.intersect(c3));
        Assert.assertEquals(true, l4.intersect(c4));
        Assert.assertEquals(true, l5.intersect(c5));

    }

    @Test
    public void testRectangleIntersectPoint() {
        //Same as Point.intersect(Rectangle) which has already been tested.
    }

    @Test
    public void testRectangleIntersectLineSeg() {
        //Same as LineSeg.intersect(Rectangle) which has already been tested. 

    }

     @Test
    public void testRectangleIntersectRectangle() {

        //case 1
        Rectangle r1 = new Rectangle(4,14,9,3);
		Rectangle r2 = new Rectangle(6,12,8,4);

        //case 2
		Rectangle r3 = new Rectangle(4,14,9,3);
		Rectangle r4 = new Rectangle(1,10,8,4);

        //case 3
		Rectangle r5 = new Rectangle(3,8,7,3);
		Rectangle r6 = new Rectangle(8,12,7,3);

        //case 4
		Rectangle r7 = new Rectangle(3,8,7,3);
		Rectangle r8 = new Rectangle(10,16,5,1);

        Assert.assertEquals(true, r1.intersect(r2));
        Assert.assertEquals(true, r3.intersect(r4));
        Assert.assertEquals(false, r5.intersect(r6));
        Assert.assertEquals(false, r7.intersect(r8));
    }

     @Test
    public void testRectangleIntersectCircle() {

        //case 1
        Rectangle r1 = new Rectangle(5,9,7,5);
		Circle c1 = new Circle(new Point(7,6), 3);

        //case 2
		Rectangle r2 = new Rectangle(4,14,9,3);
		Circle c2 = new Circle(new Point(7,6), 2);

        //case 3
		Rectangle r3 = new Rectangle(4,14,9,3);
		Circle c3 = new Circle(new Point(5,6), 3);

        //case 4
        Rectangle r4 = new Rectangle(8,16,8,4);
		Circle c4 = new Circle(new Point(6,6), 2);

        //case 5
		Rectangle r5 = new Rectangle(9,15,8,3);
		Circle c5 = new Circle(new Point(5,6), 2);

        Assert.assertEquals(true, r1.intersect(c1));
        Assert.assertEquals(true, r2.intersect(c2));
        Assert.assertEquals(true, r3.intersect(c3));
        Assert.assertEquals(false, r4.intersect(c4));
        Assert.assertEquals(false, r5.intersect(c5));

    }

    @Test
    public void testCircleIntersectPoint() {
        //Same as Point.intersect(Circle) which has already been tested. 
    }

    @Test
    public void testCircleIntersectLineSeg() {
        //Same as LineSeg.intersect(Circle) which has already been tested. 
    }

    @Test
    public void testCircleIntersectRectangle() {
        //Same as Rectangle.intersect(Circle) which has already been tested. 
    }

     @Test
    public void testCircleIntersectCircle() {

        //case 1
        Circle c1 = new Circle(new Point(5,6), 3);
		Circle c2 = new Circle(new Point(5,6), 2);
		
        //case 2
		Circle c3 = new Circle(new Point(5,6), 3);
		Circle c4 = new Circle(new Point(8,6), 3);

        //case 3
		Circle c5 = new Circle(new Point(5,6), 3);
		Circle c6 = new Circle(new Point(11,6), 3);

        //case 4
		Circle c7 = new Circle(new Point(5,6), 2);
		Circle c8 = new Circle(new Point(11,6), 2);

        Assert.assertEquals(true, c1.intersect(c2));
        Assert.assertEquals(true, c3.intersect(c4));
        Assert.assertEquals(false, c5.intersect(c6));
        Assert.assertEquals(false, c7.intersect(c8));

    }


}
