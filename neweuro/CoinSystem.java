import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;
import java.util.List;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Collections;

public class CoinSystem {

        final private List<Integer> coinValues;




        public CoinSystem(final Integer coin1, final Integer coin2, final Integer coin3, final Integer coin4) {
            List<Integer> unsortedCoinValues = Arrays.asList(coin1, coin2, coin3, coin4);
            unsortedCoinValues.sort(Comparator.naturalOrder());
            Collections.reverse(unsortedCoinValues);
            coinValues = unsortedCoinValues;
            coinValues.forEach(System.out::println);
        }


        public Integer calculateChange(final List<Integer> coinValues, final List<Integer> numberOfCoins) {
            final Integer change = 0;
            return change;
        }

        public static void main(String[] args) {

            final CoinSystem coinSystem = new CoinSystem(1,7,3,4);

        }
        


}
