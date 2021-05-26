package com.example.entity;


import javassist.bytecode.ByteArray;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "document")
public class Document implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int Id;
    @Column(name = "name")
    private String name;
    @Column(name ="data",columnDefinition="BLOB")
    byte[] data;

    public Document() {
    }

    public Document(String name, byte[] data) {
        this.name = name;
        this.data = data;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Document{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", data=" + data +
                '}';
    }
}
