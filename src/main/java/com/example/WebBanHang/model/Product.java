package com.example.WebBanHang.model;

import jakarta.persistence.*;
import lombok.*;
@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;
    private String description;
    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String Image;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}