package pr6;

public abstract class Dish {
    private String name;
    private String material;

    public Dish(String name, String material) {

        this.name = name;
        this.material = material;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getMaterial() {
        return this.material;
    }
    public void setMaterial(String material) {
        this.material = material;
    }
    public abstract void displayInfo();
}

class Plate extends Dish {
    private String color;

    public Plate(String name, String material, String color) {
        super(name, material);
        this.color = color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getColor() {
        return this.color;
    }
    public void displayInfo() {
        System.out.println("Посуда: " + super.getName() + ", Материал: " + super.getMaterial() + ", Цвет: " + color);
    }
}

class Fork extends Dish {
    private int nibs;

    public Fork(String name, String material, int nibs) {
        super(name, material);
        this.nibs = nibs;
    }
    public void setNibs(int nibs) {
        this.nibs = nibs;
    }
    public int getNibs() {
        return this.nibs;
    }
    public void displayInfo() {
        System.out.println("Посуда: " + super.getName() + ", Материал: " + super.getMaterial() + ", Количество зубьев: " + this.nibs);
    }
}

class Spoon extends Dish {
    private String type;

    public Spoon(String name, String material, String type) {
        super(name, material);
        this.type = type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getType() {
        return this.type;
    }
    public void displayInfo() {
        System.out.println("Посуда: " + super.getName() + ", Материал: " + super.getMaterial() + ", Тип: " + this.type);
    }
}
