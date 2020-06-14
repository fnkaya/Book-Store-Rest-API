package com.fnkaya.bs.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItem implements Serializable {

    @Id
    @GeneratedValue
    private long relation_id;

    private long id;

    private String name;

    private String quantity;

    private String unitPrice;

    private String imageUrl;

}
