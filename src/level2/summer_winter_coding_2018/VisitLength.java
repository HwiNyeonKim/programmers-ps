package level2.summer_winter_coding_2018;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class VisitLength {
    static Set<Route> moved;

    public int solution(String dirs) {
        moved = new HashSet<>();

        Point current = new Point(0, 0);

        // 명령 수행
        char[] orders = dirs.toCharArray();
        for (char order : orders) {
            Point destination = current;
            switch (order) {
                case 'U':
                    destination = moveUpFrom(current);
                    break;
                case 'D':
                    destination = moveDownFrom(current);
                    break;
                case 'R':
                    destination = moveRightFrom(current);
                    break;
                case 'L':
                    destination = moveLeftFrom(current);
                    break;
            }
            if (!current.equals(destination)) {
                moved.add(new Route(current, destination));
                current = destination;
            }
        }

        return moved.size();
    }

    private Point moveUpFrom(Point p) {
        int x = p.x;
        int y = Math.min(5, p.y + 1);
        return new Point(x, y);
    }

    private Point moveDownFrom(Point p) {
        int x = p.x;
        int y = Math.max(-5, p.y - 1);
        return new Point(x, y);
    }

    private Point moveRightFrom(Point p) {
        int x = Math.min(5, p.x + 1);
        int y = p.y;
        return new Point(x, y);
    }

    private Point moveLeftFrom(Point p) {
        int x = Math.max(-5, p.x - 1);
        int y = p.y;
        return new Point(x, y);
    }
}

class Point {
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Point)) {
            return false;
        }

        Point p = (Point) obj;

        return this.x == p.x && this.y == p.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

class Route {
    public Point start;
    public Point destination;

    public Route(Point start, Point destination) {
        this.start = start;
        this.destination = destination;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Route)) {
            return false;
        }

        Route route = (Route) obj;
        return (this.start.equals(route.start) && this.destination.equals(route.destination))
                || ((this.destination.equals(route.start)) && this.start.equals(route.destination));
    }

    @Override
    public int hashCode() {
        return Objects.hash(start.x + start.y + destination.x + destination.y);
    }
}