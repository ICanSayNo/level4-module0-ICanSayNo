package _04_Maze_Maker;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;


public class MazeMaker{
	
	private static int width;
	private static int height;
	
	private static Maze maze;
	
	private static Random randGen = new Random();
	private static Stack<Cell> uncheckedCells = new Stack<Cell>();
	
	
	public static Maze generateMaze(int w, int h){
		width = w;
		height = h;
		maze = new Maze(width, height);
		
		//4. select a random cell to start
		int cellRandX = new Random().nextInt(25);
		int cellRandY = new Random().nextInt(25);
		Cell origin = maze.getCell(cellRandX ,cellRandY);
		
		//5. call selectNextPath method with the randomly selected cell
		
		selectNextPath(origin);
		
		return maze;
	}

	//6. Complete the selectNextPathMethod
	private static void selectNextPath(Cell currentCell) {
		//A. mark cell as visited
		currentCell.setBeenVisited(true);
		//B. check for unvisited neighbors using the cell
		
		ArrayList<Cell> unvisitedNeighbors = new ArrayList<Cell>();
		try {
			if(!maze.getCell(currentCell.getX()+1, currentCell.getY()).hasBeenVisited()) {
				unvisitedNeighbors.add(maze.getCell(currentCell.getX()+1, currentCell.getY()));
			}
		}catch(IndexOutOfBoundsException e) {
			//ignore
		}
		try {
			if(!maze.getCell(currentCell.getX(), currentCell.getY()+1).hasBeenVisited()) {
				unvisitedNeighbors.add(maze.getCell(currentCell.getX(), currentCell.getY()+1));
			}
		}catch(IndexOutOfBoundsException e) {
			//ignore
		}
		try {
			if(!maze.getCell(currentCell.getX()-1, currentCell.getY()).hasBeenVisited()) {
				unvisitedNeighbors.add(maze.getCell(currentCell.getX()-1, currentCell.getY()));
			}
		}catch(IndexOutOfBoundsException e) {
			//ignore
		}
		try {
			if(!maze.getCell(currentCell.getX(), currentCell.getY()-1).hasBeenVisited()) {
				unvisitedNeighbors.add(maze.getCell(currentCell.getX(), currentCell.getY()-1));
			}
		}catch(IndexOutOfBoundsException e) {
			//ignore
		}
			int randNeighbor=0;
		//C. if has unvisited neighbors,
		
		if(!unvisitedNeighbors.isEmpty()) {
			randNeighbor = new Random().nextInt(unvisitedNeighbors.size());
			uncheckedCells.push(unvisitedNeighbors.get(randNeighbor));
			removeWalls(currentCell, uncheckedCells.lastElement());
			currentCell=uncheckedCells.lastElement();
			selectNextPath(currentCell);
		}
		
			//C1. select one at random.
			
			//C2. push it to the stack
		
			//C3. remove the wall between the two cells

			//C4. make the new cell the current cell and mark it as visited
		
			//C5. call the selectNextPath method with the current cell
			
			
		//D. if all neighbors are visited
		
		if(unvisitedNeighbors.isEmpty()) {
			uncheckedCells.pop();
			if(!uncheckedCells.isEmpty()) {
				currentCell=uncheckedCells.lastElement();
				selectNextPath(currentCell);
			}
		}
			//D1. if the stack is not empty
			
				// D1a. pop a cell from the stack
		
				// D1b. make that the current cell
		
				// D1c. call the selectNextPath method with the current cell
				
			
		
	}

	//7. Complete the remove walls method.
	//   This method will check if c1 and c2 are adjacent.
	//   If they are, the walls between them are removed.
	private static void removeWalls(Cell c1, Cell c2) {
		if(c1.getX()==c2.getX()&&c1.getY()+1==c2.getY()) {
			c2.setNorthWall(false);
			c1.setSouthWall(false);
		}
		if(c1.getX()==c2.getX()&&c1.getY()-1==c2.getY()) {
			c1.setNorthWall(false);
			c2.setSouthWall(false);
		}
		if(c1.getX()+1==c2.getX()&&c1.getY()==c2.getY()) {
			c1.setEastWall(false);
			c2.setWestWall(false);
		}
		if(c1.getX()-1==c2.getX()&&c1.getY()==c2.getY()) {
			c2.setEastWall(false);
			c1.setWestWall(false);
		}
	}
	
	//8. Complete the getUnvisitedNeighbors method
	//   Any unvisited neighbor of the passed in cell gets added
	//   to the ArrayList
	private static ArrayList<Cell> getUnvisitedNeighbors(Cell c) {
		return null;
	}
}
