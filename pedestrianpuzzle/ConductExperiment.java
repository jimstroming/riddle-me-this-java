
class ConductExperiment {







  public static void main(String[] args) {

    final double mediumNeighborhoodSize = 1000;
    final Point mediumTownhall = new Point(mediumNeighborhoodSize/2, mediumNeighborhoodSize/2);
    final Neighborhood mediumNeighborhood = new Neighborhood(mediumNeighborhoodSize, mediumTownhall);
    final DistanceCalculator mediumOrthogonalCalculator = new OrthogonalDistanceCalculator(mediumTownhall); 
    final DistanceCalculator mediumDiagonalCalculator   = new DiagonalDistanceCalculator(mediumTownhall); 

    // final double orthogonalMediumDistance = mediumOrthogonalCalculator.calculateDistance(50, 0);
    // final double diagonalMediumDistance   = mediumDiagonalCalculator.calculateDistance(50, 0);
    // final boolean isOrthogonalCloserMedium = mediumNeighborhood.blockMethodOneIsCloserForThisWorker(50, 0,
    //                                 mediumOrthogonalCalculator, mediumDiagonalCalculator);



    System.out.println("Neighborhood size is "+mediumNeighborhoodSize);
    // System.out.println("Distance using orthogonal sidewalks is " + orthogonalMediumDistance);
    // System.out.println("Distance using diagonal sidewalks is " + diagonalMediumDistance);
    // System.out.println("Is orthogonal closer? " + isOrthogonalCloserMedium);

    System.out.println("Now let's try the entire neighborhood");

    final double diagonalBetter = mediumNeighborhood.percentMethod1CloserForEntireNeighborhood(
                                             mediumDiagonalCalculator, mediumOrthogonalCalculator);

    System.out.println("Diagonal is better " + diagonalBetter + " of the time");

    System.out.println("The End");  


  }

}


