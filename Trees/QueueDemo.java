package trees.bst;

public class QueueDemo<T> {
    private Object[] arr;
    private int front = 0, rear = -1;

    public QueueDemo(int size) {
        arr = new Object[size];
    }

    public void offer(T val) {
        arr[++rear] = val;
    }

    @SuppressWarnings("unchecked")
    public T poll() {
        return (T) arr[front++];
    }

    public boolean isEmpty() {
        return rear < front;
    }
}