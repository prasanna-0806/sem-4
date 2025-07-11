import java.util.ArrayList;
import java.util.Scanner;

// Parent class - MenuItem
class MenuItem {
    protected String name;
    protected double price;

    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}

// Child classes for different menu categories
class VegItem extends MenuItem {
    public VegItem(String name, double price) {
        super(name, price);
    }
}

class NonVegItem extends MenuItem {
    public NonVegItem(String name, double price) {
        super(name, price);
    }
}

class Veg_Starter extends MenuItem {
    public Veg_Starter(String name, double price) {
        super(name, price);
    }
}

class NonVeg_Starter extends MenuItem {
    public NonVeg_Starter(String name, double price) {
        super(name, price);
    }
}

class Dessert extends MenuItem {
    public Dessert(String name, double price) {
        super(name, price);
    }
}

class Drinks extends MenuItem {
    public Drinks(String name, double price) {
        super(name, price);
    }
}

// Worker class
class Worker {
    private String name;
    private double salary;
    private int attendance;
    private int leaves;

    public Worker(String name, double salary, int attendance, int leaves) {
        this.name = name;
        this.salary = salary;
        this.attendance = attendance;
        this.leaves = leaves;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public int getAttendance() {
        return attendance;
    }

    public int getLeaves() {
        return leaves;
    }

    public void increaseSalary(double amount) {
        this.salary += amount;
    }

    public void displayWorkerInfo() {
        System.out.println("Name: " + name + " | Salary: Rs. " + salary + " | Attendance: " + attendance + " days | Leaves: " + leaves + " days");
    }
}

// Main Restaurant System
public class RestaurantSystem {
    static ArrayList<MenuItem> menu = new ArrayList<>();
    static ArrayList<MenuItem> orderList = new ArrayList<>();
    static ArrayList<Worker> workers = new ArrayList<>();
    static final String ADMIN_PASSWORD = "hulkbuster@31";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("***************************************************");
        System.out.println("*   WELCOME TO Spice Symphony - A TASTE OF JOY!   *");
        System.out.println("***************************************************");
        System.out.println("\nEnjoy delicious food with a 10% discount on all orders!\n");

        initializeMenu();
        initializeWorkers();

        while (true) {
            System.out.println("\nChoose Mode:");
            System.out.println("1. Admin");
            System.out.println("2. Customer");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int modeChoice = scanner.nextInt();

            switch (modeChoice) {
                case 1:
                    adminMode(scanner);
                    break;
                case 2:
                    customerMode(scanner);
                    break;
                case 3:
                    System.out.println("Exiting... Thank you!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please select again.");
            }
        }
    }

