import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ExpenseManager manager = new ExpenseManager();
        
        while (true) {
            System.out.println("\n===== Student Expense Tracker =====");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Generate Report");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            
            int ch = sc.nextInt();
            sc.nextLine();

            if (ch == 1) {
                System.out.print("Enter Description: ");
                String desc = sc.nextLine();
                System.out.print("Enter Category: ");
                String cat = sc.nextLine();
                System.out.print("Enter Amount: ");
                double amt = sc.nextDouble();

                manager.addExpense(new Expense(desc, cat, amt));
                System.out.println("Expense Added!");

            } else if (ch == 2) {
                System.out.println("\n--- All Expenses ---");
                for (Expense e : manager.getExpenses()) {
                    System.out.println(e);
                }

            } else if (ch == 3) {
                System.out.println("\n--- Report ---");
                System.out.println("Total Spent: ₹" + ReportGenerator.getTotal(manager));
                ReportGenerator.printCategoryTotals(manager);

            } else if (ch == 4) {
                break;
            }
        }

        sc.close();
    }
}
