//Project: TwoColorsABJ
//File name: TwoColorsABJ.java
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
 	 * edges class for storing edge information
 	 */
    public static class edges{																	
    		int p1;
    		int p2;
    }//class edges
    /**
 	 * vertex stores the color along with each vertex
 	 */
    public static class vertices{																	
    		int vNum;
    		int color;
    }  	//class edges

	/**
	 * DESCRIPTION: runMM
	 */
    public static void runMM(){
    	try{

			Scanner bufRead = new Scanner(System.in);
			while(true){
				boolean bicolorable = true;
				int nVertices = bufRead.nextInt();
				if(nVertices == 0){
					break;
				}//if it hits here there are no more test cases
				int nEdges = bufRead.nextInt();
				if(nEdges == 0){
					System.out.println("BICOLORABLE.");
					continue;
				}//if it enters here it is bicolorable because there are no edges
				vertices[] vertexArray = new vertices[nVertices];
				edges[] edgeArray = new edges[nEdges];
				for(int i = 0;i<nVertices;i++){
					vertexArray[i] = new vertices();
					vertexArray[i].vNum=i;
					vertexArray[i].color=-12;
				}//for parse the input into vertex array
				for(int i = 0; i<nEdges;i++){
					edgeArray[i] = new edges();
					edgeArray[i].p1= bufRead.nextInt();
					edgeArray[i].p2= bufRead.nextInt();
				}//for parse the input into edge array
				Queue<vertices> q=new LinkedList<vertices>();
				vertexArray[edgeArray[0].p1].color = 1;
				q.add(vertexArray[edgeArray[0].p1]);
				while(q.size() != 0){
					vertices curVertex = q.poll();
					for(int e=0;e<nEdges;e++){
						if(edgeArray[e].p1 == curVertex.vNum && vertexArray[edgeArray[e].p2].color == -12){
							vertexArray[edgeArray[e].p2].color = curVertex.color * -1;
							q.add(vertexArray[edgeArray[e].p2]);
						}//if edge is adjacent and un colored color it and add it to the queue
						if(edgeArray[e].p1 == curVertex.vNum && vertexArray[edgeArray[e].p2].color == curVertex.color){
							bicolorable = false;
							break;
						}//if the test case is not bicolorable if it enters this if statement
					}
				}//while
				if(bicolorable == true){
					System.out.println("BICOLORABLE.");
				}//if
				if(bicolorable == false){
					System.out.println("NOT BICOLORABLE.");
				}//if
			}//while
		}//try()
		catch(Exception exception){
			System.out.println(exception);
		}//catch()
    }//runMM()
}//end TwoColorsABJ.java