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
}
