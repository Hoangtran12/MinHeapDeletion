public class MinHeap {
        private int[] heap;
        private int heapSize;
    
        public MinHeap(int capacity) {
            heap = new int[capacity];
            heapSize = 0;
        }
    
        private void swap(int i, int j) {
            int temp = heap[i];
            heap[i] = heap[j];
            heap[j] = temp;
        }
    
        private void percolateUp(int index) {
            while (index > 0 && heap[(index - 1) / 3] > heap[index]) {
                swap((index - 1) / 3, index);
                index = (index - 1) / 3;
            }
        }
    
        private void percolateDown(int index) {
            while (3 * index + 1 < heapSize) {
                int smallerChildIndex = 3 * index + 1;
                int rightChildIndex = 3 * index + 2;
    
                if (rightChildIndex < heapSize && heap[rightChildIndex] < heap[smallerChildIndex]) {
                    smallerChildIndex = rightChildIndex;
                }
    
                if (heap[index] < heap[smallerChildIndex]) {
                    break;
                } else {
                    swap(index, smallerChildIndex);
                }
    
                index = smallerChildIndex;
            }
        }
    
        private void insert(int value) {
            heap[heapSize++] = value;
            percolateUp(heapSize - 1);
        }
    
        private void minHeapify() {
            for (int i = heapSize / 3 - 1; i >= 0; i--) {
                percolateDown(i);
            }
        }
    
        private void removeFromHeap(int index) {
            int lastIndex = heapSize - 1;
            int lastElement = heap[lastIndex];
            heap[index] = lastElement;
    
            percolateUp(index);
            percolateDown(index);
    
            heapSize--;
    
            minHeapify();
        }
    
        public void printHeap() {
            System.out.print("Heap: ");
            for (int i = 0; i < heapSize; i++) {
                System.out.print(heap[i] + " ");
            }
            System.out.println();
        }
        public void printHeapAfterRemoval() {
            System.out.print("Heap After Removal: ");
            for (int i = 0; i < heapSize; i++) {
                System.out.print(heap[i] + " ");
            }
            System.out.println();
        }
    
        public static void main(String[] args) {
            MinHeap myHeap = new MinHeap(9);
    
            myHeap.insert(1);
            myHeap.insert(4);
            myHeap.insert(2);
            myHeap.insert(3);
            myHeap.insert(6);
            myHeap.insert(5);
            myHeap.insert(9);
            myHeap.insert(8);
            myHeap.insert(7);
    //deleteMin
            while (myHeap.heapSize > 0) {
                myHeap.printHeap();
                myHeap.removeFromHeap(0);
                myHeap.printHeapAfterRemoval();
            }
        }
    }
    