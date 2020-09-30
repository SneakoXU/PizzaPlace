public class PizzaPlaceRunner {
    public static void main(String[] args) {
        PizzaPlace pizzaPlace = new PizzaPlace("Pizza, Pizza, Pizza", "513-555-5555");
        PizzaGUI app = new PizzaGUI(
                pizzaPlace.getName(),
                pizzaPlace.getCrusts(),
                pizzaPlace.getSizes(),
                pizzaPlace.getIngredients());
    }
}
