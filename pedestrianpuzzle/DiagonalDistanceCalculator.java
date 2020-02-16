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
 

  private Point calculateNextPoint(final double currentx, final double currenty) {

    final double nextx;
    final double nexty; 

    if ((currentx == townHall.x) && (currenty == townHall.y)) {
      nextx = currentx;
      nexty = currenty;
    }
    else if ((currentx >= townHall.x) && (currenty >= townHall.y)) {
      nextx = currentx - 0.5;
      nexty = currenty - 0.5;
    }
    else if ((currentx <= townHall.x) && (currenty <= townHall.y)) {
      nextx = currentx + 0.5;
      nexty = currenty + 0.5;
    }
    else if (currentx >= townHall.x) {
      nextx = currentx - 0.5;
      nexty = currenty + 0.5;
    }
    else {
      nextx = currentx + 0.5;
      nexty = currenty - 0.5;
    }

    return new Point(currentx, currenty);
  }

  private double recursiveCalculateDistance(final double workerHomex, final double workerHomey) {
    // System.out.println("x = " + workerHomex + " ; y = " + workerHomey 
    //                  + " goalx = " + townHall.x + " goaly = " + townHall.y);
    if ((Math.abs(workerHomex - townHall.x) <= 0.2) && (Math.abs(workerHomey - townHall.y) <= 0.2 )) return 0;
    if ((workerHomex >= townHall.x) && (workerHomey >= townHall.y)) {
      return 1 + recursiveCalculateDistance(workerHomex-0.5, workerHomey-0.5);
    }
    if ((workerHomex <= townHall.x) && (workerHomey <= townHall.y)) {
      return 1 + recursiveCalculateDistance(workerHomex+0.5, workerHomey+0.5);
    }
    if (workerHomex >= townHall.x) {
      return 1 + recursiveCalculateDistance(workerHomex-0.5, workerHomey+0.5);
    }
    return 1 + recursiveCalculateDistance(workerHomex+0.5, workerHomey-0.5);
  }
}
