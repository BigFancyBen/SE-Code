//Project: ShoeMakerABJ
//File name: ShoeMakerABJ.java
//Programmer: Ben Adams
//Attribution: none

//default package

//------------
//Java imports
//------------
import java.io.*; 
import java.util.*;

//-------------------
//Application imports
//-------------------
//none




class Main {

	/**
	 *DESCRIPTION: main
	 * calls runMM
	 */
    public static void main(String[] args) {
        runMM();
    } //main()


    /**
 	 * jobs class stores each jobs information
 	 */
    public static class jobs{																	//A01
    		int jobID;
    		int jobFee;
    		int jobTime;
    		float greedyFee;
   	}  	//class jobs

	/**
	 * DESCRIPTION: runMM
	 */
    public static void runMM(){
    	try{
			Scanner bufRead = new Scanner(System.in);
			int nQueues = bufRead.nextInt();								//A02
			for(int n = 0;n<nQueues;n++){
				int nJobs = bufRead.nextInt();
				jobs[] jobsArray= new jobs[nJobs];												//A03
				for(int i = 0;i<nJobs;i++){														//A04
					int time = bufRead.nextInt();
					int fee = bufRead.nextInt();
					jobsArray[i] = new jobs();
					jobsArray[i].jobID = i+1;
					jobsArray[i].jobTime =time;
					jobsArray[i].jobFee =fee;
					jobsArray[i].greedyFee = (float)jobsArray[i].jobFee/jobsArray[i].jobTime;	
				}//for() - parsing into array
				int j;
				boolean flag = true;
				jobs temp;
				while(flag){																	//A05
					flag = false;
					for(j=0;j<jobsArray.length-1;j++){
						if(jobsArray[j].greedyFee<jobsArray[j+1].greedyFee){
							temp =jobsArray[j];
							jobsArray[j] = jobsArray[j+1];
							jobsArray[j+1] = temp;
							flag = true;
						}//if() - bubble sort logic
					}//for()
				}//while()
				if(n>0){
					System.out.println();
				}
				for(int i = 0;i<nJobs;i++){														//A06
					System.out.print(jobsArray[i].jobID);
					if(i!=nJobs-1){
						System.out.print(" ");
					}
				}//for
				System.out.println();
			}//if() - all the queues are done
			return; //hits this if no errors are caught
		}//try()
		catch(Exception exception){
			System.out.println("[ERROR]");
		}//catch()
    }//runMM()
}//end ShoeMakerABJ.java