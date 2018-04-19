import java.util.*;
public class MyDeque<E>{
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

    public int size(){
	return size;
    }

    public void addFirst(E element){
	if(element == null){
	    throw new NullPointerException();
	}
	if(size == ary.length){
	    //resize();
	}
	if(start == 0){
	    start = size - 1;
	}else{
	    start--;
	}
	ary[start] = element;
    }
    
    public void addLast(E element){
	if(element == null){
	    throw new NullPointerException();
	}
	if(size == ary.length){
	    //resize();
	}
        if(end == ary.length - 1){
	    end = 0;
	}else{
	    end++;
	}
	ary[start] = element;
    }

    public E removeFirst(){
	if(size == 0){
	    throw new NoSuchElementException();
	}
	temp = ary[start];
	ary[start++] = null;
	if(start == ary.length){
	    start = 0;
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

    
}
