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


// Solution to the 538 Riddler Expres

// https://fivethirtyeight.com/features/damn-the-torpedoes-two-puzzles-ahead/

// "From Brett Andersen, some numismatic numerology:"
// "I was recently traveling in Europe and struck by the number of coins the euro uses." 
// "They have 2 euro, 1 euro, 50 cent, 20 cent, 10 cent, 5 cent, 2 cent and 1 cent coins." 
// "This got me thinking: If Riddler Nation needed to make change (anywhere from 0.01 to 0.99)" 
// "and was establishing its own mint, what values of coins would be ideal to yield the smallest"
// "number of coins in any transaction?"
// "When picking values, let’s say we’re ditching the Europeans and limiting our mint to"
// four different coin denominations — replacing the current common American ones of penny, nickel, dime and quarter."



public class CoinSystem {

        final private List<Integer> coinValues;
        final public List<List<Integer>> usefulCoinOrders;

        public CoinSystem(final int coin1, final int coin2, final int coin3, final int coin4) {
            List<Integer> unsortedCoinValues = Arrays.asList(coin1, coin2, coin3, coin4);
            unsortedCoinValues.sort(Comparator.naturalOrder());
            Collections.reverse(unsortedCoinValues);
            this.coinValues = unsortedCoinValues;

            final int coinA = coinValues.get(0);
            final int coinB = coinValues.get(1);
            final int coinC = coinValues.get(2);
            final int coinLowest = coinValues.get(3);

            final List<Integer> abcd = Arrays.asList(coinA, coinB, coinC, coinLowest);
            final List<Integer> acbd = Arrays.asList(coinA, coinC, coinB, coinLowest);
            final List<Integer> bacd = Arrays.asList(coinB, coinA, coinC, coinLowest);
            final List<Integer> bcad = Arrays.asList(coinB, coinC, coinA, coinLowest);
            final List<Integer> cabd = Arrays.asList(coinC, coinA, coinB, coinLowest);
            final List<Integer> cbad = Arrays.asList(coinC, coinB, coinA, coinLowest);

            this.usefulCoinOrders = Arrays.asList(abcd, acbd, bacd, bcad, cabd, cbad);

        }



        public int calculateMinCoinsToReachTargetForCoinOrders(final int target) {
            return this.usefulCoinOrders.stream()
                             .mapToInt(i -> calculateCoinsToReachTarget(target, i))       
                             .min()
                             .orElse(10000);
        }


        private int calculateCoinsToReachTarget(final int target, final List<Integer> coinOrder) {

            int totalNumberCoins = 0;
            int remainder = target;
            int coinNumber = 0;
            int currentCoin; 
            int numberOfCurrentCoin;           

            while (remainder > 0) {
                currentCoin = coinOrder.get(coinNumber);
                numberOfCurrentCoin = calculateNumberOfCoinsLessThanEqualTarget(remainder, currentCoin);
                totalNumberCoins += numberOfCurrentCoin;
                remainder -= numberOfCurrentCoin * currentCoin; 
                coinNumber += 1;
            }

            return totalNumberCoins;                    

        }

        private int calculateCoinTotal(final List<Integer> coinValues, final List<Integer> numberOfCoins) {

            return IntStream.range(0, numberOfCoins.size())
                .mapToObj(i -> coinValues.get(i) * numberOfCoins.get(i))
                .collect(Collectors.summingInt(n->n));

        }


        private int calculateNumberOfCoinsLessThanEqualTarget(final int target, final int coinValue) {

            return target / coinValue;

        }


        private int calculateNumberOfCoins(final List<Integer> numberOfCoins) {
           
            return numberOfCoins.stream().reduce(0, Integer::sum);

        }


        public static void main(String[] args) {

            final CoinSystem coinSystem = new CoinSystem(1,5,10,25);

            System.out.println("Coins should be 97 cents in 3 quarters, 2 dimes, 2 pennies.");  

            final List<Integer> ninetySevenCents = Arrays.asList(3, 2, 0, 2);
            final List<Integer> coinValues = Arrays.asList(25, 10, 5, 1);            

            final int change = coinSystem.calculateCoinTotal(coinValues, ninetySevenCents);
                       
            System.out.println("Total is " + change);

            System.out.println("This should be 7 coins");

            System.out.println("The number of coins is " + coinSystem.calculateNumberOfCoins(ninetySevenCents)); 

            System.out.println("11 cents is > " + coinSystem.calculateNumberOfCoinsLessThanEqualTarget(11, 5) + " nickels");

            System.out.println(coinSystem.calculateCoinsToReachTarget(97, coinValues) + " coins to reach 97 cents with 25,10,5,1");

            System.out.println(coinSystem.calculateMinCoinsToReachTargetForCoinOrders(97)
                               + " coins to reach 97 cents with any useful order of 25,10,5,1");


        }
        


}
