/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package que5;

/**
 *
 * @author root
 */
import java.util.*;

// This class doesn't have to be public if it's in the same file
class Category {
    int id;
    String name;
    Integer parentId;

    public Category(int id, String name, Integer parentId) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
    }
}
public class CategoryTree {
    public static void main(String[] args) {
        List<Category> categories = new ArrayList<>();
        categories.add(new Category(1, "Clothing", null));
        categories.add(new Category(2, "Male Clothing", 1));
        categories.add(new Category(3, "Female Clothing", 1));
        categories.add(new Category(4, "Shirts", 2));
        categories.add(new Category(5, "Dress Material", 3));
        categories.add(new Category(6, "Trousers", 2));
        categories.add(new Category(7, "Gowns", 3));
        categories.add(new Category(8, "Silk Dress Material", 5));
        categories.add(new Category(9, "T-Shirts", 4));
        categories.add(new Category(10, "Full-Arm Shirts", 4));
        categories.add(new Category(11, "Patiala-Dress", 5));

        printCategoryTree(categories);
    }

    public static void printCategoryTree(List<Category> allCategories) {
        Map<Integer, List<Category>> parentChildMap = new HashMap<>();

        for (Category cat : allCategories) {
            parentChildMap
                .computeIfAbsent(cat.parentId, k -> new ArrayList<>())
                .add(cat);
        }

        printRecursive(null, parentChildMap, 0);
    }

    private static void printRecursive(Integer parentId, Map<Integer, List<Category>> map, int level) {
        List<Category> children = map.get(parentId);
        if (children == null) return;

        for (Category child : children) {
            // Creates the tree visual effect
            String indent = "   ".repeat(level);
            String connector = (level > 0) ? "|__ " : "";
            System.out.println(indent + connector + child.name);
            
            printRecursive(child.id, map, level + 1);
        }
    }
}
