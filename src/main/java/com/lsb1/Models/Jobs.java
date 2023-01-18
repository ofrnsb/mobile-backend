package com.lsb1.Models;

import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

//Serializable merupakan sebuah interface bawaan dari java. Serialization adalah suatu proses mengubah objek menjadi byte stream, agar bisa disimpan dalam file, memori ataupun berguna dalam proses transmisi jaringan.

@Entity
@Table(name = "tbl_job")
public class Jobs implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long Id;

  @Column(nullable = false, length = 100)
  private String name;

  @ManyToMany(mappedBy = "jobs") //mapped by: indikasi jika tabel ini bukan pemilik dari join tabel
  @JsonBackReference //konfigurasi di sisi jobs agar tidak terjadi infinite cycle antara tabel useData dan tabel Jobs
  private Set<userData> userData;

  public long getId() {
    return Id;
  }

  public void setId(long id) {
    Id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
