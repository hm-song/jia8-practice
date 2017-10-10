package hm.song.stduy.ch6;


import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.reducing;

/**
 * Created by hm.song on 2017. 10. 10..
 */
public class Practice {

    private static List<Dish> menu = Dish.menu;

    public static void main(String[] args) {
        sum();
        max();
    }

    public static void max() {
        Optional<Dish> max = menu.stream().max(Comparator.comparing(Dish::getCalories));
        if (max.isPresent()) {
            System.out.println("max = " + max.get().toString());
        }
    }

    public static void sum() {
        Integer totalCalories = menu.stream().collect(
                reducing(0,
                        Dish::getCalories,
                        Integer::sum));

        System.out.println(totalCalories);
    }
}
