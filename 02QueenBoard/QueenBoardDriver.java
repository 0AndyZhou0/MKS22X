public class QueenBoardDriver{
    public static void main(String[] args){
	QueenBoard a = new QueenBoard(Integer.parseInt(args[0]));
	if(args[1].equals("solve")){
	    a.solve();
	    System.out.println(a);
	}
	if(args[1].equals("count")){
	    a.countSolutions();
	    System.out.println(a);
	}
    }
}
