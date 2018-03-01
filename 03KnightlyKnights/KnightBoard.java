public class KnightBoard{
    public static void main(String[] args){
	KnightBoard a = new KnightBoard(3,3);

	System.out.println(a);
	/* Prints
	   _ _ _
	   _ _ _
	   _ _ _
	*/

	for (int i = 0; i < 3; i++){
	    for (int j = 0; j < 3; j++){
		if (a.solve(i,j)){
		    System.out.println("There is an error with your solve method");
		}
	    }
	} //prints nothing

	System.out.println(a.countSolutions(0,0)); //prints 0



	KnightBoard b = new KnightBoard(5,5);
	System.out.println(b.solve(0,0)); //prints true
	System.out.println(b); //prints a valid solution

	try{
	    b.solve(0,0);
	}catch(IllegalStateException e){
	    System.out.println("Error: The board contains non-zero values");
	} //prints "Error: The board contains non-zero values"

	try{
	    b.countSolutions(0,0);
	}catch(IllegalStateException e){
	    System.out.println("Error: The board contains non-zero values");
	} //prints "Error: The board contains non-zero values"

	try{
	    KnightBoard b1 = new KnightBoard(-1,0);
	}catch(IllegalArgumentException e){
	    System.out.println("Error: There cannot be negative parameters in the constructor");
	} //prints "Error: There cannot be negative parameters in the constructor"

	try{
	    KnightBoard b1 = new KnightBoard(1,-1);
	}catch(IllegalArgumentException e){
	    System.out.println("Error: There cannot be negative parameters in the constructor");
	} //prints "Error: There cannot be negative parameters in the constructor"

	try{
	    KnightBoard b1 = new KnightBoard(-1,-1);
	}catch(IllegalArgumentException e){
	    System.out.println("Error: There cannot be negative parameters in the constructor");
	} //prints "Error: There cannot be negative parameters in the constructor"

	try{
	    KnightBoard b1 = new KnightBoard(5,5);
	    b1.solve(0,-1);
	}catch(IllegalArgumentException e){
	    System.out.println("Error: There cannot be negative parameters");
	} //prints "Error: There cannot be negative parameters"

	try{
	    KnightBoard b1 = new KnightBoard(5,5);
	    b1.solve(-1,0);
	}catch(IllegalArgumentException e){
	    System.out.println("Error: There cannot be negative parameters");
	} //prints "Error: There cannot be negative parameters"

	try{
	    KnightBoard b1 = new KnightBoard(5,5);
	    b1.solve(-1,-1);
	}catch(IllegalArgumentException e){
	    System.out.println("Error: There cannot be negative parameters");
	} //prints "Error: There cannot be negative parameters"



	for (int i = 0; i < 5; i++){
	    for (int j = 0; j < 5; j++){
		KnightBoard abc = new KnightBoard(5,5);
		System.out.println(abc.solve(i,j)); //prints alternating lines of true/false starting with true
	    }
	}
	KnightBoard c = new KnightBoard(5,5);

	int totalSol = 0;
	for (int i = 0; i < 5; i++){
	    for (int j = 0; j < 5; j++){
		totalSol += c.countSolutions(i,j);
	    }
	}

	System.out.println(totalSol); //prints 1728

	KnightBoard d = new KnightBoard(5,5);
	System.out.println(d.countSolutions(0,0)); //prints 304

    }	
    private int[][] board;
    private int[] moves = {-2,-2,-1,1,2,2,1,-1,1,-1,-2,-2,-1,1,2,2};
    private int solutions;

    /*
      @throws IllegalArgumentException when either parameter is negative.
     */
    public KnightBoard(int startingRows,int startingCols){
	if(startingRows <= 0 || startingCols <= 0){
	    throw new IllegalArgumentException();
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

    /*
      @throws IllegalStateException when the board contains non-zero values.
      @throws IllegalArgumentException when either parameter is negative 
      or out of bounds.
     */
    public boolean solve(int startingRow,int startingCol){
        if(checkZeros() && startingRow < 0 || startingCol < 0){
	    throw new IllegalArgumentException();
	}
        return solveH(startingRow,startingCol,1);
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

    //Sorts the order of moves
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

    //checks if solution is valid
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

    /*
      @throws IllegalStateException when the board contains non-zero values. 
      @throws IllegalArgumentException when either parameter is negative 
      or out of bounds.
    */
    public int countSolutions(int startingRow,int startingCol){
        if(checkZeros() && startingRow < 0 || startingCol < 0){
	    throw new IllegalArgumentException();
	}
        solutions = 0;
	countSolutionsH(startingRow,startingCol,1);
	return solutions;
    }

    private boolean countSolutionsH(int row ,int col, int level){
	if(board[row][col] != 0){
	    return false;
	}
	board[row][col] = level;
	for(int i = 0;i<8;i++){
	    int nextR = row + moves[i];
	    int nextC = col + moves[i+8];
	    if(nextR >= 0 && nextC >= 0 && nextR < board.length && nextC < board[0].length){
	        if(level + 1 == board.length*board[0].length + 1){
		    solutions++;
		    board[row][col] = 0;
		    return false;
		}else{
		    countSolutionsH(nextR,nextC,level+1);
		}
	    }
	}
	board[row][col] = 0;
	return false;
    }
    
    private boolean checkZeros(){
	for(int x = 0;x < board.length;x++){
	    for(int y = 0;y < board[0].length;y++){
		if(board[x][y] != 0){
		    throw new IllegalStateException();
		}
	    }
	}
	return true;
    }
}
