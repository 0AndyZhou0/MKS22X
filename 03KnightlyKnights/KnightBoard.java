
public class KnightBoard{
    public static void main(String[] args){
        KnightBoard a = new KnightBoard(7,7);
	System.out.println(a.solve());
	System.out.println(a);
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
		    grid += board[x][y] + " ";
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
	if(level == board.length*board[0].length + 1){
	    return true;
	}
	if(board[row][col] != 0){
	    return false;
	}
	int[] moves = {-2,-2,-1,1,2,2,1,-1,1,-1,-2,-2,-1,1,2,2};
	board[row][col] = level;
	for(int i = 0;i<8;i++){
	    int nextR = row + moves[i];
	    int nextC = col + moves[i+8];
	    if(nextR >= 0 && nextC >= 0 && nextR < board.length && nextC < board[0].length){
		if(solveH(nextR,nextC,level+1)){
		    return true;
		}
	    }
	}
	board[row][col] = 0;
	return false;
    }
    // level is the # of the knight

    private int[] heuristic(int row,int col){
	int[] moves = {-2,-2,-1,1,2,2,1,-1,1,-1,-2,-2,-1,1,2,2};
	int[] moveGoodness = {8,8,8,8,8,8,8,8};
        int[] moves2 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	for(int i = 0;i<8;i++){
	    int nextR = row + moves[i];
	    int nextC = col + moves[i+8];
	    
	}
	return moves;
    }

    private int checkMoves(int row,int col){
	int[] moves = {-2,-2,-1,1,2,2,1,-1,1,-1,-2,-2,-1,1,2,2};
	int numMoves = 0;
	for(int i = 0;i<8;i++){
	    int nextR = row + moves[i];
	    int nextC = col + moves[i+8];
	    if(board[nextR][nextC] == 0){
		numMoves++;
	    }
	}
	return numMoves;
    }
}
