import java.lang.Math;

class DiagonalDistanceCalculator implements DistanceCalculator {

  static final double sqrt2 = Math.sqrt(2);

  final double townHallx;
  final double townHally;

  DiagonalDistanceCalculator(final double townHallx, final double townHally) {
    this.townHallx = townHallx;
    this.townHally = townHally;
  }

  @Override
  public double calculateDistance(final double homex, final double homey) {
    return 0;
  }

  

}
