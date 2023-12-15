package restaurant.orders;

import restaurant.customer.Customer;
import restaurant.menuitems.Item;

import java.util.HashSet;
import java.util.Objects;

public class InternetOrder implements Order{
    private int size = 0;
    private int totalCost = 0;
    private ListNode head;
    private ListNode tail;
    private Customer customer;

    public InternetOrder(Customer customer) {
        this.customer = customer;
    }

    /**
     * Добавляет позицию в интернет-заказ.
     *
     * @param item Добавляемая позиция.
     * @return true, если позиция успешно добавлена, иначе false.
     */
    @Override
    public boolean add(Item item) {
        if(item == null){
            return false;
        }
        if (size == 0) {
            head = new ListNode(null, item, null);
            tail = head;
        } else {
            ListNode secondLast = tail;
            tail = new ListNode(secondLast, item, null);
            secondLast.next = tail;
        }
        size++;
        totalCost += item.getCost();
        return true;
    }

    /**
     * Возвращает массив названий всех позиций в интернет-заказе.
     *
     * @return Массив названий позиций.
     */
    @Override
    public String[] itemsName() {
        HashSet<String> hashNames = new HashSet<>(size);
        String[] names = new String[size];
        ListNode tmp = head;
        for(int i = 0; i < size; i++){
            hashNames.add(tmp.item.getName());
            tmp = tmp.next;
        }

        return hashNames.toArray(names);
    }

    /**
     * Возвращает количество позиций в интернет-заказе.
     *
     * @return Количество позиций в интернет-заказе.
     */
    @Override
    public int itemsQuantity() {
        return size;
    }

    /**
     * Возвращает количество позиций с указанным названием в интернет-заказе.
     *
     * @param itemName Название позиции.
     * @return Количество позиций с указанным названием.
     */
    @Override
    public int itemsQuantity(String itemName) {
        int count = 0;
        ListNode tmp = head;
        for(int i = 0; i < size; i++){
            if(tmp.item.getName().equals(itemName)){
                count++;
            }
            tmp = tmp.next;
        }
        return count;
    }

    /**
     * Возвращает количество позиций в интернет-заказе с указанным объектом Item.
     *
     * @param item Позиция в интернет-заказе.
     * @return Количество позиций с указанным объектом Item.
     */
    @Override
    public int itemsQuantity(Item item) {
        return itemsQuantity(item.getName());
    }

    /**
     * Возвращает массив всех позиций в интернет-заказе.
     *
     * @return Массив позиций в интернет-заказе.
     */
    @Override
    public Item[] getItems() {
        Item[] items = new Item[size];
        ListNode tmp = head;
        for(int i = 0; i < size; i++){
            items[i] = tmp.item;
            tmp = tmp.next;
        }
        return items;
    }

    /**
     * Удаляет позицию с указанным названием из интернет-заказа.
     *
     * @param itemName Название позиции.
     * @return true, если позиция успешно удалена, иначе false.
     */
    @Override
    public boolean remove(String itemName) {
        ListNode tmp = head;
        ListNode finding = null;
        for(int i = 0; i < size; i++){
            if(tmp.item.getName().equals(itemName)){
                finding = tmp;
            }
            tmp = tmp.next;
        }
        if(finding == null){
            return false;
        }
        totalCost-= finding.item.getCost();
        ListNode findingPrev = finding.previous;
        ListNode findingNext = finding.next;
        if(findingPrev == null){
            head = findingNext;
        } else if(findingNext == null){
            tail = findingPrev;
        } else {
            findingPrev.next = findingNext;
            findingNext.previous = findingPrev;
        }
        size--;
        return true;
    }

    /**
     * Удаляет позицию из интернет-заказа.
     *
     * @param item Позиция.
     * @return true, если позиция успешно удалена, иначе false.
     */
    @Override
    public boolean remove(Item item) {
        return remove(item.getName());
    }

    /**
     * Удаляет все позиции с указанным названием из интернет-заказа.
     *
     * @param itemName Название позиции.
     * @return Количество удаленных позиций.
     */
    @Override
    public int removeAll(String itemName) {
        int count = 0;
        ListNode tmp = head;
        int tmpSize = size;
        for(int i = 0; i < tmpSize; i++){
            if((tmp!= null) && (tmp.item.getName().equals(itemName))){
                remove(tmp.item);
                count++;
            }
            tmp = tmp.next;
        }
        return count;
    }

    /**
     * Удаляет все позиции из интернет-заказа с указанным объектом Item.
     *
     * @param item Позиция в интернет-заказе.
     * @return Количество удаленных позиций.
     */
    @Override
    public int removeAll(Item item) {
        return removeAll(item.getName());
    }

    /**
     * Возвращает массив позиций, отсортированных по убыванию стоимости.
     *
     * @return Массив позиций, отсортированных по убыванию стоимости.
     */
    @Override
    public Item[] sortedItemsByCostDesc() {
        Item[] items = getItems();
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

    @Override
    public int costTotal() {
        return totalCost;
    }

    @Override
    public Customer getCustomer() {
        return this.customer;
    }

    @Override
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getSize(){return size;}

    /**
     * Вложенный статический класс, представляющий узел списка для хранения позиций в интернет-заказе.
     */
    private static class ListNode {
        private ListNode previous;
        private Item item;
        private ListNode next;
        public ListNode(ListNode previous, Item item, ListNode next) {
            this.previous = previous;
            this.item = item;
            this.next = next;
        }
    }

    /**
     * Проверяет объект на равенство текущему интернет-заказу. Заказы считаются равными,
     * если их размер, общая стоимость, начальный и конечный узлы списка и заказчик равны.
     *
     * @param o Объект для сравнения с текущим интернет-заказом.
     * @return true, если объекты равны, false в противном случае.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InternetOrder that = (InternetOrder) o;
        return size == that.size && totalCost == that.totalCost && Objects.equals(head, that.head) && Objects.equals(tail, that.tail) && Objects.equals(customer, that.customer);
    }

    /**
     * Вычисляет хэш-код интернет-заказа на основе его размера, общей стоимости,
     * начального и конечного узлов списка и заказчика.
     *
     * @return Хэш-код интернет-заказа.
     */
    @Override
    public int hashCode() {
        return Objects.hash(size, totalCost, head, tail, customer);
    }

    /**
     * Представляет интернет-заказ в виде строки, включая названия всех позиций.
     *
     * @return Строковое представление интернет-заказа.
     */
    @Override
    public String toString() {
        int iMax = itemsName().length - 1;
        if (iMax == -1)
            return "[]";
        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = 0; ; i++) {
            b.append(String.valueOf(itemsName()[i]));
            if (i == iMax)
                return b.append(']').toString();
            b.append(", ");
        }
    }
}