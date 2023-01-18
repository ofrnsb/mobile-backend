package com.lsb1.Models;

import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "tbl_user")
public class userData implements Serializable {

  private static final long serialVersionUID = 1L;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  private Long Id;

  @NotEmpty(message = "can not be empty")
  @Column
  private String firstName;

  @NotEmpty(message = "can not be empty")
  @Column
  private String lastName;

  //membuat relasi dengan tabel Position
  @ManyToOne //jenis relasi
  private Position position;

  //di relation Database, tidak mungkin ada relasi many to many antara dua tabel, sehingga dibutuhkan satu tabel sebagai perantara

  @ManyToMany
  @JoinTable( ////konfigurasi join table sebagai perantara antara userData dan Jobs
    name = "tbl_user_jobs",
    joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "jobs_id")
  )
  @JsonManagedReference //konfigurasi di sisi useData agar tidak terjadi infinite cycle antara tabel useData dan tabel Jobs
  private Set<Jobs> jobs;

  public Long getId() {
    return Id;
  }

  public void setId(Long id) {
    Id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Position getPosition() {
    return position;
  }

  public void setPosition(Position position) {
    this.position = position;
  }
}
