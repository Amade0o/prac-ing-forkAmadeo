public class DuckSimulator {
 
	public static void main(String[] args) {
		simulate();
	}

	private static void simulate(){
		System.out.println("Creacion de patos");
		Duck patoHelice = new PatoHelice();
		Duck patoMallard = new MallardDuck();
		Duck patoModelo = new ModelDuck();
		Duck patoCriollo = new PatoCriollo();
		Duck patoCagon = new DuckCagon();

		System.out.println("Cadena de quacks");

		patoHelice.performQuack();
		patoMallard.performQuack();
		patoModelo.performQuack();
		patoCriollo.performQuack();
		patoCagon.performQuack();
		
		System.out.println("Cadena de vuelos");

		patoHelice.performFly();
		patoMallard.performFly();
		patoModelo.performFly();
		patoCriollo.performFly();
		patoCagon.performFly();
	}
}
