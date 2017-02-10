package ru.qa.rtsoft;

public class MyFirstProgram {

  public static void main(String[] args) {
    hello("World");
    hello("User");
    hello("All");

    double len = 5;
    System.out.println("Площадь квадрата со стороной " + len + " равна " + area(len));

    double a = 3;
    double b = 4;
    System.out.println("Площадь прямоугольника со сторонами " + a + " и " + b + " равна " + area(a, b));
  }

  public static void hello(String somebody) {
    System.out.println("Hello, " + somebody + "!");
  }

  public static double area(double l) {
    return l * l;

  }

  public static double area (double a, double b) {
    return a * b;

  }


}