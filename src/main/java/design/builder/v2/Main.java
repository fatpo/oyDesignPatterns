package design.builder.v2;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("fatpo", "man");
        System.out.println(person);

        Person person2 = new Person("fatpo", "man", null, null, null, null, "bmw", "shenzen", null);
        System.out.println(person2);
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
    private final Integer age;

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

    Person(String name, String sex, Integer age, String shoes, String clothes, String money, String car, String house, String career) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.shoes = shoes;
        this.clothes = clothes;
        this.money = money;
        this.car = car;
        this.house = house;
        this.career = career;
    }

    Person(String name, String sex) {
        this(name, sex, null, null, null, null, null, null, null);
    }
}