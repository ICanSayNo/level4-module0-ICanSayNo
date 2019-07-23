package _02_Pixel_Art;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class PixelArtMaker implements MouseListener, MouseMotionListener, ActionListener{
	private JFrame window;
	private GridInputPanel gip;
	private GridPanel gp;
	ColorSelectionPanel csp;
	private JButton saveButton;
	private JButton clearButton;
	private JButton loadButton;
	
	public void start() {
		
		gip = new GridInputPanel(this);	
		window = new JFrame("Pixel Art");
		window.setLayout(new FlowLayout());
		window.setResizable(false);
		
		saveButton = new JButton("Save");
		clearButton = new JButton("Clear");
		loadButton = new JButton("Load");
		saveButton.addActionListener(this);
		clearButton.addActionListener(this);
		loadButton.addActionListener(this);
		
		
		
		
		window.add(gip);
		window.pack();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		
	}

	public void submitGridData(int w, int h, int r, int c) {
		gp = new GridPanel(w, h, r, c);
		csp = new ColorSelectionPanel();
		window.remove(gip);
		window.add(saveButton);
		window.add(clearButton);
		window.add(loadButton);
		window.add(gp);
		window.add(csp);
		gp.repaint();
		gp.addMouseMotionListener(this);
		gp.addMouseListener(this);
		window.pack();
	}
	
	public static void main(String[] args) {
		new PixelArtMaker().start();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		gp.setColor(csp.getSelectedColor());
		System.out.println(csp.getSelectedColor());
		gp.clickPixel(e.getX(), e.getY());
		gp.repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		gp.setColor(csp.getSelectedColor());
		System.out.println(csp.getSelectedColor());
		System.out.println("hello this is test");
		gp.clickPixel(e.getX(), e.getY());
		gp.repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(saveButton)) {
			
			
		}
		else if (e.getSource().equals(clearButton)) {
			
			
		}
		else if (e.getSource().equals(loadButton)) {
			
			
		}
	}
}
