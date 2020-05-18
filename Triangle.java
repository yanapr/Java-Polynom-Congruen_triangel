
/*
 * This program gets the following 3 parameters from the user:
 * masurment of side1 ,side2, side3 
 * The sides are gonna be the lenghts of the side of the triangle
 * This program will calculate the area and the perimeter of the triangle wich sides given by the user.
 * 
 * @author (Andrey Isakov)
 * @version (1)
 */

import java.util.Scanner;

public class Triangle
{

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("This program calculates the area and the perimeter of given triangle");
        System.out.println("Please enter the three lengths of the triangle's sides");
        int Side1 = scan.nextInt();
        int Side2 = scan.nextInt();
        int Side3 = scan.nextInt();
        double s = (Side1+Side2+Side3)/2.0;//Calculating s for using it in Heron formula

        if(Side1>=Side2+Side3 || Side2>=Side1+Side3 || Side3>=Side1+Side2)// Triangle inequality check 
            System.out.println("The values you typed: " +Side1+","+Side2+","+Side3
                +" are incorrect, please type values that follow the Triangle inequality");
        else

            System.out.println("The area of the triangle is:" + Math.sqrt(s*(s-Side1)*(s-Side2)*(s-Side3))
                +" and the perimeter of the triangle is :" + (Side1+Side2+Side3));//Calculating the area and the perimeter by Heron formula
    }//end of method main
}// end of class Triangle
