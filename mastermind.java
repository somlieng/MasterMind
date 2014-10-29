import java.util.*;


public class mastermind implements methodsSetUp{
	
	public String animalName;
	public String nameName;
	
	public int animalNum; //for when right animal, wrong spot
	public int correctGuess;//for when right animal, right spot
	public int rightAnimalWrongplace;
	public int numPositions;
	
	public ArrayList masterCode = new ArrayList();//code the player inserted
	public ArrayList<animalTable>dataTable = new ArrayList<animalTable>();//this table holds the total number of each type of animal in the code
	public ArrayList finalPermute = new ArrayList (); //this table holds the animals to permute in the next string
	public ArrayList animals = new ArrayList();
//	public ArrayList iterations = new ArrayList();
	
	
	public mastermind() { //method that plays the game
		insertCode();
		animalNum();
		response();
		rightSpot();
		newGame();
	}

	public void animalList(){
		animals.add("Platypus");
		animals.add("Wombat");
		animals.add("Llama");
		animals.add("Alpaca");
		animals.add("Fox");
		animals.add("Wallaby");
	}

	@SuppressWarnings("resource")
	public void insertCode(){ //designate what animals and number of positions here
		Scanner postionNum = new Scanner(System.in);
		
		System.out.println("Please enter if you want either 4 or 6 positions in your code");//designate number of positions
		numPositions = postionNum.nextInt();
		
		animalList();
		
		//insert actual code here
		System.out.println("\nThese are the types of animals you can choose: "+animals);
		
		System.out.println("\nNow it's your time to assign the type of animal to each peg position!\n");
		
			
		//add variation prevention here
		
			for(int p = 0; p<numPositions; p++){ //creates a new node. first node to be created equals to first peg and etc.
				System.out.println("Position "+(p+1)+": ");
				Scanner name = new Scanner(System.in);
				animalName = name.next();
				masterCode.add(animalName);
			}
			
		System.out.println("This is your code!\n"+masterCode);
		
		System.out.println("\nDon't worry! The computer doesn't know what it is!\n\n Alright! Let the game start now!");
		
		System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
		
		
		}
	

	public void animalNum (){
		for(int p = 0; p<animals.size(); p++){ //make guess of all one animal in all positions to find out all animals in length
				String thisAnimal = (String) animals.get(p);
				
				System.out.println("This is Guess "+(p+1)+" from the Computer");
				
				int i = 0;
				while(i < numPositions){
				System.out.print("["+thisAnimal+"] ");
				i++;
				}
				
				Scanner rightWrong = new Scanner (System.in);
				Scanner rightRight = new Scanner (System.in);
				
				System.out.println("How many of the animals were guess correctly but in the wrong position?");
					animalNum = rightWrong.nextInt();
					
				System.out.println("How many were in the correct position?");
					correctGuess = rightRight.nextInt();
						if(correctGuess==4 || correctGuess ==6){
							System.out.println("Hey! I win!\nBye!");
							return;
						}	
					
					animalTable addThis = new animalTable(thisAnimal, animalNum); 
					dataTable.add(addThis);
					dataTable.toString();
				
		}
		
		System.out.println(dataTable);
	}
	
	@SuppressWarnings("resource")
	public void rightSpot(){
		
		
		while(correctGuess!=4||correctGuess!=6){
			
			if(correctGuess==4 || correctGuess ==6){
				System.out.println("Hey! I win!\nBye!");
				return;
			}	
			
		System.out.println(finalPermute);
		
		Scanner rightRight = new Scanner (System.in);
		
		System.out.println("How many were in the correct position?");
		correctGuess = rightRight.nextInt();
			
		permute(finalPermute);
			
		}
	
	}
	
	public ArrayList permute(ArrayList list){
		int i=0;
		for(i=0;i<numPositions;i++){
			Collections.swap(finalPermute,0,i);
			for(int j=1;j<numPositions;j++){
				Collections.swap(finalPermute,0,j);
			}
		}
		return finalPermute;
	}
	
	public void newGame() {
		//resets game but does not construct new game
		
		finalPermute = null;
		masterCode = null;
		dataTable = null;
		numPositions = 0;
		rightAnimalWrongplace = 0;
		correctGuess = 0;
		animalNum = 0;
		nameName=null;
		animalName=null;
		
		
		String[] arguments = new String[2000];
		playGame.main(arguments);
		
	}

	

	public void response() {
		for(int p = 0; p<animals.size(); p++){
			
			if(correctGuess==4 || correctGuess ==6){
				System.out.println("Hey! I win!\nBye!");
				break;
			}	
			
			rightAnimalWrongplace = dataTable.get(p).getNum();
			if(rightAnimalWrongplace!=0){
				nameName = dataTable.get(p).getAnimal();
				for(int k = 0; k<dataTable.get(p).getNum();k++){
				finalPermute.add(nameName);
				}
			}
		}
	}

	
	
}
