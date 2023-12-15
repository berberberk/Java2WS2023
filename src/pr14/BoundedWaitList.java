package pr14;
import java.util.Collection;
/**
 * Реализация ограниченного листа ожидания, наследующая функционал от {@link WaitList}.
 *
 * @param <E> Тип элементов в листе ожидания.
 */
public class BoundedWaitList<E> extends WaitList<E> {
    /**
     * Максимальная вместимость листа ожидания.
     */
    private final int capacity;
    /**
     * Конструктор для создания пустого ограниченного листа ожидания с указанной вместимостью.
     *
     * @param capacity Максимальная вместимость листа ожидания.
     * @throws IllegalArgumentException Если вместимость меньше или равна 0.
     */
    public BoundedWaitList(int capacity) {
        super();
        if (capacity <= 0)
            throw new IllegalArgumentException("Максимальный размер должен быть больше 0! Получено значение: " + capacity);
        this.capacity = capacity;
    }
    /**
     * Конструктор для создания ограниченного листа ожидания с указанной коллекцией и её размером вместимости.
     *
     * @param col Коллекция для инициализации листа ожидания.
     */
    public BoundedWaitList(Collection<E> col) {
        super(col);
        this.capacity = col.size();
    }
    /**
     * Возвращает максимальную вместимость листа ожидания.
     *
     * @return Максимальная вместимость листа ожидания.
     */
    public int getCapacity() {
        return capacity;
    }
    /**
     * Добавляет элемент в ограниченный лист ожидания.
     *
     * @param element Элемент для добавления.
     * @throws IllegalStateException Если лист ожидания заполнен и не может принять новый элемент.
     */
    @Override
    public void add(E element) {
        if (components.size() == capacity) throw new IllegalStateException("Очередь заполнена!");
        components.add(element);
    }
    /**
     * Возвращает строковое представление объекта BoundedWaitList.
     *
     * @return Строковое представление объекта BoundedWaitList.
     */
    @Override
    public String toString() {
        return "BoundedWaitList{" +
                "capacity=" + capacity +
                ", components=" + components +
                '}';
    }
}
