package apackage;

import java.util.Optional;

public class Person1 {
    private Optional<Car1> car = Optional.empty();

    public Optional<Car1> getCar() {
        return car;
    }
}
