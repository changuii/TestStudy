package parameterized;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.AggregateWith;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvSource;
import parameterized.custom.CustomArgumentAggreagtor;

public class ArgumentsAccessorTest {

    @ParameterizedTest
    @CsvSource({"이,창의","이,상현","김,지후"})
    void useArgumentsAccessor(ArgumentsAccessor argumentsAccessor){
        String firstName = argumentsAccessor.getString(0);
        String name = argumentsAccessor.get(1, String.class);

        Person p = new Person(firstName, name);
        assertThat(p.getFullName()).isEqualTo(firstName+name);
    }


    @ParameterizedTest
    @CsvSource({"이창의,이,창의","이상현,이,상현","김지후,김,지후"})
    // AggregateWith가 마지막에 와야 동작함
    void useCustomArgumentsAccessor(String expected, @AggregateWith(CustomArgumentAggreagtor.class) Person person){
        assertThat(person.getFullName()).isEqualTo(expected);
    }


    public static class Person{
        private String firstName;
        private String name;

        public Person(String firstName, String name){
            this.firstName=firstName;
            this.name=name;
        }

        public String getFullName(){
            return String.format("%s%s", firstName, name);
        }
    }
}
