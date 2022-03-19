public class Stack {
	private int [] elements;
	private int top;

	public Stack(int size){
		elements = new int[size];
		top = -1;
	}

	public boolean isEmpty(){
		if(top < 0) return true;
		return false;
	}

	public void push(int element){
		if(top == elements.length - 1){
			int temp;
			for(int i = 1; i < elements.length; i++){
				elements[i-1] = elements[i];
			}
		}
		else{
			top++;
		}
		elements[top] = element;
	}
	public int pop(){
		int temp = this.peek();
		top--;
		return temp;
	}

	public int peek(){
		if(this.isEmpty()){
			throw new NullPointerException();
		}
		return elements[top];
	}
}
