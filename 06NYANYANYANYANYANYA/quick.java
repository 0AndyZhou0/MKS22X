public class quick{
    public static void main(String[] args){
	//int[] ary = {999,999,999,4,1,0,3,2,999,999,999};
	//int[] ary = {0,999,999,999,1999,0,3,2,999,999,999};
	int[] ary = {0,1,2,3,4,5,6,1,2,4,5};
	//int[] ary = {0,0,0,0,0,1,1,1,1,1};
	print(ary);
	System.out.println(partition(ary,0,ary.length-1));
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
	int x = max;
	int copies = 1;
	min++;
	while(min < x){
	    if(nums[min] > partition){
		while(nums[x] >= partition && x > min){
		    print(nums);
		    x--;
		}
		swap(nums,min,x);
	    }
	    // if(nums[min] == partition){
	    // 	swap(nums,copies,min);
	    // 	copies++;
	    // }
	    min++;
	}
	// for(int i = min + 1;i < x;i++){
	//     swap(nums,i,i-1);
	// }
	print(nums);
	System.out.println(nums[x]);
	if(nums[min] > nums[x-1]){
	    swap(nums,min,x-1);
	}else{
	    swap(nums,min,x-2);
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
	int index = partition(nums,0,nums.length-1);
	return findKH(nums,k,index);
    }

    public static int findKH(int[]nums, int k, int index){
	if(index == k - 1){
	    return nums[index];
	}
	int index2 = 0;
	if(index < k - 1){
	}
	return findKH(nums,k,index2);
    }
}
