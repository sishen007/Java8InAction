package lambdasinaction.chap6;

import java.util.*;

import static java.util.stream.Collectors.*;
import static lambdasinaction.chap6.Dish.dishTags;
import static lambdasinaction.chap6.Dish.menu;

/**
 * 6.3 分组
 *
 * @param null
 * @author wangyh2
 * @return
 * @throw
 * @since 2020/11/19 17:15
 */
public class Grouping {

    enum CaloricLevel {DIET, NORMAL, FAT}

    ;

    public static void main(String... args) {
//        System.out.println("Dishes grouped by type: " + groupDishesByType());
//        System.out.println("Dish names grouped by type: " + groupDishNamesByType());
//        System.out.println("Dish tags grouped by type: " + groupDishTagsByType());
//        System.out.println("Caloric dishes grouped by type: " + groupCaloricDishesByType());
//        System.out.println("Dishes grouped by caloric level: " + groupDishesByCaloricLevel());
//        System.out.println("Dishes grouped by type and caloric level: " + groupDishedByTypeAndCaloricLevel());
//        System.out.println("Count dishes in groups: " + countDishesInGroups());
        System.out.println("Most caloric dishes by type: " + mostCaloricDishesByType());
//        System.out.println("Most caloric dishes by type: " + mostCaloricDishesByTypeWithoutOprionals());
//        System.out.println("Sum calories by type: " + sumCaloriesByType());
//        System.out.println("Caloric levels by type: " + caloricLevelsByType());
    }

    private static Map<Dish.Type, List<Dish>> groupDishesByType() {
        return menu.stream().collect(groupingBy(Dish::getType));
    }

    // 按类型 只获取名字
    private static Map<Dish.Type, List<String>> groupDishNamesByType() {
        return menu.stream().collect(groupingBy(Dish::getType, mapping(Dish::getName, toList())));
    }

    // java9 才有了flatMapping 扁平化处理
    private static Map<Dish.Type, Set<String>> groupDishTagsByType() {
        return menu.stream().collect(groupingBy(Dish::getType, flatMapping(dish -> dishTags.get(dish.getName()).stream(), toSet())));
    }

    // java9 才有了filtering
    private static Map<Dish.Type, List<Dish>> groupCaloricDishesByType() {
//        return menu.stream().filter(dish -> dish.getCalories() > 500).collect(groupingBy(Dish::getType));
        return menu.stream().collect(groupingBy(Dish::getType, filtering(dish -> dish.getCalories() > 500, toList())));
    }

    private static Map<CaloricLevel, List<Dish>> groupDishesByCaloricLevel() {
        return menu.stream().collect(
                groupingBy(dish -> {
                    if (dish.getCalories() <= 400) {
                        return CaloricLevel.DIET;
                    } else if (dish.getCalories() <= 700) {
                        return CaloricLevel.NORMAL;
                    } else {
                        return CaloricLevel.FAT;
                    }
                }));
    }

    // 双层分组
    private static Map<Dish.Type, Map<CaloricLevel, List<Dish>>> groupDishedByTypeAndCaloricLevel() {
        return menu.stream().collect(
                groupingBy(Dish::getType,
                        groupingBy((Dish dish) -> {
                            if (dish.getCalories() <= 400) {
                                return CaloricLevel.DIET;
                            } else if (dish.getCalories() <= 700) {
                                return CaloricLevel.NORMAL;
                            } else {
                                return CaloricLevel.FAT;
                            }
                        })
                )
        );
    }

    private static Map<Dish.Type, Long> countDishesInGroups() {
        return menu.stream().collect(groupingBy(Dish::getType, counting()));
    }

    private static Map<Dish.Type, Optional<Dish>> mostCaloricDishesByType() {
        return menu.stream().collect(
                groupingBy(Dish::getType,
                        reducing((Dish d1, Dish d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2)));
    }

    private static Map<Dish.Type, Dish> mostCaloricDishesByTypeWithoutOprionals() {
        return menu.stream().collect(
                groupingBy(Dish::getType,
                        collectingAndThen(
                                reducing((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2),
                                Optional::get)));
    }

    private static Map<Dish.Type, Integer> sumCaloriesByType() {
        return menu.stream().collect(groupingBy(Dish::getType,
                summingInt(Dish::getCalories)));
    }

    private static Map<Dish.Type, Set<CaloricLevel>> caloricLevelsByType() {
        return menu.stream().collect(
                groupingBy(Dish::getType, mapping(
                        dish -> {
                            if (dish.getCalories() <= 400) {
                                return CaloricLevel.DIET;
                            } else if (dish.getCalories() <= 700) {
                                return CaloricLevel.NORMAL;
                            } else {
                                return CaloricLevel.FAT;
                            }
                        },
                        toSet())));
    }
}
