package _02_Pixel_Art;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class GridPanel extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private int gridWidth;
	private int gridHeight;
	private int pixelWidth;
	private int pixelHeight;
	private int rows;
	private int cols;
	
	
	//1. Create a 2D array of pixels. Do not initialize it yet.
	
	Pixel[][] pixelList;
	
	private Color color;
	
	public GridPanel(int w, int h, int r, int c) {
		
		this.gridWidth = w;
		this.gridHeight = h;
		this.rows = r;
		this.cols = c;
		
		
		this.pixelWidth = gridWidth / cols;
		this.pixelHeight = gridHeight / rows;
		
		color = Color.BLACK;
		
		setPreferredSize(new Dimension(gridWidth, gridHeight));
		
		//2. Initialize the pixel array using the rows and cols variables.
		
		pixelList = new Pixel[rows][cols];
		
		//3. Iterate through the array and initialize each element to a new pixel.
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				pixelList[i][j] = new Pixel(i, j);
			}
		} 
		
	}
	
	public void setColor(Color c) {
		color = c;
	}
	
	public void clickPixel(int mouseX, int mouseY) {
		//5. Use the mouseX and mouseY variables to change the color
		//   of the pixel that was clicked. *HINT* Use the pixel's dimensions.
		pixelList[(int)mouseX/pixelWidth][(int)mouseY/pixelHeight].color = color;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		//4. Iterate through the array.
		//   For every pixel in the list, fill in a rectangle using the pixel's color.
		//   Then, use drawRect to add a grid pattern to your display.
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				g.setColor(pixelList[i][j].color);
				g.fillRect(i*pixelWidth, j*pixelHeight, pixelWidth, pixelHeight);
				g.setColor(color.BLACK);
				g.drawRect(i*pixelWidth, j*pixelHeight, pixelWidth, pixelHeight);
			}
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
