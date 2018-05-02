import java.util.ArrayList;

public class BruteCollinearPoints {
  private final ArrayList<LineSegment> segments = new ArrayList<>();

  // finds all line segments containing 4 points
  public BruteCollinearPoints(Point[] p) {
    validate(p);
    for (int i = 0; i < p.length; i++) {
      Point min = null;
      Point max = null;
      for (int j = i; j < p.length; j++) {
        for (int k = j; k < p.length; k++) {
          for (int h = k; h < p.length; h++) {
            if (slope(p[i], p[j], p[k], p[h])) {

              min = getMin(p[i], p[j], p[k], p[h]);
              max = getMax(p[i], p[j], p[k], p[h]);

              segments.add(new LineSegment(min, max));
            }
          }
        }
      }
    }
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

  private boolean slope(Point i, Point j, Point k, Point h) {
    if (i.equals(j) || j.equals(k) || k.equals(h)) return false;
    return i.slopeTo(j) == i.slopeTo(k) && i.slopeTo(k) == i.slopeTo(h);
  }

  private Point getMax(Point i, Point j, Point k, Point h) {
    if ((i.compareTo(j) > 0) &&
            (i.compareTo(k) > 0) &&
            (i.compareTo(h) > 0)
            ) {
      return i;
    }
    if ((j.compareTo(i) > 0) &&
            (j.compareTo(k) > 0) &&
            (j.compareTo(h) > 0)
            ) {
      return j;
    }
    if ((k.compareTo(j) > 0) &&
            (k.compareTo(i) > 0) &&
            (k.compareTo(h) > 0)
            ) {
      return k;
    }
    if ((h.compareTo(j) > 0) &&
            (h.compareTo(k) > 0) &&
            (h.compareTo(i) > 0)
            ) {
      return h;
    }
    return i;
  }

  private Point getMin(Point i, Point j, Point k, Point h) {
    if ((i.compareTo(j) < 0) &&
            (i.compareTo(k) < 0) &&
            (i.compareTo(h) < 0)
            ) {
      return i;
    }
    if ((j.compareTo(i) < 0) &&
            (j.compareTo(k) < 0) &&
            (j.compareTo(h) < 0)
            ) {
      return j;
    }
    if ((k.compareTo(j) < 0) &&
            (k.compareTo(i) < 0) &&
            (k.compareTo(h) < 0)
            ) {
      return k;
    }
    if ((h.compareTo(j) < 0) &&
            (h.compareTo(k) < 0) &&
            (h.compareTo(i) < 0)
            ) {
      return h;
    }
    return i;
  }

  // the number of line segments
  public int numberOfSegments() {
    return segments.size();
  }

  // the line segments
  public LineSegment[] segments() {
    return segments.toArray(new LineSegment[segments.size()]);
  }
}
