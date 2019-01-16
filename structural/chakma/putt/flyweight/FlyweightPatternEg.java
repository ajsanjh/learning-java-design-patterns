package chakma.putt.flyweight;


public class FlyweightPatternEg {
	private static final int ROWS = 6, COLS = 10;

	
	public static void main(String[] args) {
		runR();
	}
	
	
	
	/** regular run */
	private static void runR() {
		GazillionR[][] matrix = new GazillionR[ROWS][COLS];
		for (int i = 0; i < ROWS; i++) {
			for(int j =0; j < COLS; j++) {
				matrix[i][j] = new GazillionR(COLS);
			}
		}
		
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				matrix[i][j].report();
			}
			System.out.println();
		}
	}

	
}

/** normal object class. we will create a lot of objects of this */
class GazillionR {
	private static int num = 0;
	private int row, col;
	
	public GazillionR(int maxPerRow) {
		this.row = num/maxPerRow;
		this.col = num%maxPerRow;
		num ++;
	}
	
	void report() {
		System.out.print(" " + row + col);
	}
	
}


/** flyweight pattern; class updated to externalize col */




