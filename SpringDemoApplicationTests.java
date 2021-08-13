package com.example.demo;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;
import java.util.stream.Collectors;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.service.EmployeeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
class SpringDemoApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@MockBean
	private EmployeeService employeeService;

	
	@Test
	public void testGetAll() throws JsonProcessingException, Exception {
		when(employeeService.save(Mockito.any(EmployeeDto.class))).thenReturn(dummyList().get(0));
		mockMvc.perform(post("/employee/").content("{\"id\":1,\"name\":\"john\"}")
	            .contentType(MediaType.APPLICATION_JSON_VALUE))
				.andDo(print())
	            .andExpect(status().isOk())
	            .andExpect(content().json("{\"id\":1,\"name\":\"john\"}"))
	            ;
	}


	private List<EmployeeDto> dummyList() {
		//1L is for converting into LONG value
		return Arrays.asList(new EmployeeDto[]{new EmployeeDto(1L, "john"), new EmployeeDto(1L, "Martin")})
				.stream()
				.map(e -> (EmployeeDto)e)
				.collect(Collectors.toList());
	}
	
}
