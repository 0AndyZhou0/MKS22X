public class RunningMedian{
    public static void main(String[] args){
	RunningMedian a = new RunningMedian();
	a.add(1231.2);
	System.out.println(a.getMedian());
	a.add(12.0);
	System.out.println(a.getMedian());
	a.add(1.0);
	System.out.println(a.getMedian());
	a.add(.643);
	System.out.println(a.getMedian());
	a.add(74.0);
	System.out.println(a.getMedian());
    }
    
    private MyHeap<Double> smaller,larger;

    @SuppressWarnings("unchecked")
    public RunningMedian(){
	smaller = new MyHeap();
	larger = new MyHeap(false);
    }

    public void add(Double num){
        if(size() == 0){
	    smaller.add(num);
	}else{
	    if(num <= smaller.peek()){
		if(smaller.size() > larger.size()){
		    larger.add(smaller.remove());
		}
		smaller.add(num);
	    }else{
		if(smaller.size() <= larger.size()){
		    smaller.add(larger.remove());
		}
		larger.add(num);
	    }
	}
    }

    public Double getMedian(){
	if(size() == 0){
	    throw new NullPointerException();
	}
	if(size() % 2 == 1){
	    return smaller.peek();
	}
	return (larger.peek() + smaller.peek()) / 2;
    }

    public int size(){
	return larger.size() + smaller.size();
    }
}
