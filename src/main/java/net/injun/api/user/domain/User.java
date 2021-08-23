package net.injun.api.user.domain;

import lombok.Data;
import net.injun.api.order.domain.Order;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id @Column(name = "user_id")
    private long userId;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "reg_date")
    private String regDate;

    @OneToMany(mappedBy = "user")
    private List<Order> orders = new ArrayList<>();


}
