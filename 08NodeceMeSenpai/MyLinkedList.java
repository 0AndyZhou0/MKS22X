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
	list.add(12894712);
	System.out.println(list.toString());
	System.out.println(list.get(2));
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

    private Node getNode(int n){
	if(n < 0 || n > size){
	    throw new IndexOutOfBoundsException();
	}
	Node current = first;
	while(n >= 1){
	    current = current.getNext();
	    n--;
	}
	return current;
    }
    
    public Integer get(int n){
	if(n < 0 || n >= size){
	    throw new IndexOutOfBoundsException();
	}
	Node current = first;
	while(n >= 1){
	    current = current.getNext();
	    n--;
	}
	return current.getValue();
    }
    
    public void set(int index,Integer value){
	if(index < 0 || index >= size){
	    throw new IndexOutOfBoundsException();
	}
	Node current = first;
	while(index >= 1){
	    current = current.getNext();
	    index--;
	}
	current.setValue(value);
    }
    public int size(){
	return size;
    }

    // adds node to the end of the linked list
    public boolean add(Integer value){
	Node addition = new Node(value);
	addition.setPrev(last);
	last.setNext(addition);
	last = addition;
	size++;
	return true;
    }

    public void add(int index, Integer value){	
	if(index < 0 || index >= size){
	    throw new IndexOutOfBoundsException();
	}
	Node addition = new Node(value);
	if(index == size){
	    add(value);
	}else{
	    Node current = first;
	    while(index > 1){
		current = current.getNext();
		index--;
	    }
	    Node next = current.getNext().getNext();
	    current.setNext(addition);
	    addition.setPrev(current);
	    addition.setNext(next);
	    next.setPrev(addition);
	}
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
}
