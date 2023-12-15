package pr22.chair;

import pr22.chair.Chair;

public class VictorianChair implements Chair {
    private int age;

    public VictorianChair(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString(){
        return ("Викторианский стул, которому " + age + " лет!");
    }
}
