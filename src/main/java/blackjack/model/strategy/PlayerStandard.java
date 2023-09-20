package blackjack.model.strategy;

public class PlayerStandard implements StandardStrategy {

    public static final int PARTICIPANT_STANDARD = 21;

    @Override
    public boolean isMatchingStandard(int participantScore) {
        return participantScore < PARTICIPANT_STANDARD;
    }
}
