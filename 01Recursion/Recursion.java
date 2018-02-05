public class Recursion{
    public static void main(String[] args){
    }
    public static int fact(int n){
	if (n < 1){
	    return 1;
	}
	return n * fact(n-1);
    }
}
