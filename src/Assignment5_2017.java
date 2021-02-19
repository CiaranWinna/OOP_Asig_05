/**
 *
 * Student Name: Ciaran Winnan
 * Student Number: 2940836
 */

public class Assignment5_2017 {
 public static void main(String[] args) {
   	// Shape test here================================
   	//1A
	Square sq1 = new Square("Square", 10.5);
	double squareDiagonal = sq1.diagonal();
	System.out.println("Diagonal: " + squareDiagonal);
	double squareArea = sq1.area();
	System.out.println("Area: " + squareArea);
	double squarePerimeter = sq1.perimeter();
	System.out.println("Perimeter: " + squarePerimeter);
	String squareName = sq1.name();
	System.out.println("Name: " + squareName);
	String sqaureToString = sq1.toString();
	System.out.println(sqaureToString);
	sq1.display();
	//1B
	Circle cir1 = new Circle("Circle", 10.5);
	double circleArea = cir1.area();
	System.out.println("\nArea: " + circleArea);
	double circlePerimeter = cir1.perimeter();
	System.out.println("Perimeter: " + circlePerimeter);
	String circleName = cir1.name();
	System.out.println("Name: " + circleName);
	String circleToString = cir1.toString();
	System.out.println(circleToString);
	cir1.display();
	//Test Rational class here ========================
 
  	//First fraction test
  	Rational k = new Rational(4,5);
  	System.out.println("\nFraction 1: "+k);
  	int kNum = k.num();
  	System.out.println("Numerator: "+kNum);
  	int kDen = k.den();
  	System.out.println("Denominator: "+kDen);
  	Rational kAdd = k.add(new Rational(3,26));
  	System.out.println("Add: "+kAdd);
  	Rational kSub = k.add(new Rational(4,8));
  	System.out.println("Sub: "+kSub);
  	Rational kMult = k.mult(new Rational(2,3));
  	System.out.println("Mult: "+kMult);
  	Rational kDiv = k.div(new Rational(5,9));
  	System.out.println("Div: "+kDiv);
  	boolean isEqual = k.eq(new Rational(4,5));
  	System.out.println("Equal: "+isEqual);
  	Rational kMultBy = k.multBy(4);
  	System.out.println(kMultBy);
  	Rational kDivBy = k.divBy(3);
  	System.out.println(kDivBy);
  	String kToString = k.toString();
  	System.out.println(kToString);
  	//Second fraction text
  	Rational k1 = new Rational(20,8);
  	System.out.println("\nFraction 2: "+k1);
  	int k1Num = k1.num();
  	System.out.println("Numerator: "+k1Num);
  	int k1Den = k1.den();
  	System.out.println("Denominator: "+k1Den);
  	Rational k1Add = k1.add(new Rational(3,26));
  	System.out.println("Add: "+k1Add);
  	Rational k1Sub = k1.add(new Rational(4,8));
  	System.out.println("Sub: "+k1Sub);
  	Rational k1Mult = k1.mult(new Rational(2,3));
  	System.out.println("Mult: "+k1Mult);
  	Rational k1Div = k1.div(new Rational(5,9));
  	System.out.println("Div: "+k1Div);
	boolean is2Equal = k1.eq(new Rational(4,5));
  	System.out.println("Equal: "+is2Equal);
  	Rational k1MultBy = k1.multBy(7);
  	System.out.println(k1MultBy);
  	Rational k1DivBy = k1.divBy(3);
  	System.out.println(k1DivBy);
  	String k1ToString = k1.toString();
  	System.out.println(k1ToString);
  //=================================================
 }
}
abstract class Shape{
	private String name;
	public Shape(String n){name = n;}
	public abstract double area();
	public abstract double perimeter();
	public String name(){return name;}
	public String toString(){
	 return String.format("%s area: %6.2f perimeter: %6.2f\n",
				          name, area(), perimeter());
	}
	public void display(){
		System.out.printf("%s with area %6.2f and perimeter %6.2f\n",name, area(), perimeter());
	}
}

class Square extends Shape{
	private double length;
	public Square(String n, double l){
		super(n);
		length = l;
	}
	public double area(){
		double squareArea = length * length;
		return squareArea;
	}
	public double perimeter(){
		double sqaurePerimeter = length + length + length +length; //length * 4;
		return sqaurePerimeter;
	}
	public String name(){
		return super.name();
	}
	public double diagonal(){
		return length*Math.sqrt(2);
	}
	public String toString(){
	 	return String.format("%s area: %6.2f perimeter: %6.2f\n",super.name(), area(), perimeter());
	}
	public void display(){
		System.out.printf("%s with area %6.2f and perimeter %6.2f\n",super.name(), area(), perimeter());
	}
	
}

class Circle extends Shape{
	private double radius;
	public Circle(String n, double r){
		super(n);
		radius = r;
	}
	public double area(){
		double circleArea = Math.PI*(radius * radius);
		return circleArea;
	}
	public double perimeter(){
		double circlePerimeter = 2 * Math.PI * radius;
		return circlePerimeter;
	} 
	public String name(){
		return super.name();
	}
	public String toString(){
	 	return String.format("%s area: %6.2f perimeter: %6.2f\n",super.name(), area(), perimeter());
	}
	public void display(){
		System.out.printf("%s with area %6.2f and perimeter %6.2f\n",super.name(), area(), perimeter());
	}
}


interface Operations{
	public Rational add(Rational q);
	public Rational sub(Rational q);
	public Rational mult(Rational q);
	public Rational div(Rational q);
	public Rational multBy(int k);
	public Rational divBy(int k);
	public boolean eq(Rational q); //returns true if this equals q
} 
class Rational implements Operations{
	private int num,den;
	
	public Rational(int n, int d){//assume d != 0
        if(n < 0 && d < 0){ 
        	n = -n; 
        	d = -d;
        }
        else if(d < 0){
        	n = -n;
        	d = -d;
        }
        //ensures that d never negative and n positive e.g. 1/-2 is changed to -1/2
        int g = gcd(Math.abs(n), Math.abs(d));
        num = n/g;den = d/g;
	}
	
	public Rational(int n){
		num = n; 
		den = 1;
	}
	
	public int num(){return num;}
	
	public int den(){return den;}
	
	public Rational add(Rational q){
		return new Rational(num*q.den+q.num*den, den*q.den);
	}
	
	public Rational sub(Rational q){
		return new Rational(num*q.den-q.num*den, den*q.den);
	}
	
	public Rational mult(Rational q){
		return new Rational(num*q.num, den*q.den);
	}
	
	public Rational div(Rational q){
		return new Rational(num*q.den, den*q.num);
	}
	
	public Rational multBy(int k){
	
		int tempNum = num * k;
		return new Rational(tempNum,den);
		//return new Rational(gcd(Math.abs(tempNum), Math.abs(den)));
	}
	public Rational divBy(int k){
		int tempDen = den * k;
		return new Rational(num, tempDen);
		//return new Rational(gcd(Math.abs(num), Math.abs(tempDen)));
	}
	public boolean eq(Rational q){
		if(q.num == num && q.den == den){
			return true;
		}
		else{
			return false;
		}
	} //returns true if this equals q
	
	public String toString(){
		return num+"/"+den;
	}
	
	private int gcd(int a, int b){
        if(b == 0) return a;
        else return gcd(b,a%b);
  	}
}