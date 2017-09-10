package codingDojo.zooKeeper;

public class Dragon extends Mammal {
	
	public Dragon() {
		this.energyLevel = 300;
	}
	
	public void fly() {
		this.energyLevel = energyLevel - 50;
		System.out.println("Dude you're a dragon and now you're flying. WeEeEeEeEeEeE MINUS 50 HEALTH THOUGH");		
	}
	
	public void eatHumans() {
		this.energyLevel = energyLevel + 25;
		System.out.println("Eat Ritika. NoMbnOmNoMnOm taste amazing. PLUS 25 HEALTH");
	}
	
	public void attackTown() {
		this.energyLevel = energyLevel - 100;
		System.out.println("Attack on Town. WOOHOO MINUS 100 HEALTH");
	}

}
