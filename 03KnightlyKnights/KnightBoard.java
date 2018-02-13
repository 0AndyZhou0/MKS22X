public class KnightBoard{
    public static void main(String[] args){
        KnightBoard a = new KnightBoard(8,8);
	a.solve();
    }
    private int[][] board;

    public KnightBoard(int startingRows,int startingCols){
	board = new int[startingRows][startingCols];
    }
    
    //non square is required!
    public String toString(){
	String grid = "";
	for(int x = 0;x < board.length;x++){
	    for(int y = 0;y < board[0].length;y++){
		if(board[x][y] < 10){
		    grid += "_" + board[x][y] + " ";
		}else{
		    grid += "  " + board[x][y];
		}
	    }
	    grid += "\n";
	}
	return grid;
    }

    public boolean solve(){
        return solveH(0,0,1);
    }

    public int countSolutions(){
	return 0;
    }

    private boolean solveH(int row ,int col, int level){
	if(level == board.length * board[0].length){
	    return true;
	}
	int[] xMoves = {-2,-2,-1,1,2,2,1,-1};
	int[] yMoves = {1,-1,-2,-2,-1,1,2,2};
	board[row][col] = level;
	for(int i = 0;i<8;i++){
	    int nextX = row + xMoves[i];
	    int nextY = col + yMoves[i];
	    if(nextX >= 0 && nextY >= 0 && nextX < board.length && nextY < board[0].length){
		solveH(nextX,nextY,level+1);
	    }
	}
	board[row][col] = 0;
	return true;
    }
    // level is the # of the knight

}
