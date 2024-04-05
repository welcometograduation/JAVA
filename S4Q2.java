import java.util.*;

public class S4Q2 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String city, code;
        Map<String, String> cmap = new HashMap<>();
        cmap.put("Nashik", "111");
        cmap.put("Mumbai", "222");
        cmap.put("Pune", "333");

        int choice;
        do {
            System.out.println("1. Add a city and its STD code");
            System.out.println("2. Remove a city");
            System.out.println("3. Search for a city and display its STD code");
            System.out.println("4. Display Map");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter City to insert in Map: ");
                    city = sc.next();
                    if (!cmap.containsKey(city)) {
                        System.out.print("Enter STD Code: ");
                        code = sc.next();
                        cmap.put(city, code);
                        System.out.println("Added Successfully!");
                    } else {
                        System.out.println("City already exists!");
                    }
                    break;

                case 2:
                    System.out.print("Enter City name to remove: ");
                    city = sc.next();
                    if (cmap.containsKey(city)) {
                        cmap.remove(city);
                        System.out.println("Removed Successfully!");
                    } else {
                        System.out.println("City does not exist!");
                    }
                    break;

                case 3:
                    System.out.print("Enter city name to search: ");
                    city = sc.next();
                    if (cmap.containsKey(city)) {
                        code = cmap.get(city);
                        System.out.println("STD Code for City " + city + ": " + code);
                    } else {
                        System.out.println("City not found!");
                    }
                    break;

                case 4:
                    System.out.println("City and codes :\n"+cmap);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
            }
        } while (choice != 5);

        sc.close();
    }
}
