package ru.qa.rtsoft;

public class MyFirstProgram {

  public static void main(String[] args) {
    hello("World");
    hello("User");
    hello("All");

    Square s = new Square(5);
    System.out.println("Площадь квадрата со стороной " + s.l + " равна " + area(s));


    Rectangle r = new Rectangle(4,7);
    System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " равна " + area(r));
  }

  public static void hello(String somebody) {
    System.out.println("Hello, " + somebody + "!");
  }

  public static double area(Square s) {
    return s.l * s.l;

  }

  public static double area (Rectangle r) {
    return r.a * r.b;

  }


}