    // Admin Mode
    public static void adminMode(Scanner scanner) {
        System.out.print("Enter Admin Password: ");
        String password = scanner.next();
        if (!password.equals(ADMIN_PASSWORD)) {
            System.out.println("Wrong Password! Access Denied.");
            return;
        }
        while (true) {
            System.out.println("\nAdmin Menu:");
            System.out.println("1. View Workers");
            System.out.println("2. Add Worker");
            System.out.println("3. Increase Salary");
            System.out.println("4. Logout");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    viewWorkers();
                    break;
                case 2:
                    addWorker(scanner);
                    break;
                case 3:
                    increaseSalary(scanner);
                    break;
                case 4:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    // View Worker List
    public static void viewWorkers() {
        System.out.println("\nWorker List:");
        for (Worker worker : workers) {
            worker.displayWorkerInfo();
        }
    }

    // Add a Worker
    public static void addWorker(Scanner scanner) {
        System.out.print("Enter Worker Name: ");
        String name = scanner.next();
        System.out.print("Enter Salary: ");
        double salary = scanner.nextDouble();
        System.out.print("Enter Attendance: ");
        int attendance = scanner.nextInt();
        System.out.print("Enter Leaves: ");
        int leaves = scanner.nextInt();
        workers.add(new Worker(name, salary, attendance, leaves));
        System.out.println("Worker Added Successfully!");
    }

    // Increase Salary
    public static void increaseSalary(Scanner scanner) {
        System.out.print("Enter Worker Name: ");
        String name = scanner.next();
        for (Worker worker : workers) {
            if (worker.getName().equalsIgnoreCase(name)) {
                System.out.print("Enter Amount to Increase: ");
                double amount = scanner.nextDouble();
                worker.increaseSalary(amount);
                System.out.println("Salary Updated!");
                return;
            }
        }
        System.out.println("Worker Not Found!");
    }

    // Customer Mode
    public static void customerMode(Scanner scanner) {
        orderList.clear();
        displayMenu();

        System.out.print("\nEnter number of items to order: ");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter item number " + (i + 1) + ": ");
            int choice = scanner.nextInt();
            if (choice > 0 && choice <= menu.size()) {
                orderList.add(menu.get(choice - 1));
            } else {
                System.out.println("Invalid choice, skipping.");
            }
        }

        // Calculate Bill with 10% Discount
        double bill = calculateBill();
        bill = applyDiscount(bill);

        // Display Final Bill
        displayBill(bill);
    }

    // Initialize Menu
    public static void initializeMenu() {
        menu.add(new VegItem("Paneer Butter Masala", 250.12));
        menu.add(new VegItem("Kaju Paneer Curry", 253.00));
        menu.add(new VegItem("Mushroom Curry", 181.00));
        menu.add(new VegItem("Veg Pulao", 150.00));
        menu.add(new VegItem("Veg Dum Biryani", 210.00));
        menu.add(new VegItem("Paneer Biryani", 280.00));
        menu.add(new VegItem("Veg Fried Rice", 90.00));
        menu.add(new Veg_Starter("Paneer Tikka", 250.00));
        menu.add(new Veg_Starter("Chilli Paneer", 221.00));
        menu.add(new Veg_Starter("Gobi Manchurian", 90.00));
        menu.add(new Veg_Starter("Veg Noodles", 90.00));
        menu.add(new Veg_Starter("Paneer 65", 200.00));
        menu.add(new NonVegItem("Chicken Butter Masala", 260.11));
        menu.add(new NonVegItem("Mutton Curry", 321.50));
        menu.add(new NonVegItem("fish Curry", 321.50));
        menu.add(new NonVegItem("Chicken Pulao", 190.34));
        menu.add(new NonVegItem("Chicken Biryani", 200.50));
        menu.add(new NonVegItem("Chicken Fried Rice", 120));
        menu.add(new NonVegItem("Mutton Biryani", 356.00));
        menu.add(new NonVeg_Starter("Chicken Tikka", 250.00));
        menu.add(new NonVeg_Starter("Chilli Chicken", 121.00));
        menu.add(new NonVeg_Starter("BBQ Chicken", 290.00));
        menu.add(new NonVeg_Starter("Chicken Noodles", 120.00));
        menu.add(new NonVeg_Starter("Chicken Roast(Full)", 190.00));
        menu.add(new Dessert("Ice Cream", 83.00));
        menu.add(new Dessert("Rasmalai", 110.00));
        menu.add(new Dessert("Kheer", 120.00));
        menu.add(new Dessert("Bread Halwa", 79.00));
        menu.add(new Dessert("Gulab Jamun", 138.00));
        menu.add(new Drinks("Coffee", 30.00));
        menu.add(new Drinks("Tea", 20.00));
        menu.add(new Drinks("MilkShake", 121.00));
        menu.add(new Drinks("ButterMilk", 45.00));
        menu.add(new Drinks("Water", 25.00));
        menu.add(new Drinks("Mojito", 89.00));
    }

    // Initialize Workers
    public static void initializeWorkers() {
        workers.add(new Worker("Ravi", 15000, 25, 5));
        workers.add(new Worker("Suresh", 18000, 26, 4));
        workers.add(new Worker("Anita", 17000, 27, 3));
    }

    // Display Menu
    public static void displayMenu() {
        System.out.println("\nMENU:");
        int index = 1;
        for (MenuItem item : menu) {
            System.out.printf("%d. %s - Rs. %.2f\n", index++, item.getName(), item.getPrice());
        }
        System.out.println("\n🎉 Dine & Save - 10% off on all items! 🎉\n");
    }

    // Calculate Total Bill
    public static double calculateBill() {
        double total = 0;
        for (MenuItem item : orderList) {
            total += item.getPrice();
        }
        return total;
    }

    // Apply 10% Discount
    public static double applyDiscount(double bill) {
        return bill * 0.9;
    }

    // Display Final Bill
    public static void displayBill(double bill) {
        System.out.printf("\nTotal Bill after Discount: Rs. %.2f\n", bill);
    }
}

