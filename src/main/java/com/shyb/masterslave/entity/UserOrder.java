package com.shyb.masterslave.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
@Data
@Accessors(chain = true)
public class UserOrder implements Serializable {
    private Integer id;

    private String goodName;

    private Integer uid;

    private static final long serialVersionUID = 1L;

}
