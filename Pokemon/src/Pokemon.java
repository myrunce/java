
public class Pokemon {
	private String name;
	private int health;
	private String type;
	private static int pokemonCount = 0;
	
	public Pokemon(String nameParam, int healthParam, String typeParam) {
		this.name = nameParam;
		this.health = healthParam;
		this.type = typeParam;
		pokemonCount++;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setHealth(int health) {
		this.health = health;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getHealth() {
		return this.health;
	}
	
	public String getType() {
		return this.type;
	}
}
