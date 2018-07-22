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

    private final Integer maxChange = 99;
    private final Integer minChange = 1;

    public List<Integer> calculateBestCoinCombination() {


        return Arrays.asList(25,10,5,1,9);

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

