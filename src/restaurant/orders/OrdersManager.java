package restaurant.orders;

import restaurant.menuitems.Item;

import java.util.HashMap;
import java.util.Map;

public interface OrdersManager {
    Map<String, Order> ordersHashMap = new HashMap<>();
    int itemsQuantity(String itemName);
    int itemsQuantity(Item item);
    Order[] getOrders();
    int ordersCostSummary();
}