/*
 * @lc app=leetcode.cn id=622 lang=java
 *
 * [622] 设计循环队列
 */
class MyCircularQueue {

    int[] data;

    int head = -1, tail = -1;
    int count, size;

    /** Initialize your data structure here. 
     * Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        count = k;
        data = new int[count];
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is
     * successful.
     */
    public boolean enQueue(int value) {
        if (size == count) {
            return false;
        }
        if(head==-1){
            head=0;
        }
        tail = (tail + 1) % count;
        data[tail] = value;
        size++;
        return true;
    }
    /**
     * Delete an element from the circular queue. Return true if the operation is
     * successful.
     */
    public boolean deQueue() {
        if (size == 0) {
            return false;
        }
        size--;
        head = (head + 1) % count;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        return size <= 0 ? -1 : data[head];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        return size <= 0 ? -1 : data[tail];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return size==0;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return size==count;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k); boolean param_1 =
 * obj.enQueue(value); boolean param_2 = obj.deQueue(); int param_3 =
 * obj.Front(); int param_4 = obj.Rear(); boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
