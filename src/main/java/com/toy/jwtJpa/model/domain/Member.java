package com.toy.jwtJpa.model.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.persistence.GenerationType;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "member_no")
    private Long no;

    @Column(name = "id", length = 30, unique = true)
    private String id;

    @Column(name = "password", length = 30)
    private String password;

    @Column(name = "name", length = 30)
    private String name;

    @Column(name = "email", length = 30)
    private String email;

    @Column(name = "used", length = 1)
    private int used;

    @Override
    public String toString() {
        return "Member{" +
                "no=" + no +
                ", id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", used=" + used +
                '}';
    }
}
