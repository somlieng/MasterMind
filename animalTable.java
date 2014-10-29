
public class animalTable {
	private int num;
	private String Animal;
	
	public animalTable(String object, int foo){
		Animal = object;
		num = foo;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getAnimal() {
		return Animal;
	}

	public void setAnimal(String animal) {
		Animal = animal;
	}

	public String toString(){
		return Animal+", "+num;
	}
	
	
}
