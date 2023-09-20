package blackjack.model.strategy;

public class DealerStandard implements StandardStrategy {

    public static final int DEALER_STANDARD = 17;

    @Override
    public boolean isMatchingStandard(int dealerSum) {
        return dealerSum < DEALER_STANDARD;
    }
}
