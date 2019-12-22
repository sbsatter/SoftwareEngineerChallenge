package com.sbsatter.paypaydemo;


import com.sbsatter.paypaydemo.impl.ImmutableQueue;
import com.sbsatter.paypaydemo.solution.Queue;
import org.junit.Assert;
import org.junit.Test;

public class TestImmutableQueueForIntegers {

    Queue<Integer> queue;

    private void testEnQueue(int n) {
        Queue<Integer> testQueue = new ImmutableQueue<Integer>();
        for (int i = 0; i < n; i++) {
            testQueue = testQueue.enQueue(i);
            assert testQueue instanceof ImmutableQueue && ((ImmutableQueue)testQueue).getSize() == (i+1);
        }
        queue = testQueue;
        System.out.println(queue);
    }

    private void testDeQueue(boolean ordered) {
        Queue<Integer> testQueue = queue;
        Assert.assertNotNull("Queue not initialized, call testEnQueue first!", testQueue);
        int initialSize = ((ImmutableQueue)testQueue).getSize();
        System.out.println("Queue size before dequeue: " + initialSize);
        for (int i = initialSize; i > 0; i--) {
            Integer dequeuedObject = testQueue.head();
            testQueue = testQueue.deQueue();

            // check size functionality
            assert ((ImmutableQueue)testQueue).getSize() == i - 1;

            assert !ordered || dequeuedObject == (initialSize - i);

            System.out.println("Dequeued => " + dequeuedObject);
            System.out.println(queue);
            System.out.println("-----------------------------------------------------------------");
        }

        assert testQueue.isEmpty();
        System.out.println("Done");
        System.out.println(testQueue);

    }

    @Test
    public void test() {
        int n = 10;

        testEnQueue(n);
        // check if dequeue elements match the order they were added
        testDeQueue(true);

    }

}
