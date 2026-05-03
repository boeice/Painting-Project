import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Shapes.ShapeType;

public class ToolBar extends JPanel implements ActionListener, ChangeListener {
	
	private Color color = Color.black;
	private DrawingPanel panel;
	private JButton colorBtn = new JButton("Color Pallet");
	private JButton freeBtn = new JButton("Free");
	private JButton rectBtn = new JButton("Rect");
	private JButton ovalBtn = new JButton("Oval");
	private JCheckBox fillBox = new JCheckBox("Fill");
	private JSlider strokeSize = new JSlider(1,50,5);
	private JLabel strokeLabel = new JLabel("Stroke Size");

	
	public ToolBar(DrawingPanel p) {
		
		this.panel = p;
        colorBtn.addActionListener(this);
        freeBtn.addActionListener(this);
        ovalBtn.addActionListener(this);
        rectBtn.addActionListener(this);
        fillBox.addActionListener(this);
        strokeSize.addChangeListener(this);
        
        add(strokeLabel);
        add(strokeSize);
        add(colorBtn); 
        add(freeBtn);    
        add(ovalBtn);    
        add(rectBtn); 
        add(fillBox);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == colorBtn) {
			color = JColorChooser.showDialog(null, "Pick a Color", color);
			panel.setColor(color); 
		}
		else if (e.getSource() == freeBtn) {
	        panel.setShapeType(ShapeType.FREEHAND);
	    }
		else if (e.getSource() == rectBtn) {
	        panel.setShapeType(ShapeType.RECTANGLE);
	    }
		else if (e.getSource() == ovalBtn) {
	        panel.setShapeType(ShapeType.OVAL);
	    }
		if (e.getSource() == fillBox) {
		    panel.setFilled(fillBox.isSelected());
		}
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		float size = strokeSize.getValue();
		panel.setStrokeSize(size); 

	}
}
