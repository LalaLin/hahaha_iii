package boringday;

public class Sleep1 {


	// 排序1

	public int[] sort1(int[] array) {
		int i,temp;
		int len=array.length;
		boolean ischaged=false;

		do {
			ischaged=false;
			for (abc=0;abc<len-1;abc++) {
				if(array[i] > array[i+1]) {
				temp=array[i];// 虛擬位置存放
				array[i] =array[i+1];
				array[i+1]=temp;
				ischaged=true;

			}
			} //end forloop
		}while(ischaged);//do	
		
			return array;
	}
	
	
	
	public static void main(String[] args) {
		int[] array = new int[30];
		System.out.print("old array(i):");
		for (int i=0;i<30;i++) {
		array[i]=(int)(Math.random()*400)+1;
		System.out.print(array[i] +" ,");

		}
		System.out.print("\n");
		System.out.println("--------------------------");

		Sleep1 sleep=new Sleep1();
		System.out.print("new array(i):");		
		sleep.sort1(array);
		for(int arr:array) {
		System.out.print(arr+" ,");
		}
		
	}
	
}
