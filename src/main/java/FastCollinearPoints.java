import java.util.ArrayList;
import java.util.Arrays;

public class FastCollinearPoints {
  private final ArrayList<LineSegment> lineSegments;

  // finds all line segments containing 4 or more points
  public FastCollinearPoints(Point[] points) {
    validate(points);
    lineSegments = new ArrayList<>(points.length);
    Point[] aux = new Point[points.length];
    System.arraycopy(points, 0, aux, 0, points.length);
    for (int i = 0; i < points.length; i++) {
      Point first = null;
      Point last = null;
      int count = 0;
      Arrays.sort(aux, points[i].slopeOrder());
      // sort(points, aux, 0, points.length-1);
      // System.out.println(Arrays.toString(aux));
      ArrayList<Point> pointsList = new ArrayList<>();
      pointsList.add(points[i]);
      for (int j = 0; j < aux.length - 1; j++) {
        System.out.print(points[i].slopeTo(aux[j]) + "  ");
        if (points[i].slopeTo(aux[j]) == points[i].slopeTo(aux[j + 1])) {
         pointsList.add(aux[j]);
         last = aux[j+1];
        }
      }
      pointsList.add(last);
      if (pointsList.size() > 3) {
        System.out.println(pointsList);

        //lineSegments.add(new LineSegment(first, last));
      }
      System.out.println();
    }
  }

  // the number of line segments
  public int numberOfSegments() {
    return lineSegments.size();
  }

  private void validate(Point[] p) {
    if (p == null) throw new IllegalArgumentException();
    for (int i = 0; i < p.length; i++) {
      for (int j = 0; j < p.length; j++) {
        if (p[j] == null) throw new IllegalArgumentException();
        if (i != j && p[i].slopeTo(p[j]) == Double.NEGATIVE_INFINITY) {
          throw new IllegalArgumentException();
        }
      }
    }
  }

  // the line segments
  public LineSegment[] segments() {
    return lineSegments.toArray(new LineSegment[lineSegments.size()]);
  }

 /* private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
    if (hi <= lo) return;
    int mid = lo + (hi - lo) / 2;
    sort(a, aux, lo, mid);
    sort(a, aux, mid + 1, hi);
    merge(a, aux, lo, mid, hi);
  }

  private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {

    for (int k = lo; k <= hi; k++) {
      aux[k] = a[k];
    }

    int i = lo;
    int j = mid + 1;
    for (int k = lo; k <= hi; k++) {
      if (i > mid) a[k] = aux[j++];
      else if (j > hi) a[k] = aux[i++];
      else if (less(aux[j], aux[i])) a[k] = aux[j++];
      else a[k] = aux[i++];
    }
  }

  private static boolean less(Comparable a1, Comparable a2) {
    return a1.compareTo(a2) < 0;
  } */
}
