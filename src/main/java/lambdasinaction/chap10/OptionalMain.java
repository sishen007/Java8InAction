package lambdasinaction.chap10;

import java.util.*;

import static java.util.stream.Collectors.toSet;

/**
 * 10.3 Optional
 *
 * @param null
 * @author wangyh2
 * @return
 * @throw
 * @since 2020/11/25 17:04
 */
public class OptionalMain {

    public static void main(String[] args) {
        System.out.println(new OptionalMain().getCarInsuranceName(Optional.empty()));
    }

    public String getCarInsuranceName(Optional<Person> person) {
        return person.flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("Unknown");
    }

    public String getCarInsuranceNameByAge(Optional<Person> person, Integer minAge) {
        return person.filter(p -> p.getAge() >= minAge)
                .flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("Unknown");
    }


    public Set<String> getCarInsuranceNames(List<Person> persons) {
        return persons.stream()
                .map(Person::getCar)
                .map(optCar -> optCar.flatMap(Car::getInsurance))
                .map(optInsurance -> optInsurance.map(Insurance::getName))
                .flatMap(Optional::stream)
                .collect(toSet());
    }
}
