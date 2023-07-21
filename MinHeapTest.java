import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MinHeapTest {

    public int[] array;

    @Test
    public void testSwap(){
        array = new int[]{6, 2, 3, 4};
        MinHeap.swap(array, 0, 1);
        assertArrayEquals(new int[]{2, 6, 3, 4}, array);
    }

    @Test
    public void testHeapify(){
        array = new int[]{4,3,2,1,6,7,4,2};
        int[] expected = new int[]{1,2,2,3,6,7,4,4};
        MinHeap.buildMinHeap(array);
        assertArrayEquals(expected, array);
    }

    @Test
    public void testMinHeapInsertElement(){
        array = new int[]{1,2,2,3,6,7,4,4};
        int[] actual = MinHeap.insertElement(array, 5);
        int[] expected = new int[]{1,2,2,3,5,7,4,4,6};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testMinHeapDeleteElement(){
        array = new int[]{1,2,2,3,6,7,4,4};
        int[] expected = new int[]{1,2,2,3,7,4,4};
        int[] actual = MinHeap.deleteElement(array, 6);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testMinHeapHeapSort(){
        array = new int[]{1,2,2,3,6,7,4,4};
        int[] expected = new int[]{1,2,2,3,4,4,6,7};
        int[] actual = MinHeap.heapSort(array);
        assertArrayEquals(expected, actual);
    }

}
