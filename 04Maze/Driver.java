import java.util.*;
import java.io.*;
public class Driver{
    public static void main(String[]args){
	Maze f;
	try{
	    f = new Maze("data3.dat");//true animates the maze.        
	    f.setAnimate(true);
	    f.solve();

	    System.out.println(f);
	}catch(FileNotFoundException e){
	    System.out.println("data1.dat was not found");
	    System.exit(1);
	}
    }
}
