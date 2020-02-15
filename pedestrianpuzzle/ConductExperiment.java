
class ConductExperiment {







  public static void main(String[] args) {

    final double mediumNeighborhoodSize = 100;
    final Point mediumTownhall = new Point(mediumNeighborhoodSize/2, mediumNeighborhoodSize/2);
    final Neighborhood mediumNeighborhood = new Neighborhood(mediumNeighborhoodSize, mediumTownhall);
    final DistanceCalculator mediumOrthogonalCalculator = new OrthogonalDistanceCalculator(mediumTownhall); 
    final DistanceCalculator mediumDiagonalCalculator   = new DiagonalDistanceCalculator(mediumTownhall); 

    final double orthogonalMediumDistance = mediumOrthogonalCalculator.calculateDistance(50, 0);
    final double diagonalMediumDistance   = mediumDiagonalCalculator.calculateDistance(50, 0);


    System.out.println("Neighborhood size is "+mediumNeighborhoodSize);
    System.out.println("Distance using orthogonal sidewalks is " + orthogonalMediumDistance);
    System.out.println("Distance using diagonal sidewalks is " + diagonalMediumDistance);
 
    
    System.out.println("The End");  


  }

}


