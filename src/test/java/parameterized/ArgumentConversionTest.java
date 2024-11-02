package parameterized;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;
import parameterized.custom.CustomConverter;

public class ArgumentConversionTest {

    @ParameterizedTest
    // 암시적으로 변환된다.
    @CsvSource({"A", "B", "C", "D", "E", "F"})
    void implicitConversion(Test test){
        assertThat(test.name()).isBetween("A", "F");
    }
    public enum Test{
        A, B, C, D, E, F;
    }

    // 명시적 변환
    @ParameterizedTest
    @CsvSource({"2018/12/25,2018", "2019/02/11,2019"})
    void 컨버터를_커스터마이징할_수_있다(@ConvertWith(CustomConverter.class)LocalDate date, int expected){
        assertThat(date.getYear()).isEqualTo(expected);
    }





}
