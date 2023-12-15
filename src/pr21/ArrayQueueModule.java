package pr21;

public class ArrayQueueModule {

    private static int size = 0;
    private static int head = 0;
    static int a = 5;
    static int b = 6;
    static int c = 7;
    static int d = 8;
    static int e = 9;
    static int f = 10;
    static int g = 11;

    private static Object[] elements = {a, b, c, d, e, f, g};


    public static void enqueue(Object element) {
        assert element != null;
        ensureCapacity(size + 1);
        elements[(head + size) % elements.length] = element;
        size++;
    }

    private static void ensureCapacity(int capacity) {
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

    public static Object dequeue() {
        assert size > 0;
        Object x = elements[head];
        head = (head + 1) % elements.length;
        size--;
        return x;
    }

    public static Object element() {
        assert size > 0;
        return elements[head];
    }

    public static int size() {
        return size;
    }

    public static boolean isEmpty() {
        return size == 0;
    }

    public static void clear() {
        Object[] newElements = new Object[5];
        elements = newElements;
        size = 0;
        head = 0;
    }

    public static String toStr() {
        if (size == 0) return "[]";
        StringBuilder str = new StringBuilder("[");
        if (head < (head + size) % elements.length) {
            for (int i = head; i < (head + size) % elements.length; i++) {
                str.append(elements[i].toString());
                str.append(", ");
            }
        } else {
            for (int i = head; i < elements.length; i++) {
                str.append(elements[i].toString());
                str.append(", ");
            }
            for (int i = 0; i < (head + size) % elements.length; i++) {
                str.append(elements[i].toString());
                str.append(", ");
            }
        }
        str.delete(str.length() - 2, str.length());
        str.insert(str.length(), ']');
        return str.toString();
    }

    public static void main(String[] args) {
        //input
        for (int i = 0; i < 10; i++) {
            ArrayQueueModule.enqueue(i+1);
        }
        System.out.println(toStr());

        //pop half
        for (int i = 0; i < 5; i++) {
            ArrayQueueModule.dequeue();
        }
        System.out.println(toStr());

        //input half
        for (int i = 0; i < 5; i++) {
            ArrayQueueModule.enqueue(i);
        }
        System.out.println(toStr());

        //input more
        for (int i = 100; i < 108; i++) {
            ArrayQueueModule.enqueue(i);
        }
        System.out.println(toStr());
    }
}