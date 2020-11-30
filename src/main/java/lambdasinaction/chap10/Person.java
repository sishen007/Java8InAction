package lambdasinaction.chap10;

import java.util.*;

public class Person {

    private Optional<Car> car;

    public Optional<Car> getCar() {
        return car;
    }

    private Integer age;
    public Integer getAge(){
        return this.age;
    }
}
