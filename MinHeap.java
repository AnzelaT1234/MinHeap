
public class MinHeap {

    public static int[] insertElement(int[] heap, int newElement){
        int heapSize = heap.length+1;
        int[] newHeap = new int[heapSize];
        int newIndex = heapSize-1;
        for (int i=0; i<heapSize; i++){
            if (newElement<heap[i]){
                newIndex = i;
                break;
            }
        }

        for (int i=0; i<heapSize-1; i++){
            if (i==newIndex){
                newHeap[i] = newElement;
            }
            else{
                newHeap[i] = heap[i];
            }
        }
        newHeap[heapSize-1] = heap[newIndex];
        buildMinHeap(newHeap);
        return newHeap;
    }

    public static int[] deleteElement(int[] heap, int element){
        int[] newHeap = new int[heap.length-1];
        int index = -1;
        for (int i=0; i<heap.length; i++){
            if (heap[i]==element){
                index = i;
                break;
            }
        }

        if (index == -1){
            return heap;
        }

        int j = 0;
        for (int i=0; i< newHeap.length; i++){
            if (i==index){
                j++;
            }
            newHeap[i] = heap[j];
            j++;

        }
        buildMinHeap(newHeap);
        return newHeap;
    }

    public static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    public static void heapify(int[] array, int heapSize, int index){
        int left = index*2+1; //1
        int right = left+1; //2

        int smallest = index; //0

        if (left < heapSize && array[smallest]>array[left]){
            smallest = left;
        }

        if (right < heapSize && array[smallest]> array[right]){
            smallest = right;
        }

        if (smallest!=index){
            swap(array, smallest, index);
            heapify(array, heapSize, smallest);
        }
    }

    public static void buildMinHeap(int[] array){
        int heapSize = array.length;
        for (int i=(heapSize/2); i>-1; i--){
            heapify(array, heapSize, i);
        }
    }

    public static void printHeap(int[] heap){
        for (int i=0; i<heap.length; i++){
            System.out.print(heap[i] + ", ");
        }
        System.out.println();
    }

    public static int[] heapSort(int[] heap){
        int[] sortedArray = new int[heap.length];

        for (int i=0; i<sortedArray.length; i++){
            sortedArray[i] = heap[0];
            heap = deleteElement(heap, heap[0]);
        }
        return sortedArray;
    }



}
