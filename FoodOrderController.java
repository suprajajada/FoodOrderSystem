package com.example.foodorder.controller;
import java.util.*;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.foodorder.model.FoodOrder;
import com.example.foodorder.service.FoodOrderService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/orders")

public class FoodOrderController {
	@Autowired
    private FoodOrderService service;

    // GET all orders
    @GetMapping
    public List<FoodOrder> getAllOrders() {
        return service.getAllOrders();
    }

    // GET by ID
    @GetMapping("/{id}")
    public FoodOrder getOrderById(@PathVariable Long id) {
        return service.getOrderById(id);
    }

    // POST
    @PostMapping
    public FoodOrder addOrder(@Valid @RequestBody FoodOrder order) {
        return service.addOrder(order);
    }

    // PUT
    @PutMapping("/{id}")
    public FoodOrder updateOrder(
            @PathVariable Long id,
            @Valid @RequestBody FoodOrder order) {

        return service.updateOrder(id, order);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteOrder(@PathVariable Long id) {
        service.deleteOrder(id);
        return "Order deleted successfully";
    }

    // PATCH
    @PatchMapping("/{id}")
    public FoodOrder patchOrder(
            @PathVariable Long id,
            @RequestBody Map<String, Object> updates) {

        return service.patchOrder(id, updates);
    }

}
