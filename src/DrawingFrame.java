import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;

public class DrawingFrame extends JFrame {
	
	private DrawingPanel panel = new DrawingPanel();
    private ToolBar toolbar = new ToolBar(panel); ///
    
	DrawingFrame(){
		setTitle("Paint");
		setSize(800,600);
		setBackground(Color.white);
		setLayout(new BorderLayout());
		
		add(panel, BorderLayout.CENTER);
		add(toolbar, BorderLayout.NORTH);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
