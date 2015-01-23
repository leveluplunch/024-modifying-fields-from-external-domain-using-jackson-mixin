package com.levelup;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public interface PersonMixIn {
	
	@JsonProperty("fullname")
	abstract String getName();
	
	@JsonIgnore 
	abstract String getSsn();

}
