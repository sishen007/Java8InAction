package lambdasinaction.chap5;

import lambdasinaction.chap4.*;

import java.util.*;

import static java.util.stream.Collectors.toList;
import static lambdasinaction.chap4.Dish.menu;

/**
 * 5.2节
 *
 * @param
 * @author wangyh2
 * @return
 * @throw
 * @since 2020/11/17 13:20
 */
public class Mapping {

    public static void main(String... args) {

        // map
//        List<String> dishNames = menu.stream()
//                                     .map(Dish::getName)
//                                     .collect(toList());
//        System.out.println(dishNames);
//
//        // map
        List<String> words = Arrays.asList("Hello", "World");
//        List<Integer> wordLengths = words.stream()
//                                         .map(String::length)
//                                         .collect(toList());
//        System.out.println(wordLengths);

        /**
         *实现功能: 讲words中每个单词提取字母并去重
         */
        // 尝试1. 使用map进行分割words 没有实现
//        words.stream().map(word->word.split("")).distinct().forEach(System.out::println);
        // 尝试2. 还是没有实现
//        words.stream().map(word->word.split("")).map(Arrays::stream).distinct().forEach(System.out::println);
        // 尝试3. 使用flatMap实现(成功实现)
//        words.stream().map(word->word.split("")).flatMap(Arrays::stream).distinct().forEach(System.out::println);

//        System.out.println("");
        // 尝试4: 相当于尝试3
//        words.stream()
//                 .flatMap((String line) -> Arrays.stream(line.split("")))
//                 .distinct()
//                 .forEach(System.out::println);


        // 作业1: 根据[1, 2, 3, 4,5]，应该返回[1, 4, 9, 16, 25]。
//        Arrays.asList(1, 2, 3, 4, 5).stream().map(a -> a * a).forEach(System.out::println);


        // flatMap
        List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> numbers2 = Arrays.asList(6, 7, 8);
        List<int[]> pairs =
                numbers1.stream()
                        .flatMap((Integer i) -> numbers2.stream()
                                .map((Integer j) -> new int[]{i, j})
                        )
                        .filter(pair -> (pair[0] + pair[1]) % 3 == 0)
                        .collect(toList());
        pairs.forEach(pair -> System.out.println("(" + pair[0] + ", " + pair[1] + ")"));
    }
}
