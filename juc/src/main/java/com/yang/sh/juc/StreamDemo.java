package com.yang.sh.juc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.logging.Filter;

@Data
@NoArgsConstructor
@AllArgsConstructor
class User{
    private Integer id  ;
    private String userName;
    private int age;

}
/*
* 偶数ID
* 年龄大于24
* 且用户名转为大写
* 且用户字母倒排序
* 只输出一个用户名字
* */
public class StreamDemo {
    public static void main(String[] args) {
        User u1 = new User(11, "a", 23);
        User u2 = new User(12, "b", 24);
        User u3 = new User(13, "c", 22);
        User u4 = new User(14, "d", 28);
        User u5 = new User(16, "e", 26);

        List<User> list = Arrays.asList(u1, u2, u3, u4, u5);

        list.stream()
                .filter(u->u.getId()%2==0)
                .filter(u->u.getAge()>24)
                .map(u->u.getUserName().toUpperCase())
                .sorted((o1,o2)-> o2.compareTo(o1))
                .limit(1)
                .forEach(System.out::println);



    }
}
