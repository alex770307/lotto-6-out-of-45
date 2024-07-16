import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class LotteryNumberGenerator implements NumberGenerator {

    private static final int COUNTER_MAX_NUMBER = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    @Override
    public Set<Integer> generateNumbers() {
        Random random = new Random();

        while (true) {
            Set<Integer> randomSet = new TreeSet<>();
            while (randomSet.size() < COUNTER_MAX_NUMBER) {
                randomSet.add(random.nextInt(MIN_NUMBER, MAX_NUMBER + MIN_NUMBER));
            }
            return randomSet;
        }
    }
}