import java.util.*;
import java.io.*;
public class USACO{
    
    public static void main(String[] args){
        for (int i = 1; i < 11; i ++){
	    String file = "makelake/makelake." + i; // Remove the "makelake/" if the test files are in the same directory
	    int ans = getAnswer(file + ".out");
	    
	    int ansU = USACO.bronze(file + ".in");
	    
	    System.out.println("Your Answer: " + ansU);
	    System.out.println("Answer: " + ans);
	    System.out.println("Correct? " + (ans == ansU));
	}

	// for (int i = 1; i < 11; i ++){
	//     String file = "ctravel/ctravel." + i; // Remove the "ctravel/" if the test files are in the same directory
	//     int ans = getAnswer(file + ".out");
	    
	//     int ansU = USACO.silver(file + ".in");
	    
	//     System.out.println("Your Answer: " + ansU);
	//     System.out.println("Answer: " + ans);
	//     System.out.println("Correct? " + (ans == ansU));
	// }
	//System.out.println(USACO.silver("ctravel/ctravel.1.in"));
    }

    public static int getAnswer(String filename){
	try{
	    File f = new File(filename);
	    Scanner s = new Scanner(f);
	    
	    String inty = s.nextLine();
	    return Integer.parseInt(inty);
	    
	}catch (FileNotFoundException e){
	    System.out.println("FILE!");
	}
	return 0;
    }
	    
    public static int bronze(String filename){
	int elevation;
	int[][] instructions;
	int[][] grid;
	try{
	    File f = new File(filename);
	    Scanner s = new Scanner(f);
	    String temp = s.nextLine();
	    String[] nums = temp.split(" ");
	    grid = new int[Integer.parseInt(nums[0])][Integer.parseInt(nums[1])];
	    elevation = Integer.parseInt(nums[2]);
	    instructions = new int[Integer.parseInt(nums[3])][3];
	    for(int r = 0;r < grid.length;r++){
		temp = s.nextLine();
		String[] line = temp.split(" ");
		for(int c = 0;c < grid[0].length;c++){
		    grid[r][c] = Integer.parseInt(line[c]);
		}
	    }
	    for(int r = 0;r < instructions.length;r++){
		temp = s.nextLine();
		String[] line = temp.split(" ");
		for(int c = 0;c < line.length;c++){
		    instructions[r][c] = Integer.parseInt(line[c]);
		}
	    }
	    int[] moves = {-1,-1,-1,0,0,1,1,1,0,1,0,-1,1,-1,1,0,-1,0};
	    for(int i = 0;i < instructions.length;i++){
		int row = instructions[i][0];
		int col = instructions[i][1];
		int tallest = grid[row][col];
		for(int x = 0;x < 9;x++){
		    int nextR = row + moves[x];
		    int nextC = col + moves[x+9];
		    if(nextR >= 0 && nextR < grid.length && nextC >= 0 && nextC < grid[0].length){
			if(grid[nextR][nextC] > tallest){
			    tallest = grid[nextR][nextC];
			}
		    }
		}
		for(int x = 0;x < 9;x++){
		    int nextR = row + moves[x];
		    int nextC = col + moves[x+9];
		    if(nextR >= 0 && nextR < grid.length && nextC >= 0 && nextC < grid[0].length){
			if(grid[nextR][nextC] > tallest - instructions[i][2]){
			    grid[nextR][nextC] = tallest - instructions[i][2];
			}
		    }
		}
	    }
	    int sum = 0;
	    for(int r = 0;r < grid.length;r++){
		for(int c = 0;c < grid[0].length;c++){
		    if(elevation > grid[r][c]){
			sum += elevation - grid[r][c];
		    }
		}
	    }
	    System.out.println(sum);
	    return sum * 72 * 72;
	}catch(FileNotFoundException e){
	    System.exit(1);
	}
	return 0;
    }
    public static int silver(String filename){
	char[][] grid;
	int start1, start2, end1, end2, time;
	int[][] numWays;//current number of ways to get to each space.
	int[][] numGrid, tempGrid;
	try{
	    File f = new File(filename);
	    Scanner s = new Scanner(f);
	    String temp = s.nextLine();
	    String[] nums = temp.split(" ");
	    grid = new char[Integer.parseInt(nums[0])][Integer.parseInt(nums[1])];
	    time = Integer.parseInt(nums[2]);
	    for(int r = 0;r < grid.length;r++){
		temp = s.nextLine();
		for(int c = 0;c < temp.length();c++){
		    grid[r][c] = temp.charAt(c);
		} 
	    }
	    temp = s.nextLine();
	    String[] line = temp.split(" ");
	    start1 = Integer.parseInt(line[0]) - 1;
	    start2 = Integer.parseInt(line[1]) - 1;
	    end1 = Integer.parseInt(line[2]) - 1;
	    end2 = Integer.parseInt(line[3]) - 1;
	    numGrid = new int[grid.length][grid[0].length];
	    tempGrid = new int[grid.length][grid[0].length];
	    numGrid[start1][start2] = 1;
	    return silverH(grid, numGrid, tempGrid, end1, end2, time, 0);
	}catch(FileNotFoundException e){
	    System.exit(1);
	}
	return 0;
    }
    
    private static int silverH(char[][] grid, int[][] numGrid, int[][] temp, int end1, int end2, int endtime, int time){
	if(time == endtime){
	    return numGrid[end1][end2];
	}
	for(int r = 0;r < grid.length;r++){
	    for(int c = 0;c < grid[0].length;c++){
		temp[r][c] = 0;
	    }
	}
	int[] moves = {0,0,1,-1,1,-1,0,0};
	for(int r = 0;r < grid.length;r++){
	    for(int c = 0;c < grid[0].length;c++){
		if(numGrid[r][c] > 0){
		    for(int i = 0;i < 4;i++){
			int nextR = r + moves[i];
			int nextC = c + moves[i+4];
			if(nextR >= 0 && nextR < numGrid.length && nextC >= 0 && nextC < numGrid[0].length && grid[nextR][nextC] != '*'){
			    temp[nextR][nextC] += numGrid[r][c];
			}
		    }
		}
	    }
	}
	return silverH(grid,temp,numGrid,end1,end2,endtime,time+1);
    }
}
