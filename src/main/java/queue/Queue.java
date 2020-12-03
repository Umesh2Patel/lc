package queue;

public class Queue {
	
	private int maxSize; //initializes the set number of slots 
	private long[] queArray; // slots to main the data
	private int front; // this will be the index position for the element at the back of the line
	private int rear;
	private int nItems; //counter to mantain the number of itmes in our queue
	
	public Queue(int size){
		this.maxSize = size;
		this.queArray = new long[size];
		front = 0;
		rear = -1; 
		nItems = 0;
	}
	
	public void insert(long j){
		
		if(rear == maxSize-1)
			rear = -1;
		
		rear++;
		queArray[rear] = j;
		nItems ++;
	}
	
	public long remove(){
		long temp = queArray[front];
		front++;
		if(front == maxSize){
			front = 0;
		}
		nItems--;
		return temp;
	}
	
	public void view(){
		System.out.print("[ ");
		for(int i=0; i < queArray.length; i++){
			System.out.print(queArray[i]+" ");
		}
		System.out.print("]");
	}

}
