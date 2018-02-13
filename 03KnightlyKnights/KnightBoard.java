public class KnightBoard{
    public static void main(String[] args){
	System.out.println("arrrrrrgggggggggggghhh");
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
	return true;
    }
    // level is the # of the knight

}
