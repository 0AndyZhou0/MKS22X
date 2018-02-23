public class KnightBoard{
    public static void main(String[] args){
        KnightBoard a = new KnightBoard(5,5);
	//System.out.println(a.solve());
	//System.out.println(a);
	//System.out.println(a.checkSol(0,0,1));
	//a.board[0][0] = 5;
	//System.out.println(a.checkSol(0,0,1));
	//System.out.println(a);
	System.out.println(a.countSolutions());
    }
    private int[][] board;
    private int[] moves = {-2,-2,-1,1,2,2,1,-1,1,-1,-2,-2,-1,1,2,2};
    private int solutions;

    public KnightBoard(int startingRows,int startingCols){
	if(startingRows <= 0 || startingCols <= 0){
	    throw new IllegalStateException();
	}
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
        solutions = 0;
	countSolutionsH(0,0,0,solutions);
	return solutions;
    }

    public boolean countSolutionsH(int row ,int col, int level, int solutions){
        if(level == board.length*board[0].length + 1){
	    solutions+=1;
	    return false;
	}
	if(board[row][col] != 0){
	    return false;
	}
	int[] order = heuristic(row,col);
	board[row][col] = level;
	for(int i = 0;i<8;i++){
	    int nextR = row + moves[order[i]];
	    int nextC = col + moves[order[i]+8];
	    if(nextR >= 0 && nextC >= 0 && nextR < board.length && nextC < board[0].length){
	    	if(solveH(nextR,nextC,level+1)){
	    	    return true;	
	    	}
	    }
	}
	board[row][col] = 0;
	return false;
    }

    private boolean solveH(int row ,int col, int level){
	if(level == board.length*board[0].length + 1){
	    return true;
	}
	if(board[row][col] != 0){
	    return false;
	}
	int[] order = heuristic(row,col);
	board[row][col] = level;
	for(int i = 0;i<8;i++){
	    int nextR = row + moves[order[i]];
	    int nextC = col + moves[order[i]+8];
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
	int[] moveGoodness = {9,9,9,9,9,9,9,9};
	for(int i = 0;i < 8;i++){
	    int nextR = row + moves[i];
	    int nextC = col + moves[i+8];
	    if(nextR >= 0 && nextC >= 0 && nextR < board.length && nextC < board[0].length){
		moveGoodness[i] = checkMoves(nextR,nextC);
	    }
	}
	return SortMin(moveGoodness);
    }

    private int checkMoves(int row,int col){
	int numMoves = 0;
	for(int i = 0;i<8;i++){
	    int nextR = row + moves[i];
	    int nextC = col + moves[i+8];
	    if(nextR >= 0 && nextC >= 0 && nextR < board.length && nextC < board[0].length){
		if(board[nextR][nextC] == 0){
		    numMoves++;
		}
	    }
	}
	return numMoves;
    }

    private int[] SortMin(int[] moveGoodness){
	int[] order = new int[8];
	for(int i = 0;i < 8;i++){
	    int min = 0;
	    for(int x = 0;x < 8;x++){
		if(moveGoodness[x] < moveGoodness[min]){
		    min = x;
		}
	    }
	    order[i] = min;
	    moveGoodness[min] = 10;
	}
	return order;
    }

    private boolean checkSol(int r,int c,int num){
	if(board[r][c] != num){
	    return false;
	}
	if(num == board.length*board[0].length){
	    return true;
	}
	for(int i = 0;i<8;i++){
	    int nextR = r + moves[i];
	    int nextC = c + moves[i+8];
	    if(nextR >= 0 && nextC >= 0 && nextR < board.length && nextC < board[0].length){
	    	if(checkSol(nextR,nextC,num+1)){
	    	    return true;	
	    	}
	    }
	}
	return false;
    }
}
