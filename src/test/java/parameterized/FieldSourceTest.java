package parameterized;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.FieldSource;

public class FieldSourceTest {
    static List<Integer> negativeNumbers = List.of(-1, -2, -3, -4,-1000);
    static List<String> 이름이_같다면_필드명_생략가능 = List.of("racingcar", "sportscar", "basiccar");

    @ParameterizedTest
    @FieldSource("negativeNumbers")
    void negativeNumberTest(int negativeNumber){
        assertThat(negativeNumber).isLessThan(0);
    }

    @ParameterizedTest
    @FieldSource
    void 이름이_같다면_필드명_생략가능(String car){
        assertThat(car).endsWith("car");
    }


}
