package apackage;

import java.util.Optional;

public class TestPerson1 {
    public String getCarInSuranceName(Optional<Person1> person1) {
        return person1.flatMap(Person1::getCar)
                .flatMap(Car1::getInsurance)
                .map(Insurance1::getName)
                .orElse("Unknown");
    }

    public static void main(String[] args) {
        System.out.println( new TestPerson1().getCarInSuranceName(Optional.ofNullable(new Person1())));
    }
}
