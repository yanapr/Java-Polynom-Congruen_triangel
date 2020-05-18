
/*
 * This calss gets the following 12 parameters from the user:
 * x11,y11,x12,y12,x13,y13  represnt the cordinates of the first triangle.
 * x21,y21,x22,y22,x23,y23  represnt the cordinates of the second triangle
 * And making triangle congruent test for triangle created by user inputs  
 * @author (Andrey Isakov)
 * @version (1)
 * 
 */
import java.util.Scanner;
public class Congruent
{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("This program checks whether the two triangles whose vertices are given by the user are congruent.\n"
            +  "Please enter the vertices");

        /*representing the dots first digit number of the triangle second digit number of the dot*/
        double x11 = scan.nextDouble();
        double y11 = scan.nextDouble();
        double x12 = scan.nextDouble();
        double y12 = scan.nextDouble();
        double x13 = scan.nextDouble();
        double y13 = scan.nextDouble();

        double x21 = scan.nextDouble();
        double y21 = scan.nextDouble();
        double x22 = scan.nextDouble();
        double y22 = scan.nextDouble();
        double x23 = scan.nextDouble();
        double y23 = scan.nextDouble();

        //Calculate the value of each side of the triangles
        double a = (Math.sqrt(Math.pow(x11-x12,2)+Math.pow(y11-y12,2)));
        double b = (Math.sqrt(Math.pow(x11-x13,2)+Math.pow(y11-y13,2)));
        double c = (Math.sqrt(Math.pow(x12-x13,2)+Math.pow(y12-y13,2)));

        double d = (Math.sqrt(Math.pow(x21-x22,2)+Math.pow(y21-y22,2)));
        double e = (Math.sqrt(Math.pow(x21-x23,2)+Math.pow(y21-y23,2)));
        double f = (Math.sqrt(Math.pow(x22-x23,2)+Math.pow(y22-y23,2)));

        //Triangle congruent test
        if((a == d && b == e && c == f) || (a == d && b == f && c == e)||(a == e && b == d && c == f) || (a == e && b == f && c == d)
        ||(a == f && b == e && c == d) || (a == f && b == d && c == e)) {
            System.out.println("The first triangle is (" + x11 + "," + y11 + ")" + " (" + x12 + "," + y12 + ")" + " (" + x13 + "," + y13 + ")");
            System.out.println("Its lengths are " +a+"," +b+"," +c);
            System.out.println("The second triangle is (" + x21 + "," + y21 + ")" + " (" + x22 + "," + y22 + ")" + " (" + x23 + "," + y23 + ")");
            System.out.println("Its lengths are "  +d+","+e+ ","+f);
            System.out.println("The triangles are congruent");
        }else{
        
        
            System.out.println("The first triangle is (" + x11 + "," + y11 + ")" + " (" + x12 + "," + y12 + ")" + " (" + x13 + "," + y13 + ")");
            System.out.println("Its lengths are " +a+"," +b+"," +c);
            System.out.println("The second triangle is (" + x21 + "," + y21 + ")" + " (" + x22 + "," + y22 + ")" + " (" + x23 + "," + y23 + ")");
            System.out.println("Its lengths are "  +d+","+e+ ","+f);
            System.out.println("The triangles are not congruent");
        }   

    }
}

