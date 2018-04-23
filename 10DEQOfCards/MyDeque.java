import java.util.*;
@SuppressWarnings("unchecked")
public class MyDeque<E>{
    public static void main(String[] args){
	MyDeque<String> a = new MyDeque();
	
	a.addFirst("hi");
	System.out.println(a);
	a.addLast("bye");
	System.out.println(a);
	a.addLast("tree");
	System.out.println(a);
	a.addFirst("friend");
	System.out.println(a);
	// a.addFirst("hi");
	// System.out.println(a);
	// a.addLast("bye");
	// System.out.println(a);
	// a.addLast("tree");
	// System.out.println(a);
	// a.addFirst("friend");
	// System.out.println(a);
	// a.addFirst("hi");
	// System.out.println(a);
	// a.addLast("bye");
	// System.out.println(a);
	// a.addLast("tree");
	// System.out.println(a);
	// a.addFirst("friend");
	// System.out.println(a);
	// a.addFirst("hi");
	// System.out.println(a);
	// a.addLast("bye");
	// System.out.println(a);
	// a.addLast("tree");
	// System.out.println(a);
	// a.addFirst("friend");
	// System.out.println(a);
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
	String line = "[";
	for(int i = first;i <= last;i++){
	    if(i == ary.length){
		i = 0;
	    }
	    line += ary[i] + ",";
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
	    last = 0;
	}else{
	    if(size == ary.length){
		resize();
	    }
	    if(first-- == 0){
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
	for(int i = first;i <= last;i++){
	    if(i == ary.length){
		i = 0;
	    }
	    bigger[index++] = ary[i];
	}
	ary = bigger;
	first = 0;
	last = size - 1;
    }
}
