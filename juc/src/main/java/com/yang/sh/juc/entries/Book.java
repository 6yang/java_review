package com.yang.sh.juc.entries;

import lombok.*;
import lombok.experimental.Accessors;


@AllArgsConstructor
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class Book {

    private int id;
    private String bookName ;
    private double price;

    public static void main(String[] args) {
        Book book = new Book();
        book.setId(1).setBookName("c++").setPrice(11);

    }


}
