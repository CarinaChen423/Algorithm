class Lab5_Heap {
    private int[] Heap;
    private int size;
    private int maxsize;
    private static final int FRONT = 1;

    public Lab5_Heap(int maxsize){
        this.maxsize = maxsize;
        this.size = 0;
        Heap = new int[this.maxsize+1];
        Heap[0] = Integer.MIN_VALUE;
    }

    private int parent(int pos){return pos / 2;}
    private int leftchild(int pos){return (2 * pos);}
    private int rightchild(int pos){
        return (2*pos)+1;
    }

    private boolean isLeaf(int pos){
        if (pos>(size/2)){
            return true;
        }
        return false;
    }

    public boolean contains(int element) {
        for (int i = 1; i <= size; i++) {
            if (Heap[i] == element) {
                return true;
            }
            System.out.println("Visited: " + Heap[i]);
        }
        return false;
    }

    private void swap(int s1, int s2){
        int tmp;
        tmp = Heap[s1];
        Heap[s1] = Heap[s2];
        Heap[s2] = tmp;
    }

    private void minHeapify(int pos) {
        if (!isLeaf(pos)) {
            int swapPos = pos;
            if (rightchild(pos) <= size)
                swapPos = Heap[leftchild(pos)] < Heap[rightchild(pos)] ? leftchild(pos) : rightchild(pos);
            else
                swapPos = leftchild(pos);

            if (Heap[pos] > Heap[leftchild(pos)] || Heap[pos] > Heap[rightchild(pos)]) {
                swap(pos, swapPos);
                minHeapify(swapPos);
            }
        }
    }

    public void insert(int element){
        if(size>=maxsize){
            return;
        }
        Heap[++size] = element;
        int current = size;

        while (Heap[current] < Heap[parent(current)]){
            swap(current,parent(current));
            current = parent(current);
        }
    }

    public void print(){
        for(int i = 1; i<=size/2;i++){
            System.out.println("PARENT: "+Heap[i] + " LEFT CHILD: "+Heap[2*i]+" RIGHT CHILD: " + Heap[2*i+1]);
            System.out.println();
        }
    }
    public int delete(){
        int popped = Heap[FRONT];
        Heap[FRONT] = Heap[size--];
        minHeapify(FRONT);
        return popped;
    }



    public static void main(String[] args) {
        System.out.println("The Min Heap is: ");
        Lab5_Heap minHeap = new Lab5_Heap(10);
        minHeap .insert(15);
        minHeap .insert(40);
        minHeap .insert(30);
        minHeap .insert(50);
        minHeap .insert(10);
        minHeap .insert(100);
        minHeap .insert(40);
        minHeap .print();

        if (minHeap.contains(40)) {
            System.out.println("40 is in the heap");
        } else {
            System.out.println("40 is not in the heap");
        }
        System.out.println();
        System.out.println("After delete " + minHeap .delete());
        minHeap .print();
    }
}

