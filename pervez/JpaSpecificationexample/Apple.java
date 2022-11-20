package com.hrms.pervez.JpaSpecificationexample;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Apple {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long appleId;
    private String appleName;
    private String taste;
    private float price;

}