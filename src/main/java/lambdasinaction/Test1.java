package lambdasinaction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.String.valueOf;
import static java.util.stream.Collectors.joining;

/**
 * TODO
 *
 * @author wangyh2
 * @version v1.0
 * @since 2020-11-20 15:18
 */
public class Test1 {
    public static Map<Integer, Integer> icterusStatusMap = new HashMap<>();
    static {
        icterusStatusMap.put(2, 1);
        icterusStatusMap.put(3, 2);
        icterusStatusMap.put(4, 3);
        icterusStatusMap.put(5, 4);
    }
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        String icterusStatus = integers.stream().map(d -> valueOf(icterusStatusMap.getOrDefault(d, 0))).filter(d -> !"0".equals(d)).collect(joining(","));
        System.out.println(icterusStatus);
    }

}
