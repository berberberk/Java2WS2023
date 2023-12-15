package pr9.priceable;

public interface Priceable {
    int getPrice();

    class Cinnabon implements Priceable {
        private int price;
        public Cinnabon(int price){
            this.price = price;
        }
        public int getPrice() {
            return this.price;
        }
    }

    class Socks implements Priceable {
        private int price;
        public Socks(int price){
            this.price = price;
        }
        public int getPrice() {
            return this.price;
        }
    }
}
