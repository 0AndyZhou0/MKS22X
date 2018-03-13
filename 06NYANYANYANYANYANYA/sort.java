public class sort{
    public static void main(String[] args){
	int[] ary = {4,1,3,5,3,2,5};
	print(ary);
	partition(ary);
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
	
    public static void partition(int[] nums){
	int partition = nums[0];
	int x = nums.length - 1;
	for(int i = 1;i < x;i++){
	    if(nums[i] > partition){
		while(nums[x] > partition && x > i){
		    x--;
		}
		swap(nums,i,x);
	    }
	}
	for(int i = 1;i < x;i++){
	    swap(nums,i,i-1);
	}
	nums[x - 1] = partition;
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
        System.out.println(line + "]");
    }
}
