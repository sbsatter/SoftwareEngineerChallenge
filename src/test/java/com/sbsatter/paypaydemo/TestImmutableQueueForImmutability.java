package com.sbsatter.paypaydemo;

import com.sbsatter.paypaydemo.impl.ImmutableQueue;
import com.sbsatter.paypaydemo.solution.Queue;
import org.junit.Assert;
import org.junit.Test;

public class TestImmutableQueueForImmutability {

    private Queue<Integer> queue;

    private void initialize(int n) {
        Queue<Integer> queue = new ImmutableQueue<Integer>();
        for (int i = 0; i < n; i++) {
            queue = queue.enQueue(i);
        }
        this.queue = queue;
    }

    private void testEnqueue(int n) {
        assert this.queue != null;

        Queue<Integer> queue = this.queue;

        for (int i = 0; i < n; i++) {
            queue = queue.enQueue(i);
            assert ((ImmutableQueue) queue).getSize() == ((ImmutableQueue) this.queue).getSize() + (i + 1);
        }

    }

    private void testDequeue() {
        assert this.queue != null;
        Queue<Integer> queue = this.queue;
        int i = 0;
        while (! queue.isEmpty()) {
            queue = queue.deQueue();
            Assert.assertEquals(((ImmutableQueue) queue).getSize(), ((ImmutableQueue) this.queue).getSize() - (++i));
        }

        System.out.println(String.format("Size of global var: %d, size of local var: %d",
                ((ImmutableQueue) queue).getSize(), ((ImmutableQueue) this.queue).getSize()));
    }

    @Test
    public void test() {
        initialize(10);
        testEnqueue(5);
        testDequeue();
    }


}
