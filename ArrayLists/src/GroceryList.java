import java.util.ArrayList;

public class GroceryList {
    private ArrayList<String> groceryList = new ArrayList<>();

    public void addGroceryItem(String item){
        groceryList.add(item);
    }

    public void printGroceryList(){
        if(groceryList.size() <= 1)
            System.out.println("You have " + groceryList.size() + " item in your list");
        else
            System.out.println("You have " + groceryList.size() + " items in your list");
        for(int i = 0; i < groceryList.size(); i++){
            System.out.println((i+1) + ". " + groceryList.get(i));
        }
    }

    public void modifyGroceryItem(int position, String item){
        groceryList.set(position, item);
        System.out.println("Grocery item " + (position + 1) + " has been modified");
    }

    public void removeGroceryItem(int position){
        String item = groceryList.get(position);
        groceryList.remove(position);
        System.out.println("Item " + item + " is removed");
    }

    public String findItem(String searchItem){
        boolean exists = groceryList.contains(searchItem);
        if(exists){
            return groceryList.get(groceryList.indexOf(searchItem));
        }

        return "Item is not found in the list";
    }



}
