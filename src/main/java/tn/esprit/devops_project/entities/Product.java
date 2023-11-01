package tn.esprit.devops_project.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idProduct;
    String title;
    float price;
    int quantity;
    @Enumerated(EnumType.STRING)
    ProductCategory category;
    @ManyToOne
    @JsonIgnore
    Stock stock;
    public Product(Long id,String title,float price,int quantity){
        this.setIdProduct(id);
        this.setTitle(title);
        this.setPrice(price);
        this.setQuantity(quantity);
    }

    public Product(long l, String s, int i, int i1, ProductCategory books) {
        this.category=books;
        this.setIdProduct(l);
        this.setTitle(title);
        this.setPrice(price);
        this.setQuantity(quantity);
    }
}
