import java.lang.Math;

class OrthogonalDistanceCalculator implements DistanceCalculator {

  private final Point townHall;

  OrthogonalDistanceCalculator(final Point townHall) {
    this.townHall = new Point(townHall.x, townHall.y);
  }

  @Override
  public double calculateDistance(final double homex, final double homey) {
    return Math.abs(homex - townHall.x) + Math.abs(homey - townHall.y);
  }

}
