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



public class CoinSystemExplorer {

    private final int maxChange = 99;
    private final int minChange = 1;

    public List<Integer> calculateBestCoinCombination() {

        int leastCoinsRequired = 10000;
        List<Integer> bestCombination = Arrays.asList(0,0,0,0,leastCoinsRequired);
 
        int coin4 = 1;
        for(int coin1 = 99; coin1 > 3; coin1--){
            for(int coin2 = coin1 - 1; coin2 > 2; coin2--) {
                for (int coin3 = coin2 - 1; coin3 > 1; coin3--) {
                      CoinSystem coinSystem = new CoinSystem(coin1, coin2, coin3, coin4);
                      int coinsRequired = maxCoinsRequired(coinSystem); 

                      if (coinsRequired < leastCoinsRequired) {
                          bestCombination = Arrays.asList(coin1, coin2, coin3, coin4, coinsRequired);
                          leastCoinsRequired = coinsRequired;
                      }
            
                }  
            }
        }

        return bestCombination;

    }

    
    public int maxCoinsRequired(CoinSystem coinSystem) {

        return IntStream.rangeClosed(minChange, maxChange)
                        .map(i -> coinSystem.calculateMinCoinsToReachTargetForCoinOrders(i))      
                        .max()
                        .orElse(0);

    }


    public static void main(String[] args) {
        
        final CoinSystemExplorer explorer = new CoinSystemExplorer();
        final List<Integer> optimalCoinSet = explorer.calculateBestCoinCombination();
        System.out.println("Best combination uses these coins:");
        System.out.println(optimalCoinSet.get(0) + ", " + optimalCoinSet.get(1) +", " 
                         + optimalCoinSet.get(2) + ", " + optimalCoinSet.get(3));
        System.out.println("With this combination, change between " + explorer.minChange + " and " 
                         + explorer.maxChange + " cents can be made with " + optimalCoinSet.get(4) +" coins."); 

    }


}

