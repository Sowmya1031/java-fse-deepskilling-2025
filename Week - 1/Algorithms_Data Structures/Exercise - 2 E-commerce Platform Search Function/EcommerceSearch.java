import java.util.*;

public class EcommerceSearch {

    // Product class (inside the same file)
    static class Product {
        int productId;
        String productName;
        String category;

        public Product(int productId, String productName, String category) {
            this.productId = productId;
            this.productName = productName;
            this.category = category;
        }

        public String toString() {
            return productId + " - " + productName + " (" + category + ")";
        }
    }

    // Linear Search
    public static Product linearSearch(Product[] products, int targetId) {
        for (Product product : products) {
            if (product.productId == targetId) {
                return product;
            }
        }
        return null;
    }

    // Binary Search
    public static Product binarySearch(Product[] products, int targetId) {
        int left = 0, right = products.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (products[mid].productId == targetId) {
                return products[mid];
            } else if (products[mid].productId < targetId) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    // Main Method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Product[] products = {
            new Product(103, "Shoes", "Footwear"),
            new Product(101, "T-shirt", "Clothing"),
            new Product(105, "Phone", "Electronics"),
            new Product(102, "Laptop", "Electronics"),
            new Product(104, "Backpack", "Accessories")
        };

        System.out.println("Welcome to the E-commerce Search Engine!");
        System.out.print("Enter the Product ID to search: ");
        int searchId = scanner.nextInt();

        // Linear Search
        System.out.println("\nLinear Search Result:");
        Product result1 = linearSearch(products, searchId);
        System.out.println(result1 != null ? result1 : "Product not found");

        // Sort for binary search
        Arrays.sort(products, Comparator.comparingInt(p -> p.productId));

        // Binary Search
        System.out.println("\nBinary Search Result:");
        Product result2 = binarySearch(products, searchId);
        System.out.println(result2 != null ? result2 : "Product not found");

        scanner.close();
    }
}
