import java.util.*;
import java.io.*;
public class Maze{

    private char[][] maze;
    private boolean animate;//false by default
    private int[] moves = {0,1,0,-1,-1,0,1,0};

    public static void main(String[] args){
	System.out.println(0);
    }

    /*Constructor loads a maze text file, and sets animate to false by default.

      1. The file contains a rectangular ascii maze, made with the following 4 characters:
      '#' - Walls - locations that cannot be moved onto
      ' ' - Empty Space - locations that can be moved onto
      'E' - the location of the goal (exactly 1 per file)
      'S' - the location of the start(exactly 1 per file)

      2. The maze has a border of '#' around the edges. So you don't have to check for out of bounds!

      3. When the file is not found OR the file is invalid (not exactly 1 E and 1 S) then: print a meaningful error and exit the program.
    */
    public Maze(String filename) throws FileNotFoundException{
	try{
	    aMAZEingScouter(filename);
	}catch(FileNotFoundException e){
	    System.out.println(filename+".dat could not be found");
	    System.exit(1);
	}
    }

    public  void aMAZEingScouter(String filename) throws FileNotFoundException{
	ArrayList<char[]> mazeTemp = new ArrayList<>();
	File text = new File(filename);
	Scanner inf = new Scanner(text);
	while(inf.hasNextLine()){
	    String temp = inf.nextLine();
	    char[] line = new char[temp.length()];
	    for(int i = 0;i < line.length;i++){
		line[i] = temp.charAt(i);
	    }
	    mazeTemp.add(line);
	}
	maze = new char[mazeTemp.size()][mazeTemp.get(0).length];
        for(int r = 0;r < maze.length;r++){
	    for(int c = 0;c < maze[0].length;c++){
	        maze[r][c] = mazeTemp.get(r)[c];
	    }
	}
    }
    
    private void wait(int millis){
         try {
             Thread.sleep(millis);
         }
         catch (InterruptedException e) {
         }
     }

    public void setAnimate(boolean b){
        animate = b;
    }

    public String toString(){
	String board = "";
	for(int r = 0;r < maze.length;r++){
	    for(int c = 0;c < maze[0].length;c++){
		board += maze[r][c];
	    }
	    board += "\n";
	}
	return board;
    }

    public void clearTerminal(){
        //erase terminal, go to top left of screen.
        System.out.println("\033[2J\033[1;1H");
    }


    /*Wrapper Solve Function returns the helper function
      Note the helper function has the same name, but different parameters.
      Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.
    */
    public int solve(){
	int row = -1;
	int col = -1;
	for(int r = 0;r < maze.length;r++){
	    for(int c = 0;c < maze[0].length;c++){
		if(maze[r][c] == 'S'){
		    row = r;
		    col = c;
		}
	    }
	}
	maze[row][col] = ' ';
        return solve(row,col);
    }

    /*
      Recursive Solve function:

      A solved maze has a path marked with '@' from S to E.

      Returns the number of @ symbols from S to E when the maze is solved,
      Returns -1 when the maze has no solution.

      Postcondition:
        The S is replaced with '@' but the 'E' is not.
        All visited spots that were not part of the solution are changed to '.'
            Note: This is not required based on the algorithm, it is just nice visually to see.
        All visited spots that are part of the solution are changed to '@'
    */
    private int solve(int row, int col){ //you can add more parameters since this is private

        //automatic animation! You are welcome.
        if(animate){
            clearTerminal();
            System.out.println(this);
            wait(20);
        }

	if(maze[row][col] == 'E'){
	    return -1;
	}
	int[] order = orderMoves(row,col);
        for(int i = 0;i < 4;i++){
	    int r = row + moves[order[i]];
	    int c = col + moves[order[i]+4];
	    if(maze[r][c] != '@' && maze[r][c] != '#'){
		if(maze[row][col] == '.'){
		    maze[row][col] = '@';
		}
		if(maze[row][col] == ' '){
		    maze[row][col] = '.';
		}
	        if(solve(r,c) == -1){
		    return -1;
		}
		if(maze[row][col] == '.'){
		    maze[row][col] = ' ';
		}
		if(maze[row][col] == '@'){
		    maze[row][col] = '.';
		}
	    }
	}
        return 0; //so it compiles
    }

    private int[] orderMoves(int row,int col){
	int[] order = new int[4];
	int[] rater = new int[4];
	for(int i = 0;i < 4;i++){
	    int r = row + moves[i];
	    int c = col + moves[i+4];
	    if(maze[row][col] == ' '){
		rater[i] = 0;
	    }
	    if(maze[row][col] == '.'){
	        rater[i] = 1;
	    }
	    if(maze[row][col] == '@'){
		rater[i] = 2;
	    }
	    if(maze[row][col] == '#'){
	        rater[i] = 3;
	    }
	}
	for(int i = 0;i < 4;i++){
	    int min = 0;
	    for(int x = 0;x < 4;x++){
		if(rater[x] < rater[min]){
		    min = x;
		}
	    }
	    rater[min] = 4;
	    order[i] = min;
	    System.out.println(order[i]);
	}
	return order;
    }

}
