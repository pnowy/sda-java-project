package pl.sda.programming1.datastructures.domain;

import com.google.common.base.Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class Category {

    private String id;
    private String name;
    private Category parent;
    private List<Category> children;
    private int level;

    private Category() {
        this.id = UUID.randomUUID().toString();
        this.children = new ArrayList<>();
    }

    public Category(String name) {
        this();
        this.parent = null;
        this.name = name;
        this.level = 0;
    }

    private Category(String name, Category parent) {
        this();
        this.name = name;
        this.parent = parent;
        this.level = parent.level + 1;
    }

    public Category addSubcategory(String name) {
        Category child = new Category(name, this);
        this.children.add(child);
        return child;
    }

//    public Category addSubcategory(String ... names) {
//        Category newCategory = addSubcategory(names[0]);
//        Arrays.asList(names).stream().skip(1).forEach(n -> {
//            newCategory.addSubcategory(n);
//        });
//        return newCategory;
//    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Strings.repeat(" ", this.level * 3)).append(this.name).append("\n");
        for (Category subCategory : children) {
            sb.append(subCategory.toString());
        }
        return sb.toString();
    }
}
