package pr22.chair;

public interface Chair {
    String toString();

    class VictorianChair implements Chair {
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
    class MagicChair implements Chair {
        public void doMagic() {
            System.out.println("Вы стали свидетелем самой настоящей магии, совершенной непримечательным на вид стулом!");
        }

        @Override
        public String toString() {
            return "Обыкновенный магический стул";
        }
    }
    class FunctionalChair implements Chair {
        public int sum(int a, int b) {
            return a + b;
        }
        @Override
        public String toString() {
            return "Многофункциональный стул с функцией калькулятора. Но не стоит ожидать многого, это по-прежнему лишь стул.";
        }
    }
}
