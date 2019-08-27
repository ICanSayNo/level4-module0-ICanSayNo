package _02_Pixel_Art;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JButton;
import javax.swing.JOptionPane;
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

	public void save() {
		String fileName = JOptionPane.showInputDialog("What would you like to name this file?");
		try (FileOutputStream fos = new FileOutputStream(new File("src/_02_Pixel_Art/" + fileName + ".dat")); 
				ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(new SaveArtData(gridWidth, gridHeight, pixelWidth, pixelHeight, rows, cols, pixelList));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void clear() {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				pixelList[i][j].color=color.white;
				repaint();
			}
		}
	}
	
	public void load() {
		String fileName = JOptionPane.showInputDialog("What file would you like to load?");
		try (FileInputStream fis = new FileInputStream(new File("src/_02_Pixel_Art/" + fileName + ".dat")); 
				ObjectInputStream ois = new ObjectInputStream(fis)) {
			SaveArtData sd = (SaveArtData) ois.readObject();
			gridHeight = sd.gridHeight;
			gridWidth = sd.gridWidth;
			pixelWidth = sd.pixelWidth;
			pixelHeight = sd.pixelHeight;
			pixelList = sd.pixelList;
			rows = sd.rows;
			cols = sd.cols;
			setPreferredSize(new Dimension(gridWidth, gridHeight));
			
			System.out.println(sd.rows + "  " + sd.cols + "\n");
			//for (int i = 0; i < rows; i++) {
			//	for (int j = 0; j < cols; j++) {
			//		System.out.println(i + "  " + j + "  " + sd.pixelList[i][j].color);
			//		pixelList[i][j].color = sd.pixelList[i][j].color;
			//	}
			//}
			repaint();
		} catch (IOException e) {
			e.printStackTrace();
			//return null;
		} catch (ClassNotFoundException e) {
			// This can occur if the object we read from the file is not
			// an instance of any recognized class
			e.printStackTrace();
			//return null;
		}
	}
}
