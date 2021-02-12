package kg.attractor.java.homework;
import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;

import com.google.gson.Gson;
import kg.attractor.java.homework.domain.Order;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

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

    public void maxAndMinForHomeDelivery(List<Order> orders){

    }





}
