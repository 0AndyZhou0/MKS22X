public class MyHeap<T extends Comparable<T>>{
    private T[] ary;
    private int size = 0;
    private boolean MaxMin = true;

    public static void main(String[] args){
	
    }
    
    @SuppressWarnings("unchecked")
    public MyHeap(){
	ary = (T[])new Object[15];
    }

    @SuppressWarnings("unchecked")
    public MyHeap(boolean listStyle){
	ary = (T[])new Object[15];
	MaxMin = listStyle;
    }

    public void add(T element){
	if(size == ary.length - 1){
	    resize();
	}
	ary[++size] = element;
	//add code to position element correctly.
    }

    //remove the top element
    public T remove(){
	ary[0] = ary[size--];
	ary[size] = null;
	//add code to poisition elements correctly.
	return ary[0];
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
	T[] bigger = (T[])new Object[ary.length * 2];
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
}
