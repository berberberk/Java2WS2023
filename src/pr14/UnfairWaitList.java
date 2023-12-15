package pr14;

/**
 * Реализация листа ожидания с нечестными методами, наследующая функционал от {@link WaitList}.
 *
 * @param <E> Тип элементов в листе ожидания.
 */
public class UnfairWaitList<E> extends WaitList<E> {

    /**
     * Конструктор для создания пустого листа ожидания.
     */
    public UnfairWaitList() {
        super();
    }

    /**
     * Удаляет первое вхождение указанного элемента из листа ожидания и перемещает его в конец.
     *
     * @param element Элемент для удаления и перемещения.
     */
    public void remove(E element) {
        boolean removed = false;
        for (int i = 0; i < components.size(); i++) {
            E el = components.remove();
            if (!removed && el.equals(element)) {
                removed = true;
            } else {
                components.add(el);
            }
        }
        if (removed) {
            components.add(components.remove());
        }
    }

    /**
     * Удаляет первое вхождение указанного элемента из листа ожидания и перемещает его в конец.
     *
     * @param element Элемент для перемещения в конец.
     */
    public void moveToBack(E element) {
        int prevSize = components.size();
        remove(element);
        if (components.size() < prevSize) {
            components.add(element);
        }
    }
}

