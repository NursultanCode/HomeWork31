package kg.attractor.java;

import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;

// используя статические imports
// мы импортируем *всё* из Collectors и Comparator.
// теперь нам доступны такие операции как
// toList(), toSet() и прочие, без указания уточняющего слова Collectors. или Comparator.
// вот так было до импорта Collectors.toList(), теперь стало просто toList()


import kg.attractor.java.homework.RestaurantOrders;
import kg.attractor.java.homework.domain.Order;

import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        // это для домашки
        // выберите любое количество заказов, какое вам нравится.
        var orders = RestaurantOrders.read("orders_100.json").getOrders();
        //var mostExpensive = RestaurantOrders.getMostExpensive(orders, 3);
        //mostExpensive.forEach(Order::printAllItems);
        //var mostCheapest = RestaurantOrders.getMostCheapest(orders, 3);
        //mostCheapest.forEach(Order::printAllItems);
        //var homeDelivery = RestaurantOrders.getListWithDelivery(orders);
        //homeDelivery.forEach(Order::printAllItems);
        //RestaurantOrders.maxAndMinForHomeDelivery(orders);
        //System.out.println("Total price of all orders: "+ RestaurantOrders.totalPriceOfAllOrders(orders));
        //var list = RestaurantOrders.getMoreThanMinAndLessThanMaxOrders(orders);
        //list.forEach(Order::printAllItems);
        //var mails = RestaurantOrders.getAllMails(orders);
        //mails.forEach(System.out::println);
        //var customersByGroup = RestaurantOrders.getGroupsOfCustomers(orders);
        //customersByGroup.forEach((key,value) -> value.forEach(Order::printAllItems));
        //var customersWithTotal = RestaurantOrders.getCustomersWithTotal(orders);
        //customersWithTotal.forEach((key, value)-> System.out.println(key.getFullName()+": "+value));
        //System.out.println("Customer with min order");
        //System.out.println(RestaurantOrders.customerWithMin(customersWithTotal));
        //System.out.println("Customer with max order");
        //System.out.println(RestaurantOrders.customerWithMax(customersWithTotal));



        //var orders = RestaurantOrders.read("orders_1000.json").getOrders();
        //var orders = RestaurantOrders.read("orders_10_000.json").getOrders();

        // протестировать ваши методы вы можете как раз в этом файле (или в любом другом, в котором вам будет удобно)
    }
}
