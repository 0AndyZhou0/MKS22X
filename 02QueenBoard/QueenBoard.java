public class QueenBoard{
    public static void main(String[] args){
	//QueenBoard a = new QueenBoard(8);
	//System.out.println(a);
	//System.out.println(a.countSolutions());
	//System.out.println(a);
    }
    private int[][] board;
    public int solutions;
    
    public QueenBoard(int size){
	board = new int[size][size];
    }

    private boolean hasNonZero(){
	for(int r = 0;r < board.length;r++){
	    for(int c = 0;c < board.length;c++){
		if(board[r][c] != 0){
		    return false;
		}
	    }
	}
	return true;
    }
    
    private boolean addQueen(int r, int c){
	if(board[r][c] != 0){
	    return false;
	}
	//Adds row and col
	for(int i = 0;i < board.length;i++){
	    board[i][c]++;
	    board[r][i]++;
	}
	//Adds diagonal
	for(int i = -1;i <= 1;i+=2){
	    int row = r;
	    int col = c;
	    while(row >= 0 && col >= 0 && row < board.length && col < board.length){
		board[row][col]++;
		row+=i;
		col+=i;
	    }
	    row = r;
	    col = c;
	    while(row >= 0 && col >= 0 && row < board.length && col < board.length){
		board[row][col]++;
		row-=i;
		col+=i;
	    }
	}
	//Adds Queen
	board[r][c] = -1;
	return true;
    }
    private boolean removeQueen(int r, int c){
	if(board[r][c] != -1){
	    return false;
	}
	//Removes row and col
	for(int i = 0;i < board.length;i++){
	    board[i][c]--;
	    board[r][i]--;
	}
	//Removes diagonal
	for(int i = -1;i <= 1;i+=2){
	    int row = r;
	    int col = c;
	    while(row >= 0 && col >= 0 && row < board.length && col < board.length){
		board[row][col]--;
		row+=i;
		col+=i;
	    }
	    row = r;
	    col = c;
	    while(row >= 0 && col >= 0 && row < board.length && col < board.length){
		board[row][col]--;
		row-=i;
		col+=i;
	    }
	}
	//Removes Queen
	board[r][c] = 0;
        return true;
    }

    /**
     *@return The output string formatted as follows:
     *All numbers that represent queens are replaced with 'Q' 
     *all others are displayed as underscores '_'
     *There are spaces between each symbol:  
     *Q _ _ _
     *_ _ Q _
     * etc.
     */
    public String toString(){
	String s = "";
	for(int x = 0;x < board.length;x++){
	    for(int y = 0;y < board.length;y++){
	        if(board[x][y] == -1){
		    s+="Q ";
		}
		//if(board[x][y] == 0){
		else{
		    s+="_ ";
		}
		    //}
		//if(board[x][y] > 0){
		//    s+=board[x][y]+" ";
		//}
	    }
	    s+="\n";
	}
	return s;
    }

    /**
     *@return false when the board is not solveable and leaves the board filled with zeros; 
     *        true when the board is solveable, and leaves the board in a solved state
     *@throws IllegalStateException when the board starts with any non-zero value
     */
    public boolean solve(){
	if(!checkZeros()){
	    throw new IllegalStateException();
	}
	return solveHelper(0);
    }
    private boolean solveHelper(int r){
	if(r == board.length){
	    return true;
	}
	for(int c = 0;c < board.length;c++){
	    if(addQueen(r,c)){
		if(solveHelper(r+1)){
		    return true;
		}
		removeQueen(r,c);
	    }
	}
	return false;
    }

    /**
     *@return the number of solutions found, and leaves the board filled with only 0's
     *@throws IllegalStateException when the board starts with any non-zero value
     */
    public int countSolutions(){
	if(!checkZeros()){
	    throw new IllegalStateException();
	}
        solutions = 0;
	countSolutionsHelper(0);
	return solutions;
    }
    public boolean countSolutionsHelper(int r){
        if(r == board.length){
	    //System.out.println(this.toString());
	    solutions++;
	    return false;
	}
	for(int c = 0;c < board.length;c++){
	    if(addQueen(r,c)){
	        if(countSolutionsHelper(r+1)){
		    return true;
		}
		removeQueen(r,c);
	    }
	}
	return false;
    }

    private boolean checkZeros(){
	for(int x = 0;x < board.length;x++){
	    for(int y = 0;y < board.length;y++){
		if(board[x][y] == 0){
		    return false;
		}
	    }
	}
	return true;
    }
}
