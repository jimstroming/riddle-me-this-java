import java.lang.Math;

class DiagonalDistanceCalculator implements DistanceCalculator {

  static final double sqrt2 = Math.sqrt(2);

  private final Point townHall;

  DiagonalDistanceCalculator(final Point townHall) {
    this.townHall = new Point(townHall.x, townHall.y);
  }

  @Override
  public double calculateDistance(final double workerHomex, final double workerHomey) {
    return recursiveCalculateDistance(workerHomex, workerHomey) * sqrt2/2;
  }
 
  private double recursiveCalculateDistance(final double workerHomex, final double workerHomey) {
    if ((workerHomex == townHall.x) && (workerHomey == townHall.y)) return 0;
    if ((workerHomex >= townHall.x) && (workerHomey >= townHall.y)) {
      return 1 + recursiveCalculateDistance(workerHomex-0.5, workerHomey-0.5);
    }
    if ((workerHomex < townHall.x) && (workerHomey < townHall.y)) {
      return 1 + recursiveCalculateDistance(workerHomex+0.5, workerHomey+0.5);
    }
    if (workerHomex > townHall.x) {
      return 1 + recursiveCalculateDistance(workerHomex-0.5, workerHomey-0.5);
    }
    return 1 + recursiveCalculateDistance(workerHomex+0.5, workerHomey+0.5);
  }
}
