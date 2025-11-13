import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        // I. Joining
        // 1. Nối đơn giản
        String s1 = names.stream().collect(Collectors.joining());
        System.out.println(s1);
        // Kết quả: "AliceBobCharlie"

        // 2. Nối với dấu phân cách (delimiter)
        String s2 = names.stream().collect(Collectors.joining(", "));
        System.out.println(s2);
        // Kết quả: "Alice, Bob, Charlie"

        // 3. Nối với dấu phân cách, tiền tố (prefix) và hậu tố (suffix)
        String s3 = names.stream().collect(Collectors.joining(", ", "[", "]"));
        System.out.println(s3);
        // Kết quả: "[Alice, Bob, Charlie]"

//      II. GroupBy
        List<Product> products = Arrays.asList(
                new Product("Apple", "Fruit", 1.8),
                new Product("Broccoli", "Vegetable", 0.5),
                new Product("Orange", "Fruit", 1),
                new Product("Carrot", "Vegetable", 0.3)
        );
        // Key: String (tên danh mục)
        Map<String, List<Product>> byCategory = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory));
        // Product::getCategory là cách viết ngắn của p -> p.getCategory()
        System.out.println(byCategory);


        // Key: Price (Giá cả)
        Map<String, List<Product>> listProductGroupByPrice = products.stream().collect(Collectors.groupingBy(product -> {
            if (product.getPrice() < 1) {
                return "Cheap";
            } else {
                return "Expensive";
            }
        }));
        System.out.println(listProductGroupByPrice);

        // Ngoài nhóm, có thể dùng groupingBy để count
        Map<String, Long> countByCategory = products.stream().collect(Collectors.groupingBy(Product::getCategory, Collectors.counting()));
        System.out.println(countByCategory);
    }
}