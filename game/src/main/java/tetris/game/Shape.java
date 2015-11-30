package tetris.game;

import java.util.Random;
import java.lang.Math;

public class Shape {
	//No-shape, z-shape, s-shape, line-shape, t-shape, l-shape, mirrorL-shape
	//Q: square shepe, q from square in portuguese
	enum Shapes {no, z, s, line, t, q, l, lM};
	
	private Shapes piece;
	private int[][] coords;
	private int [][][] tableCoord;
	
	public Shape(){
		coords = new int[4][2];
		setShape(Shapes.no);
	}
	
	public void setShape(Shapes shape){
		tableCoord = new int[][][] {
	            { { 0, 0 },   { 0, 0 },   { 0, 0 },   { 0, 0 } },
	            { { 0, -1 },  { 0, 0 },   { -1, 0 },  { -1, 1 } },
	            { { 0, -1 },  { 0, 0 },   { 1, 0 },   { 1, 1 } },
	            { { 0, -1 },  { 0, 0 },   { 0, 1 },   { 0, 2 } },
	            { { -1, 0 },  { 0, 0 },   { 1, 0 },   { 0, 1 } },
	            { { 0, 0 },   { 1, 0 },   { 0, 1 },   { 1, 1 } },
	            { { -1, -1 }, { 0, -1 },  { 0, 0 },   { 0, 1 } },
	            { { 1, -1 },  { 0, -1 },  { 0, 0 },   { 0, 1 } }
	        };
		
		for (int i = 0;i < 4;i++){
			for (int j = 0;j < 2;j++){
				coords[i][j] = tableCoord[shape.ordinal()][i][j];
			}
		}
		
		piece = shape;
	}
	
	private void setX(int index, int x) { coords[index][0] = x; }
    private void setY(int index, int y) { coords[index][1] = y; }
    public int x(int index) { return coords[index][0]; }
    public int y(int index) { return coords[index][1]; }
    public Shapes getShape()  { return piece; }
    
    public void setRandomShape(){
    	
        Random rg = new Random();
        int x = Math.abs(rg.nextInt()) % 7 + 1;
        Shapes[] values = Shapes.values(); 
        setShape(values[x]);
    }
    
    public int minX(){
    	
      int min = coords[0][0];
      for (int i=0; i < 4; i++) {
          min = Math.min(min, coords[i][0]);
      }
      return min;
    }
    
    public int minY(){
    	
      int min = coords[0][1];
      for (int i=0; i < 4; i++) {
          min = Math.min(min, coords[i][1]);
      }
      return min;
    }
    
    public Shape rotateLeft() {
    	
        if (piece == Shapes.q)
            return this;

        Shape result = new Shape();
        result.piece = piece;

        for (int i = 0; i < 4; ++i) {
            result.setX(i, y(i));
            result.setY(i, -x(i));
        }
        return result;
    }
    
    public Shape rotateRight(){
    	
        if (piece == Shapes.q)
            return this;

        Shape result = new Shape();
        result.piece = piece;

        for (int i = 0; i < 4; ++i) {
            result.setX(i, -y(i));
            result.setY(i, x(i));
        }
        return result;
    }
    
}
