import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class StringTest {
    private static final String DELIMITER = ",";

    @Test
    void 문자열을_구분자로_분리하면_정확히_분리되는지_검증(){
        String data = "1,2";

        String[] datas = data.split(DELIMITER);

        assertThat(datas).contains("1", "2");
    }

    @Test
    void 단일_문자열을_분리하면_정확히_해당_문자만_존재하는지_검증(){
        String data = "1";

        String[] datas = data.split(DELIMITER);

        assertThat(datas).containsExactly("1");
    }

    @Test
    void 문자열_자르기__테스트(){
        String data = "(1,2)";

        // begin <= data < end
        String deletedData = data.substring(1, 4);

        assertThat(deletedData).isEqualTo("1,2");
    }

    @Test
    void 문자열에서_특정_문자_추출_테스트(){
        String data = "abc";

        char extract1 = data.charAt(0);
        char extract2 = data.charAt(1);
        char extract3 = data.charAt(2);

        assertThat(extract1).isEqualTo('a');
        assertThat(extract2).isEqualTo('b');
        assertThat(extract3).isEqualTo('c');
    }

    @Test
    void 문자열에서_특정_문자를_추출할때_문자열_범위를_벗어나면_예외가_발생한다(){
        String data = "abc";

        assertThatThrownBy(() -> {
            for(int i=0; i<500; i++){
                data.charAt(i);
            }
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining(String.format("Index %d out of bounds for length %d", data.length(), data.length()))
                .hasMessageMatching("Index \\d+ out of bounds for length \\d+");
    }


}
