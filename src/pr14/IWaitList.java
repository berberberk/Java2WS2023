package pr14;

import java.util.Collection;

/**
 * Интерфейс для представления листов ожидания.
 *
 * @param <E> Тип элементов в листе ожидания.
 */
public interface IWaitList<E> {
    /**
     * Добавляет элемент в лист ожидания.
     *
     * @param element Элемент для добавления.
     */
    void add(E element);

    /**
     * Удаляет и возвращает элемент из листа ожидания.
     *
     * @return Удаленный элемент.
     */
    E remove();

    /**
     * Проверяет, содержится ли указанный элемент в листе ожидания.
     *
     * @param element Элемент для проверки.
     * @return true, если элемент содержится в листе, иначе false.
     */
    boolean contains(E element);

    /**
     * Проверяет, содержатся ли все элементы указанной коллекции в листе ожидания.
     *
     * @param collection Коллекция для проверки.
     * @return true, если все элементы коллекции содержатся в листе, иначе false.
     */
    boolean containsAll(Collection<E> collection);

    /**
     * Проверяет, пуст ли лист ожидания.
     *
     * @return true, если лист ожидания пуст, иначе false.
     */
    boolean isEmpty();
}
