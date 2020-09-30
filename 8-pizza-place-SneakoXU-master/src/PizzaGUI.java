import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PizzaGUI extends JFrame {
    private JPanel mainPanel;
    private JPanel labelPanel;
    private JPanel receiptPanel;
    private JPanel optionsPanel;
    private JPanel buttonsPanel;
    private JButton quitButton;
    private JButton clearButton;
    private JButton orderButton;
    private JPanel crustPanel;
    private JPanel sizesPanel;
    private JPanel toppingsPanel;
    private JTextArea receiptTextArea;
    private JLabel Pizza;
    private ArrayList<JCheckBox> ingredientCheckboxes;
    private ArrayList<JRadioButton> crustsRadioButtons;
    private ButtonGroup crustGroup;
    private JComboBox sizeCombo;
    private ArrayList<Crust> availableCrusts;
    private ArrayList<Size> availableSizes;
    private ArrayList<Ingredient> availableIngredients;

    public PizzaGUI(String title, ArrayList<Crust> crusts, ArrayList<Size> sizes, ArrayList<Ingredient> ingredients){
        super(title);
        availableCrusts = crusts;
        availableSizes = sizes;
        availableIngredients = ingredients;

        //create checkboxes using the ingredients
        ingredientCheckboxes = new ArrayList<>();
        for(Ingredient i:ingredients){
            JCheckBox newObj = new JCheckBox(i.toString());
            newObj.putClientProperty("value", i);
            ingredientCheckboxes.add(newObj);
        }
        //create radio buttons using the crusts
        crustsRadioButtons = new ArrayList<>();
        for(Crust c:crusts){
            JRadioButton newObj = new JRadioButton(c.toString());
            newObj.putClientProperty("value", c);
            crustsRadioButtons.add(newObj);
        }

        //create a combo box using the sizes
        sizeCombo = new JComboBox(sizes.toArray());



        add(mainPanel);
        setSize(800,600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        quitButton.addActionListener((ActionEvent e) -> {
            int selectedOption = JOptionPane.showConfirmDialog(
                    null,
                    "Are you sure you want to quit?",
                    "Choose",
                    JOptionPane.YES_NO_OPTION);
            if(selectedOption == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });

        orderButton.addActionListener((ActionEvent e) ->{
            //create order
            Order order = new Order();
            //get user selections
            ArrayList<Ingredient> selectedIngredients = new ArrayList<>();
            for(JCheckBox item: ingredientCheckboxes){
                if(item.isSelected()){
                    //(Ingredient) is casting - the ClientProperty takes a type of object so need to cast it to own type before adding to ArrayList
                    selectedIngredients.add((Ingredient) item.getClientProperty("value"));
                }
            }

            Crust selectedCrust = null;
            for(JRadioButton item: crustsRadioButtons){
                if(item.isSelected()){}
                selectedCrust = (Crust) item.getClientProperty("value");
            }

            Size selectedSize = (Size) sizeCombo.getSelectedItem();

            //create pizza
            Pizza pizza = new Pizza(selectedCrust, selectedSize, selectedIngredients);

            //add pizza to the order
            order.addPizza(pizza);

            //display receipt
            String receipt = order.getReceipt();
            receiptTextArea.setText(receipt);
        });

        //set action for clear button (aka clear out text area)
        clearButton.addActionListener((ActionEvent e) -> {
            receiptTextArea.setText("");
            for (JCheckBox item : ingredientCheckboxes){
                item.setSelected(false);
            }
            for (JRadioButton item : crustsRadioButtons){
                item.setSelected(false);
            }

        });

        //updateUI - adds buttons, checkboxes and combobox to layout
        updateUI();
    }

    private void updateUI(){
        GridLayout toppingsPanelLayout = new GridLayout(ingredientCheckboxes.size(), 1);
        toppingsPanel.setLayout(toppingsPanelLayout);
        for(JCheckBox item:ingredientCheckboxes){
            toppingsPanel.add(item);
        }

        GridLayout crustsPanelLayout = new GridLayout(crustsRadioButtons.size(), 1);
        crustPanel.setLayout(crustsPanelLayout);
        for(JRadioButton item:crustsRadioButtons){
            crustPanel.add(item);
        }

        GridLayout sizesPanelLayout = new GridLayout(1,1);
        sizesPanel.setLayout(sizesPanelLayout);
        sizesPanel.add(sizeCombo);

    }



}
