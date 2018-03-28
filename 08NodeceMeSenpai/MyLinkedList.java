import java.util.*;
public class MyLinkedList{
    Node first,last;
    int length;
    public String toString(){
	return "";
    }
    public int get(int n){
	Node current = first;
	while(n > 1 && current.getNext() != null){
	    current = current.getNext();
	    n--;
	}
	if(1 == n){
	    return current.getValue();
	}else{
	    System.exit(1);
	}
    }
    public void set(int index,int value){
	Node current = first;
	while(index > 2 && current.getNext() != null){
	    current = current.getNext();
	    index--;
	}
	if(2 == index){
	    //current = new Node(current.getValue(),
	}
    }
}
private class Node{
    Node next,prev;
    int data;
    public Node(data){
	this.data = data;
	next = null;
	prev = null;
    }
    public Node(data,next,prev){
	this.data = data;
	next = next;
	prev = prev;
    }
    private Node getNext(){
	return next;
    }
    private Node getPrev(){
	return prev;
    }
    private int getValue(){
	return data;
    }
    private String toString(){
	return "";
    }
}
