package design.builder.v3;

public class Main {
    public static void main(String[] args) {
        Person person = new Person.Builder("fatpo", "man")
                .age("18")
                .money("10000000")
                .car("bmw")
                .career("IT")
                .build();

        System.out.println(person);
    }
}


/**
 * 不可变对象，Person
 */
class Person {
    /**
     * 不可变，必须
     */
    private final String name;

    /**
     * 不可变，必须
     */
    private final String sex;

    /**
     * 不可变，非必须
     */
    private final String age;

    /**
     * 不可变，非必须
     */
    private final String shoes;

    /**
     * 不可变，非必须
     */
    private final String clothes;

    /**
     * 不可变，非必须
     */
    private final String money;

    /**
     * 不可变，非必须
     */
    private final String car;

    /**
     * 不可变，非必须
     */
    private final String house;

    /**
     * 不可变，非必须
     */
    private final String career;


    private Person(Builder builder) {
        this.name = builder.name;
        this.sex = builder.sex;
        this.age = builder.age;
        this.shoes = builder.shoes;
        this.clothes = builder.clothes;
        this.money = builder.money;
        this.car = builder.car;
        this.house = builder.house;
        this.career = builder.career;
    }

    public static class Builder {
        private final String name;
        private final String sex;
        private String age;
        private String shoes;
        private String clothes;
        private String money;
        private String car;
        private String house;
        private String career;

        public Builder(String name, String sex) {
            this.name = name;
            this.sex = sex;
        }

        public Builder age(String age) {
            this.age = age;
            return this;
        }

        public Builder shoes(String shoes) {
            this.shoes = shoes;
            return this;
        }

        public Builder clothes(String clothes) {
            this.clothes = clothes;
            return this;
        }

        public Builder money(String money) {
            this.money = money;
            return this;
        }

        public Builder car(String car) {
            this.car = car;
            return this;
        }

        public Builder career(String career) {
            this.career = house;
            return this;
        }

        public Builder house(String house) {
            this.house = house;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }

}