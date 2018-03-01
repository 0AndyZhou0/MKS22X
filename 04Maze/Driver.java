import java.util.*;
import java.io.*;
public class Driver{

<<<<<<< HEAD
    public static void main(String[]args){
	Maze f;
	try{
	    f = new Maze("data1.dat");//true animates the maze.        
	    f.setAnimate(true);
	    f.solve();

	    System.out.println(f);
	}catch(FileNotFoundException e){
	    System.out.println("data1.dat was not found");
	    System.exit(1);
	}
=======
    public static void main(String[]args) throws FileNotFoundException{
        Maze f;
	f = new Maze("data1.dat");

	//true animates the maze.
	f.setAnimate(true);
	f.solve();
	
	System.out.println(f);
>>>>>>> 27f08a0b5cd44645c734e93eb9e7e0b3c41451d4
    }
}
