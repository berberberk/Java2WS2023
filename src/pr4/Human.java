package pr4;

public class Human {
    private String name;
    private int age;
    private final char sex;
    public Human(String name, int age, char sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
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
    public void setAge(int age) {
        if (0 < age && age < 100) {
            this.age = age;
        }
    }
    public char getSex() {
        return this.sex;
    }
    @Override
    public String toString() {
        return "Имя: " + this.name + ", Возраст: " + this.age + ", Пол: " + this.sex;
    }

    public class Head {
        private String thought;

        public String getThought() {
            return this.thought;
        }

        public void think(String thought) {
            this.thought = thought;
        }
    }

    public class Hand {
        private boolean clap;
        public void setState(boolean clap) {
            this.clap = clap;
        }
        public void getState() {
            if (this.clap) {
                System.out.println("Хлопает в ладоши");
            }
            else {
                System.out.println("Руки отдыхают");
            }
        }
    }

    public class Leg {
        private boolean run;
        public void setState(boolean run) {
            this.run = run;
        }
        public void getState() {
            if (run) {
                System.out.println("Бежит");
            }
            else {
                System.out.println("Ноги отдыхают");
            }
        }
    }
}
