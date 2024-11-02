package parameterized;

import java.util.stream.Stream;

public class UtilMethodSourceTest {

    public static Stream<Integer> provideEvenNumber(){
        return Stream.of(2, 4, 6, 8, 10, 12, 14);
    }
}
