package com.lsb1.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lsb1.DTO.responseData;
import com.lsb1.Models.userData;
import com.lsb1.Repos.userRepo;

import jakarta.validation.Valid;

@RestController
public class mainApi {

  @Autowired
  private userRepo repo;

  @GetMapping(value = "/")
  public List<userData> getData() {
    return repo.findAll();
  }

  @PostMapping(value = "/save")
  public ResponseEntity<responseData<userData>> saveData(
    @Valid @RequestBody userData user,
    Errors errors
  ) {
    responseData<userData> responseData = new responseData<>();

    if (errors.hasErrors()) {
      for (ObjectError error : errors.getAllErrors()) {
        responseData.getMessage().add(error.getDefaultMessage());
      }
      responseData.setPayload(null);
      responseData.setStatus(false);
      responseData.setMessages("agak lain koneksi kau kutengok bah");
      return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(responseData);
    }

    responseData.setPayload(null);
    responseData.setStatus(false);

    repo.save(user);
    return ResponseEntity.ok(responseData);
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
