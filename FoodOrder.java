package com.example.foodorder.model;
import jakarta.validation.constraints.*;

public class FoodOrder {
	 private Long orderId;

	    @NotBlank(message = "Customer name is required")
	    private String customerName;

	    @NotBlank(message = "Food item cannot be empty")
	    private String foodItem;

	    @Min(value = 1, message = "Quantity must be at least 1")
	    private int quantity;

	    @NotNull(message = "Price is mandatory")
	    private Double price;

	    public Long getOrderId() {
	        return orderId;
	    }

	    public void setOrderId(Long orderId) {
	        this.orderId = orderId;
	    }

	    public String getCustomerName() {
	        return customerName;
	    }

	    public void setCustomerName(String customerName) {
	        this.customerName = customerName;
	    }

	    public String getFoodItem() {
	        return foodItem;
	    }

	    public void setFoodItem(String foodItem) {
	        this.foodItem = foodItem;
	    }

	    public int getQuantity() {
	        return quantity;
	    }

	    public void setQuantity(int quantity) {
	        this.quantity = quantity;
	    }

	    public Double getPrice() {
	        return price;
	    }

	    public void setPrice(Double price) {
	        this.price = price;
	    }

}
