public class Quick{
    public static void main(String[] args){
	//int[] ary = {999,999,999,4,1,0,3,2,999,999,999};
	//int[] ary = {0,999,999,999,1999,0,3,2,999,999,999};
	int[] ary = {0,1,2,3,4,5,6,1,2,4,5};
	//int[] ary = {0,0,0,0,0,1,1,1,1,1};
	//int[] ary = {0,0,0,0,0,0,0,0,0,0,0,0,0};
	//int[] ary = {1,2,0};
	//print(ary);
	//System.out.println(partition(ary,0,ary.length-1));
	//System.out.println(quickselect(ary,5));
	quicksort(ary);
        print(ary);
    }

    /*
      int[] list;
      public sort(int[] nums){
      list = new int[nums.length];
      for(int i = 0;i < nums.length;i++){
      list[i] = nums[i];
      }
      }
    */

    
    public static int partition(int[] nums, int min, int max){
	int index = (int)(Math.random() * (max - min + 1)) + min;
        swap(nums,index,min);
	int partition = nums[min];
	int i = min + 1;
	int j = max;
	int k = min;
	while(i <= j){
	    if(nums[i] == partition){
	    	i++;
	    }
	    else if(nums[i] < partition){
		swap(nums,i,k);
		k++;
		i++;
	    }
	    else{
		swap(nums,i,j);
		j--;
	    }
	}
	return j;
    }
    

    // public static int partition(int[] nums, int min, int max){
    //     swap(nums,(int)(Math.random() * (max - min + 1)) + min,min);
    // 	int partition = nums[min];
    // 	int i = min;
    // 	int j = min + 1;
    // 	while(j < max + 1){
    // 	    if(nums[j] <= partition){
    // 		i++;
    // 		swap(nums,i,j);
    // 	    }
    // 	    j++;
    //     }
    // 	swap(nums,i,min);
    // 	return i;
    // }
    
    public static void swap(int[]nums, int num1, int num2){
	int temp = nums[num1];
	nums[num1] = nums[num2];
	nums[num2] = temp;
    }

    public static void print(int[] ary){
	String line = "[";
	for(int i = 0;i < ary.length;i++){
	    line += ary[i] + ",";
	}
        System.out.println(line.substring(0,line.length()-1) + "]");
    }

    public static int quickselect(int[] nums, int k){
	int index = partition(nums,0,nums.length-1);
	return findKH(nums,k,index);
    }

    public static int findKH(int[]nums, int k, int index){
	if(index == k - 1){
	    return nums[index];
	}
	int index2 = 0;
	if(index < k - 1){
	    index2 = partition(nums,index+1,nums.length-1);
	    return findKH(nums,k,index2);
	}else{
	    index2 = partition(nums,0,index-1);
	    return findKH(nums,k,index2);
	}
    }

    public static void quicksort(int[]nums){
	if(nums.length != 0){
	    int pivot = partition(nums,0,nums.length-1);
	    quickSortH(nums,pivot+1,nums.length-1);
	    quickSortH(nums,0,pivot-1);
	}
    }
    
    public static void quickSortH(int[]nums,int min,int max){
	if(max > min){
	    int pivot = partition(nums,min,max);
	    quickSortH(nums,pivot+1,max);
	    quickSortH(nums,min,pivot-1);
	}
    }
}
