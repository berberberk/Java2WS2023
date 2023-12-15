package pr6;

public class TestFurnitureShop {
    public static void main(String[] args) {
        FurnitureShop shop = new FurnitureShop("Sofa Paradise", "Salesman");
        FurnitureForSale sofa1 = new FurnitureForSale("Берлинец", "Кожа", "Диван", 45000);
        FurnitureForSale sofa2 = new FurnitureForSale("Жоли", "Флок", "Диван", 50000);
        FurnitureForSale chair = new FurnitureForSale("Антуан", "Дерево", "Стул", 6000);
        FurnitureForSale bed = new FurnitureForSale("Жанна", "Металл", "Кровать", 55000);
        shop.receipt(sofa1);
        shop.receipt(sofa2);
        shop.receipt(chair);
        shop.displayInfo();
        shop.setAccessMode("Customer");
        shop.checkPrice("Жоли", 53000);
        shop.setAccessMode("Salesman");
        shop.checkPrice("Жоли", 53000);
        shop.receipt(bed);
        shop.addToCart("Берлинец");
        shop.setAccessMode("Customer");
        shop.addToCart("Берлинец");
        shop.addToCart("Жанна");
        shop.showCart();
        shop.clearCart();
        shop.showCart();
        shop.displayInfo("Жоли");
        shop.addToCart("Жоли");
        shop.displayInfo("Жанна");
        shop.addToCart("Ж Цена: анна");
        shop.displayInfo("Антуан");
        shop.addToCart("Антуан");
        shop.showCart();
        shop.buyFurniture();
    }
}
