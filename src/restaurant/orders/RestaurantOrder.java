package restaurant.orders;

import restaurant.customer.Customer;
import restaurant.menuitems.Item;

import java.util.HashSet;

public class RestaurantOrder implements Order {
    int size = 0;
    private Item[] items;
    private Customer customer;

    public RestaurantOrder(Customer customer) {
        this.items = new Item[0];
        this.customer = customer;
    }

    public RestaurantOrder() {
        this.items = new Item[0];
    }

    /**
     * Добавляет позицию в заказ.
     *
     * @param item Добавляемая позиция.
     * @return true, если позиция успешно добавлена, иначе false.
     */
    @Override
    public boolean add(Item item) {
        if (item == null) return false;
        Item[] newItemsList = new Item[size + 1];
        System.arraycopy(items, 0, newItemsList, 0, items.length);
        newItemsList[items.length] = item;
        items = newItemsList;
        size++;
        return true;
    }

    /**
     * Возвращает массив названий всех позиций в заказе.
     *
     * @return Массив названий позиций.
     */
    @Override
    public String[] itemsName() {
        HashSet<String> hashNames = new HashSet<>(size);
        for (int i = 0; i < size; i++) {
            hashNames.add(items[i].getName());
        }
        String[] names = new String[hashNames.size()];
        return hashNames.toArray(names);
    }

    /**
     * Возвращает количество позиций в заказе.
     *
     * @return Количество позиций в заказе.
     */
    @Override
    public int itemsQuantity() {
        return size;
    }

    /**
     * Возвращает количество позиций с указанным названием в заказе.
     *
     * @param itemName Название позиции.
     * @return Количество позиций с указанным названием.
     */
    @Override
    public int itemsQuantity(String itemName) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (items[i].getName().equals(itemName)) count++;
        }
        return count;
    }

    /**
     * Возвращает количество позиций в заказе с указанным объектом Item.
     *
     * @param item Позиция в заказе.
     * @return Количество позиций с указанным объектом Item.
     */
    @Override
    public int itemsQuantity(Item item) {
        return itemsQuantity(item.getName());
    }

    /**
     * Возвращает массив всех позиций в заказе.
     *
     * @return Массив позиций в заказе.
     */
    @Override
    public Item[] getItems() {
        return items;
    }

    /**
     * Удаляет позицию с указанным названием из заказа.
     *
     * @param itemName Название позиции.
     * @return true, если позиция успешно удалена, иначе false.
     */
    @Override
    public boolean remove(String itemName) {
        int index = -1;
        for (int i = 0; i < items.length; i++) {
            if (items[i].getName().equals(itemName)) {
                index = i;
            }
        }
        if (index == -1) return false;
        Item[] temp = items;
        items = new Item[temp.length - 1];
        System.arraycopy(temp, 0, items, 0, index);
        System.arraycopy(temp, index + 1, items, index, temp.length - index - 1);
        size--;
        return false;
    }

    /**
     * Удаляет позицию из заказа.
     *
     * @param item Позиция.
     * @return true, если позиция успешно удалена, иначе false.
     */
    @Override
    public boolean remove(Item item) {
        return remove(item.getName());
    }

    /**
     * Удаляет все позиции с указанным названием из заказа.
     *
     * @param itemName Название позиции.
     * @return Количество удаленных позиций.
     */
    @Override
    public int removeAll(String itemName) {
        int count = 0;
        while (contains(itemName)) {
            remove(itemName);
        }
        return count;
    }

    /**
     * Удаляет все позиции из заказа с указанным объектом Item.
     *
     * @param item Позиция в заказе.
     * @return Количество удаленных позиций.
     */
    @Override
    public int removeAll(Item item) {
        return removeAll(item.getName());
    }

    /**
     * Проверяет, содержится ли позиция с указанным названием в заказе.
     *
     * @param itemName Название позиции.
     * @return true, если позиция содержится в заказе, иначе false.
     */
    public boolean contains(String itemName) {
        for (int i = 0; i < size; i++) {
            if (items[i].getName().equals(itemName)) return true;
        }
        return false;
    }

    /**
     * Возвращает массив позиций, отсортированных по убыванию стоимости.
     *
     * @return Массив позиций, отсортированных по убыванию стоимости.
     */
    @Override
    public Item[] sortedItemsByCostDesc() {
        Item[] items = this.getItems();
        int min;
        int j;
        for (int i = 1; i < items.length; i++) {
            min = i;
            Item tmp = items[i];
            for (j = i; j > 0 && (tmp.compareTo(items[j - 1]) < 0); j--) {
                items[j] = items[j - 1];
            }
            items[j] = tmp;
        }
        return items;
    }

    /**
     * Возвращает общую стоимость заказа.
     *
     * @return Стоимость заказа.
     */
    @Override
    public int costTotal() {
        int cost = 0;
        for (int i = 0; i < size; i++) {
            cost += items[i].getCost();
        }
        return cost;
    }

    public int getSize(){
        return size;
    }

    @Override
    public Customer getCustomer() {
        return this.customer;
    }

    @Override
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}