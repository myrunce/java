
public abstract class AbstractClass implements PokemonInterface{
	
	public Pokemon createPokemon(String name, int health, String type) {
		return new Pokemon (name, health, type);
	}
	
	public void attackPokemon(Pokemon p) {
		int currentHealth = p.getHealth() - 10;
		p.setHealth(currentHealth);
	}
}
