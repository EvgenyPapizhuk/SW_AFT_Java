package ru.aftlessons.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTest {

    @Test
    public void test (){
        Point t = new Point(3,4);
//        assert t.x == 2;
        assert t.x == 3;
        System.out.println("Тест № 1 пройден");
    }

    @Test
    public void test2 (){
        Point t = new Point(3,4);
//        Assert.assertEquals( t.distance(new Point(3,4)) , 2);
        Assert.assertEquals( t.distance(new Point(3,4)) , 0);
        System.out.println("Тест № 2 пройден");
    }

    @Test
    public void test3 (){
        Point t = new Point(3,4);
        Assert.assertEquals( t.distance(new Point(3,4)) , 0);
        System.out.println("Тест № 3 пройден");
    }

    @Test
    public void test4 (){
        Point t = new Point(3,4);
        Assert.assertEquals( t.distance(new Point(3,3)) , 1);
        System.out.println("Тест № 4 пройден");
    }

    @Test
    public void test5 (){
        Point t = new Point(3,4);
        Assert.assertEquals( t.distance(new Point(4,5)) , 1.4142135623730951);
        System.out.println("Тест № 5 пройден");
    }


}
