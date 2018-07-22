import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.IntStream;
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


        public Integer calculateChange(final Integer totalCost, final List<Integer> coinValues, final List<Integer> numberOfCoins) {


            final Integer coinSum = IntStream.range(0, numberOfCoins.size())
                .mapToObj(i -> coinValues.get(i) * numberOfCoins.get(i))
                .collect(Collectors.summingInt(n->n));

            return totalCost - coinSum;

        }

        public static void main(String[] args) {

            final CoinSystem coinSystem = new CoinSystem(1,5,10,25);

            System.out.println("Price 100 cents");  
            System.out.println("Coins are 97 cents in 3 quarters, 2 dimes, 2 pennies.");  
            System.out.println("Change should be 3 cents");

            final List<Integer> ninetySevenCents = Arrays.asList(3, 2, 0, 2);
            final List<Integer> coinValues = Arrays.asList(25, 10, 5, 1);
            

            final Integer change = coinSystem.calculateChange(100, coinValues, ninetySevenCents);
                       
            System.out.println("Change is " + change);


        }
        


}
