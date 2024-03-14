//Implement the stack structure (i.e. its representations along with basic operations) using one-way lists implemented using dynamic variables. The elements of the stack are pairs of real numbers (x, y) ∈ R.
//Implement a queue structure using a one-way array. The elements of the queue are pairs of name and surname strings.

public class Lab4_Stack {
    class Node {
        double x, y;
        Node next;

        Node(double x, double y){
            this.x = x;
            this.y = y;
            this.next = null;
        }
    }
    Node top;

    public Lab4_Stack(){
        this.top=null;
    }

    public void push(double x, double y){
        Node temp = new Node(x, y);
        temp.next = top;
        top = temp;
    }

    public boolean isEmpty(){
        return top == null;
    }

    public void pop(){
        if(top == null){
            System.out.println("Stack is empty");
        }
        top = (top).next;
    }
}

 class StringQueue{
    int front, rear, capacity;
    String queue[];
    public StringQueue(int capacity){
        front = rear = 0;
        this.capacity = capacity;
        queue = new String[capacity];
    }
    public void enqueue(String data){
        if(capacity == rear){
            System.out.println("Queue is full");
        }
        else {
            queue[rear] = data;
            rear++;
        }
    }

    public void dequeue(){
        if(front == rear){
            System.out.println("Queue is empty");
        }
        else{
            for(int i=0; i < rear - 1; i++){
                queue[i] = queue[i+1];
            }
            if(rear<capacity){
                queue[rear] = null;
                rear--;
            }
        }
    }
}
