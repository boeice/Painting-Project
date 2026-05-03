package Shapes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;

public class Rectangle implements Shape{

	private Color color;
    private Point startPoint, endPoint;
    private boolean filled;
    private float strokeSize;
    
    public Rectangle(Color c, Point s, boolean f, float size){
     	this.strokeSize = size;
    		this.color = c;
    		this.startPoint = s;
    		this.endPoint = startPoint;
    		this.filled = f;
    }
    
	@Override
	public void draw(Graphics g) {
		
		int x = Math.min(startPoint.x, endPoint.x); 
        int y = Math.min(startPoint.y, endPoint.y); 
        
        int width = Math.abs(startPoint.x - endPoint.x);
        int height = Math.abs(startPoint.y - endPoint.y);
        
     	Graphics2D g2 = (Graphics2D) g;
     	
     	g2.setColor(color);
     	g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
     	g2.setStroke(new BasicStroke(strokeSize, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND)); 
     	
        if (filled) {
            g2.fillRect(x, y, width, height);  
        } else {
            g2.drawRect(x, y, width, height);  
        }
	}

	@Override
	public void addPoint(Point p) {
		 endPoint = p;
	}
	
}
