package parameterized;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class MethodSourceTest {

    @ParameterizedTest
    @MethodSource("provideStringNumberAndNumber")
    void 메서드를_인수로_사용하는_테스트(String stringNumber, int number){
        assertThat(Integer.parseInt(stringNumber)).isEqualTo(number);
    }

    private static Stream<Arguments> provideStringNumberAndNumber(){
        return Stream.of(
                Arguments.of("10", 10),
                Arguments.of("20", 20),
                Arguments.of("30", 30),
                Arguments.of("50", 50)
        );
    }

    @ParameterizedTest
    @MethodSource
    void 메서드_이름이_같은경우_메서드_이름을_제공할_필요가_없다(List<Integer> input){
        assertThat(input.size()).isEqualTo(input.get(0));
    }

    private static Stream<List<Integer>> 메서드_이름이_같은경우_메서드_이름을_제공할_필요가_없다(){
        return Stream.of(
                List.of(1),
                List.of(2,1),
                List.of(5,1,2,3,4),
                List.of(10,1,2,3,4,5,6,7,8,9)
        );
    }

    @ParameterizedTest
    @MethodSource("parameterized.UtilMethodSourceTest#provideEvenNumber")
    void 외부_클래스_메서드_참조하여_값을_가져온다(int evenNumber){
        assertThat(evenNumber % 2).isZero();
    }

    @ParameterizedTest
    @MethodSource("parameterized.UtilMethodSourceTest#provideEvenNumber")
    @MethodSource("provideStringNumberAndNumber")
    void 대부분의_Source_는_반복가능하다(int number){
        assertThat(number % 2).isZero();
    }


}

