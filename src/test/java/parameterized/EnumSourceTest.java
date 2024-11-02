package parameterized;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.Month;
import java.util.EnumSet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.EnumSource.Mode;

public class EnumSourceTest {


    @ParameterizedTest
    @EnumSource(Month.class)
    void 열거형_값_테스트(Month month){
        int monthNumber = month.getValue();
        assertThat(monthNumber).isBetween(1, 12);
    }

    @ParameterizedTest
    @DisplayName("names에 존재하는 열거형 타입만 사용되도록 필터링")
    @EnumSource(value = Month.class, names = {"APRIL", "JUNE", "SEPTEMBER", "NOVEMBER"})
    void 열거형_동일값만_나오게_테스트(Month month){
        final boolean isALeapYear = false;
        assertThat(month.length(isALeapYear)).isEqualTo(30);
    }

    @ParameterizedTest
    @DisplayName("names에 존재하지 않는 열거형 타입만 인자로 사용되도록 필터링")
    @EnumSource(value = Month.class,
            names = {"APRIL", "JUNE", "SEPTEMBER", "NOVEMBER", "FEBRUARY"},
            mode = Mode.EXCLUDE
    )
    void 열거형_일치하지_않는_값만_나오게_테스트(Month month){
        final boolean isALeapYear = false;
        assertThat(month.length(isALeapYear)).isEqualTo(31);
    }

    @ParameterizedTest
    @EnumSource(value = Month.class, names = ".+BER", mode = Mode.MATCH_ANY)
    void 열거형_정규식_필터링_테스트(Month month){
        EnumSet<Month> months = EnumSet.of(Month.SEPTEMBER, Month.OCTOBER, Month.NOVEMBER, Month.DECEMBER);
        assertThat(months.contains(month)).isTrue();
    }

}
