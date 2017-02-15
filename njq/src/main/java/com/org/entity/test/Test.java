package com.org.entity.test;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String sex;

    /**
     * @return id
     */
    public Long getId() {
        return this.id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return sex
     */
    public String getSex() {
        return this.sex;
    }

    /**
     * @param sex
     */
    public void setSex(String sex) {
        this.sex = sex;
    }
}