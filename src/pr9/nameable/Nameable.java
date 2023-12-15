package pr9.nameable;

public interface Nameable {
    String getName();

    class City implements Nameable {
        private String name;
        public City(String name){
            this.name = name;
        }
        public String getName() {
            return this.name;
        }
    }

    class Dog implements Nameable {
        private String breed;
        public Dog(String breed){
            this.breed = breed;
        }
        public String getName() {
            return this.breed;
        }
    }

    class Planet implements Nameable {
        private String name;
        public Planet(String name){
            this.name = name;
        }
        public String getName() {
            return this.name;
        }
    }
}
