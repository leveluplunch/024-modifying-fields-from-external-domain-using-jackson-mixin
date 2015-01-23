package com.levelup;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.common.collect.ImmutableMap;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.PathNotFoundException;

/**
 * Unit test for simple App.
 */
public class AppTest {

	private ObjectMapper mapper = null;
	private ObjectWriter writer = null;

	@Before
	public void setUp() {
		mapper = new ObjectMapper();

		mapper.setMixIns(ImmutableMap.<Class<?>, Class<?>> of(Person.class,
				PersonMixIn.class));

		writer = mapper.writer().with(SerializationFeature.INDENT_OUTPUT);
	}

	@Test
	public void rename_field_jackson() throws JsonProcessingException {
		
		Person person = new Person("1", "333445555", "Jack Johnson");
		
		String json = writer.writeValueAsString(person);
		
		System.out.println(json);
		
		String fullName = JsonPath.read(json, "$.fullname");
		
		assertEquals("Jack Johnson", fullName);
		
	}
	
	@Test(expected=PathNotFoundException.class)
	public void ignore_field_jackson() throws JsonProcessingException {

		Person person = new Person("2", "222556789", "Joe Webb");

		String json = writer.writeValueAsString(person);

		JsonPath.read(json, "$.ssn");
	}
	
	
	
	
	
}
