package restaurant.menuitems;

public final class Dish implements Item {
    private static final int DEFAULT_COST = 0; // Стоимость по умолчанию

    private final Integer cost;
    private final String name;
    private final String description;

    /**
     * Конструктор для создания блюда с названием и описанием.
     *
     * @param name        Название напитка.
     * @param description Описание напитка.
     */
    public Dish(String name, String description) {
        this(DEFAULT_COST, name, description);
    }

    /**
     * Конструктор для создания блюда с указанной стоимостью, названием и описанием.
     *
     * @param cost        Стоимость блюда.
     * @param name        Название блюда.
     * @param description Описание блюда.
     */
    public Dish(int cost, String name, String description) {
        this.cost = cost;
        this.name = name;
        this.description = description;
    }

    /**
     * Получить стоимость блюда.
     *
     * @return Стоимость блюда.
     */
    @Override
    public int getCost() {
        return cost;
    }

    /**
     * Получить название блюда.
     *
     * @return Название блюда.
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Получить описание блюда.
     *
     * @return Описание блюда.
     */
    @Override
    public String getDescription() {
        return description;
    }

    /**
     * Возвращает информацию о блюда в строковом формате.
     *
     * @return Строковое описание блюда.
     */
    @Override
    public String toString() {
        return name + ": " + description + ". Цена: " + cost;
    }

    /**
     * Возвращает результат сравнения с другим объектом по цене.
     *
     * @return Результат сравнения.
     */
    @Override
    public int compareTo(Item o) {
        return -(cost.compareTo(o.getCost()));
    }
}

