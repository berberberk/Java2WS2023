package pr14;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Реализация интерфейса {@link IWaitList} с использованием очереди на основе ConcurrentLinkedQueue.
 *
 * @param <E> Тип элементов, хранящихся в очереди.
 */
public class WaitList<E> implements IWaitList<E> {
    /**
     * Очередь для хранения элементов.
     */
    protected ConcurrentLinkedQueue<E> components;

    /**
     * Конструктор по умолчанию, инициализирующий пустую очередь.
     */
    public WaitList() {
        components = new ConcurrentLinkedQueue<>();
    }

    /**
     * Конструктор, инициализирующий очередь элементами из переданной коллекции.
     *
     * @param collection Коллекция элементов для инициализации очереди.
     */
    public WaitList(Collection<E> collection) {
        components = new ConcurrentLinkedQueue<>(collection);
    }

    /**
     * Возвращает строковое представление объекта WaitList.
     *
     * @return Строковое представление объекта WaitList.
     */
    @Override
    public String toString() {
        return "WaitList{" +
                "components=" + components +
                '}';
    }

    /**
     * Добавляет элемент в конец очереди.
     *
     * @param element Элемент для добавления в очередь.
     */
    @Override
    public void add(E element) {
        components.add(element);
    }

    /**
     * Удаляет и возвращает элемент из начала очереди.
     *
     * @return Удаленный элемент.
     * @throws IllegalStateException Если очередь пуста.
     */
    @Override
    public E remove() {
        if (isEmpty()) throw new IllegalStateException("Очередь пуста!");
        return components.remove();
    }
    /**
     * Проверяет, содержится ли указанный элемент в очереди.
     *
     * @param element Элемент для проверки.
     * @return true, если элемент содержится в очереди, иначе false.
     */
    @Override
    public boolean contains(E element) {
        boolean res = false;
        for (int i = 0; i < components.size(); i++) {
            E el = components.remove();
            if (el.equals(element)) res = true;
            components.add(el);
        }
        return res;
    }
    /**
     * Проверяет, содержатся ли все элементы указанной коллекции в очереди.
     *
     * @param collection Коллекция для проверки.
     * @return true, если все элементы коллекции содержатся в очереди, иначе false.
     */
    @Override
    public boolean containsAll(Collection<E> collection) {
        ArrayList<E> al = new ArrayList<>(collection);
        for (int i = 0; i < collection.size(); i++) {
            boolean res = false;
            for (int j = 0; j < components.size(); j++) {
                E el = components.remove();
                if (el.equals(al.get(i))) res = true;
                components.add(el);
            }
            if (!res) return false;
        }
        return true;
    }
    @Override
    public boolean isEmpty() {
        return components.isEmpty();
    }
}