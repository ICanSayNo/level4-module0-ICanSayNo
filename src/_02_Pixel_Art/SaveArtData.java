package _02_Pixel_Art;

import java.io.Serializable;

public class SaveArtData implements Serializable{
	public final int gridWidth;
	public final int gridHeight;
	public final int pixelWidth;
	public final int pixelHeight;
	public final int rows;
	public final int cols;
	public final Pixel[][] pixelList;
	
	
	public SaveArtData(int gridWidth, int gridHeight, int pixelWidth, int pixelHeight, int rows, int cols, Pixel[][] pixelList) {
		this.gridWidth = gridWidth;
		this.gridHeight = gridHeight;
		this.pixelWidth = pixelWidth;
		this.pixelHeight = pixelHeight;
		this.rows = rows;
		this.cols = cols;
		this.pixelList = pixelList;
	}
}
