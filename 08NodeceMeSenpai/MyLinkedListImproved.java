import java.util.*;
//Caution: Keep out of reach of children.
public class MyLinkedListimproved<T> implements Iterable<T>{
    public static void main(String args[]){
        
    }

    Node first,last;
    int size;

    public MyLinkedList(){
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
    public Integer get(int n){
        return getNode(n).getValue();
    }

    // changes the value of a specified node
    public void set(int index,Integer value){
        getNode(index).setValue(value);
    }

    // returns the number of nodes
    public int size(){
	return size;
    }

    // adds node to the end of the linked list
    public boolean add(Integer value){
        add(size,value);
	return true;
    }

    // adds a node to the specified index
    public void add(int index, Integer value){
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
    public int indexOf(Integer value){
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

    public boolean remove(Integer value){
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

    public Integer remove(int index){
        if(index < 0 || index >= size){
	    throw new IndexOutOfBoundsException();
	}
	if(index == 0){
	    Integer thing = first.getValue();
	    first = first.getNext();
	    size--;
	    return thing;
	}
	if(index == size-1){
	    Integer thing = last.getValue();
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
	Integer data;
	
	public Node(Integer data){
	    this.data = data;
	    next = null;
	    prev = null;
	}
	
	public Node(Integer data,Node next,Node prev){
	    this.data = data;
	    next = next;
	    prev = prev;
	}
	
	private Node getNext(){return next;}
	private Node getPrev(){return prev;}
	private Integer getValue(){return data;}
	private void setValue(int value){data = value;}
	private void setPrev(Node prev){this.prev = prev;}
	private void setNext(Node next){this.next = next;}
	public String toString(){return "" + getValue();}
    }

    Private class Irritator implements Iterator<T>{
	Node current;
	public Irritator(Node first){
	    current = first;
	}
	public boolean hasNext(){
	    return current != null;
	}
	public T next(){
	    return current.getValue();
	}
	public void remove();
    }

    public iterator<T> iterator(){
	return new Irritator(first);
    }
}
