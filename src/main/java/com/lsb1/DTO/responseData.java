package com.lsb1.DTO;

import java.util.ArrayList;
import java.util.List;

public class responseData<T> {

  private Boolean status;
  private List<String> message = new ArrayList<>();
  private T payload;
  private String messages;

  public String getMessages() {
    return messages;
}

public void setMessages(String messages) {
    this.messages = messages;
}

public Boolean getStatus() {
    return status;
  }

  public void setStatus(Boolean status) {
    this.status = status;
  }

  public List<String> getMessage() {
    return message;
  }

  public void setMessage(List<String> message) {
    this.message = message;
  }

  public T getPayload() {
    return payload;
  }

  public void setPayload(T payload) {
    this.payload = payload;
  }
}
