package restaurant;

import restaurant.customer.Address;
import restaurant.customer.Customer;
import restaurant.exceptions.*;
import restaurant.menuitems.Dish;
import restaurant.menuitems.Drink;
import restaurant.menuitems.Item;
import restaurant.orders.*;
import java.util.Scanner;
import java.util.Arrays;

public class TestRestaurant {
    public static void main(String[] args) throws IllegalTableNumber, OrderAlreadyAddedException {
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
        System.out.println("Ближайший к свободный столик в ресторане: " + manager1.freeTableNumber());
        manager1.add(order1, 12);
        System.out.println(Arrays.toString(manager1.getOrder(12).itemsName()));
        Order order2 = new InternetOrder(myself);
        Item bumble = new Drink(220, "Бамбл-кофе", "Освежающий напиток на основе эспрессо и апельсинового фреша");
        order2.add(bumble);
        InternetOrdersManager manager2 = new InternetOrdersManager();
        manager2.add(order2);
        manager2.add(order1);
        System.out.println(manager2.ordersCostSummary());

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите свое имя: ");
        String customerFirstName = sc.nextLine();
        System.out.println("Введите свою фамилию: ");
        String customerSecondName = sc.nextLine();
        System.out.println("Введите свой возраст: ");
        int customerAge = sc.nextInt();
        sc.nextLine();
        System.out.println("Введите свой адрес в формате Город,Улица,Индекс,Дом,Квартира,Литера:");
        String customerAddressString = sc.nextLine();
        Address customerAddress = new Address(customerAddressString);
        Customer customer = new Customer(customerFirstName, customerSecondName, customerAge, customerAddress);
        System.out.println("Выберите тип заказа:\n1. Заказ в зале\n2. Онлайн-заказ");
        int orderType = sc.nextInt();
        switch (orderType) {
            case 1 -> {
                Order customOrder = new RestaurantOrder(customer);
                boolean quit = false;
                while (!quit) {
                    System.out.println("Доступные для заказа позиции меню: " + "\n1." + cola.getName() +
                            "\n2." + macncheese.getName() + "\n3." + bumble.getName() + "\nВведите 0, чтобы завершить заказ");
                    int itemType = sc.nextInt();
                    switch (itemType) {
                        case 0 -> {
                            quit = true;
                        }
                        case 1 -> {
                            customOrder.add(cola);
                        }
                        case 2 -> {
                            customOrder.add(macncheese);
                        }
                        case 3 -> {
                            customOrder.add(bumble);
                        }
                    }
                }
                System.out.println("На какой столик вы бы хотели оформить заказ?");
                int tableNum = sc.nextInt();
                try {
                    manager1.add(customOrder, tableNum);
                }
                catch (IllegalTableNumber e) {
                    System.out.println("К сожалению, был выбран недоступный столик! " +
                            "Мы оформим заказ на ближайший свободный столик. Номер столика: " + manager1.freeTableNumber());
                    manager1.add(customOrder, manager1.freeTableNumber());
                }
                catch (OrderAlreadyAddedException e) {
                    System.out.println("К сожалению, выбранный вами столик уже занят! " +
                            "Мы оформим заказ на ближайший свободный столик. Номер столика: " + manager1.freeTableNumber());
                    manager1.add(customOrder, manager1.freeTableNumber());
                }
                System.out.println("Приятного аппетита! Сумма к оплате: " + customOrder.costTotal());
            }
            case 2 -> {
                Order customOrder = new InternetOrder(customer);
                boolean quit = false;
                while (!quit) {
                    System.out.println("Доступные для заказа позиции меню: " + "\n1." + cola.getName() +
                            "\n2." + macncheese.getName() + "\n3." + bumble.getName() + "\nВведите 0, чтобы завершить заказ");
                    int itemType = sc.nextInt();
                    switch (itemType) {
                        case 0 -> {
                            quit = true;
                        }
                        case 1 -> {
                            customOrder.add(cola);
                        }
                        case 2 -> {
                            customOrder.add(macncheese);
                        }
                        case 3 -> {
                            customOrder.add(bumble);
                        }
                    }
                }
                manager2.add(customOrder);
                System.out.println("Приятного аппетита! Сумма к оплате: " + customOrder.costTotal());
            }
        }
    }

}
