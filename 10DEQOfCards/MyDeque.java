import java.util.*;
@SuppressWarnings("unchecked")
public class MyDeque<E>{
    public static void main(String[] args){
	MyDeque<String> a = new MyDeque<>(), a1 = new MyDeque<>();
	System.out.println(a);
	a.addFirst("hi");
	System.out.println(a);
	a.addFirst("hi");
	System.out.println(a);
	a.addFirst("hi");
	System.out.println(a);
        // MyDeque<String> a = new MyDeque<>(), a1 = new MyDeque<>();
	// ArrayList<String> b = new ArrayList<>();

	// int size = Integer.parseInt(args[0]);
	// for(int i = 0; i < size; i++){
	//     int temp = (int)(Math.random() * 1000);
	//     if(temp % 2 == 0){
	// 	a.addFirst("" + temp);
	// 	a1.addFirst("" + temp);
	// 	b.add(0, "" + temp);
	//     }
	//     else{
	// 	a.addLast("" + temp);
	// 	a1.addLast("" + temp);
	// 	b.add("" + temp);
	//     }
	// }

	// int index = 0;
	// boolean hasError = false;
	// String errorEvaluation = "Errors found at these indices: ";
	// for (String x : b){
	//     if (!(x.equals(a.getFirst()))){
	// 	System.out.println("The getFirst() function is incorrect at index " + index);
	// 	hasError = true;
	//     }
	//     if (!(x.equals(a.removeFirst()))){
	// 	System.out.println("There is an error at index " + index);
	// 	errorEvaluation += index + ", ";
	// 	hasError = true;
	//     }
	//     index++;
	// }


	// if(hasError){
	//     errorEvaluation = errorEvaluation.substring(0, errorEvaluation.length() - 2);
	//     System.out.println(errorEvaluation);
	//     System.out.println("MyDeque: " + a1);
	//     System.out.println("Actual Deque: " + b);
	// }
	// else{
	//     System.out.println("Your deque is bug-free!");
	// }
    }
    
    private E[] ary;
    private int first,last;
    private int size;

    @SuppressWarnings("unchecked")
    public MyDeque(){
	ary = (E[])new Object[10];
	size = 0;
    }

    @SuppressWarnings("unchecked")
    public MyDeque(int initialCapacity){
	if(initialCapacity <= 0){
	    throw new IllegalArgumentException();
	}
	ary = (E[])new Object[initialCapacity];
	size = 0;
    }

    public String toString(){
	if(size == 0){
	    return "[]";
	}
	String line = "[";
	for(int i = first;i != last;){
	    line += ary[i++] + ",";
	    if(i == ary.length){
		i = 0;
	    }
	}
	line += ary[last];
	return line + "]";
    }

    public int size(){
	return size;
    }

    public void addFirst(E element){
	if(element == null){
	    throw new NullPointerException();
	}
	if(size == 0){
	    ary[0] = element;
	    first = 0;
	    last = 0;
	}else{
	    if(size == ary.length){
		resize();
	    }
	    first--;
	    if(first == -1){
		first = ary.length - 1;
	    }
	    ary[first] = element;
	}
	size++;
    }
    
    public void addLast(E element){
	if(element == null){
	    throw new NullPointerException();
	}
	if(size == 0){
	    ary[0] = element;
	    first = 0;
	    last = 0;
	}else{
	    if(size == ary.length){
		resize();
	    }
	    if(++last == ary.length){
		last = 0;
	    }
	    ary[last] = element;
	}
	size++;
    }

    public E removeFirst(){
	if(size-- == 0){
	    throw new NoSuchElementException();
	}
	E temp = ary[first];
	ary[first++] = null;
	if(first == ary.length){
	    first = 0;
	}
	return temp;
    }

    public E removeLast(){
	if(size-- == 0){
	    throw new NoSuchElementException();
	}
	E temp = ary[last];
	ary[last--] = null;
        if(last == -1){
	    last = ary.length - 1;
	}
	return temp;
    }

    public E getFirst(){
	if(size == 0){
	    throw new NoSuchElementException();
	}
	return ary[first];
    }
    
    public E getLast(){
	if(size == 0){
	    throw new NoSuchElementException();
	}
	return ary[last];
    }

    @SuppressWarnings("unchecked")
    private void resize(){
	E[] bigger = (E[]) new Object[size*2];
	int index = 0;
	for(int i = first;i != last;i++){
	    if(i == ary.length){
		i = 0;
	    }
	    bigger[index++] = ary[i];
	}
	bigger[index] = ary[last];
	ary = bigger;
	first = 0;
	last = index;
    }
}
