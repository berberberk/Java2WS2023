package pr22.chair;

public class Client {
    private Chair chair = new Chair.MagicChair();

    public void sit() {
        System.out.println("Клиент сидит на стуле. Описание стула: " + chair);
    }

    public void setChair(Chair chair) {
        this.chair = chair;
    }
}
