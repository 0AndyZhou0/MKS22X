import java.util.*;
//Caution: Keep out of reach of children.
public class MyLinkedListImproved<T extends Comparable<T>> implements Iterable<T>{
    public static void main(String args[]){
        MyLinkedListImproved<String> s = new MyLinkedListImproved<>();
	s.add("asdasda");
	System.out.println(s);

	MyLinkedListImproved<String> t = new MyLinkedListImproved<>();
	for (int i = 0; i < 100; i++){
	    t.add(i + " ");
	}
	for (String x: t){
	    System.out.print(x);
	}
	System.out.println(t);
    }

    Node first,last;
    int size;

    public MyLinkedListImproved(){
	first = null;
	last = null;
	size = 0;
    }
    
    public String toString(){
	if(size == 0){
	    return "[]";
	}
	String list =  "[";
	Node current = first;
	while(current.getNext() != null){
	    list += current.toString() + ",";
	    current = current.getNext();
	}
	return list + current.toString() + "]";
    }

    //clears the list of all nodes
    public void clear(){
	first = null;
	last = null;
	size = 0;
    }

    // returns a specified node
    private Node getNode(int n){
	// basic index out of bounds exception
	if(n < 0 || n >= size){
	    throw new IndexOutOfBoundsException();
	}
	if(n == size-1){
	    return last;
	}
	Node current = first;
	while(n > 0){
	    current = current.getNext();
	    n--;
	}
	return current;
    }
    
    // returns the value of a specified node
    public T get(int n){
        return getNode(n).getValue();
    }

    // changes the value of a specified node
    public void set(int index,T value){
        getNode(index).setValue(value);
    }

    // returns the number of nodes
    public int size(){
	return size;
    }

    // adds node to the end of the linked list
    public boolean add(T value){
        add(size,value);
	return true;
    }

    // adds a node to the specified index
    public void add(int index, T value){
	Node addition = new Node(value);
	if(size == 0){
	    first = addition;
	    last = addition;
	}
	else{
	    if(index == 0){
		addition.setNext(first);
		first.setPrev(addition);
		first = addition;
	    }else{
		if(index == size){
		    addition.setPrev(last);
		    last.setNext(addition);
		    last = addition;
		}else{
		    Node current = getNode(index);
		    current.getPrev().setNext(addition);
		    addition.setPrev(current.getPrev());
		    addition.setNext(current);
		    current.setPrev(addition);
		}
	    }
	}
	size++;
    }

    // finds the index of the first instance of a value
    // otherwise, it returns -1;
    public int indexOf(T value){
	Node current = first;
	int i = 0;
	while(current != null){
	    if(current.getValue().equals(value)){
		return i;
	    }
	    current = current.getNext();
	    i++;
	}
	return -1;
    }

    public boolean remove(T value){
        Node current = first;
	int i = 0;
	while(current != null){
	    if(current.getValue().equals(value)){
	        remove(i);
		return true;
	    }
	    current = current.getNext();
	    i++;
	}
	return false;
    }

    public T remove(int index){
        if(index < 0 || index >= size){
	    throw new IndexOutOfBoundsException();
	}
	if(index == 0){
	    T thing = first.getValue();
	    first = first.getNext();
	    size--;
	    return thing;
	}
	if(index == size-1){
	    T thing = last.getValue();
	    last = last.getPrev();
	    size--;
	    return thing;
	}
	Node current = getNode(index);
        current.getPrev().setNext(current.getNext());
	current.getNext().setPrev(current.getPrev());
	size--;
	return current.getValue();
    }
    
    private class Node{
	Node next,prev;
	T data;
	
	public Node(T data){
	    this.data = data;
	    next = null;
	    prev = null;
	}
	
	public Node(T data,Node next,Node prev){
	    this.data = data;
	    next = next;
	    prev = prev;
	}
	
	private Node getNext(){return next;}
	private Node getPrev(){return prev;}
	private T getValue(){return data;}
	private void setValue(T value){data = value;}
	private void setPrev(Node prev){this.prev = prev;}
	private void setNext(Node next){this.next = next;}
	public String toString(){return "" + getValue();}
    }

    private class Irritator implements Iterator<T>{
	Node current;
	public Irritator(Node first){
	    current = first;
	}
	public boolean hasNext(){
	    return current.equals(null);
	}
	public T next(){
	    return current.getValue();
	}
	public void remove(){

	    
	}
    }

    public Iterator<T> iterator(){
	return new Irritator(first);
    }

    public int max(){
	if(size == 0){
	    return -1;
	}
	Node current = first;
	int max = 0;
	T maxValue = current.getValue();
	int i = 0;
	while(current != null){
	    if(current.getValue().compareTo(maxValue) > 0){
		max = i;
		maxValue = current.getValue();
	    }
	    i++;
	}
	return max;
    }

    public int min(){
	if(size == 0){
	    return -1;
	}
	Node current = first;
	int min = 0;
        T minValue = current.getValue();
	int i = 0;
	while(current != null){
	    if(current.getValue().compareTo(minValue) < 0){
		min = i;
		minValue = current.getValue();
	    }
	    i++;
	}
	return min;
    }
}
