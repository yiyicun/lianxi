import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {
        List<Person> list = new ArrayList();
        list.add(new Person(1, "1"));
        //list.add(new Person(1, "4"));
        list.add(new Person(2, "2"));
        list.add(new Person(3, "3"));

        Map<Integer, String> collect = list.stream().collect(Collectors.toMap(Person::getId, Person::getName));
        Map<Integer, Person> collect1 = list.stream().collect(Collectors.toMap(Person::getId, Function.identity(), (a,b)->a));
        Map<Integer, Person> collect2 = list.stream().collect(Collectors.toMap(Person::getId, v -> v, (a,b)->a));
        Collection<Person> values = list.stream().collect(Collectors.toMap(Person::getId, Function.identity(), (a, b) -> a)).values();
        long count = list.stream().collect(Collectors.toMap(Person::getId, Function.identity(), (a, b) -> a)).values().stream().count();

        System.out.println(collect);
        System.out.println(collect1);
        System.out.println(collect2);
        System.out.println(values);
        System.out.println(count);
    }
}

