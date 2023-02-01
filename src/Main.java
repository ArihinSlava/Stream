import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(10);
        integerList.add(55);
        integerList.add(15);
        integerList.add(25);
        integerList.add(86);
        integerList.add(5);
        integerList.add(17);
        Stream<Integer> streamList = integerList.stream();
        findMinMax(streamList,Comparator.comparingInt(i -> i), (min,max) -> System.out.println( "Минимальное - " + min + " Максимальное - " + max));

        ///Task2
        countEvenNumbers(integerList);
    }



    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {
        List<T> arrayList;
        T min = null;
        T max = null;
         arrayList = stream
                 .sorted(order)
                 .collect(Collectors.toList());
        if (arrayList.size() != 0) {
            min = arrayList.get(0);
            max = arrayList.get(arrayList.size() - 1);
        } else {
            minMaxConsumer.accept(min, max);
        }
    }

    public static void countEvenNumbers(List<Integer> list) {
        System.out.println("Количество четных чисел -  " + list.stream()
                .filter(x -> x % 2 != 0 )
                .count());
    }
}
