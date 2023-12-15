package pr6;
import java.util.ArrayList;
import java.util.List;

public class FurnitureShop {
    private String accessMode;
    private String shopName;
    private List<FurnitureForSale> assortment = new ArrayList<FurnitureForSale>();
    private List<String> assortmentNames = new ArrayList<String>();
    private List<String> shoppingCart = new ArrayList<String>();

    public FurnitureShop(String shopName, String accessMode) {
        this.accessMode = accessMode;
        this.shopName = shopName;
    }

    public void setAccessMode(String accessMode) {
        this.accessMode = accessMode;
    }

    public void receipt(FurnitureForSale goods) {
        this.assortment.add(goods);
        this.assortmentNames.add(goods.getName());
        System.out.println("Новое поступление товара: " + goods.getName());
    }

    public void checkPrice(String furnitureName, float rightPrice) {
        if (this.accessMode == "Salesman") {
            if (!this.assortmentNames.contains(furnitureName)) {
                System.out.println("Товара " + furnitureName + " нет в ассортименте!");
            } else {
                int i = this.assortmentNames.indexOf(furnitureName);
                FurnitureForSale furnitureObj = this.assortment.get(i);
                if (furnitureObj.getPrice() != rightPrice) {
                    float oldPrice = furnitureObj.getPrice();
                    furnitureObj.setPrice(rightPrice);
                    System.out.println("Цена товара " + furnitureName + " была изменена с " + oldPrice + " на " + furnitureObj.getPrice());
                } else {
                    System.out.println("Цена товара соответствует указанной");
                }
            }
        }
        else {
            System.out.println("Недостаточно прав!");
        }
    }

    public void displayInfo(String furnitureName) {
        int i = this.assortmentNames.indexOf(furnitureName);
        FurnitureForSale furnitureObj = this.assortment.get(i);
        furnitureObj.displayInfo();
    }

    public void addToCart(String furnitureName) {
        if (this.accessMode == "Customer") {
            if (!this.assortmentNames.contains(furnitureName)) {
                System.out.println("Товара " + furnitureName + " нет в ассортименте!");
            }
            else {
                this.shoppingCart.add(furnitureName);
            }
        }
        else {
            System.out.println("Вы находитесь в режиме продавца и не можете взаимодействовать с корзиной.");
        }
    }

    public void showCart() {
        if (this.accessMode == "Customer") {
            if (!this.shoppingCart.isEmpty()) {
                System.out.println("Товары в корзине: " + this.shoppingCart);
            } else {
                System.out.println("В корзине нет товаров!");
            }
        }
        else {
            System.out.println("Вы находитесь в режиме продавца и не можете взаимодействовать с корзиной.");
        }
    }

    public void clearCart() {
        if (this.accessMode == "Customer") {
            if (!this.shoppingCart.isEmpty()) {
                this.shoppingCart.clear();
                System.out.println("Корзина очищена!");
            }
            else { System.out.println("Корзина пуста!");}
        }
        else { System.out.println("Вы находитесь в режиме продавца и не можете взаимодействовать с корзиной."); }
    }
    public void buyFurniture() {
        if (this.accessMode == "Customer") {
            if (this.shoppingCart.isEmpty()) {
                System.out.println("Корзина пуста!");
            }
            else {
                for (int i = 0; i < this.shoppingCart.size(); i++) {
                    int index = this.assortmentNames.indexOf(this.shoppingCart.get(i));
                    this.assortmentNames.remove(index);
                    this.assortment.remove(index);
                    System.out.println("Покупка товара " + shoppingCart.get(i) + " прошла успешно!");
                }
                this.shoppingCart.clear();
                System.out.println("Спасибо за покупку! Приходите еще :)");
            }
        }
        else { System.out.println("Вы находитесь в режиме продавца и не можете совершать покупки."); }
    }
    public void displayInfo() {
        System.out.println("Добро пожаловать в магазин " + this.shopName + "!");
        if (!this.assortmentNames.isEmpty()) {
            System.out.println("Товары в наличии: " + this.assortmentNames);
        }
        else { System.out.println("Магазин пуст!"); }
    }
}