import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import java.util.ArrayList;
import javax.swing.JPanel;

import Shapes.Shape;
import Shapes.ShapeType;
import Shapes.FreehandShape;
import Shapes.Rectangle;
import Shapes.Oval;

public class DrawingPanel extends JPanel 
		implements MouseMotionListener, MouseListener{
	
	private Color color = Color.black;
	private ArrayList<Shape> shapes = new ArrayList<>();
	private Shape currentShape;
	private ShapeType currentShapeType = ShapeType.FREEHAND;
	private boolean filled = false;
	private float strokeSize = 5f;
	
	public DrawingPanel() {
        setBackground(Color.white);
        addMouseMotionListener(this);
        addMouseListener(this);
    }
	
	public void setStrokeSize(float size) {
	    this.strokeSize = size;
	}
	
	public void setColor(Color color) {
        this.color = color;
    }
	public void setFilled(boolean filled) {
	    this.filled = filled;
	}
	
	@Override
	protected void paintComponent(Graphics g) { 
		super.paintComponent(g);
		for (Shape s : shapes) {
	        s.draw(g);
	    }
		if (currentShape != null) {
	        currentShape.draw(g);
	    }
	}

	@Override
	public void mousePressed(MouseEvent e) { 
		Point p = e.getPoint();
		switch (currentShapeType) {

        case FREEHAND:
            currentShape = new FreehandShape(color, p, strokeSize);
            break;

        case RECTANGLE:
            currentShape = new Rectangle(color, p, filled, strokeSize);
            break;

        case OVAL:
            currentShape = new Oval(color, p, filled, strokeSize);
            break;
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		currentShape.addPoint(e.getPoint());
        repaint();
	}
	
	public void setShapeType(ShapeType t) {
        this.currentShapeType = t;
    }
	
	@Override
	public void mouseReleased(MouseEvent e) {
		shapes.add(currentShape);
		currentShape = null; 
	}
	
	@Override public void mouseEntered(MouseEvent e) {}
    @Override public void mouseExited(MouseEvent e) {}
    @Override public void mouseClicked(MouseEvent e) {}
    @Override public void mouseMoved(MouseEvent e) {}
}
