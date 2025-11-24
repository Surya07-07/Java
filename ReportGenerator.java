import java.util.HashMap;

public class ReportGenerator {

    public static double getTotal(ExpenseManager manager) {
        double total = 0;
        for (Expense e : manager.getExpenses()) {
            total += e.getAmount();
        }
        return total;
    }

    public static void printCategoryTotals(ExpenseManager manager) {
        HashMap<String, Double> map = new HashMap<>();

        for (Expense e : manager.getExpenses()) {
            map.put(e.getCategory(), map.getOrDefault(e.getCategory(), 0.0) + e.getAmount());
        }

        System.out.println("\nCategory-wise Spending:");
        for (String cat : map.keySet()) {
            System.out.println(cat + " : ₹" + map.get(cat));
        }
    }
}
