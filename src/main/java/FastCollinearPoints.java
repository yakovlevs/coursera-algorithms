import java.util.ArrayList;
import java.util.Arrays;

public class FastCollinearPoints {
  private final ArrayList<LineSegment> lineSegments;
  private final Point[] points;

  // finds all line segments containing 4 or more points
  public FastCollinearPoints(Point[] points) {
    validate(points);
    this.points = points;
    lineSegments = new ArrayList<>(points.length);
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
    Point[] aux = new Point[points.length];
    ArrayList<Point> lsp = new ArrayList<>();
    System.arraycopy(points, 0, aux, 0, points.length);
    for (int i = 0; i < points.length; i++) {
      Arrays.sort(aux, points[i].slopeOrder());

      Point first = aux[0];
      Point last = aux[0];
      int count = 0;

      for (int j = 0; j < aux.length - 1; j++) {
        // System.out.print(points[i].slopeTo(aux[j]) + "  ");
        if (points[i].slopeTo(aux[j]) == points[i].slopeTo(aux[j + 1])) {

          first = first.compareTo(aux[j]) < 0 ? first : aux[j];
          first = first.compareTo(aux[j + 1]) < 0 ? first : aux[j + 1];

          last = last.compareTo(aux[j]) > 0 ? last : aux[j];
          last = last.compareTo(aux[j + 1]) > 0 ? last : aux[j + 1];

          count++;
        } else if (first != last) {
          if (count >= 2) {
            break;
          } else {
            first = aux[0];
            last = aux[0];
            count = 0;
          }
        }
      }
      if (first != null && last != null && count >= 2) {
        lsp.add(first);
        lsp.add(last);
      }
      // System.out.println();
      // System.out.println("-----------" + lsp);
    }


    for (int i = 0; i < lsp.size() - 1; i += 2) {
      for (int j = 0; j < lsp.size() - 1; j += 2) {
        if ((i != j) && (lsp.get(i) == lsp.get(j)) && (lsp.get(i + 1) == lsp.get(j + 1))) {
          lsp.remove(j);
          lsp.add(j, null);
          lsp.remove(j + 1);
          lsp.add(j + 1, null);
        }
      }
    }
    //System.out.println(lsp);
    for (int i = 0; i < lsp.size() - 1; i += 2) {
      if (lsp.get(i) != null && lsp.get(i + 1) != null) {
        lineSegments.add(new LineSegment(lsp.get(i), lsp.get(i + 1)));
      }
    }
    return lineSegments.toArray(new LineSegment[lineSegments.size()]);
  }

}
