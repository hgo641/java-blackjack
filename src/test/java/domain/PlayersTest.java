package domain;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class PlayersTest {

    @DisplayName("참여 인원은 1명 이상 4명 이하이다")
    @ParameterizedTest
    @MethodSource("parameterProvider")
    void playerCount1_4(List<String> names) {
        assertThatNoException()
            .isThrownBy(() -> Players.from(names));
    }

    static Stream<List<String>> parameterProvider() {
        return Stream.of(
            List.of("a"),
            List.of("a", "kiara", "ash", "woowa")
        );
    }

    @DisplayName("참여 인원은 1명미만이 될 수 없다")
    @Test
    void playerCount_shouldNotBeUnder1() {
        assertThatThrownBy(() -> Players.from(Collections.emptyList()));
    }

    @DisplayName("참여 인원은 4명초과가 될 수 없다")
    @Test
    void playerCount_shouldNotBeOver4() {
        assertThatThrownBy(() -> Players.from(List.of("a", "b", "c", "d", "e")));
    }

    @DisplayName("플레이어의 이름은 중복될 수 없다")
    @Test
    void validateDuplication() {
        assertThatThrownBy(() -> Players.from(List.of("hongo", "hongo", "ash", "kiara")))
            .isInstanceOf(IllegalArgumentException.class);
    }
}