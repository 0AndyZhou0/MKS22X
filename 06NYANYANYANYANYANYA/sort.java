public class sort{
    public static void main(String[] args){
	//int[] ary = {999,999,999,4,1,0,3,2,999,999,999};
	//int[] ary = {0,999,999,999,1999,0,3,2,999,999,999};
	int[] ary = {0,1,2,3,4,5,6,1,2,4,5};
	//int[] ary = {0,0,0,0,0,1,1,1,1,1};
	print(ary);
	//partitionBefore(ary,2);
        // for(int i = 0;i < ary.length;i++){
	//     System.out.println(quickselect(ary,i+1));
	// }
	System.out.println(quickselect(ary,1));
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

    
    public static int partitionAfter(int[] nums, int n){
	int index = (int)(Math.random() * (nums.length - n - 1) + n + 1);
	swap(nums,index,0);
	return partitionAtZero(nums);
    }

     public static int partitionBefore(int[] nums, int n){
	int index = (int)(Math.random() * n);
	swap(nums,index,0);
	return partitionAtZero(nums);
    }
    
    public static int partition(int[] nums){
	int index = (int)(Math.random() * nums.length);
	swap(nums,index,0);
	int partition = nums[0];
	int x = nums.length - 1;
	int copies = 1;
	for(int i = 1;i < x;i++){
	    if(nums[i] > partition){
		while(nums[x] >= partition && x > i){
		    x--;
		}
		swap(nums,i,x);
	    }
	    if(nums[i] == partition){
		swap(nums,copies,i);
		copies++;
	    }
	}
	for(int i = 1;i < x;i++){
	    swap(nums,i,i-1);
	}
	return x - 1;
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
	int index = partition(nums);
	return findKH(nums,k,index);
    }

    public static int findKH(int[]nums, int k, int index){
	if(index == k - 1){
	    return nums[index];
	}
	int index2 = 0;
	if(index < k - 1){
	    index2 = partitionAfter(nums,index);
	}else{
	    index2 = partitionBefore(nums,index);
	}
	return findKH(nums,k,index2);
    }
}
