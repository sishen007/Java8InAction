package lambdasinaction.chap6;

import java.util.*;
import java.util.function.*;

import static java.util.stream.Collectors.*;
import static lambdasinaction.chap6.Dish.menu;

/**
 * 6.2 规约和汇总
 *
 * @param null
 * @return 
 * @throw 
 *
 * @author wangyh2
 * @since  2020/11/19 10:51 
 */
public class Summarizing {

    public static void main(String ... args) {
//        System.out.println("Nr. of dishes: " + howManyDishes());
//        System.out.println("The most caloric dish is: " + findMostCaloricDish());
//        System.out.println("The most caloric dish is: " + findMostCaloricDishUsingComparator());
//        System.out.println("Total calories in menu: " + calculateTotalCalories());
//        System.out.println("Average calories in menu: " + calculateAverageCalories());
//        System.out.println("Menu statistics: " + calculateMenuStatistics());
        System.out.println("Short menu: " + getShortMenu());
        System.out.println("Short menu comma separated: " + getShortMenuCommaSeparated());
    }


    private static long howManyDishes() {
        // 也可以直接使用下面的 return menu.stream().count();
        return menu.stream().collect(counting());
    }

    private static Dish findMostCaloricDish() {
        return menu.stream().collect(reducing((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2)).get();
    }

    private static Dish findMostCaloricDishUsingComparator() {
        Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);
        BinaryOperator<Dish> moreCaloricOf = BinaryOperator.maxBy(dishCaloriesComparator);
        return menu.stream().collect(reducing(moreCaloricOf)).get();
    }

    private static int calculateTotalCalories() {
        return menu.stream().collect(summingInt(Dish::getCalories));
    }

    private static Double calculateAverageCalories() {
        return menu.stream().collect(averagingInt(Dish::getCalories));
    }

    private static IntSummaryStatistics calculateMenuStatistics() {
        return menu.stream().collect(summarizingInt(Dish::getCalories));
    }

    private static String getShortMenu() {
        return menu.stream().map(Dish::getName).collect(joining());
    }

    private static String getShortMenuCommaSeparated() {
        return menu.stream().map(Dish::getName).collect(joining(", "));
    }
}
