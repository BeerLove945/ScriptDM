package com.script.work;

import com.script.Point;
import com.script.com.ComDM;
import com.script.util.Delay;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DmMouseSimulator extends AbstractWork{
    private static final int MOUSE_MOVE_DELAY = 5; //
    private static final int CONTROL_POINTS = 4;   //
    public static DmMouseSimulator simulator = new DmMouseSimulator();
    private Random random = new Random();

    private List<Point> generateBezierPath(Point start, Point end) {
        List<Point> controlPoints = generateControlPoints(start, end);
        List<Point> path = new ArrayList<>();

        for (double t = 0; t <= 1; t += getVariableStep()) {
            Point p = calculateBezierPoint(t, controlPoints);
            path.add(p);
        }
        return path;
    }

    private List<Point> generateControlPoints(Point start, Point end) {
        List<Point> points = new ArrayList<>();
        int offset = random.nextInt(50) + 30;

        points.add(start);
        for (int i = 1; i < CONTROL_POINTS - 1; i++) {
            int x = start.x + (end.x - start.x) * i / CONTROL_POINTS
                    + random.nextInt(offset) - offset/2;
            int y = start.y + (end.y - start.y) * i / CONTROL_POINTS
                    + random.nextInt(offset) - offset/2;
            points.add(new Point(x, y));
        }
        points.add(end);
        return points;
    }

    private double getVariableStep() {
        double base = 0.02 + random.nextDouble() * 0.03;
        return base * (1 + Math.sin(Math.PI * random.nextDouble()));
    }

    // Bezier
    private Point calculateBezierPoint(double t, List<Point> points) {
        while (points.size() > 1) {
            List<Point> newPoints = new ArrayList<>();
            for (int i = 0; i < points.size() - 1; i++) {
                int x = (int) (points.get(i).x * (1 - t) + points.get(i + 1).x * t);
                int y = (int) (points.get(i).y * (1 - t) + points.get(i + 1).y * t);
                newPoints.add(new Point(x, y));
            }
            points = newPoints;
        }
        return points.get(0);
    }
    Point lastPoint;
    // real move
    public void realMove(int endX, int endY) {
       realMove(mouse,endX,endY);
    }

    private void sleep(int ms) {
        Delay.delay(ms);
//        try {
//            Thread.sleep(ms);
//        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//        }
    }

    @Override
    public void work() {

    }

    public static void main(String[] args) {
        DmMouseSimulator simulator = new DmMouseSimulator();
        simulator.realMove(800, 600);
    }

    public void realMove(ComDM com, int endX, int endY) {

    }
}
