package hm.song.stduy.ch6;


import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.reducing;

/**
 * Created by hm.song on 2017. 10. 10..
 */
public class Practice {

    private static List<Dish> menu = Dish.menu;

    public static void main(String[] args) {
        sum();
        max();
        join();
        grouping();
    }

    public static void max() {
        Optional<Dish> max = menu.stream().max(Comparator.comparing(Dish::getCalories));
        if (max.isPresent()) {
            System.out.println("max result = " + max.get().toString());
        }
    }

    public static void sum() {
        Integer totalCalories = menu.stream().collect(
                reducing(0,
                        Dish::getCalories,
                        Integer::sum));

        System.out.println("sum result = " + totalCalories);
    }

    public static void join() {
        String result = menu.stream()
                .map(Dish::getName)
                .collect(
                        reducing((s1, s2) -> s1.join(",", s2)))
                .get();

        System.out.println("joining result = " + result);
    }

    public static void grouping() {
        Map<Dish.Type, List<Dish>> grouped = menu.stream()
                .collect(
                        groupingBy(Dish::getType));
        System.out.println("grouping result = " + grouped);
    }
}
