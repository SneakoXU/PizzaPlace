import java.util.ArrayList;

public class Order {
    ArrayList<Pizza> pizzas;
    double TAX_RATE = 0.07;

    public Order() {
        this.pizzas = new ArrayList<Pizza>();
    }

    //adds new pizza to order/arraylist
    public void addPizza(Pizza pizza){
        this.pizzas.add(pizza);
    }

    //getter that shows list of pizzas ordered
    public ArrayList<Pizza> getPizzas() {
        return pizzas;
    }

    //getter that shows receipt
    public String getReceipt(){
        String receiptString = "PIZZA\n";

        receiptString += "===========================================\n";
        //crust and size
        for(int pizzaCounter = 0; pizzaCounter<pizzas.size(); pizzaCounter++){
            receiptString += "------- Pizza " + pizzaCounter+1 + ": " + "-------\n";
            receiptString += String.format("%-10s& %-10s\t\t$%5.2f\n",
                    pizzas.get(pizzaCounter).getCrust().getName(),
                    pizzas.get(pizzaCounter).getSize().getName(),
                    pizzas.get(pizzaCounter).getSize().getPrice()
            );
            //Toppings
            for(Ingredient ingredient: this.pizzas.get(pizzaCounter).getIngredients()){
                receiptString += String.format("     %-20s\t\t$%5.2f\n", ingredient.getName(), ingredient.getPrice());
            }
        }

        receiptString += "\n\n";
        receiptString += String.format("Subtotal\t\t\t$%5.2f\n", this.getTotal());
        receiptString += String.format("Tax\t\t\t$%5.2f\n", this.getTotal() * TAX_RATE);
        receiptString += "===========================================\n";
        receiptString += String.format("Total\t\t\t$%5.2f\n", this.getTotal() * (1+TAX_RATE));
        receiptString += "________________________________________________";

        return receiptString;
    }

    public double getTotal(){
        double total=0;
        for(Pizza x:pizzas){
            total += x.getTotal();
        }
        return total;
    }


}

