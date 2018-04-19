import java.util.*;
public class MyDeque<E>{
    public static void main(String[] args){
	MyDeque<String> a = new MyDeque();
	
	a.addFirst("hi");
	
    }
    
    private T[] ary;
    private int start,end;
    private int size;

    @SuppressWarnings("unchecked")
    public MyDeque(){
	ary = new E[10];
	size = 0;
    }

    @SuppressWarnings("unchecked")
    public MyDeque(int initialCapacity){
	if(initialCapacity <= 0){
	    throw new IllegalArgumentException();
	}
	ary = new E[initialCapacity];
	size = 0;
    }

    public String toString(){
	String line = "[";
	for(int i = first;i < last;i++){
	    if(i == ary.length){
		i = 0;
	    }
	    line += ary[i] + ","
	}
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
	    end = 0;
	}
	if(size == ary.length){
	    //resize();
	}
	if(first == 0){
	    first = size - 1;
	}else{
	    first--;
	}
	ary[first] = element;
    }
    
    public void addLast(E element){
	if(element == null){
	    throw new NullPointerException();
	}
	if(size == 0){
	    ary[0] = element;
	    first = 0;
	    end = 0;
	}
	if(size == ary.length){
	    //resize();
	}
        if(end == ary.length - 1){
	    end = 0;
	}else{
	    end++;
	}
	ary[first] = element;
    }

    public E removeFirst(){
	if(size == 0){
	    throw new NoSuchElementException();
	}
	temp = ary[first];
	ary[first++] = null;
	if(first == ary.length){
	    first = 0;
	}
	return temp;
    }

    public E removeLast(){
	if(size == 0){
	    throw new NoSuchElementException();
	}
	temp = ary[end];
	ary[end--] == null;
        if(end == -1){
	    end = ary.length - 1;
	}
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
	return ary[end];
    }
}
