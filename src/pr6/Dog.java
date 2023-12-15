package pr6;

public abstract class Dog {
    private String name;
    private int age;
    private String color;

    public Dog(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return this.age;
    }
    public String getColor() {
        return this.color;
    }
    public abstract String getBreed();
    public abstract void displayInfo();
}

class Breed extends Dog {
    private String breed;

    public Breed(String name, int age, String color, String breed) {
        super(name, age, color);
        this.breed = breed;
    }
    public String getBreed(){
        return this.breed;
    }
    public void displayInfo() {
        System.out.println("Порода: " + this.breed + ", Имя: " + super.getName() + ", Возраст:] " + super.getAge() + ", " +
                "Цвет: " + super.getColor());
    }
}
