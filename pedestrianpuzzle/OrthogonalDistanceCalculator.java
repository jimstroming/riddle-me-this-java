import java.lang.Math;

class OrthogonalDistanceCalculator implements DistanceCalculator {

  final int townHallx;
  final int townHally;

  OrthogonalDistanceCalculator(final int townHallx, final int townHally) {
    this.townHallx = townHallx;
    this.townHally = townHally;
  }

  @Override
  public int calculateDistance(int homex, int homey) {
    return Math.abs(homex - townHallx) + Math.abs(homey - townHally);
  }

}
