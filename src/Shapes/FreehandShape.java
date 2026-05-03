package Shapes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.geom.Path2D;


public class FreehandShape implements Shape{
	private Path2D.Float path = new Path2D.Float();
	private Color color;
	private float strokeSize;
	
	public FreehandShape(Color c, Point s, float size) {
	    this.strokeSize = size;
		this.color = c;
		path.moveTo(s.x, s.y); ///
	}

	@Override
	public void draw(Graphics g) {
		Graphics2D brush = (Graphics2D) g; 
	    brush.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		brush.setStroke(new BasicStroke(strokeSize, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND)); 

     	brush.setColor(color);
     	brush.draw(path);
	}

	@Override
	public void addPoint(Point p) {
		path.lineTo(p.x, p.y); ///
	}
}
