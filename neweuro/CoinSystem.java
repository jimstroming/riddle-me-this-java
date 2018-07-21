import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;
import java.util.List;
import java.util.Arrays;

public class CoinSystem {

        final private List<Integer> coinSystem;


        public CoinSystem(Integer coin1, Integer coin2, Integer coin3, Integer coin4) {
            this.coinSystem = Arrays.asList(coin1, coin2, coin3, coin4);
        }


}
