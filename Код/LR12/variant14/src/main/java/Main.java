import variant14.Area;

public class Main {

    public static void main(String[] args) {
        Area area = new Area(5);
        System.out.println(area.isPointInArea(0 , 0));
        System.out.println(area.isPointInArea(-5, 0));
        System.out.println(area.isPointInArea(5, 0));
        System.out.println(area.isPointInArea(0, 5));
        System.out.println(area.isPointInArea(0, -5));
        System.out.println(area.isPointInArea(1, -1));

        System.out.println();
        System.out.println(area.isPointInArea(-5, 5));
        System.out.println(area.isPointInArea(5, 5));
        System.out.println(area.isPointInArea(5, -5));
        System.out.println(area.isPointInArea(-5, -5));
    }

}
