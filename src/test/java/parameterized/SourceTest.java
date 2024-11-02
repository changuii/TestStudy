package parameterized;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.assertj.core.util.Strings;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

public class SourceTest {


    @ParameterizedTest
    // short, byte, int, long, float, double, char, String, Class
    // string, class에 null 불가능
    @ValueSource(ints = {1,2,3,4,5,6,7,8,9,10})
    void 여러_타입을_입력받을_수_있다(int x){
        assertThat(Integer.valueOf(x)).isEqualTo(x);
    }

    // 5.4부터 null값을 넣을 수 있다.
    @ParameterizedTest
    @NullSource
    void NULL_값을_입력받을_수_있다(String x){
        assertThat(x).isNull();
    }

    // String, Collection 등 가능
    @ParameterizedTest
    @EmptySource
    void 빈_값을_입력받을_수_있다(List<Integer> list){
        assertThat(list).isEmpty();
    }

    // String, Collection 등 가능
    @ParameterizedTest
    @NullAndEmptySource
    void 빈_값과_NULL_값을_한번에_입력받을_수_있다(String input){
        assertThat(Strings.isNullOrEmpty(input)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("@NullAndEmptySource, @ValueSource를 동시에 사용가능")
    @NullAndEmptySource
    @ValueSource(strings = {" ", "  ", "\t", "\n"})
    void 두_어노테이션을_동시에_사용가능(String input){
        assertThat(Strings.isNullOrEmpty(input));
    }





}
