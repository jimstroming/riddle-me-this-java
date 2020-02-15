import java.lang.Math;

class OrthogonalDistanceCalculator implements DistanceCalculator {

  private final Point townHall;

  OrthogonalDistanceCalculator(final double townHallx, final double townHally) {
    townHall = new Point(townHallx, townHally);
  }

  @Override
  public double calculateDistance(final double homex, final double homey) {
    return Math.abs(homex - townHall.x) + Math.abs(homey - townHall.y);
  }

}
