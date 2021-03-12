package blackjack.view;

import blackjack.domain.card.Card;
import blackjack.domain.user.Money;
import blackjack.domain.user.Player;
import blackjack.domain.user.User;
import blackjack.domain.user.Users;

import java.util.List;

import static java.util.stream.Collectors.joining;

public class OutputView {
    private static final String COMMA = ", ";
    private static final String COMMA_WITH_BLANK = ", ";

    public static void printInputNames() {
        System.out.println("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)");
    }

    public static void printInputMoney(String name) {
        System.out.println("\n" + name + "의 베팅 금액은?");
    }

    public static void printDistribute(Users users) {
        System.out.println("\n딜러와 " + String.join(COMMA, users.getPlayerNames()) + "에게 2장의 카드를 나누었습니다.");
    }

    public static void printCards(Users users) {
        System.out.println("딜러: " + users.getDealer().showOneCard());
        users.getPlayers()
                .forEach(OutputView::printPlayerCards);
        System.out.println();
    }

    public static void printPlayerCards(Player player) {
        System.out.print(player.getName() + "카드: ");
        printCards(player.getCards());
    }

    private static void printCards(List<Card> cards) {
        String cardsGroup = cards.stream()
                .map(Card::toString)
                .collect(joining(COMMA_WITH_BLANK));
        System.out.println(cardsGroup);
    }

    public static void printPlayerHit(Player player) {
        System.out.println(player.getName() + "는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)");
    }

    public static void printDealerHit() {
        System.out.println("\n딜러는 16이하라 한장의 카드를 더 받았습니다.\n");
    }

    public static void printDealerNotHit() {
        System.out.println("\n딜러는 17이상이라 한장의 카드를 추가로 받지 못하였습니다.\n");
    }

    public static void printResults(Users users) {
        printResult(users.getDealer());
        users.getPlayers()
                .forEach(OutputView::printResult);
    }

    private static void printResult(User user) {
        System.out.println(user.getName() + "카드: " +
                user.getCards()
                        .stream()
                        .map(Card::toString)
                        .collect(joining(COMMA_WITH_BLANK)) + " - 결과: " +
                user.getScore());
    }

    public static void printProfit(Users users, List<Money> profit) {
        System.out.println("\n## 최종 수익");
        printEachProfit(users, profit);
    }

    private static void printEachProfit(Users users, List<Money> profit) {
        System.out.println(users.getDealer().getName() + ": " + profit.get(0).toInteger());
        for (int i = 0; i < users.getPlayers().size(); i++) {
            System.out.println(users.getPlayers().get(i).getName() + ": " + profit.get(i+1).toInteger());
        }
    }
}
