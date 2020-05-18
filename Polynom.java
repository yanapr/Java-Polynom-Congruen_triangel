/**
 * The class represents one polynom element as list.
 *
 * @author (Andrey Isakov)
 * @version (08/02/2020)
 */

public class Polynom {
    // instance variables
    private PolyNode _head;
    /**
     * creating new list 
     */
    public Polynom () {
        _head = null;
    }
    

    /**
     * getting object from polynome class and initializing the start of the list with this object
     * @param p - object from polynome class to initialize the list  
     */
    public Polynom (PolyNode p) {
        _head = p;
    }

    
    /**
     * gets the start of the list (made this for using some tester that studet made)
     */
    public PolyNode getHead(){
        return _head;
    }

    
    /**
     * 
     * Adding given polynode to another polynom sibuhiot O(n+m)
     * @param privew - the privew object in the list
     * @param p - the polynode added 
     * @return this - the sum of polynom and given polynode if the list is empy will return given polynode
     */
    public Polynom addNode(PolyNode p) {
        //checking if the list is empty if so initializing the list with p if not the list is not empty adding the polynode to other polynom
        if (_head == null) {

            _head = p;

        } else {

            PolyNode privew = null, next = _head;
            // going from start of the list to the end and adding 2 polynoms by arithmetics
            while (next != null) {

                if(next.getPower() < p.getPower()) {

                    p.setNext(next);

                    if(privew == null) {
                        _head = p;
                    } else {
                        privew.setNext(p);
                    }

                    break;
                }

                if(next.getNext() == null) {

                    next.setNext(p);

                    break;
                }

                privew = next;
                next = next.getNext();

            }  

        }
        return this;
    }
    
    
    /**
     * 
     * Geting scalar and multiply the polynome by given scalar 
     * @param num - the scalar
     * @param runner - the new polynome after multiply by scalar 
     * @return this - the new polynome after multiply by num
     */
    public Polynom multByScalar (int num) {
        PolyNode runner = _head;
        // going from the start of the polynode to the end and multiply each coefficient by num
        while(runner != null) {
            runner.setCoefficient(runner.getCoefficient()*num);
            runner = runner.getNext();
        }
        return this;
    }
    
    
    /**
     * 
     * Geting polynome that added to another polynome 
     * @param other - other polynome added 
     * @param a - the start of the polynome 
     * @param b - the start of the other polynome
     * @return this - the result of the sum of 2 polynoms 
     */
    public Polynom addPol (Polynom other) {

        PolyNode a = _head , b = other._head;
        //going going through other polynome
        while(b != null) {
            // checking if first polynome is empty if so go through other polynome to the sum of both polynoms exit when out of polynode in other polynome
            if(a == null) {
                while(b != null) {
                    addNode( new PolyNode(b) );
                    b = b.getNext();
                }
                break;
            }
            // add 2 polynoms by arithmetics rules of math
            if(a.getPower() < b.getPower()) {

                addNode( new PolyNode(b) );

                b = b.getNext();
            }
            else if(a.getPower() > b.getPower()) {

                a = a.getNext();
            }
            else if(a.getPower() == b.getPower()) {

                a.setCoefficient( a.getCoefficient() + b.getCoefficient() );

                b = b.getNext();
            }

        }
        return this;
    }
    
    
    /**
     * 
     * Geting polynome that multiply by another polynome 
     * @param a - start of polynome 
     * @param a - start of other polynome
     * @param paramByAll - polynom for calculation
     * @param power - polynom for calculation
     * @param coefficient - polynom for calculation
     * @param AllParamByAll - the multiply new polynom
     * @return this - the result of the multiply of 2 polynoms 
     */
    public Polynom multPol (Polynom other) {

        PolyNode a = _head;
        Polynom AllParamByAll = new Polynom();
        // going through firstand second polynom and multiply the power of both polynoms and adding each coefficient of both polynoms
        while(a != null) {

            PolyNode b = other._head;
            Polynom paramByAll = new Polynom();

            while(b != null) {

                int power = a.getPower() + b.getPower(); 
                double coefficient = a.getCoefficient() * b.getCoefficient();
                //adding new polynode with new power and coefficient values to paramByAll 
                paramByAll.addNode( new PolyNode(power,coefficient) );

                b = b.getNext();
            }
            //adding the paramByAll polynom to the final result and moving through list
            AllParamByAll.addPol(paramByAll);

            a = a.getNext();

        }

        _head = AllParamByAll._head;

        return this;
    }
    /**
     * 
     * differential on polynom 
     * @param privew - privew polynome  
     * @param next - the start of the polynome 
     * @param power - the power after differential action
     * @param coefficient - the coefficient after differential action
     * @return this - the result of the differential action on the polynom
     */
    public Polynom differential () {

        PolyNode privew = null, next = _head;

        while (next != null) {
            //after differential action 
            int power = next.getPower() - 1; 
            double coefficient = next.getCoefficient() * next.getPower();
            // in case power <0 go to the next polynode if the power is 1 return 1 on polynode if the power is 0 return 0  
            //all calculation on power and coefficient
            if(power < 0) {

                if(privew == null) {
                    _head = next.getNext();

                    next = _head;
                } else {
                    privew.setNext(next.getNext());

                    next = privew;
                }

            } else {
                next.setCoefficient(coefficient);
                next.setPower(power);
            }

            privew = next;
            next = next.getNext();

        }
        return this;
    }
    
    
    /**
     * 
     * returns a String that represents polynom 
     * @param ret - final return of polynom
     * @param runner - runs from start to end of the polynome
     * @return String that represents this polynom in the following format :2.8x^10-4.9x^3+6.5x^2-12.0
     */
    public String toString() {

        String ret = "";
        PolyNode runner = _head;
        //runs from start to end of the polynome and adding the polynods by recurtion O(n) time and O(1)
        while (runner != null) {

            ret += runner.getCoefficient() > 0 ? "+" : "";
            ret += runner.toString();
            ret += " ";
            runner = runner.getNext();
        }
        return ret;
    }
}