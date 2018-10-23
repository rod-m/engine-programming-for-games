package game_engine2D.game_components;


import java.util.ArrayList;

import game_engine2D.GameManager;

import processing.core.*;

public class BasicSpatialGrid {
	class Coord {
		int x, y;
		public Coord(int _x, int _y) {
			x = _x;
			y = _y;
		}
	
	}
	int outOfBounds = 0;
	private int height, gridLengthX, gridLengthY, gridSize;
	private int gridRes = 2;
	private Coord globalMin = new Coord(9999999,999999);
	private Coord globalMax = new Coord(-999999,-999999);
	// flattened two dimensional list of all grids
	private ArrayList<SpatialGridCell> spatialGridCells;
	
	public BasicSpatialGrid(int h, int _gridRes) {
		height = h;
		gridRes = _gridRes; //how many divisions to make
		
		defineMinMax();
		makeSpatialGrid();
	
		populateGrid();
	}
	
	private void defineMinMax() {
		
		for (int i = 0; i < GameManager.gameBoundingBoxes.size(); i++) {
			BoundingBox bb = GameManager.gameBoundingBoxes.get(i);
			if(bb.left < globalMin.x) {
				globalMin.x = (int)bb.left;
			}
			if(bb.top < globalMin.y) {
				globalMin.y = (int)bb.top;
			}
			if(bb.right > globalMax.x) {
				globalMax.x = (int)bb.right;
			}
			if(bb.bottom > globalMax.y) {
				globalMax.y = (int)bb.bottom;
			}
		}
	}
	private void makeSpatialGrid() {
		gridSize = height / gridRes;
		gridLengthX = PApplet.floor( globalMax.x / gridSize );
		gridLengthY = PApplet.floor( globalMax.y / gridSize );
		spatialGridCells = new ArrayList<SpatialGridCell>();
		for(int x=0; x<=gridLengthX;x++) {
			for(int y=0; y<=gridLengthY; y++) {
				int l = x * gridSize;
				int r = (x +1) * gridSize;
				int t = y * gridSize;
				int b = (y +1) * gridSize;
				spatialGridCells.add(new SpatialGridCell(l,r,t,b));
			}
		}
	}
	
	private void populateGrid() {
		for (int i = 0; i < GameManager.gameBoundingBoxes.size(); i++) {
			BoundingBox bb = GameManager.gameBoundingBoxes.get(i);
			addToGrid(bb);
		}
	}
	private void addToGrid(BoundingBox _bb) {
		//position in grid x. Force grid snap on overlaps?
		Coord pos = gridCoordinates(_bb.right,_bb.bottom);
		int index = pos.x * gridLengthX + pos.y;
		addByIndexTo(index, _bb);
		pos = gridCoordinates(_bb.left,_bb.bottom);
		index = pos.x * gridLengthX + pos.y;
		addByIndexTo(index, _bb);
		pos = gridCoordinates(_bb.left,_bb.top);
		index = pos.x * gridLengthX + pos.y;
		addByIndexTo(index, _bb);
		pos = gridCoordinates(_bb.right,_bb.top);
		index = pos.x * gridLengthX + pos.y;
		addByIndexTo(index, _bb);
		
	}
	private void addByIndexTo(int index, BoundingBox _bb) {
		if (index < spatialGridCells.size() ) {
			
			SpatialGridCell b = spatialGridCells.get(index);
			 boolean retval = b.subBoundingBoxes.contains(_bb); 
			 if(!retval) b.subBoundingBoxes.add(_bb);
		}else {
			outOfBounds ++;
		}
	}
	private Coord gridCoordinates(float x, float y) {
		int gridPosX = PApplet.abs((int)PApplet.ceil(((globalMin.x - x) / gridSize)));
		int gridPosY = PApplet.abs((int)PApplet.ceil(((globalMin.y - y) / gridSize)));
		return new Coord(gridPosX,gridPosY);
	}
	public ArrayList<BoundingBox> queryGrid(BoundingBox _bb) {
		Coord pos = gridCoordinates(_bb.right, _bb.bottom);
		int index = pos.x * gridLengthX + pos.y;
		if (spatialGridCells.size() < index) {
			PApplet.println("Player out of bounds!");
			index = 0;
		}
		
		return spatialGridCells.get(index).subBoundingBoxes;
		
		
	}
}
