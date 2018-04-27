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

    public void add(String s){
	if(size == ary.length - 1){
	    resize();
	}
	
    }

    public String remove(){

    }

    public String peek(){

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
    
    public void swap(String[] ary,int a,int b){
	String temp = ary[a];
	ary[a] = ary[b];
	ary[b] = temp;
    }
}
