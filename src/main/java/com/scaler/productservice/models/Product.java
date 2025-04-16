package com.scaler.productservice.models;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity; // For newer versions (Jakarta)


import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Product extends BaseModel {

    private String title;
    private String description;
    private double price;
    private String image;
    @ManyToOne(cascade = {jakarta.persistence.CascadeType.PERSIST})
    @JoinColumn(name="cat_id")
    @JsonBackReference
    private Category category;

}
