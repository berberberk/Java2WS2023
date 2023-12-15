package pr6;

public abstract class Furniture {
    protected String name;
    private String material;
    public Furniture(String name, String material){
        this.name = name;
        this.material = material;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getMaterial() {
        return material;
    }
    public void setMaterial(String material) {
        this.material = material;
    }
    public abstract String displayPrice();
    public abstract void displayInfo();
}

class FurnitureForSale extends Furniture {
    private String type;
    private float price;

    public FurnitureForSale(String name, String material, String type, float price) {
        super(name, material);
        this.type = type;
        this.price = price;
    }
    public float getPrice() {
        return this.price;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    public String displayPrice() {
        return "Товар стоит " + this.price;
    }
    public void displayInfo() {
        System.out.println("Вид мебели: " + this.type + ", Наименование: " + super.getName()
                + ", Материал: " + super.getMaterial() + ", Цена: " + this.price);
    }
}
