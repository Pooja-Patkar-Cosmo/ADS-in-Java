package trees.bst;

public class StackDemo<T> {
    private Object[] arr;
    private int top = -1;

    public StackDemo(int size) {
        arr = new Object[size];
    }

    public void push(T val) {
        arr[++top] = val;
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        return (T) arr[top--];
    }

    public boolean isEmpty() {
        return top == -1;
    }
}

/*

    1. Why use @SuppressWarnings("unchecked")?
    Java cannot check at runtime whether arr[top] is genuinely a T (due to type erasure).
    Because Java cannot guarantee 100% type safety, the compiler shouts an "unchecked cast" warning.
    This annotation tells the compiler to silence that warning and compile cleanly.


    2. Why Object[] arr instead of T[] arr?
    In Java, you cannot write new T[size].
    Generic types exist only during compilation. At runtime, Java wipes generic types away.
    Because Java doesn't know the exact memory size of T at runtime, you must allocate an Object[] and manually cast it to (T).

 */