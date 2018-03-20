public class Merge{
    public static void main(String[] args){
	int[] ary = {1,2,54,1,56,4,2,2,6,34,23,6,2};
	mergesort(ary);
	print(ary);
    }

    public static void mergesort(int[]data){
	int[] temp = new int[data.length];
	msort(data,temp,0,data.length-1);
    }
	
    private static void msort(int[]data, int[]temp, int lo, int hi){
	if(hi > lo){
	    msort(temp,data,lo,(hi-lo+1)/2);
	    msort(temp,data,(hi-lo+3)/2,hi);
	    merge(data,temp,lo,hi);
	}
    }

    private static void merge(int[]data,int[]temp,int lo,int hi){
	int split1 = (hi-lo+1)/2;
	int i = 0;
	int j = 0;
	int index = lo;
	//while(i <= split1 && j <= hi){
	
	    if(data[i] <= data[j]){
		temp[index] = data[i];
		i++;
	    }else{
		temp[index] = data[j];
		j++;
	    }
	    index++;
	}
	// while(i <= split1){
	//     temp[index] = data[i];
	//     i++;
	//     index++;
	// }
	// while(j <= hi){
	//     temp[index] = data[j];
	//     j++;
	//     index++;
	// }
    }

    public static String print(int[] ary){
	String line = "[";
	    for(int i = 0;i < ary.length-1;i++){
		line+= i + ",";
	    }
	line += ary[ary.length-1] + "]";
	return line;
    }
}
