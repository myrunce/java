
public class Pokedex extends AbstractClass{
	public String pokemonInfo(Pokemon p) {
		return "Name: " + p.getName() + ", Type: " + p.getType() + ", Health: " + p.getHealth();
	}
}
