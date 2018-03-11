import java.util.*;
import java.io.*;
public class USACO{
    
    public static void main(String[] args){
	System.out.println(USACO.bronze("makelake/makelake.1.in"));
	System.out.println(USACO.silver("ctravel/ctravel.1.in"));
    }
    
	    
    public static int bronze(String filename){
	int elevation, numInstructions;
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
	}catch(FileNotFoundException e){
	    System.exit(1);
	}
	return 0;
    }
    public static int silver(String filename){
	char[][] grid;
	int start1, end1, start2, end2, time;
	int[][] numWays;//current number of ways to get to each space.
	int[][] tempGrid;
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
	    start1 = Integer.parseInt(line[0]);
	    end1 = Integer.parseInt(line[1]);
	    start2 = Integer.parseInt(line[2]);
	    end2 = Integer.parseInt(line[3]);
	}catch(FileNotFoundException e){
	    System.exit(1);
	}
	return 0;
    }
}
