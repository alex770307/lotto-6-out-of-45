import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class LotteryNumberGenerator implements NumberGenerator {

    private static final int NUMBER_COUNT = 6;
    private static final int MAX_NUMBER = 45;

    @Override
    public Set<Integer> generateNumbers() {
        Random random = new Random();

        while (true) {
            Set<Integer> randomSet = new TreeSet<>();
            while (randomSet.size() < NUMBER_COUNT) {
                randomSet.add(random.nextInt(1, MAX_NUMBER + 1));
            }
            return randomSet;
        }
    }
}