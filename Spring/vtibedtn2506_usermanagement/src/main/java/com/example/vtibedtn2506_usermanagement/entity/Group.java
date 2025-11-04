package com.example.vtibedtn2506_usermanagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "`groups`")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name_group")
    private String nameGroup;

    @Column(name = "date")
    private Date date;

    @Column(name = "description")
    private String description;

}
