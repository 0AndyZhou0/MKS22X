public class MyHeap<T extends Comparable<T>>{
    private T[] ary;
    private int size = 0;
    private boolean MaxMin = true;

    public static void main(String[] args){
	MyHeap<Integer> a = new MyHeap<>();
	a.add(1);
	a.add(9);
	a.add(1231);
	a.add(7);
	a.add(12);
	a.add(13);
	System.out.println(a);
    }
    
    @SuppressWarnings("unchecked")
    public MyHeap(){
	ary = (T[])new Comparable[15];
    }

    @SuppressWarnings("unchecked")
    public MyHeap(boolean listStyle){
	ary = (T[])new Comparable[15];
	MaxMin = listStyle;
    }

    public String toString(){
	String line = "[";
	for(int i = 0;i < size;i++){
	    line += ary[i] + ",";
	}
	return line + "]";
    }
    
    public void add(T element){
	if(size == ary.length - 1){
	    resize();
	}
	ary[size++] = element;
	//add code to position element correctly.
	int thing = (size-2)/2;
	while(element.compareTo(ary[thing]) > 0){
	    swapUp(size-1);
	    thing = (thing-1)/2;
	}
    }

    public void addSingle(int index){
	while(index < size){

	}
    }

    //remove the top element
    public T remove(){
	T top = ary[0];
	ary[0] = ary[size--];
	ary[size] = null;
	//add code to poisition elements correctly.
	return top;
    }

    public T peek(){
	if(ary.length > 0){return ary[0];}
	return null;
    }

    public int size(){
	return size;
    }

    @SuppressWarnings("unchecked")
    public void resize(){
	T[] bigger = (T[])new Comparable[ary.length * 2];
	for(int i = 0;i < ary.length;i++){
	    bigger[i] = ary[i];
	}
	ary = bigger;
    }
    
    public void swapUp(int n){
	T temp = ary[n];
	ary[n] = ary[(n-1)/2];
	ary[(n-1)/2] = temp;
    }

    public void swapDown(int n,int inc){
	T temp = ary[n];
	ary[n] = ary[2*n+inc];
	ary[2*n+inc] = temp;
    }
}
