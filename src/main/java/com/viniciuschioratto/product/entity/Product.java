package com.viniciuschioratto.product.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

import java.util.Date;
import java.util.UUID;

public class Product {

    @Id
    private UUID id = UUID.randomUUID();
    private String name;
    private String description;
    @CreatedDate
    private Date insertDate;
    @Version
    private String version;

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public String getVersion() {
        return version;
    }
}
