# 🍽️ Restaurant Management System in Java

Welcome to **Spice Symphony - A Taste of Joy!**  
This Java-based console application is designed to simplify restaurant operations, including order management and worker administration, for small and mid-sized businesses.

---

## 📌 Features

### 👥 Customer Mode
- Displays a categorized restaurant menu:
  - Veg
  - Non-Veg
  - Starters (Veg & Non-Veg)
  - Desserts
  - Drinks
- Customers can:
  - Select multiple items by number
  - View total price
  - Get a **10% Diwali discount**
  - View a final bill

### 🔐 Admin Mode (Password Protected)
- Password: `hulkbuster@31`
- Admin can:
  - View worker list (with salary, attendance, and leaves)
  - Add new workers
  - Increase salaries of existing workers

---

## 🧱 Code Structure

| Class             | Purpose                                                                 |
|------------------|-------------------------------------------------------------------------|
| `MenuItem`        | Base class for menu items (name, price)                                 |
| `VegItem`, etc.   | Inherited classes for each food category                                |
| `Worker`          | Manages worker details like name, salary, attendance, and leaves        |
| `RestaurantSystem`| Main class handling UI flow, menu, and logic for customer/admin modes   |

---

## 🚀 How to Run

1. Clone or download the repository.
2. Open the project in any Java IDE (e.g., IntelliJ, Eclipse) or run via terminal:
   ```bash
   javac RestaurantSystem.java
   java RestaurantSystem
