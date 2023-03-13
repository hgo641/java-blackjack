package domain.game;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class ResultTest {
    static Stream<Arguments> getResultOfOpponentData() {
        return Stream.of(
                Arguments.arguments(Result.LOSE, Result.WIN),
                Arguments.arguments(Result.PUSH, Result.PUSH),
                Arguments.arguments(Result.WIN, Result.LOSE)
        );
    }

    @ParameterizedTest
    @MethodSource("getResultOfOpponentData")
    void getResultOfOpponent(Result result, Result expected) {
        assertThat(result.getResultOfOpponent()).isEqualTo(expected);
    }
}