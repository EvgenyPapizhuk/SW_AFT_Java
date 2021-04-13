public class printHelloWorld {
    public static void main(String[] args) {
//        System.out.println("Hello World!");

        Point sample = new Point(3, 4);
        System.out.println("Дистанция между точками: " + sample.distance(new Point(4, 3)));
        System.out.println("Дистанция между точками: " + sample.distance(new Point(3, 4)));
        System.out.println("Дистанция между точками: " + sample.distance(new Point(10, 10)));


    }
}