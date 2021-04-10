public class printHelloWorld {
    public static void main(String[] args) {
//        System.out.println("Hello World!");

        System.out.println("Дистанция между точками: " + Point.distance(new Point(3, 4), new Point(4, 3)));
        System.out.println("Дистанция между точками: " + Point.distance(new Point(3, 4), new Point(3, 4)));
        System.out.println("Дистанция между точками: " + Point.distance(new Point(3, 4), new Point(10, 10)));


    }
}