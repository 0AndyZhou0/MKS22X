import java.util.*;
import java.io.*;
public class Driver{
    public static void main(String[]args){
	Maze f;
	try{
	    f = new Maze("data2.dat");//true animates the maze.        
	    f.setAnimate(false);
	    System.out.println(f.solve());

	    System.out.println(f);
	}catch(FileNotFoundException e){
	    System.out.println(".dat was not found");
	    System.exit(1);
	}
    }
}
