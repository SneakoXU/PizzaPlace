

import java.util.ArrayList;

public class PizzaPlace {
    String name;
    String phone;
    ArrayList<Crust> crusts;
    ArrayList<Size> sizes;
    ArrayList<Ingredient> ingredients;
    ArrayList<Order> orders;

    public PizzaPlace(String name, String phone) {
        this.name = name;
        this.phone = phone;
        this.orders = new ArrayList<Order>();
        //sizes
        this.sizes = new ArrayList<Size>();
        this.sizes.add(new Size("Small", 6, 8));
        this.sizes.add(new Size("Medium", 10, 12));
        this.sizes.add(new Size("Large", 14, 16));

        //crusts
        this.crusts = new ArrayList<Crust>();
        this.crusts.add(new Crust("Thin", 0));
        this.crusts.add(new Crust("Regular", 0));
        this.crusts.add(new Crust("Deep-dish", 0));


        //ingredients
        this.ingredients = new ArrayList<Ingredient>();
        this.ingredients.add(new Ingredient("Cheese", 0));
        this.ingredients.add(new Ingredient("Pepperoni", 0));
        this.ingredients.add(new Ingredient("Sausage", 0));
        this.ingredients.add(new Ingredient("Mushrooms", 0));
        this.ingredients.add(new Ingredient("Pineapple", 0));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public ArrayList<Crust> getCrusts() {
        return crusts;
    }

    public void setCrusts(ArrayList<Crust> crusts) {
        this.crusts = crusts;
    }

    public ArrayList<Size> getSizes() {
        return sizes;
    }

    public void setSizes(ArrayList<Size> sizes) {
        this.sizes = sizes;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }
}
