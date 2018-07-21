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

        final private List<Integer> coinSystem;




        public CoinSystem(Integer coin1, Integer coin2, Integer coin3, Integer coin4) {
            List<Integer> unsortedCoinSystem = Arrays.asList(coin1, coin2, coin3, coin4);
            unsortedCoinSystem.sort(Comparator.naturalOrder());
            Collections.reverse(unsortedCoinSystem);
            coinSystem = unsortedCoinSystem;
            coinSystem.forEach(System.out::println);
        }


        public Integer calculateChange(Integer salePrice) {
            final Integer change = 0;
            return change;
        }

        public static void main(String[] args) {

            final CoinSystem coinSystem = new CoinSystem(1,7,3,4);

        }
        


}
