package com.example.foodorder.service;
import java.util.*;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.example.foodorder.model.FoodOrder;

@Service

public class FoodOrderService {
	private List<FoodOrder> orders = new ArrayList<>();
    private Long nextId = 1L;

    // GET - All orders
    public List<FoodOrder> getAllOrders() {
        return orders;
    }

    // GET - By ID
    public FoodOrder getOrderById(Long id) {
        return orders.stream()
                .filter(o -> o.getOrderId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Order not found"));
    }

    // POST - Add order
    public FoodOrder addOrder(FoodOrder order) {
        order.setOrderId(nextId++);
        orders.add(order);
        return order;
    }

    // PUT - Update order
    public FoodOrder updateOrder(Long id, FoodOrder newOrder) {

        FoodOrder order = getOrderById(id);

        order.setCustomerName(newOrder.getCustomerName());
        order.setFoodItem(newOrder.getFoodItem());
        order.setQuantity(newOrder.getQuantity());
        order.setPrice(newOrder.getPrice());

        return order;
    }

    // DELETE - Delete order
    public void deleteOrder(Long id) {
        FoodOrder order = getOrderById(id);
        orders.remove(order);
    }

    // PATCH - Partial update
    public FoodOrder patchOrder(Long id, Map<String, Object> updates) {

        FoodOrder order = getOrderById(id);

        if (updates.containsKey("customerName")) {
            order.setCustomerName(
                    (String) updates.get("customerName"));
        }

        if (updates.containsKey("foodItem")) {
            order.setFoodItem(
                    (String) updates.get("foodItem"));
        }

        if (updates.containsKey("quantity")) {
            order.setQuantity(
                    ((Number) updates.get("quantity")).intValue());
        }

        if (updates.containsKey("price")) {
            Object price = updates.get("price");
            order.setPrice(price == null ? null :
                    ((Number) price).doubleValue());
        }

        return order;
    }

}
