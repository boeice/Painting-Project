import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import Shapes.ShapeType;

public class ToolBar extends JPanel implements ActionListener, ChangeListener {
	
	private Color color = Color.black;
	private DrawingPanel panel;
	
	private JButton colorBtn = new JButton("Color Pallet");
	private JButton freeBtn = new JButton("Free");
	private JButton rectBtn = new JButton("Rect");
	private JButton ovalBtn = new JButton("Oval");
	
	private JButton clearBtn = new JButton("Clear");
	
	private JButton undoBtn = new JButton("Undo");
	private JButton redoBtn = new JButton("Redo");

	private JRadioButton fillBtn = new JRadioButton("Fill");
	private JRadioButton drawBtn = new JRadioButton("Draw");
	
    private ButtonGroup modeGroup = new ButtonGroup();

	private JSlider strokeSize = new JSlider(1,50,5);
	private JLabel strokeLabel = new JLabel("Stroke Size");
	
	public ToolBar(DrawingPanel p) {
		this.panel = p;
		
        colorBtn.addActionListener(this);
        
        freeBtn.addActionListener(this);
        ovalBtn.addActionListener(this);
        rectBtn.addActionListener(this);
        
        fillBtn.addActionListener(this);
        drawBtn.addActionListener(this);
        
        strokeSize.addChangeListener(this);
        
        clearBtn.addActionListener(this);
        undoBtn.addActionListener(this);
        redoBtn.addActionListener(this);

        add(strokeLabel);
        add(strokeSize);
        
        add(colorBtn); 
        
        add(freeBtn);    
        add(ovalBtn);    
        add(rectBtn); 
        
        add(undoBtn);
        add(redoBtn);
        add(clearBtn);
        
        add(fillBtn);
        add(drawBtn);
        
        modeGroup.add(drawBtn);
        modeGroup.add(fillBtn);
        
        fillBtn.setVisible(false);
        drawBtn.setVisible(false);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == colorBtn) {
	    	color = JColorChooser.showDialog(null, "Pick a Color", color);
	    	panel.setColor(color);
	    	}
		
	    else if (e.getSource() == freeBtn)  { ////
	        	panel.setShapeType(ShapeType.FREEHAND);
	    	    fillBtn.setVisible(false);
	        drawBtn.setVisible(false);
	    }
		
	    else if (e.getSource() == rectBtn) { ////
	        panel.setShapeType(ShapeType.RECTANGLE);
	        fillBtn.setVisible(true);
	        drawBtn.setVisible(true);
	    }

	    else if (e.getSource() == ovalBtn) { ////
	        panel.setShapeType(ShapeType.OVAL);
	        fillBtn.setVisible(true);
	        drawBtn.setVisible(true);
	    }
		
	    else if (e.getSource() == undoBtn)  panel.undo();
	    else if (e.getSource() == redoBtn) panel.redo();
		
	    else if (e.getSource() == clearBtn) panel.clear();
		
	    else if (e.getSource() == fillBtn)  panel.setFilled(true);
	    else if (e.getSource() == drawBtn)  panel.setFilled(false);
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		float size = strokeSize.getValue();
		panel.setStrokeSize(size); 
	}
}
