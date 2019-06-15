package com.asol.security;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value="request")
public class UserInfo {
	 public String getId() {
	      return id;
	   }

	   public void setId(String id) {
	      this.id = id;
	   }

	   private String id;
}
