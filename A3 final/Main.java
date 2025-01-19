import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Main {
	public static void main(String[] args) {
		AbstractShape p1 = new Point();
		AbstractShape p2 = new Point(23.2f, 111.1f);

		CollisionDetector p3 = new Point(7.1f, 0.4f);
		CollisionDetector r1 = new Rectangle();
		CollisionDetector c1 = new Circle(new Point(7.1f, 0.4f), 3.3f);
		CollisionDetector l1 = new LineSeg((Point)p1, (Point)p2);
		
		System.out.println("r1 intersects with c1 is " + r1.intersect((Circle)c1));
		
		System.out.println("You created " + AbstractShape.getNumOfInstances() + " Shapes:");
		System.out.println("  " + Rectangle.getNumOfInstances() + " Rectangles.");
		System.out.println("  " + LineSeg.getNumOfInstances() + " Line Segments.");
		System.out.println("  " + Point.getNumOfInstances() + " Points.");
		System.out.println("  " + Circle.getNumOfInstances() + " Circles.");
		//BlackboxWithoutJUnit.runTests();	

		// POINT INTERSECT LINE
		// Point p1 = new Point(6f, 5f);
		// LineSeg l1 = new LineSeg(new Point(3,3),new Point(9,3));

		// Point p2 = new Point(6f, 3f);
		// LineSeg l2 = new LineSeg(new Point(3,3),new Point(9,3));

		// Point p3 = new Point(3f, 3f);
		// LineSeg l3 = new LineSeg(new Point(3,3),new Point(9,3));

		// Point p4 = new Point(2f, 3f);
		// LineSeg l4 = new LineSeg(new Point(3,3),new Point(9,3));

		//POINT INTERSECT RECTANGLE
		// Point p1 = new Point(6, 5);
		// Rectangle r1 = new Rectangle(4,12,7,3);

		// Point p2 = new Point(4, 5);
		// Rectangle r2 = new Rectangle(4,12,7,3);

		// Point p3 = new Point(2, 5);
		// Rectangle r3 = new Rectangle(4,12,7,3);

		// Point p4 = new Point(4, 3);
		// Rectangle r4 = new Rectangle(4,12,7,3);

		//POINT INTERSECT CIRCLE
		// Point p1 = new Point(6, 5);
		// Circle c1 = new Circle(new Point(7,6), 3);

		// Point p2 = new Point(4, 6);
		// Circle c2 = new Circle(new Point(7,6), 3);

		// Point p3 = new Point(3, 4);
		// Circle c3 = new Circle(new Point(7,6), 3);

		//LINE SEGMENT

		//LINE INTERSECT POINT
		// LineSeg l1 = new LineSeg(new Point(3,3),new Point(9,3));
		// Point p1 = new Point(6f, 5f);

		// LineSeg l2 = new LineSeg(new Point(3,3),new Point(9,3));
		// Point p2 = new Point(6f, 3f);
		
		// LineSeg l3 = new LineSeg(new Point(3,3),new Point(9,3));
		// Point p3 = new Point(3f, 3f);

		// LineSeg l4 = new LineSeg(new Point(3,3),new Point(9,3));
		// Point p4 = new Point(2f, 3f);

		// LINE INTERSECT LINE
		// LineSeg l1 = new LineSeg(new Point(3,3),new Point(7,7));
		// LineSeg l2 = new LineSeg(new Point(3,7),new Point(7,3));

		// LineSeg l3 = new LineSeg(new Point(3,3),new Point(7,7));
		// LineSeg l4 = new LineSeg(new Point(3,3),new Point(7,7));

		// LineSeg l5 = new LineSeg(new Point(3,3),new Point(7,7));
		// LineSeg l6 = new LineSeg(new Point(5,3),new Point(9,7));

		// LineSeg l7 = new LineSeg(new Point(3,3),new Point(7,7));
		// LineSeg l8 = new LineSeg(new Point(5,5),new Point(9,9));

		// LineSeg l9 = new LineSeg(new Point(3,3),new Point(7,3));
		// LineSeg l10 = new LineSeg(new Point(7,3),new Point(12,3));

		// LineSeg l11 = new LineSeg(new Point(3,5),new Point(8,5));
		// LineSeg l12 = new LineSeg(new Point(6,5),new Point(6,1));

		//LINE INTERSECT RECTANGLE
		// LineSeg l1 = new LineSeg(new Point(7,4),new Point(9,6));
		// Rectangle r1 = new Rectangle(4,12,7,3);

		// LineSeg l2 = new LineSeg(new Point(8,8),new Point(10,10));
		// Rectangle r2 = new Rectangle(4,12,7,3);

		// LineSeg l3 = new LineSeg(new Point(4,4),new Point(4,6));
		// Rectangle r3 = new Rectangle(4,12,7,3);

		// LineSeg l4 = new LineSeg(new Point(7,6),new Point(9,8));
		// Rectangle r4 = new Rectangle(4,12,7,3);

		// LineSeg l5 = new LineSeg(new Point(12,5),new Point(15,5));
		// Rectangle r5 = new Rectangle(4,12,7,3);

		//LINE INTERSECT CIRCLE
		
		// LineSeg l1 = new LineSeg(new Point(6,5),new Point(8,7));
		// Circle c1 = new Circle(new Point(7,6), 3);

		// LineSeg l2 = new LineSeg(new Point(11,5),new Point(13,7));
		// Circle c2 = new Circle(new Point(7,6), 3);

		// LineSeg l3 = new LineSeg(new Point(4,4),new Point(4,8));
		// Circle c3 = new Circle(new Point(7,6), 3);

		// LineSeg l4 = new LineSeg(new Point(10,6),new Point(13,6));
		// Circle c4 = new Circle(new Point(7,6), 3);

		// LineSeg l5 = new LineSeg(new Point(6,7),new Point(9,10));
		// Circle c5 = new Circle(new Point(7,6), 3);
		
		//RECTANGLE

		//RECTANGLE INTERSECT POINT
		// Rectangle r1 = new Rectangle(4,12,7,3);
		// Point p1 = new Point(6, 5);

		// Rectangle r2 = new Rectangle(4,12,7,3);
		// Point p2 = new Point(4, 5);
		
		// Rectangle r3 = new Rectangle(4,12,7,3);
		// Point p3 = new Point(2, 5);

		// Rectangle r4 = new Rectangle(4,12,7,3);
		// Point p4 = new Point(4, 3);

		//RECTANGLE INTERSECT LINE
		// Rectangle r1 = new Rectangle(4,12,7,3);
		// LineSeg l1 = new LineSeg(new Point(7,4),new Point(9,6));

		// Rectangle r2 = new Rectangle(4,12,7,3);
		// LineSeg l2 = new LineSeg(new Point(8,8),new Point(10,10));

		// Rectangle r3 = new Rectangle(4,12,7,3);
		// LineSeg l3 = new LineSeg(new Point(4,4),new Point(4,6));

		// Rectangle r4 = new Rectangle(4,12,7,3);
		// LineSeg l4 = new LineSeg(new Point(7,6),new Point(9,8));

		// Rectangle r5 = new Rectangle(4,12,7,3);
		// LineSeg l5 = new LineSeg(new Point(12,5),new Point(15,5));

		//RECTANGLE INTERSECT RECTANGLE
		// Rectangle r1 = new Rectangle(4,14,9,3);
		// Rectangle r2 = new Rectangle(6,12,8,4);

		// Rectangle r3 = new Rectangle(4,14,9,3);
		// Rectangle r4 = new Rectangle(1,10,8,4);

		// Rectangle r5 = new Rectangle(3,8,7,3);
		// Rectangle r6 = new Rectangle(8,12,7,3);

		// Rectangle r7 = new Rectangle(3,8,7,3);
		// Rectangle r8 = new Rectangle(10,16,5,1);

		//RECTANGLE INTERSECT CIRCLE
		// Rectangle r1 = new Rectangle(5,9,7,5);
		// Circle c1 = new Circle(new Point(7,6), 3);

		// Rectangle r2 = new Rectangle(4,14,9,3);
		// Circle c2 = new Circle(new Point(7,6), 2);

		// Rectangle r3 = new Rectangle(4,14,9,3);
		// Circle c3 = new Circle(new Point(5,6), 3);

		// Rectangle r4 = new Rectangle(8,16,8,4);
		// Circle c4 = new Circle(new Point(6,6), 2);

		// Rectangle r5 = new Rectangle();
		// Circle c5 = new Circle(new Point(5,6), 2);

		

		//CIRCLES

		//CIRCLE INTERSECT CIRCLE

		// Circle c1 = new Circle(new Point(5,6), 3);
		// Circle c2 = new Circle(new Point(5,6), 2);
		
		// Circle c3 = new Circle(new Point(5,6), 3);
		// Circle c4 = new Circle(new Point(8,6), 3);

		// Circle c5 = new Circle(new Point(5,6), 3);
		// Circle c6 = new Circle(new Point(11,6), 3);

		// Circle c7 = new Circle(new Point(5,6), 2);
		// Circle c8 = new Circle(new Point(11,6), 2);


		//System.out.println(c7.intersect(c8));



	
		// ShapeVisualizer.visualize(r4,c4);

		//composition
	// LineSeg l = new LineSeg(new Point(2,2), new Point(1,1)); Circle c = new Circle(new Point(7.1f, 0.4f), 3.3f); Rectangle r = new Rectangle(1,3,3,2);
	// CompShape s = new CompShape();
	// s.addShape(l); s.addShape(c); s.addShape(r);
	// CompShape s2 = new CompShape(); s.removeShape(r);
	// s2.addShape(r);
	// s2.addShape(s);
	// //intersect
	// s2.intersect(l); s2.intersect(c); s2.intersect(r); s2.intersect(s);
	// //access components
	// CompShapeIterator it = s2.getIterator(); it.first();
	// while(it.isDone())
	// {
	// AbstractShape shape = it.getCurrentShape();
	// it.next(); }
	// //singleton Drawing
	// Drawing dwg = Drawing.getInstance(); dwg.setShape(s2);
	// AbstractShape ds = dwg.getShape();
	System.out.println("Creating and modifying CompShapes");
	LineSeg l = new LineSeg(new Point(2, 2), new Point(1, 1));
	Circle c = new Circle(new Point(7.1f, 0.4f), 3.3f);
	Rectangle r = new Rectangle(1, 3, 3, 2);
	CompShape s = new CompShape();
	s.addShape(l);
	s.addShape(c);
	s.addShape(r);
	CompShape s2 = new CompShape();
	s.removeShape(r);
	s2.addShape(r);
	s2.addShape(s);

	// Intersect
	System.out.println("\nChecking intersections:");
	System.out.println("s2 intersects with l: " + s2.intersect(l));
	System.out.println("s2 intersects with c: " + s2.intersect(c));
	System.out.println("s2 intersects with r: " + s2.intersect(r));
	System.out.println("s2 intersects with s: " + s2.intersect(s));

	// Access components
	System.out.println("\nAccessing components of s2:");
	CompShapeIterator it = s2.getIterator();
	it.first();
	while(!it.isDone()) {
		AbstractShape shape = it.getCurrentShape();
		System.out.println("Current shape: " + shape);
		it.next();
	}
	// Singleton Drawing
	System.out.println("\nUsing the Drawing singleton:");
	Drawing dwg = Drawing.getInstance();
	dwg.setShape(s2);
	AbstractShape ds = dwg.getShape();
	System.out.println("Shape in Drawing: " + ds);
	}
}
