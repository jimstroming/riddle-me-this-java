import java.lang.Math;

class OrthogonalDistanceCalculator implements DistanceCalculator {

  final double townHallx;
  final double townHally;

  OrthogonalDistanceCalculator(final double townHallx, final double townHally) {
    this.townHallx = townHallx;
    this.townHally = townHally;
  }

  @Override
  public double calculateDistance(final double homex, final double homey) {
    return Math.abs(homex - townHallx) + Math.abs(homey - townHally);
  }

}
