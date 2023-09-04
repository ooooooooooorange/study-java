package com.chapter13.wrapper;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Description:
 * @Author: xuzixin9
 * @Date: 2023/5/31 21:59
 */
public class Arrays02 {
    public static void main(String[] args) {
        Book[] books = new Book[4];
        books[0] = new Book("红楼", 100);
        books[1] = new Book("水浒传", 90);
        books[2] = new Book("青年文摘", 5);
        books[3] = new Book("Java精通", 300);
        Arrays.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                double priceVal = o1.getPrice() - o2.getPrice();
                if(priceVal > 0) {
                    return -1;
                } else if(priceVal < 0) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        System.out.println(Arrays.toString(books));

        Arrays.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o2.getName().length() - o1.getName().length();
            }
        });
        System.out.println(Arrays.toString(books));
    }
}

class Book {
    private String name;
    private double price;

    public Book(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                "}\n";
    }
}
