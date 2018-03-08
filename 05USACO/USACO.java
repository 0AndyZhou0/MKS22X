import java.util.*;
import java.io.*;
public class USACO{
    public static int bronze(String filename) throws FileNotFoundException{
	try{
	    File f = new File(filename);
	    Scanner s = new Scanner(f);
	    
	}catch(FileNotFoundException e){
	    System.exit(1);
	}
    }
    public static int silver(String filename) throws FileNotFoundException{
	char[][] grid;
	int start1, end1, start2, end2, time;
	int[][] numWays;//current number of ways to get to each space.
	int[][] temp;
	try{
	    File f = new File(filename);
	    Scanner s = new Scanner(f);
	    int i = 0;
	    String temp = s.nextLine();
	    String[] nums = temp.split(" ");
	    grid = new char[Integer.parseInt(nums[0])][Integer.parseInt(nums[0])];
	    time = Integer.parseInt(nums[3]);
	    while(s.hasNextLine()){
		String temp = s.nextLine();
		char[] line = new char[temp.length()];
		for(int x = 0;x < line.length;x++){
		    
		}
		i++;
	    }
	}catch(FileNotFoundException e){
	    System.exit(1);
	}
}
