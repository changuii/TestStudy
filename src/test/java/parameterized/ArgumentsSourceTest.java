package parameterized;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsSource;
import parameterized.custom.CustomProvider;
import parameterized.custom.CustomVariableSource;

public class ArgumentsSourceTest {

    static Stream<Arguments> arguments = Stream.of(
            Arguments.of("가나다라마바사", 7),
            Arguments.of("김치맨", 3),
            Arguments.of("창의", 2)
    );

    @ParameterizedTest
    @ArgumentsSource(CustomProvider.class)
    void 사용자_정의_Provider가_가능하다(String input, int length){
        assertThat(input.length()).isEqualTo(length);
    }

    @ParameterizedTest
    @CustomVariableSource("arguments")
    void 사용자_정의_어노테이션이_가능하다(String input, int length){
        assertThat(input.length()).isEqualTo(length);
    }
}
