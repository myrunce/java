package codingDojo.zooKeeper;

public class ZooKeeperTest {

	public static void main(String[] args) {
		Gorilla bobby = new Gorilla();	
	
		bobby.throwSomething();
		bobby.throwSomething();
		bobby.throwSomething();
		bobby.eatBananas();
		bobby.eatBananas();
		bobby.climb();
		bobby.displayEnergy();
		
		Dragon myron = new Dragon();
		
		myron.attackTown();
		myron.attackTown();
		myron.attackTown();
		myron.eatHumans();
		myron.eatHumans();
		myron.fly();
		myron.fly();
		myron.displayEnergy();
	}
}
