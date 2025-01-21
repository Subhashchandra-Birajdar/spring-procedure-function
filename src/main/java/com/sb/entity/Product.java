package com.sb.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NamedStoredProcedureQuery(
        name = "updateStockProcedure",
        procedureName = "update_stock",
        parameters = {
                @StoredProcedureParameter(mode=ParameterMode.IN,name = "productId",type = Integer.class),
                @StoredProcedureParameter(mode=ParameterMode.IN,name = "quantity",type = Integer.class)
        }
)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double price;
    private int stockQuantity;
}

/*
Once the user purchase the product i need to deduct the stock quantity in the inventory system
let's say one of the product quantity 10 is available as a user purchase 5 there should be 5 stock quantity available
in the inventory,nothing just update the stocks;
i can write query or
i can write the java code ,
what if i say i can handle this complex schenario in the database itself.
for that we can create a stored procedure.
 */