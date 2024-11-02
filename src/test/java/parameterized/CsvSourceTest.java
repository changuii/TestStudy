package parameterized;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

public class CsvSourceTest {


    @ParameterizedTest
    @CsvSource({"test,TEST","asd,ASD","qWe,QWE","xyz,XYZ"})
    void 여러개의_인수를_입력받을_수_있는_CSV_SOURCE_테스트(String input, String result){
        String actualValue = input.toUpperCase();
        assertThat(actualValue).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"test:TEST", "asd:ASD"}, delimiter = ':')
    void 구분자를_변경해줄_수_있다(String input, String result){
        String actualValue = input.toUpperCase();
        assertThat(actualValue).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv", numLinesToSkip = 0)
    void 파일로_입력받을_수_있다(String input, String result){
        String actualValue = input.toUpperCase();
        assertThat(actualValue).isEqualTo(result);
    }
}
