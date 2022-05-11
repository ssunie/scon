package com.scon.project.admin.lecture.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.scon.project.config.SconApplication;

@SpringBootTest
@ContextConfiguration(classes = {SconApplication.class})
public class LectureControllerTests {

	@Autowired
	private LectureController lectureController;
	private MockMvc mockMvc;
	
	// success
	@Test
	@Disabled
	@DisplayName("의존성 주입 테스트")
	public void testInit() {
		
		assertNotNull(lectureController);	// success
		assertNotNull(mockMvc);				// success
	}
	
	@BeforeEach
	public void setUp() {
		
		mockMvc = MockMvcBuilders.standaloneSetup(lectureController).build();
	}
	
	// success
	@Test
	@Disabled
	@DisplayName("수강 내역 조회용 컨트롤러 테스트")
	public void testSelectLecture() throws Exception {
		
		// when & then
		mockMvc.perform(MockMvcRequestBuilders.get("/admin/lecture/list"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.forwardedUrl("admin/lecture/list"))
				.andDo(MockMvcResultHandlers.print());	
	}
	
	// success
	@Test
	@Disabled
	@DisplayName("강의 조회용 컨트롤러 테스트")
	public void testSelectClass() throws Exception {
		
		// when & then
		mockMvc.perform(MockMvcRequestBuilders.get("/admin/lecture/insertForm"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.forwardedUrl("admin/lecture/insertForm"))
				.andDo(MockMvcResultHandlers.print());	
	}
	
	// success
	@Test
	
	@DisplayName("수강 등록용 컨트롤러 테스트")
	public void testInsertLecture() throws Exception {
		
		// given
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("clsId", "22");
		params.add("", "");
		params.add("", "");
		params.add("", "");
		
		// when & then
		mockMvc.perform(MockMvcRequestBuilders.post("/admin/lecture/insertForm").params(params))
				.andExpect(MockMvcResultMatchers.status().is3xxRedirection())
				.andExpect(MockMvcResultMatchers.flash().attributeCount(1))
				.andExpect(MockMvcResultMatchers.redirectedUrl("/admin/lecture/list"))
				.andDo(MockMvcResultHandlers.print());
	}
	
}