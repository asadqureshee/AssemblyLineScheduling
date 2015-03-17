//Muhammad Asad Ullah
//Registration number 01199
//BSCS 2-B

package assemblyline;

public class AssemblyLine {

	public static int fastestWay(int[][] stationTime, int[][] transferTime, int[] entryTime, int[] exitTime){
		if(entryTime.length != exitTime.length){
			System.err.println("Entry times not equal to exit times "); // throws error if entrytimes not equal to exit times
			return 55;
			
		}
		
		if(transferTime[0].length != transferTime[1].length){
			System.err.println("Incorrect arguments for transfer time bwteeen stations"); //throws error if transition times instances are greater than station times
			return 56;
		}
		
		if(stationTime[0].length != stationTime[1].length){
			System.err.println("Number of stations are not the same");    //stations should be same else error
			return 57;
		}
		
		int n = stationTime[0].length;
		int[] f1 = new int[n];   
		int[] f2 = new int[n];   
		
		int time = 0;
		f1[0] = entryTime[0] + stationTime[0][0];    //getting the first station's time
		f2[0] = entryTime[1] + stationTime[1][0];
		int[] line = new int[n];

		if (f1[0] < f2[0])
			line[0] = 1;
		else
			line[0] = 2;
	
		
		System.out.println("\nOptimal Path");
		System.out.println("\nStart\n");


		for(int i=1; i<n; i++){      //algorithm implemetnation
			if(f1[i-1]+stationTime[0][i] <= f2[i-1]+transferTime[1][i-1]+stationTime[0][i]){
				f1[i] = f1[i-1]+stationTime[0][i];
			}
			else{

				f1[i]  = f2[i-1]+transferTime[1][i-1]+stationTime[0][i];	
		
			}

			if(f2[i-1]+stationTime[1][i] <= f1[i-1]+transferTime[0][i-1]+stationTime[1][i]){
				f2[i] = f2[i-1]+stationTime[1][i];
				}
			else{
				f2[i] = f1[i-1]+transferTime[0][i-1]+stationTime[1][i];    
				}


			if(f1[i] <= f2[i]){     //checks which line was chosen. 
				line[i] = 1;
			}
			else{
				line[i] = 2;
			}



		}


		if(f1[n-1]+exitTime[0] <= f2[n-1]+exitTime[1]){
			time  = f1[n-1]+exitTime[0];        //returns the one with the lowest cost. 
		}
		else{
			time  = f2[n-1]+exitTime[1];
		}


		int count = 1;
		for( int z =0 ; z<n ;  z++)    //prints the optimal line and the respective stations in order they were visited. 
		{	

			System.out.println("Line:  " + line[z] +    "   Station:  " + count );
			count++;
		}

		System.out.println("\nEnd");

		//System.out.println("\n");

		return time;
	}





	
}
