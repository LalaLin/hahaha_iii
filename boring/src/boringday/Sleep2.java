package boringday;

public class Sleep2 {
	// 排序2
	public void sort1(int[] array) {
		int temp, loc;
		int len = array.length;
		for (int i = 0; i < len - 1; i++) {
			loc = i;// 目前的位置(最小位)
			for (int j = i + 1; j < len; j++) {
				if (array[loc] > array[j]) {// 往後退
					loc = j;
				}
				}
				temp = array[loc]; // 虛擬位置存放須往後放的array[loc]
				array[loc] = array[i]; // 放到最後
				array[i] = temp;
			}
		
	}

	public static void main(String[] args) {
		System.out.println("------------------Sleep2:　　　");
		int[] array = new int[30];
		System.out.print("old array(i):");
		for (int i = 0; i < 30; i++) {
			array[i] = (int) (Math.random() * 400) + 1;
			System.out.print(array[i] + " ,");

		}
		System.out.print("\n");
		System.out.println("--------------------------");

		Sleep2 sleep = new Sleep2();
		System.out.print("new array(i):");
		sleep.sort1(array);
		for (int arr : array) {
			System.out.print(arr + " ,");
		}
	}

}
