package pr21;

public class ArrayQueueADT {
    // Инвариант: queue != null && size >= 0
    private int size = 0;
    private int head = 0;
    private Object[] elements = new Object[5];

    // Предусловие: element != null
    // Постусловие: элемент добавлен в конец очереди
    public static void enqueue(ArrayQueueADT queue, Object element) {
        assert element != null;
        ensureCapacity(queue, queue.size + 1);
        queue.elements[(queue.head + queue.size) % queue.elements.length] = element;
        queue.size++;
    }

    // Предусловие: capacity != null
    // Постусловие: ёмкость массива, используемого для хранения элементов очереди в queue,
    // увеличена до capacity, если capacity больше текущей ёмкости.
    private static void ensureCapacity(ArrayQueueADT queue, int capacity) {
        if (capacity <= queue.elements.length) {
            return;
        }
        Object[] newElements = new Object[2 * capacity];
        if (queue.head == 0) {
            for (int i = 0; i < queue.size; i++) {
                newElements[i] = queue.elements[i];
            }
            queue.elements = newElements;
        } else {
            for (int i = queue.head; i < queue.elements.length; i++) {
                newElements[i - queue.head] = queue.elements[i];
            }
            for (int i = 0; i <= (queue.head + queue.size) % queue.elements.length; i++) {
                newElements[i + queue.elements.length - queue.head] = queue.elements[i];
            }
            queue.head = 0;
            queue.elements = newElements;
        }
    }

    // Предусловие: очередь не пуста
    // Постусловие: первый элемент удален из очереди и возвращен
    public static Object dequeue(ArrayQueueADT queue) {
        assert queue.size > 0;
        Object x = queue.elements[queue.head];
        queue.head = (queue.head + 1) % queue.elements.length;
        queue.size--;
        return x;
    }

    // Предусловие: очередь не пуста
    // Постусловие: ничего не меняется
    public static Object element(ArrayQueueADT queue) {
        assert queue.size > 0;
        return queue.elements[queue.head];
    }

    // Предусловие: ничего не требуется
    // Постусловие: возвращается текущий размер очереди
    public static int size(ArrayQueueADT queue) {
        return queue.size;
    }

    // Предусловие: ничего не требуется
    // Постусловие: возвращается true, если очередь пуста, и false в противном случае
    public static boolean isEmpty(ArrayQueueADT queue) {
        return queue.size == 0;
    }

    // Предусловие: ничего не требуется
    // Постусловие: все элементы удалены, размер очереди равен 0
    public static void clear(ArrayQueueADT queue) {
        Object[] newElements = new Object[5];
        queue.elements = newElements;
        queue.size = 0;
        queue.head = 0;
    }

    // Предусловие: ничего не требуется
    // Постусловие: возвращается строка с элементами очереди
    public static String toStr(ArrayQueueADT queue) {
        StringBuilder str = new StringBuilder("[");
        if (queue.size == 0) return "[]";
        if (queue.head < (queue.head + queue.size) % queue.elements.length) {
            for (int i = queue.head; i < (queue.head + queue.size) % queue.elements.length; i++) {
                str.append(queue.elements[i].toString());
                str.append(", ");
            }
        } else {
            for (int i = queue.head; i < queue.elements.length; i++) {
                str.append(queue.elements[i].toString());
                str.append(", ");
            }
            for (int i = 0; i < (queue.head + queue.size) % queue.elements.length; i++) {
                str.append(queue.elements[i].toString());
                str.append(", ");
            }
        }
        str.delete(str.length() - 2, str.length());
        str.insert(str.length(), ']');
        return str.toString();
    }
    public static void main(String[] args) {
        ArrayQueueADT queue = new ArrayQueueADT();

        //input
        for (int i = 0; i < 10; i++) {
            ArrayQueueADT.enqueue(queue, i);
        }
        System.out.println(ArrayQueueADT.toStr(queue));

        //pop half
        for (int i = 0; i < 5; i++) {
            ArrayQueueADT.dequeue(queue);
        }
        System.out.println(ArrayQueueADT.toStr(queue));

        //input half
        for (int i = 0; i < 5; i++) {
            ArrayQueueADT.enqueue(queue, i);
        }
        System.out.println(ArrayQueueADT.toStr(queue));

        //input more
        for (int i = 100; i < 108; i++) {
            ArrayQueueADT.enqueue(queue, i);
        }
        System.out.println(ArrayQueueADT.toStr(queue));
    }
}