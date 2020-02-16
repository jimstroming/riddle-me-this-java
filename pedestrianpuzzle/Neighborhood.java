import java.util.List; 
import java.util.ArrayList; 
import java.util.stream.IntStream;

class Neighborhood {

  private final Point townHall;
 
  private final double townLengthWidth;

  Neighborhood(final double townLengthWidth, Point townHall) {
    this.townLengthWidth = townLengthWidth;
    this.townHall = new Point(townHall.x, townHall.y);
  }

  public boolean blockMethodOneIsCloserForThisWorker(final double workerHomex, final double workerHomey, 
                       final DistanceCalculator distanceCalculator1, final DistanceCalculator distanceCalculator2) {

    final double distance1 = distanceCalculator1.calculateDistance(workerHomex, workerHomey);
    final double distance2 = distanceCalculator2.calculateDistance(workerHomex, workerHomey);
    return distance1 <= distance2;
  }

 
  public double percentMethod1CloserForEntireNeighborhood(final DistanceCalculator distanceCalculator1, 
                                             final DistanceCalculator distanceCalculator2) {

    double method1Advantage = 0;
    double method2Advantage = 0;

    for (int i = 0; i < townLengthWidth; i++) {
      for (int j = 0; j < townLengthWidth; j++) {
        if (blockMethodOneIsCloserForThisWorker(i, j, distanceCalculator1, distanceCalculator2)) {
          method1Advantage++;
        }
        else {
          method2Advantage++; 
        }
      }
    }
    return method1Advantage / (method1Advantage + method2Advantage); 
  }



}
