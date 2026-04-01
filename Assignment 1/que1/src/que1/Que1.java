/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package que1;

/**
 *
 * @author root
 */
public class Que1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Shape s1 = new Rectangle("Blue", 10, 5);
        Shape s2 = new Triangle("Red", 8, 6);

        // Polymorphic behavior
        System.out.println(s1);
        System.out.println(s2);

        // Downcasting
        if (s1 instanceof Rectangle) {
            Rectangle r = (Rectangle) s1; // Downcasting
            System.out.println("Rectangle Area (downcasted): " + r.getArea());
        }

        if (s2 instanceof Triangle) {
            Triangle t = (Triangle) s2; // Downcasting
            System.out.println("Triangle Area (downcasted): " + t.getArea());
        }
    }
    
}
