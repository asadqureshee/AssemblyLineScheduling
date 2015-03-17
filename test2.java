package assemblyline;

import static org.junit.Assert.*;

import org.junit.Test;

public class test2 {

	@Test
	public void test() {
		
		//int trueCost = 45;
		int[][] stationTime = {{7,9,3,4,8,5}, {8,5,6,4,5,8}}; //array for time taken per station
		int[][] linetransferTime= {{2,3,1,3,4}, {2,1,2,2,1}};  //array for extra cost in changing assembly line 
		int[] entryTime = {2, 4};  //entry times for assembly lines
		int[] leavingTime = {4, 3,5};   //leaving times for asseblmy lines

		int l = AssemblyLine.fastestWay(stationTime, linetransferTime, entryTime, leavingTime);
		if(l == 55){
			fail("Entry times not equal to exit times");
		}

		System.out.println("\nOptimal Time:  "+l);
		//fail("Not yet implemented");
	}
	
	

}
