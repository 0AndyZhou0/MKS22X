public class Sort{
    public static void radixsort(MyLinkedListImproved<Integer> list){
	int largestDigit = 1;
        for(Integer i: list){
	    if((int)(Math.log(i) / Math.log(10)) > largestDigit){
		largestDigit = (int)(Math.log(i) / Math.log(10));
	    }
	}
    }

    public static void sort(MyLinkedListImproved<Integer> list, int digit){
	@SuppressWarnings("unchecked")
	    MyLinkedListImproved<Integer>[] ary = new MyLinkedListImproved[10];
        for(Integer i: list){
	    ary[(int)(Math.log(i) / Math.log(10))].add(i);
	}
	list.clear();
	
    }

}
