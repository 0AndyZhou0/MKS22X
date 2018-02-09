public class Recursion{
    public static void main(String[] args){
	//System.out.println(fact(4));
	//System.out.println(fact(5));
	//System.out.println(fact(-5));
	//System.out.println(fib(4));
	//System.out.println(fib(5));
	//System.out.println(fib(6));
	//System.out.println(fib(7));
	//System.out.println(fib(-8));
	//System.out.println(sqrt(0));
	//System.out.println(sqrt(1));
	//System.out.println(sqrt(2));
	//System.out.println(sqrt(3));
	//System.out.println(sqrt(4));
	//System.out.println(sqrt(-4));
        boolean a = queenProblem();
    }
    public static int fact(int n){
	if(n < 0){
	    throw new IllegalArgumentException();
	}
	if(n == 0){
	    return 1;
	}
	return n * fact(n-1);
    }
    public static int fib(int n){
	if(n < 0){
	    throw new IllegalArgumentException();
	}
	if(n == 0){
	    return 0;
	}
	if(n == 1){
	    return 1;
	}
	return fib(n-1) + fib(n-2);
    }
    public static double sqrt(double n){
	if(n < 0){
	    throw new IllegalArgumentException();
	}
	if(n == 0){
	    return 0;
	}
	double guess = n / 2;
	return sqrtHelper(n,guess);
    }
    public static double sqrtHelper(double n,double guess){
	guess = (n / guess + guess) / 2;
	if(guess * guess - n > n * 0.00000000000000000000001){
	    return sqrtHelper(n,guess);
	}
	return guess;
    }

    public static boolean queenProblem(){
	int[][] pieces = new int[9][9];
	return queenProblemHelper(pieces,0,0);
    }
    public static boolean queenProblemHelper(int[][] pieces,int x,int y){
	if(x == 8 && y == 8){
	    for(int row = 0;row < 9;row++){
		String line = "";
		for(int col = 0;col < 9;col++){
		    line += pieces[row][col] + " ";
		}
		System.out.println(line);
	    }
	    return false;
	}
        if(pieces[x][y] != 0){
	    if(y == 8){
		y = -1;
		x++;
	    }
	    return queenProblemHelper(pieces,x,y++);
	}else{
	    for(int i = 0;i < 9;i++){
		pieces[x][i]++;
		pieces[i][y]++;
		pieces[x][y] = 1;
	    }
	    if(y == 8){
		y = -1;
		x++;
	    }
	    return queenProblemHelper(pieces,x,y++);
	}
    }
}
