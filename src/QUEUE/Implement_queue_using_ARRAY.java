package QUEUE;

public class Implement_queue_using_ARRAY {
	static int arr[];
	static int start = -1 , end = -1 , currsize = 0;

	public static void push(int x){
		if(currsize == arr.length){
			return;
		}
		if(end == -1){
			start = 0 ;
			end = 0;
			arr[start] = x;
		}
		else{
			end = (end + 1) % arr.length;
			arr[end] = x;
			currsize++;
		}
	}
	public static int top(){
		if (start == -1) {
			return -1;
		}
		return arr[start];
	}
	public static int size(){
		return currsize;
	}
	public static void pop(){
		if (start == -1) {
			return;
		}
		if (currsize == 1) {
			start = -1;
			end = -1;
		}else
			start = (start + 1) % arr.length;
		currsize--;
		return;
	}
	public static void main(String[] args) {
		arr = new int[6];
		push(4);
		push(14);
		push(24);
		push(34);
		System.out.println(top());
		System.out.println(size());
		pop();
		System.out.println(top());
	}
}
