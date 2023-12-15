package restaurant.orders;

import restaurant.customer.Customer;
import restaurant.menuitems.Item;

public interface Order {
    boolean add(Item item);
    String[] itemsName();
    int itemsQuantity();
    int itemsQuantity(String itemName);
    int itemsQuantity(Item item);
    Item[] getItems();
    boolean remove(String itemName);
    boolean remove(Item item);
    int removeAll(String itemName);
    int removeAll(Item item);
    Item[] sortedItemsByCostDesc();
    int costTotal();
    Customer getCustomer();
    void setCustomer(Customer customer);

}