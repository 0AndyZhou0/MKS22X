public class quick{
    public static void main(String[] args){
	//int[] ary = {999,999,999,4,1,0,3,2,999,999,999};
	//int[] ary = {0,999,999,999,1999,0,3,2,999,999,999};
	//int[] ary = {0,1,2,3,4,5,6,1,2,4,5};
	//int[] ary = {0,0,0,0,0,1,1,1,1,1};
	int[] ary = {0,0,0,0,0,0,0,0,0,0,0,0,0};
	print(ary);
	//System.out.println(partition(ary,0,ary.length-1));
	System.out.println(quickselect(ary,5));
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
	System.out.println(index);
	swap(nums,index,min);
	int partition = nums[min];
	int copies = 1;
	for(int i = min + 1;i < max;i++){
	    print(nums);
	    if(nums[i] >= partition){
		while(nums[max] > partition && max > i){
		    print(nums);
		    max--;
		}
		swap(nums,i,max);
	    }
	     if(nums[i] == partition){
	     	swap(nums,copies,i);
	     	copies++;
	     }
	}
	for(int i = min + 1;i < max;i++){
	    swap(nums,i,max);
	}
	if(nums[min] >= nums[max]){
	    swap(nums,min,max);
	}else{
	    swap(nums,min,max-1);
	}
	return max;
    }
    
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
}
