package kg.attractor.java.homework;
import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;

import com.google.gson.Gson;
import kg.attractor.java.homework.domain.Customer;
import kg.attractor.java.homework.domain.Order;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class RestaurantOrders {
    // Этот блок кода менять нельзя! НАЧАЛО!
    private List<Order> orders;

    private RestaurantOrders(String fileName) {
        var filePath = Path.of("lesson31/data", fileName);
        Gson gson = new Gson();
        try {
            orders = List.of(gson.fromJson(Files.readString(filePath), Order[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static RestaurantOrders read(String fileName) {
        var ro = new RestaurantOrders(fileName);
        ro.getOrders().forEach(Order::calculateTotal);
        return ro;
    }

    public List<Order> getOrders() {
        return orders;
    }
    // Этот блок кода менять нельзя! КОНЕЦ!
    //----------------------------------------------------------------------
    //------   Реализация ваших методов должна быть ниже этой линии   ------
    //----------------------------------------------------------------------

    // Наполните этот класс решением домашнего задания.
    // Вам необходимо создать все необходимые методы
    // для решения заданий из домашки :)
    // вы можете добавлять все необходимые imports
    public static List<Order> getMostCheapest(List<Order> orders, int n){
        return orders.stream()
                .sorted(comparing(Order::calculateTotal))
                .limit(n)
                .collect(toList());
    }

    public static List<Order> getMostExpensive(List<Order> orders, int n){
        return orders.stream()
                .sorted(comparing(Order::calculateTotal).reversed())
                .limit(n)
                .collect(toList());
    }

    public static List<Order> getListWithDelivery(List<Order> orders){
        return orders.stream()
                .filter(Order::isHomeDelivery)
                .collect(toList());
    }

    public static void maxAndMinForHomeDelivery(List<Order> orders){
          var delivery = getListWithDelivery(orders);
          var max = getMostExpensive(delivery,1);
          var min = getMostCheapest(delivery, 1);
        System.out.println("\nWith maximum total price delivery to home");
          max.forEach(Order::printAllItems);
        System.out.println("\nWith minimum total price delivery to home");
          min.forEach(Order::printAllItems);
    }
    public static double totalPriceOfAllOrders(List<Order> orders){
        return orders.stream()
                .mapToDouble(Order::calculateTotal)
                .sum();
    }
    public static List<Order> getMoreThanMinAndLessThanMaxOrders(List<Order> orders){
        return orders.stream()
                .takeWhile(order -> order.calculateTotal()<maxForOrders(orders).calculateTotal() && order.calculateTotal()>minForOrders(orders).calculateTotal())
                .collect(toList());
    }

    public static Order maxForOrders(List<Order> orders){
        var max = getMostExpensive(orders,1);
        return max.get(0);
    }

    public static Order minForOrders(List<Order> orders){
        var min = getMostCheapest(orders, 1);
        return min.get(0);
    }

    public static TreeSet<String> getAllMails(List<Order> orders){
        return orders.stream()
                .map(Order::getCustomer)
                .map(Customer::getEmail)
                .collect(toCollection(TreeSet::new));
    }

    public static Map<Customer, List<Order>> getGroupsOfCustomers(List<Order> orders){
        return orders.stream()
                .collect(groupingBy(Order::getCustomer));
    }
    public static Map<Customer, Double> getCustomersWithTotal(List<Order> orders){
        return orders.stream()
                .collect(groupingBy(Order::getCustomer,
                        summingDouble(Order::calculateTotal)));
    }
    public static Customer customerWithMin(Map<Customer, Double> customerDoubleMap){
        return Collections.min(customerDoubleMap.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public static Customer customerWithMax(Map<Customer, Double> customerDoubleMap){
        return Collections.max(customerDoubleMap.entrySet(), Map.Entry.comparingByValue()).getKey();
    }







}
