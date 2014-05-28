import java.util.Scanner;
public class Main {

	static Scanner getin = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("Royal Broussard's Vector Calculus Project");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("input a line :");
		System.out.println("  Symetric input \n  ");
		
		//int input = getin.nextInt();
		
		//Matrix in form
		//xprime	yprime	zprime
		//d1		d2		d3
		
		String[][] equation = { { "x₀", "y₀", "z₀" }, 
								{ "d1", "d2", "d3" }, };
		
		String[] point = {"x","y","z"};
		
		
		equation = getequation(equation);
		
		System.out.println("\ninput a point :");
		point = getpoint(point);
		System.out.println("");
		System.out.print("Equation: ");
		System.out.println("((x-"+((String) equation[0][0])+")/"+((String) equation[1][0])+ ") =" 
		+ " ((y-" + ((String) equation[0][1]) + ")/" + ((String) equation[1][1]) + ") =" + 
		" ((z-" + ((String) equation[0][2]) + ")/" + ((String) equation[1][2]) + ")" );
		
		System.out.print("Point: ");
		System.out.println("P(" + point[0] +"," + point[1] + "," + point[2] + ")");
		
		
		
		boolean isonline = tests.testifonline(equation , point);
		if(isonline == true){
		System.out.println("point P is on line L");
		} else {
		System.out.println("point P DOES NOT lie on line L");
		tests.findplanewithlandp(equation, point);
		}
		
		tests.findplaneperpendicular(equation, point);
		if(isonline == true){
		System.out.print("Since P lies on line L, the point syemtric to P around L would be the same as P :");
		tests.findpointsymmetrictopaboutl(equation, point);
		} else {
		System.out.print("Point syemtric to P around L: ");
		tests.findpointsymmetrictopaboutl(equation, point);
		}
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
		private static String[] getpoint( String[] point){
			for(int i =  0; i<3; i++){
				System.out.println("P(" + point[0] +"," + point[1] + "," + point[2] + ")");
				System.out.print("Enter a value for "+ point[i] + ":");
				String input = getin.next();
				point[i] = input;
			}
			return point;
		}
	
	
		private static String[][] getequation( String[][] equation){
			
			
			for(int i=0; i<3; i++ ){ 
				System.out.println("((x-"+((String) equation[0][0])+")/"+((String) equation[1][0])+ ") =" 
					+ " ((y-" + ((String) equation[0][1]) + ")/" + ((String) equation[1][1]) + ") =" + 
					" ((z-" + ((String) equation[0][2]) + ")/" + ((String) equation[1][2]) + ")" );
			
				System.out.print("Enter Value for " + ((String) equation[0][i]) + ":" );
				
				String  input =   getin.next();
				equation[0][i] = input;
			
			}
			
			
			for( int i = 0; i<3; i++ ){ 
				System.out.println("((x-"+((String) equation[0][0])+")/"+((String) equation[1][0])+ ") =" 
					+ " ((y-" + ((String) equation[0][1]) + ")/" + ((String) equation[1][1]) + ") =" + 
					" ((z-" + ((String) equation[0][2]) + ")/" + ((String) equation[1][2]) + ")" );
			
				System.out.print("Enter Value for " + ((String) equation[1][i]) + ":" );
				String  input =   getin.next();
				equation[1][i] = input;
			
			}
			
			return equation;
			
		}
	
	
}
