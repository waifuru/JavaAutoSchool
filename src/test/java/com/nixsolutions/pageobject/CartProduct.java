package com.nixsolutions.pageobject;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class CartProduct {

    private String name;
    private String color;
    private String size;
    private double unitPrice;
    private int quantity;
    private double totalPrice;

    public CartProduct() {
    }

}
