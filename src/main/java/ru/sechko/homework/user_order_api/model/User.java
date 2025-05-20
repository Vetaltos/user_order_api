package ru.sechko.homework.user_order_api.model;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import ru.sechko.homework.user_order_api.view.Views;

import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(Views.UserSummary.class)
    private Long id;

    @NotBlank
    @JsonView(Views.UserSummary.class)
    private String name;

    @Email
    @NotBlank
    @JsonView(Views.UserSummary.class)
    private String email;

    @OneToMany(mappedBy = "user",  cascade = CascadeType.ALL)
    @JsonView(Views.UserDetails.class)
    private List<Order> orders;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
