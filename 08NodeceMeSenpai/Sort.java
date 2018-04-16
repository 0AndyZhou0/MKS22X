public class Sort{
    public static void main(String[] args){
	MyLinkedListImproved<Integer> x = new MyLinkedListImproved<>();
	for(int i = 8; i > 0; i--){
	    x.add((int)(Math.random()* i *10));
	}
	System.out.println(x);
	x.add(100);
	radixsort(x);
	System.out.println(x);

    }
    public static void radixsort(MyLinkedListImproved<Integer> list){
	int largestDigit = 1;
        for(Integer i: list){
	    if((int)(Math.log(i) / Math.log(10)) > largestDigit){
		largestDigit = (int)(Math.log(i) / Math.log(10));
	    }
	}
	for(int i = 1;i <= largestDigit;i++){
	    sort(list,i);
	}
    }

    public static void sort(MyLinkedListImproved<Integer> list, int digit){
	@SuppressWarnings("unchecked")
	    MyLinkedListImproved<Integer>[] ary = new MyLinkedListImproved[10];
        for(Integer i: list){
	    ary[(int)(Math.log(i) / Math.log(Math.pow(10,digit)))].add(i);
	}
	list.clear();
	list = ary[0];
	for(int i = 1;i < 10;i++){
	    list.merge(ary[i]);
	}
    }

}
