class MyCircularDeque {
    private int[] q;        // Array to store deque elements
    private int front;      // Index of the front element
    private int size;       // Current number of elements in the deque
    private int capacity;   // Maximum capacity of the deque

    // Constructor to initialize the deque with a fixed size k
    public MyCircularDeque(int k) {
        q = new int[k];    // Initializes the array with size k
        capacity = k;      // Sets the maximum capacity
        front = 0;         // Sets the initial front index to 0
        size = 0;          // Sets the initial size to 0
    }

    // Method to insert an element at the front of the deque
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;  // Cannot insert if the deque is full
        }
        if (!isEmpty()) {
            front = (front - 1 + capacity) % capacity;  // Adjusts the front index circularly
        }
        q[front] = value;   // Places the value at the front
        ++size;             // Increases the size
        return true;        // Insertion successful
    }

    // Method to insert an element at the rear of the deque
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;  // Cannot insert if the deque is full
        }
        int rear = (front + size) % capacity; // Calculate the correct rear index
        q[rear] = value;                      // Insert value at the rear index
        ++size;                               // Increment the size
        return true;                          // Insertion successful
    }

    // Method to delete an element from the front of the deque
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;  // Cannot delete if the deque is empty
        }
        front = (front + 1) % capacity;  // Move the front index forward circularly
        --size;                         // Decrement the size
        return true;                    // Deletion successful
    }

    // Method to delete an element from the rear of the deque
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;  // Cannot delete if the deque is empty
        }
        --size;            // Decrement the size, logically adjusting the rear
        return true;       // Deletion successful
    }

    // Method to get the front element of the deque
    public int getFront() {
        if (isEmpty()) {
            return -1;   // Return -1 if the deque is empty
        }
        return q[front]; // Return the element at the front
    }

    // Method to get the rear element of the deque
    public int getRear() {
        if (isEmpty()) {
            return -1;  // Return -1 if the deque is empty
        }
        return q[(front + size - 1) % capacity];  // Compute the index of the rear element
    }

    // Method to check if the deque is empty
    public boolean isEmpty() {
        return size == 0; // Returns true if the deque has no elements
    }

    // Method to check if the deque is full
    public boolean isFull() {
        return size == capacity; // Returns true if the deque is full
    }
}

/**
 * Example usage:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
