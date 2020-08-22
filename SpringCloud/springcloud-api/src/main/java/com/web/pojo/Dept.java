package com.web.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @anthor Tolaris
 * @date 2020/4/18 - 1:08
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)//链式写法
public class Dept implements Serializable {

    private Long deptno;
    private String dname;
    private String db_source;

    public Dept(String dname) {
        this.dname = dname;
    }
}
