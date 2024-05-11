package com.example.productservice.models;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Category extends BaseModel {

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category", cascade = CascadeType.REMOVE)
    // being already mapped by an attribute called category
    private List<Product> products;
    private String name;
    private String description;
    private String imageUrl;
}
