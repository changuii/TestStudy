import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    void set의_size_테스트(){
        int size = 3;

        int setSize = numbers.size();

        assertThat(setSize).isEqualTo(size);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void set의_contains_테스트(int value){
        assertThat(numbers.contains(value)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void CsvSource_테스트(int number, boolean result){
        assertThat(numbers.contains(number)).isEqualTo(result);
    }
}
