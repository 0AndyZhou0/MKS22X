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
	//System.out.println(isPossibleSum(13,56000));
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
    public static boolean isPossibleSum(int n,int target){
	if(target == 0){
	    return true;
	}
	if(n < 0){
	    return false;
	}
	return isPossibleSum(n-1,target) || isPossibleSum(n-1,target-n);
    }
}
