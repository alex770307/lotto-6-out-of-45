import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class LotteryNumberGenerator implements NumberGenerator {
    @Override
    public Set<Integer> generateNumbers() {
        Random random = new Random();

        while (true) {
            Set<Integer> randomSet = new TreeSet<>();
            while (randomSet.size() < 6) {
                randomSet.add(random.nextInt(1, 46));
            }
            return randomSet;
        }
    }
}