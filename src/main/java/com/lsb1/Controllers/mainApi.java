package com.lsb1.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lsb1.Models.userData;
import com.lsb1.Repos.userRepo;

@RestController
public class mainApi {

  @Autowired
  private userRepo repo;

  @GetMapping(value = "/")
  public List<userData> getData() {
    return repo.findAll();
  }

  @PostMapping(value = "/save")
  public String saveData(@RequestBody userData user) {
    repo.save(user);
    return "saved....";
  }

  @PutMapping(value = "/save/{id}")
  public String editData(@PathVariable long id, @RequestBody userData user) {
    userData updateData = repo.findById(id).get();
    updateData.setFirstName(user.getFirstName());
    updateData.setLastName(user.getLastName());

    return "saved....";
  }

  @DeleteMapping(value = "/delete/{id}")
  public String deleteData(@PathVariable long id) {
    userData deleteData = repo.findById(id).get();
    repo.delete(deleteData);
    return "deleted...";
  }
}
