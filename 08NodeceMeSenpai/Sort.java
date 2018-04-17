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
	int largestDigit = 0;
        for(Integer i: list){
	    if((int)(Math.log(i) / Math.log(10)) > largestDigit){
		largestDigit = (int)(Math.log(i) / Math.log(10));
	    }
	    System.out.println(largestDigit);
	}
	for(int i = 0;i <= largestDigit;i++){
	    sort(list,i);
	}
    }

    public static void sort(MyLinkedListImproved<Integer> list, int digit){
	@SuppressWarnings("unchecked")
	    MyLinkedListImproved<Integer>[] ary = new MyLinkedListImproved[10];
	for(int i = 0;i < 10;i++){
	    ary[i] = new MyLinkedListImproved<Integer>();
	}
	for(Integer i: list){
	    ary[(int)(i / Math.pow(10,digit)) % 10].add(i);
	}
	list.clear();
	for(int i = 0;i < 10;i++){
	    list.extend(ary[i]);
	}
    }

}
