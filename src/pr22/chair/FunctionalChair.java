package pr22.chair;

import pr22.chair.Chair;

public class FunctionalChair implements Chair {
    public int sum(int a, int b) {
        return a + b;
    }

    @Override
    public String toString() {
        return "Многофункциональный стул с функцией калькулятора. Но не стоит ожидать многого, это по-прежнему лишь стул.";
    }
}
