package com.limonnana.backend02.entity;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "KEY_WORD")
public class KeyWord implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "KEY_WORD_ID")
    private Long keyWordId;

    @NotNull
    @Column(nullable = false)
    private String name;



    public String getName() {
        return name;
    }

    public KeyWord name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof KeyWord)) {
            return false;
        }
        return keyWordId != null && keyWordId.equals(((KeyWord) o).keyWordId);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "KeyWord{" +
                "id=" + getKeyWordId() +
                ", name='" + getName() + "'" +
                "}";
    }

    public Long getKeyWordId() {
        return keyWordId;
    }

    public void setKeyWordId(Long keyWordId) {
        this.keyWordId = keyWordId;
    }
}