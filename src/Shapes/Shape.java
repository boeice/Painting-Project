package Shapes;

import java.awt.Graphics;
import java.awt.Point;

public interface Shape {
	void draw(Graphics g);
	void addPoint(Point p);
}
