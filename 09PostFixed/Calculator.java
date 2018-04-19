import java.util.*;
public class Calculator{
    public static void main(String[] args){
	System.out.println(eval("10 2 +"));
	System.out.println(eval("99 9 + 1 3 + /"));
    }
    public static double eval(String expression){
	String[] temp = expression.split(" ");
	Stack<Double> list = new Stack();
	for(int i = 0;i < temp.length;i++){
	    String s = temp[i];
	    if(s.equals("+")){
		list.push(list.pop() + list.pop());
	    }
	    else if(s.equals("-")){
		list.push(0 - (list.pop() - list.pop()));
	    }
	    else if(s.equals("*")){
		list.push(list.pop() * list.pop());
	    }
	    else if(s.equals("/")){
		list.push(1 / (list.pop() / list.pop()));
	    }
	    else if(s.equals("%")){
		double num = list.pop();
		list.push(list.pop() % num);
	    }
	    else{
		list.push(Double.parseDouble(s));
	    }
	}
	return list.pop();
    }
}
