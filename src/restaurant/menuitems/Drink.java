package restaurant.menuitems;

public final class Drink implements Item {
    private static final int DEFAULT_COST = 0; // Стоимость по умолчанию

    private final Integer cost;
    private final String name;
    private final String description;

    /**
     * Конструктор для создания напитка с названием и описанием.
     *
     * @param name        Название напитка.
     * @param description Описание напитка.
     */
    public Drink(String name, String description) {
        this(DEFAULT_COST, name, description);
    }

    /**
     * Конструктор для создания напитка с указанной стоимостью, названием и описанием.
     *
     * @param cost        Стоимость напитка.
     * @param name        Название напитка.
     * @param description Описание напитка.
     */
    public Drink(int cost, String name, String description) {
        this.cost = cost;
        this.name = name;
        this.description = description;
    }

    /**
     * Получить стоимость напитка.
     *
     * @return Стоимость напитка.
     */
    @Override
    public int getCost() {
        return cost;
    }

    /**
     * Получить название напитка.
     *
     * @return Название напитка.
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Получить описание напитка.
     *
     * @return Описание напитка.
     */
    @Override
    public String getDescription() {
        return description;
    }

    /**
     * Возвращает информацию о напитке в строковом формате.
     *
     * @return Строковое описание напитка.
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

