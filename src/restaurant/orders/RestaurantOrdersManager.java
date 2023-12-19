package restaurant.orders;

import restaurant.menuitems.Item;
import restaurant.exceptions.*;

public class RestaurantOrdersManager implements OrdersManager {
    Order[] orders;

    public RestaurantOrdersManager() {
        this.orders = new Order[16];
    }

    /**
     * Возвращает общее количество позиций с заданным именем во всех заказах.
     *
     * @param itemName Имя позиции.
     * @return Общее количество позиций с заданным именем.
     */
    @Override
    public int itemsQuantity(String itemName) {
        int count = 0;
        for (Order order : orders) {
            count += order.itemsQuantity(itemName);
        }
        return count;
    }

    /**
     * Возвращает общее количество заказов определенной позиции.
     *
     * @param item Позиция меню.
     * @return Общее количество заказанных позиций.
     */
    @Override
    public int itemsQuantity(Item item) {
        return itemsQuantity(item.getName());
    }

    @Override
    public Order[] getOrders() {
        return orders;
    }

    /**
     * Возвращает общую стоимость всех заказов.
     *
     * @return Общая стоимость всех заказов.
     */
    @Override
    public int ordersCostSummary() {
        int sum = 0;
        for (Order order : orders) {
            sum += order.costTotal();
        }
        return sum;
    }

    /**
     * Добавляет заказ к указанному столу.
     *
     * @param order       Заказ.
     * @param tableNumber Номер стола.
     * @throws IllegalTableNumber При выборе несуществующего столика
     * @throws OrderAlreadyAddedException При выборе столика, к которому уже привязан заказ
     */
    public void add(Order order, int tableNumber) throws IllegalTableNumber, OrderAlreadyAddedException {
        if (tableNumber < 1 || tableNumber > 15) throw new IllegalTableNumber("Столик с таким номером недоступен");
        if (orders[tableNumber] == null) {
            orders[tableNumber] = order;
        } else {
            throw new OrderAlreadyAddedException("К указанному столику уже привязан заказ");
        }
    }

    public void addItem(Item item, int tableNumber) throws OrderAlreadyAddedException {
        if (orders[tableNumber] == null) {
            orders[tableNumber] = new RestaurantOrder();
            orders[tableNumber].add(item);
        } else {
            throw new OrderAlreadyAddedException("К указанному столику уже привязан заказ");
        }
    }


    /**
     * Возвращает номер первого свободного стола.
     *
     * @return Номер свободного стола или -1, если все столы заняты.
     */
    public int freeTableNumber() {
        for (int i = 1; i < 16; i++) {
            if (orders[i] == null) return i;
        }
        return -1;
    }

    /**
     * Возвращает массив номеров свободных столов.
     *
     * @return Массив номеров свободных столов.
     */
    public int[] freeTableNumbers() {
        int count = 0;
        for (int i = 1; i < 16; i++) {
            if (orders[i] == null) count++;
        }
        int[] freeTables = new int[count];
        int j = 1;
        for (int i = 1; i < 16; i++) {
            if (orders[i] == null) freeTables[j] = i;
            j++;
        }
        return freeTables;
    }

    /**
     * Возвращает заказ для указанного стола.
     *
     * @param tableNumber Номер стола.
     * @return Заказ для указанного стола или null, если стол пуст.
     * @throws IllegalTableNumber При указании несуществуюшего номера столика
     */
    public Order getOrder(int tableNumber) throws IllegalTableNumber {
        if (tableNumber < 1 || tableNumber > 15) throw new IllegalTableNumber("Столик с таким номером недоступен");
        return orders[tableNumber];
    }

    /**
     * Удаляет заказ с указанного стола.
     *
     * @param tableNumber Номер стола.
     * @throws IllegalTableNumber При указании несуществуюшего номера столика
     */
    public void remove(int tableNumber) throws IllegalTableNumber {
        if (tableNumber < 1 || tableNumber > 15) throw new IllegalTableNumber("Столик с таким номером недоступен");
        orders[tableNumber] = null;
    }

    /**
     * Удаляет указанный заказ.
     *
     * @param order Указанный заказ.
     * @return Номер стола, с которого был удален заказ, или -1, если заказ не найден.
     */
    int remove(Order order) {
        for (int i = 1; i < orders.length; i++) {
            if (orders[i].equals(order)) {
                remove(orders[i]);
                return i;
            }
        }
        return -1;
    }

    /**
     * Удаляет все вхождения указанного заказа.
     *
     * @param order Указанный заказ.
     * @return Количество удаленных заказов.
     */
    public int removeAll(Order order) {
        int count = 0;
        for (int i = 1; i < orders.length; i++) {
            if (orders[i].equals(order)) {
                remove(orders[i]);
                count++;
            }
        }
        return count;
    }
}