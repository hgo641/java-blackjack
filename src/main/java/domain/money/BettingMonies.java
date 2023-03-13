package domain.money;

import java.util.List;
import java.util.stream.Collectors;

public class BettingMonies {
    private final List<BettingMoney> bettingMonies;

    private BettingMonies(final List<BettingMoney> bettingMonies) {
        this.bettingMonies = bettingMonies;
    }

    public static BettingMonies of(final List<Integer> bettingMoneyValues) {
        List<BettingMoney> bettingMonies = bettingMoneyValues.stream()
                .map(bettingMoneyValue -> BettingMoney.of(bettingMoneyValue))
                .collect(Collectors.toList());
        return new BettingMonies(bettingMonies);
    }

    public int size() {
        return bettingMonies.size();
    }

    public Money get(int index) {
        return bettingMonies.get(index);
    }
}
