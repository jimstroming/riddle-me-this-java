class Point {

  final double x;
  final double y;

  Point(final double x, final double y) {
    this.x = x;
    this.y = y;
  }

  static boolean equals(Point point1, Point point2) {
    return ((point1.x == point2.x) && (point1.y == point2.y));
  }

}
