package restaurant.menuitems;

public interface Item extends Comparable<Item>{
    /**
     * Получить стоимость позиции.
     *
     * @return Стоимость позиции.
     */
    int getCost();

    /**
     * Получить название позиции.
     *
     * @return Название позиции.
     */
    String getName();

    /**
     * Получить описание позиции.
     *
     * @return Описание позиции.
     */
    String getDescription();

    /**
     * Возвращает информацию об объекте в строковом формате.
     *
     * @return Строковое описание объекта.
     */
    String toString();
}

