package format;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.DecimalFormat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DecimalFormatTest {

    private final DecimalFormat decimalFormat;

    public DecimalFormatTest(){
        decimalFormat = new DecimalFormat();
    }

    @DisplayName("0 기호 사용")
    @Test
    void zeroPattern(){
        int number = 10;
        String expected = "00010";

        // 기존 수에서 빈자리를 0으로 채움
        decimalFormat.applyPattern("00000");
        String actual = decimalFormat.format(number);

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("# 기호 사용")
    @Test
    void sharpSignPattern(){
        int number = 10;
        String expected = "10";

        // 기존 수에서 빈자리를 채우지 않음
        decimalFormat.applyPattern("######");
        String actual = decimalFormat.format(number);

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName(". 기호")
    @Test
    void decimalPoint(){
        int number = 10;
        String expected = "10.0";

        // '.'은 소수점을 나타냄
        decimalFormat.applyPattern("#.0");
        String actual = decimalFormat.format(number);

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("- 기호")
    @Test
    void minusSign(){
        int number = 10;
        String expected = "-10";

        // '-'는 음수를 나타냄
        decimalFormat.applyPattern("-#");
        String actual = decimalFormat.format(number);

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName(", 기호")
    @Test
    void 단위_구분자(){
        int number = 10000000;
        String expected = "10,000,000";

        // '-'는 음수를 나타냄
        decimalFormat.applyPattern("##,###,###");
        String actual = decimalFormat.format(number);

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("% 연산")
    @Test
    void 퍼센트_연산(){
        int number = 100;
        String expected = "10000%";

        // '-'는 음수를 나타냄
        decimalFormat.applyPattern("#%");
        String actual = decimalFormat.format(number);

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("% 기호")
    @Test
    void 퍼센트_기호(){
        int number = 100;
        String expected = "100%";

        // '-'는 음수를 나타냄
        decimalFormat.applyPattern("#'%'");
        String actual = decimalFormat.format(number);

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("우테코 미션에 적용할 패턴")
    @Test
    void 미션에_적용할_패턴(){
        double rate = 2000.0;
        String expected = "2000.0%";

        // '-'는 음수를 나타냄
        decimalFormat.applyPattern("#.0'%'");
        String actual = decimalFormat.format(rate);

        assertThat(actual).isEqualTo(expected);
    }
}

