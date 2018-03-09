import java.util.*;
import java.io.*;
public class USACO{
    
    public static void main(String[] args){
	System.out.println(USACO.bronze("makelake/makelake.1.in"));
	System.out.println(USACO.silver("ctravel/ctravel.1.in"));
    }
    
	    
    public static int bronze(String filename){
	int row, col, elevation;
	int numInstructions;
	
	try{
	    File f = new File(filename);
	    Scanner s = new Scanner(f);
	    
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
	    int i = 0;
	    while(s.hasNextLine()){
		temp = s.nextLine();
		if(s.hasNextLine()){
		    for(int x = 0;x < temp.length();x++){
			grid[i][x] = temp.charAt(x);
		    }
		}else{
		    String[] line = temp.split(" ");
		    start1 = Integer.parseInt(line[0]);
		    end1 = Integer.parseInt(line[1]);
		    start2 = Integer.parseInt(line[2]);
		    end2 = Integer.parseInt(line[3]);
		}
		i++;
	    }
	}catch(FileNotFoundException e){
	    System.exit(1);
	}
	return 0;
    }
}
