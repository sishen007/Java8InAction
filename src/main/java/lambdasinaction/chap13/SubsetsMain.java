package lambdasinaction.chap13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 13.2.4 函数式编程实战
 *
 * @param null
 * @return
 * @throw
 *
 * @author wangyh2
 * @since  2020/11/30 15:55
 */
public class SubsetsMain {

    public static void main(String[] args) {
        List<List<Integer>> subs = subsets(Arrays.asList(1, 4, 9));
        subs.forEach(System.out::println);
    }

    public static List<List<Integer>> subsets(List<Integer> l) {
        if (l.isEmpty()) {
            List<List<Integer>> ans = new ArrayList<>();
            ans.add(Collections.emptyList());
            return ans;
        }
        Integer first = l.get(0); // 4
        List<Integer> rest = l.subList(1,l.size()); // [9]
        List<List<Integer>> subans = subsets(rest); // [[]]
        List<List<Integer>> subans2 = insertAll(first, subans);
        return concat(subans, subans2);
    }

    public static List<List<Integer>> insertAll(Integer first, List<List<Integer>> lists) {
        List<List<Integer>> result = new ArrayList<>();
        for (List<Integer> l : lists) {
            List<Integer> copyList = new ArrayList<>();
            copyList.add(first);
            copyList.addAll(l);
            result.add(copyList);
        }
        return result;
    }

    static List<List<Integer>> concat(List<List<Integer>> a, List<List<Integer>> b) {
        List<List<Integer>> r = new ArrayList<>(a);
        r.addAll(b);
        return r;
    }
}
