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
        final private List<List<Integer>> usefulCoinOrders;

        


        public CoinSystem(final Integer coin1, final Integer coin2, final Integer coin3, final Integer coin4) {
            List<Integer> unsortedCoinValues = Arrays.asList(coin1, coin2, coin3, coin4);
            unsortedCoinValues.sort(Comparator.naturalOrder());
            Collections.reverse(unsortedCoinValues);
            this.coinValues = unsortedCoinValues;
            this.coinValues.forEach(System.out::println);

            final Integer coinA = coinValues.get(0);
            final Integer coinB = coinValues.get(1);
            final Integer coinC = coinValues.get(2);
            final Integer coinLowest = coinValues.get(3);

            final List<Integer> abcd = Arrays.asList(coinA, coinB, coinC, coinLowest);
            final List<Integer> acbd = Arrays.asList(coinA, coinC, coinB, coinLowest);
            final List<Integer> bacd = Arrays.asList(coinB, coinA, coinC, coinLowest);
            final List<Integer> bcad = Arrays.asList(coinB, coinC, coinA, coinLowest);
            final List<Integer> cabd = Arrays.asList(coinC, coinA, coinB, coinLowest);
            final List<Integer> cbad = Arrays.asList(coinC, coinB, coinA, coinLowest);

            this.usefulCoinOrders = Arrays.asList(abcd, acbd, bacd, bcad, cabd, cbad);

        }



        private Integer calculateMinCoinsToReachTargetForCoinOrders(final Integer target, final List<List<Integer>> coinOrders) {
            return coinOrders.stream()
                             .mapToInt(i -> calculateCoinsToReachTarget(target, i))       
                             .min()
                             .orElse(10000);
        }


        private Integer calculateCoinsToReachTarget(final Integer target, final List<Integer> coinOrder) {

            Integer totalNumberCoins = 0;
            Integer remainder = target;
            Integer coinNumber = 0;
            Integer currentCoin; 
            Integer numberOfCurrentCoin;           

            while (remainder > 0) {
                // System.out.println("Remainder is " + remainder);
                currentCoin = coinOrder.get(coinNumber);
                // System.out.println("currentCoin is " + currentCoin);
                numberOfCurrentCoin = calculateNumberOfCoinsLessThanEqualTarget(remainder, currentCoin);
                // System.out.println("numberOfCurrentCoin is " + numberOfCurrentCoin);
                totalNumberCoins += numberOfCurrentCoin;
                remainder -= numberOfCurrentCoin * currentCoin; 
                coinNumber += 1;
            }

            return totalNumberCoins;                    

        }

        private Integer calculateCoinTotal(final List<Integer> coinValues, final List<Integer> numberOfCoins) {

            return IntStream.range(0, numberOfCoins.size())
                .mapToObj(i -> coinValues.get(i) * numberOfCoins.get(i))
                .collect(Collectors.summingInt(n->n));

        }


        private Integer calculateNumberOfCoinsLessThanEqualTarget(final Integer target, final Integer coinValue) {

            return target / coinValue;

        }


        private Integer calculateNumberOfCoins(final List<Integer> numberOfCoins) {
           
            return numberOfCoins.stream().reduce(0, Integer::sum);

        }


        public static void main(String[] args) {

            final CoinSystem coinSystem = new CoinSystem(1,5,10,25);

            System.out.println("Coins should be 97 cents in 3 quarters, 2 dimes, 2 pennies.");  

            final List<Integer> ninetySevenCents = Arrays.asList(3, 2, 0, 2);
            final List<Integer> coinValues = Arrays.asList(25, 10, 5, 1);            

            final Integer change = coinSystem.calculateCoinTotal(coinValues, ninetySevenCents);
                       
            System.out.println("Total is " + change);

            System.out.println("This should be 7 coins");

            System.out.println("The number of coins is " + coinSystem.calculateNumberOfCoins(ninetySevenCents)); 

            System.out.println("11 cents is > " + coinSystem.calculateNumberOfCoinsLessThanEqualTarget(11, 5) + " nickels");

            System.out.println(coinSystem.calculateCoinsToReachTarget(97, coinValues) + " coins to reach 97 cents with 25,10,5,1");

            System.out.println(coinSystem.calculateMinCoinsToReachTargetForCoinOrders(97, coinSystem.usefulCoinOrders)
                               + " coins to reach 97 cents with any useful order of 25,10,5,1");


        }
        


}
