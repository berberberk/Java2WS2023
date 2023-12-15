package pr21;

public class ArrayQueue {

    private int size = 0;
    private int head = 0;
    private Object[] elements = new Object[5];

    public void enqueue(Object element) {
        assert element != null;
        ensureCapacity(size + 1);
        elements[(head + size) % elements.length] = element;
        size++;
    }

    private void ensureCapacity(int capacity) {
        if (capacity <= elements.length) {
            return;
        }
        Object[] newElements = new Object[2 * capacity];
        if (head == 0) {
            for (int i = 0; i < size; i++) {
                newElements[i] = elements[i];
            }
            elements = newElements;
        } else {
            for (int i = head; i < elements.length; i++) {
                newElements[i - head] = elements[i];
            }
            for (int i = 0; i <= (head + size) % elements.length; i++) {
                newElements[i + elements.length - head] = elements[i];
            }
            head = 0;
            elements = newElements;
        }
    }

    public Object dequeue() {
        assert size > 0;
        Object x = elements[head];
        head = (head + 1) % elements.length;
        size--;
        return x;
    }

    public Object element() {
        assert size > 0;
        return elements[head];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        Object[] newElements = new Object[5];
        elements = newElements;
        size = 0;
        head = 0;
    }

    public String toStr() {
        StringBuilder str = new StringBuilder("[");
        if (size == 0) return "[]";
        if (head < (head + size) % elements.length) {
            for (int i = head; i < (head + size) % elements.length; i++) {
                str.append(elements[i]);
                str.append(", ");
            }
        } else {
            for (int i = head; i < elements.length; i++) {
                str.append(elements[i]);
                str.append(", ");
            }
            for (int i = 0; i < (head + size) % elements.length; i++) {
                str.append(elements[i]);
                str.append(", ");
            }
        }
        str.delete(str.length() - 2, str.length());
        str.insert(str.length(), ']');
        return str.toString();
    }

    public static void main(String[] args) {

        ArrayQueue queue = new ArrayQueue();
        //input
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i+2);
        }
        System.out.println(queue.toStr());

        //pop half
        for (int i = 0; i < 5; i++) {
            queue.dequeue();
        }
        System.out.println(queue.toStr());

        //input half
        for (int i = 0; i < 5; i++) {
            queue.enqueue(i);
        }
        System.out.println(queue.toStr());

        //input more
        for (int i = 100; i < 108; i++) {
            queue.enqueue(i);
        }
        System.out.println(queue.toStr());
    }
}