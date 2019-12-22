package com.sbsatter.paypaydemo;

import com.sbsatter.paypaydemo.impl.ImmutableQueue;
import com.sbsatter.paypaydemo.solution.Queue;
import org.junit.Test;

public class TestImmutableQueueForObjects {

    Queue<String> calendar;
    String [] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

    private void testEnQueue() {
        Queue<String> monthProgressor = new ImmutableQueue<String>();
        for (String month : months) {
            monthProgressor = monthProgressor.enQueue(month);
        }
        calendar = monthProgressor;
    }

    private void testDequeue() {
        Queue<String> monthProgressor = this.calendar;
        for (String month : months) {
            assert month.equals(monthProgressor.head());
            monthProgressor = monthProgressor.deQueue();
        }
        calendar = monthProgressor;
        assert calendar.isEmpty();
    }

    @Test
    public void test() {
        testEnQueue();
        testDequeue();
    }

}
