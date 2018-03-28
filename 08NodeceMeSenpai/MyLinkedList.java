import java.util.*;
public class MyLinkedList{
    public static void main(String args[]){
	MyLinkedList list = new MyLinkedList();
	System.out.println(list.toString());
	list.add(235);
        System.out.println(list.toString());
	list.add(123);
        System.out.println(list.toString());
	list.set(1,123123);
	System.out.println(list.toString());
	//list.set(10,123123);
	System.out.println(list.toString());
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
    
    public int get(int n){
	if(n < 1 || n > size){
	    throw new IndexOutOfBoundsException();
	}
	Node current = first;
	while(n > 1){
	    current = current.getNext();
	    n--;
	}
	return current.getValue();
    }
    
    public void set(int index,int value){
	if(index < 1 || index > size){
	    throw new IndexOutOfBoundsException();
	}
	Node current = first;
	while(index > 1){
	    current = current.getNext();
	    index--;
	}
	current.setValue(value);
    }
    public int size(){
	return size;
    }

    // adds node to the end of the linked list
    public boolean add(int value){
	if(size == 0){
	    Node current = new Node(value);
	    first = current;
	    last = current;
	    size++;
	    return true;
	}
	Node current = new Node(value);
	current.setPrev(last);
	last.setNext(current);
	last = current;
	size++;
	return true;
    }

    
    private class Node{
	Node next,prev;
	int data;
	
	public Node(int data){
	    this.data = data;
	    next = null;
	    prev = null;
	}
	
	public Node(int data,Node next,Node prev){
	    this.data = data;
	    next = next;
	    prev = prev;
	}
	
	private Node getNext(){return next;}
	private Node getPrev(){return prev;}
	private int getValue(){return data;}
	private void setValue(int value){data = value;}
	private void setPrev(Node prev){this.prev = prev;}
	private void setNext(Node next){this.next = next;}
	public String toString(){return "" + getValue();}
    }
}
