public class Merge{
    public static void main(String[] args){

    }

    public static void mergesort(int[]data){
	int[] temp = new int[data.length];
	msort(data,temp,0,data.length-1);
    }
	
    private static void msort(int[]data, int[]temp, int lo, int hi){
	if(hi > lo){
	    msort(temp,data,lo,(hi-lo+1)/2);
	    msort(temp,data,(hi-lo+3)/2,hi);
	}
    }

    private static void merge(int[]data,int[]temp,int lo,int hi){
	
    }
}
