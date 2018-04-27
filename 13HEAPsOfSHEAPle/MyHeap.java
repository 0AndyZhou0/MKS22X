public class MyHeap{
    private String[] ary;
    private int size = 0;
    private boolean MaxMin = true;
    
    public MyHeap(){
	ary = new String[15];
    }

    public MyHeap(boolean){
	ary = new String[15];
	MaxMin = boolean;
    }

    public void add(String element){
	if(size == ary.length - 1){
	    resize();
	}
	ary[++size] = element;
	//add code to position element correctly.
    }

    //remove the top element
    public String remove(){
	ary[0] = ary[size--];
	ary[size] = null;
	//add code to poisition elements correctly.
    }

    public String peek(){
	if(ary.length > 0){return ary[0]}
	return null;
    }

    public int size(){
	return size;
    }

    public void resize(){
	String[] bigger = new String[ary.length * 2];
	for(int i = 0;i < ary.length;i++){
	    bigger[i] = ary[i];
	}
	ary = bigger;
    }
    
    public void swapUp(int n){
	String temp = ary[nn];
	ary[n] = ary[(n-1)/2];
	ary[(n-1)/2] = temp;
    }
}
