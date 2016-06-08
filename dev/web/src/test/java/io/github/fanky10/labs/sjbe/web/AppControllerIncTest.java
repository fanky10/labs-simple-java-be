package io.github.fanky10.labs.sjbe.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import io.github.fanky10.labs.sjbe.Application;
import io.github.fanky10.labs.sjbe.config.AppConfig;
import io.github.fanky10.labs.sjbe.web.rest.AppController;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest
public class AppControllerIncTest {

	@Inject
	private AppConfig appConfig;

	private MockMvc restUserMockMvc;

	@Before
	public void setup() {
		AppController appController = new AppController();
		ReflectionTestUtils.setField(appController, "appConfiguration",
				appConfig);
		this.restUserMockMvc = MockMvcBuilders.standaloneSetup(appController)
				.build();
	}

	@Test
	public void testGetApplication() throws Exception {
		restUserMockMvc
				.perform(
						get("/api/application").accept(
								MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().contentType("application/json"))
				.andExpect(jsonPath("$.version").value("1.0.1"));
	}

}
