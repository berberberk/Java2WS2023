package pr16;

public class Exception1 {
    public void exceptionDemo() {
        System.out.println(2 / 0);
    }

    public void exceptionDemo2() {
        System.out.println(2.0 / 0.0);
    }

    public void exceptionDemo3() {
        try {
            System.out.println(2 / 0);
        } catch (ArithmeticException e) {
            System.out.println("Attempted division by zero");
        }
    }

    public static void main(String[] args) {
        Exception1 q = new Exception1();
        //q.exceptionDemo();
        //q.exceptionDemo2();
        q.exceptionDemo3();
    }
}

/* Java float и double типы реализуют стандарт IEEE 754
* для чисел с плавающей запятой, где при делении на ноль возвращается бесконечность.
* Выброс исключения фактически нарушил бы этот стандарт.
* Целочисленная арифметика отличается и не имеет специальных значений бесконечности или NaN,
* поэтому создание исключений является полезным поведением.
*/

/* Если разделить double на 0, JVM покажет Infinity .
* Приставка: Infinity
* Если вы разделите int на 0, то JVM выдаст Arithmetic Exception .
* Приставка:Exception in thread "main" java.lang.ArithmeticException: / by zero
* Но если мы разделим int на 0.0, то JVM покажет Infinity:
* Приставка: Infinity
* Это связано с тем, что JVM автоматически вводит приведение int к double,
* поэтому мы получаем бесконечность вместо ArithmeticException.
*/

