package restaurant;

import restaurant.customer.Address;
import restaurant.customer.Customer;
import restaurant.menuitems.Dish;
import restaurant.menuitems.Drink;
import restaurant.menuitems.Item;
import restaurant.orders.*;

import java.util.Arrays;

public class TestRestaurant {
    public static void main(String[] args) {
        Address address = new Address("Москва,Цветной бульвар,127051,2,78,С");
        System.out.println(address);
        Customer myself = new Customer("Тарас", "Педченко", 18, address);
        Order order1 = new RestaurantOrder(myself);
        Item cola = new Drink(150, "Добрый Кола", "Самая добрая версия всемирно известного напитка");
        System.out.println(cola);
        order1.add(cola);
        Item macncheese = new Dish(330, "Макароны с сыром", "Дальний родственник итальянской пасты родом из США");
        order1.add(macncheese);
        order1.add(macncheese);
        System.out.println("Количество позиций <Макароны с сыром> в заказе: " + order1.itemsQuantity("Макароны с сыром"));
        RestaurantOrdersManager manager1 = new RestaurantOrdersManager();
        System.out.println("Свободные столики в ресторане: " + manager1.freeTableNumber());
        manager1.add(order1, 12);
        System.out.println(Arrays.toString(manager1.getOrder(12).itemsName()));
        Order order2 = new InternetOrder(myself);
        Item bumble = new Drink(220, "Бамбл-кофе", "Освежающий напиток на основе эспрессо и апельсинового фреша");
        order2.add(bumble);
        InternetOrdersManager manager2 = new InternetOrdersManager();
        manager2.add(order2);
        manager2.add(order1);
        System.out.println(manager2.ordersCostSummary());



    }

}
