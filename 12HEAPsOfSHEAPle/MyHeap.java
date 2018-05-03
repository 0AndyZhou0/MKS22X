public class MyHeap<T extends Comparable<T>>{
    private T[] ary;
    private int size = 0;
    private boolean MaxMin = true;

    public static void main(String[] args){
        MyHeap<Integer> heap = new MyHeap<>();
	for(int i = 0; i < 15; i++){
	    heap.add(i);
	}
	System.out.println(heap);
	heap.remove();
	System.out.println(heap);

	heap.remove();
	System.out.println(heap);

	heap.remove();

	System.out.println(heap);
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
	MoveElementUp(size-1);
    }

    //remove the top element
    public T remove(){
	if(size == 0){
	    throw new NullPointerException();
	}
	T top = ary[0];
	ary[0] = ary[--size];
	ary[size] = null;
        for(int i = size-1;i > 0;i--){
	    MoveElementDown(i);
	}
	return top;
    }

    private void MoveElementUp(int index){
	T element = ary[index];
	if(MaxMin){
	    while(element.compareTo(ary[(index-1)/2]) > 0){
		swapUp(index--);
		index /= 2;
	    }
	}else{
	    while(element.compareTo(ary[(index-1)/2]) < 0){
		swapUp(index--);
		index /= 2;
	    }
	}
    }

    private void MoveElementDown(int index){
	T element = ary[index];
	int i = 1;
	if(MaxMin){
	    while(2 * index + 2 < size && ary[2*index+1].compareTo(ary[index]) > 0 && ary[2*index+1].compareTo(ary[index]) > 0){
		if(ary[2*index+1].compareTo(ary[2*index+2]) >= 0){
		    i = 1;
		}else{
		    i = 2;
		}
		swapDown(index,i);
		index = index * 2 + i;
	    }
	}
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
