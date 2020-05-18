/**
 * The class represents one polynode element.
 * sibuhiut makom O(1) all methods
 * sibuhiut zman O(n) all methods
 * @author (Andrey Isakov)
 * @version (08/02/2020)
 */



public class PolyNode {
     // instance variables
     private int _power; 
     private double _coefficient; 
     private PolyNode _next;
    /**
     * 
     * Gets the power and the coefficient elements and the next polynone and initializing it 
     * @param _power - the pow of the element
     * @param _coefficient - the coefficient of the element
     * @param _next - next polynode on the list
     */
     public PolyNode(int power,double coefficient, PolyNode next) {
         //checking if the power and coefficient meeting the question requirements
         if (power < 0 || coefficient < 0) {
             _power = 0;
             _coefficient = 0;
         }
         _coefficient = coefficient;
         _power = power;
         _next = next;
     }
     /**
     * 
     * Gets the power and the coefficient elements and the next polynone and initializing _next to null 
     * if the power is less then 0 the power&coefficient will be initialized to 0
     * if the coefficient is less then 0 the coefficient&power will be initialized to 0
     * @param _power - the pow of the element
     * @param _coefficient - the coefficient of the element
     * @param _next - next polynode on the list
     */
     public PolyNode(int power, double coefficient) {
         //checking if power and coefficient meet the question requirements
         if (power < 0 || coefficient < 0) {
             _power = 0;
             _coefficient = 0;
         }
         _power = power;
         _coefficient = coefficient;
         _next = null;
     }
     /**
     * copy constructor
     * @param p - the polynode to be copied
     */
     public PolyNode(PolyNode p) {

         _power = p._power;
         _coefficient = p._coefficient;
         _next = null;
     }
     
     
     /** gets the power 
     * @return the power 
     */
     public int getPower() {

         return _power;
     }
     
     
     /** gets the coefficient 
     * @return the coefficient 
     */
     public double getCoefficient() {

         return _coefficient;
     }
     
     
     /** gets the next polynode 
     * @return the next polynode 
     */
     public PolyNode getNext() {

         return _next;
     }
     
     
     /** set the power   
     * @param power - the power value to be set
     */
     public void setPower(int power) {

         _power = power;
     }

     
     /** set the coefficient   
     * @param coefficient - the coefficient value to be set
     */
     public void setCoefficient(double coefficient) {

         _coefficient = coefficient;
     }

     
     /** set the next polynode   
     * @param next - the next polynode  value to be set
     */
     public void setNext(PolyNode next) {

         _next = next;
     }
     
     /**
     * returns a String that represents polynode 
     * @return String that represents this polynode in the following format if the power is 2 and the coefficient is 6.5 :
     * "6.5x^2" if  if the power is 2 and the coefficient is -6.5 return "-6.5x^2"
     */
     
     public String toString() {
         
         if(_coefficient == 0) {
             return "";
         }
         //returning onlt the coefficient if the the power is 0
         if(_power == 0) {
             return "" + _coefficient;
         }
         
         //checking if the coefficient is 1 and the power is 1 if so not returning coefficient  before the x
         if(_coefficient == 1) {
             if(_power == 1) {
                 return "x";
             } else {
                 return "x^" + _power;
             }

         }
         if(_coefficient == -1&&_power <0) {
             
                 return "";
             
         }
         //checking if the coefficient is -1 and the power is 1 if so not returning coefficient  before the x return - before the x
         if(_coefficient == -1) {
             if(_power == 1) {
                 return "-x";
             } else {
                 return "-x^" + _power;
             }
         }
         //checking if the power is 1 if so return the polynode withour the power 
         if(_power == 1) {
             return _coefficient + "x";
         } else {
             return _coefficient + "x^" + _power;
         }
         
         
     }

 }  