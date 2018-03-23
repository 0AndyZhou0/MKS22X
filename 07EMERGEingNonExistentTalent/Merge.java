public class Merge{
    public static void main(String[] args){
	int[] ary = {1,2,54,1,56,4,2,2,6,34,23,6,2};
	//int[] ary = {0,0,0,0,0,0,0,0,0};
	//int[] ary = {1,1,1,1,4,4,4,4,4,1,1,1,1};
	System.out.println(print(ary));
	mergesort(ary);
	System.out.println(print(ary));
    }

    public static void mergesort(int[]data){
	if(data.length != 0){
		int[] temp = new int[data.length];
		// for(int i = 0;i < data.length;i++){
		//     temp[i] = data[i];
		// }
		msort(data,temp,0,data.length-1);
	}
    }
	
    private static void msort(int[]data, int[]temp, int lo, int hi){
	if(hi > lo){
	    for(int i = lo;i <= hi;i++){
		temp[i] = data[i];
	    }
	    int split = (hi+lo)/2;
	    msort(temp,data,lo,split);
	    msort(temp,data,split+1,hi);
	    merge(data,temp,lo,hi);
	}
    }

    private static void merge(int[]data,int[]temp,int lo,int hi){
	int split = (hi+lo)/2;
	int i = lo;
	int j = split + 1;
	int index = lo;
	while(i <= split && j <= hi){
	    if(temp[i] <= temp[j]){
		data[index] = temp[i];
		i++;
	    }else{
		data[index] = temp[j];
		j++;
	    }
	    index++;
	}
	while(i <= split){
	    data[index] = temp[i];
	    i++;
	    index++;
	}
	while(j <= hi){
	    data[index] = temp[j];
	    j++;
	    index++;
	}
    }

    public static String print(int[] ary){
	String line = "[";
	    for(int i = 0;i < ary.length-1;i++){
		line+= ary[i] + ",";
	    }
	line += ary[ary.length-1] + "]";
	return line;
    }

    public static void insertionSort(int[] data){
	for (int i = 1;i < data.length;i++){
	    for (int n = i;n > 0;n--){
		if (data[n] < data[n-1]){
		    swap(data,n,n-1);
		    //System.out.println(toString(data));  //for testing
		}
		else{
		    n = 1;
		}
	    }
	}
    }
}
