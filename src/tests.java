
public class tests {

	/**
	 * @param args
	 */
	public static boolean testifonline(String[][] equation, String[] point){
		
		// plug the point into the equation
		double xresult = (Double.parseDouble(point[0]) - Double.parseDouble(equation[0][0])) / Double.parseDouble(equation[1][0]) ; 
		//System.out.println("x re:" + xresult);
		double yresult = (Double.parseDouble(point[1]) - Double.parseDouble(equation[0][1])) / Double.parseDouble(equation[1][1]) ;
		//System.out.println("y re:" + yresult);
		double zresult = (Double.parseDouble(point[2]) - Double.parseDouble(equation[0][2])) / Double.parseDouble(equation[1][2]) ;
		//System.out.println("z re:" + zresult);
		
		// compares the results of each of the three parts of the equation (returns 0 if all are equal)
		int istrue = Math.abs(Double.compare(xresult, yresult)) + Math.abs(Double.compare(yresult, zresult));
		//System.out.println("Double.compare(yresult, zresult):" + Double.compare(yresult, zresult));
		//System.out.println("Double.compare(xresult, yresult):" + Double.compare(xresult, yresult));
		//System.out.println("istrue:" + istrue);
		if (istrue == 0) {
			return true;
		} else {
			return false;
		}
	}

	public static void findplanewithlandp(String[][] equation, String[] point){
		
		// point on L
		double pox= Double.parseDouble(equation[0][0]);
		double poy= Double.parseDouble(equation[0][1]);
		double poz= Double.parseDouble(equation[0][2]);
		
		// L direction vector components
		double d1= Double.parseDouble(equation[1][0]);
		double d2= Double.parseDouble(equation[1][1]);
		double d3= Double.parseDouble(equation[1][2]);
		
		//second point on l
		double p1x= d1+pox;
		double p1y= d2+poy;
		double p1z= d3+poz;
		
		// inputed point p
		double px= Double.parseDouble(point[0]);
		double py= Double.parseDouble(point[1]);
		double pz= Double.parseDouble(point[2]);
		
		// vector P0P
		double PoPx = px-pox; //a1
		double PoPy = py-poy; //a2
		double PoPz = pz-poz; //a3
		//System.out.println("vector PoP: " + PoPx + "," + PoPy + ","+ PoPz);
		//vector PoP1
		double PoP1x = d1;//p1x-pox; //b1
		double PoP1y = d2;//p1y-poy; //b2
		double PoP1z = d3;//p1z-poz; //b3
		//System.out.println("vector PoP1: " + PoP1x + "," + PoP1y + ","+ PoP1z);
		
		//crossproduct i(a2b3 - a3b2)  -j(a1b3 - a3b1) k(a1b2 -a2b1) 
		double n1x = (PoPy * PoP1z) - (PoPz * PoP1y);
		double n1y = -1 * ((PoPx * PoP1z) - (PoPz * PoP1x));
		double n1z = (PoPx * PoP1y) - (PoPy * PoP1x);

		System.out.print("\n");
		System.out.print("Plane that contains l and p : ");
		System.out.print(n1x + "(x-(" + pox + ")) + " + 
				n1y + "(y-(" + poy + ")) + " +
				n1z + "(y-(" + poz + "))=0" );
	}
	
	// finds a plane perpendicular to l containing P
	public static void findplaneperpendicular(String[][] equation, String[] point){
		//d1(x- x0)+ d2(y- y0)+ d3(z- z0)=0
		double d1= Double.parseDouble(equation[1][0]);
		double d2= Double.parseDouble(equation[1][1]);
		double d3= Double.parseDouble(equation[1][2]);
		
		double x0= Double.parseDouble(point[0]);
		double y0= Double.parseDouble(point[1]);
		double z0= Double.parseDouble(point[2]);
		
		System.out.print("\n");
		System.out.print("Plane that contains P and is perpendicular to l: ");
		System.out.print(d1 + "(x-(" + x0 + ")) + " + 
				d2 + "(y-(" + y0 + ")) + " +
				d3 + "(y-(" + z0 + "))=0\n" );
		
	}
	
	
	public static void findpointsymmetrictopaboutl(String[][] equation, String[] point)
	{
		// point on L
				double pox= Double.parseDouble(equation[0][0]);
				double poy= Double.parseDouble(equation[0][1]);
				double poz= Double.parseDouble(equation[0][2]);
				
				// L direction vector components
				double d1= Double.parseDouble(equation[1][0]);
				double d2= Double.parseDouble(equation[1][1]);
				double d3= Double.parseDouble(equation[1][2]);
				
				//second point on l
				double p1x= d1+pox;
				double p1y= d2+poy;
				double p1z= d3+poz;
				
				// inputed point p
				double px= Double.parseDouble(point[0]);
				double py= Double.parseDouble(point[1]);
				double pz= Double.parseDouble(point[2]);
				
				// vector P0P
				double PoPx = px-pox; //a1
				double PoPy = py-poy; //a2
				double PoPz = pz-poz; //a3
				//System.out.println("vector PoP: " + PoPx + "," + PoPy + ","+ PoPz);
				//vector PoP1
				double PoP1x = p1x-pox;//p1x-pox; //b1
				double PoP1y = p1y-poy;//p1y-poy; //b2
				double PoP1z = p1z-poz;//p1z-poz; //b3
				//System.out.println("vector PoP1: " + PoP1x + "," + PoP1y + ","+ PoP1z);
	
				// dot product of PoP and PoP1
				double dotproduct = PoPx*PoP1x + PoPy*PoP1y + PoPz*PoP1z;
				 
				double normofpop1squared = (PoP1x*PoP1x) + (PoP1y*PoP1y) + (PoP1z*PoP1z);
				
				double dotovernorm = dotproduct/normofpop1squared;
				
				//projection vecor
				double pvx = dotovernorm*PoP1x;
				double pvy = dotovernorm*PoP1y;
				double pvz = dotovernorm*PoP1z;
				//System.out.println("Projection Vector:" +pvx+" "+pvy+" "+pvz);
				
				//Point M
				double PoMx = pox + pvx; //PoP1x
				double PoMy = poy + pvy;
				double PoMz = poz + pvz;
				//System.out.println("Point M :" +PoMx+" "+PoMy+" "+PoMz);

				
				// vector PM
				double PMx = PoMx - px;
				double PMy = PoMy - py;
				double PMz = PoMz - pz;
				//System.out.println("Point M :" +PMx+" "+PMy+" "+PMz);

				
				// point symmetric Ps
				double Psx = 2*PMx + px;
				double Psy = 2*PMy + py;
				double Psz = 2*PMz + pz;
	
				
				System.out.print("Ps("+ Psx + "," + Psy + "," + Psz + ")");
	}	
	
	
}
