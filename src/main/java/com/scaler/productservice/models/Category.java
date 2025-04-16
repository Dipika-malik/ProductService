package com.scaler.productservice.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Category extends BaseModel {

    private String name;
    @OneToMany(mappedBy = "category", fetch = jakarta.persistence.FetchType.EAGER, cascade = jakarta.persistence.CascadeType.PERSIST)
    @JsonManagedReference
    private List<Product> products;
}
