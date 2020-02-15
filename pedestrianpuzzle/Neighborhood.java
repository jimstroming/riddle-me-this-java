

class Neighborhood {

  private final Point townHall;
 
  private final double townLengthWidth;

  Neighborhood(final double townLengthWidth) {
    this.townLengthWidth = townLengthWidth;
    this.townHall = new Point(townLengthWidth/2, townLengthWidth/2);
  }

  public boolean blockMethodOneIsCloserForThisWorker(final double workerHomex, final double workerHomey, 
                       final DistanceCalculator DistanceCalculator1, final DistanceCalculator DistanceCalculator2) {

    final double distance1 = DistanceCalculator1.calculateDistance(workerHomex, workerHomey);
    final double distance2 = DistanceCalculator2.calculateDistance(workerHomex, workerHomey);
    return distance1 <= distance2;
  }

}
