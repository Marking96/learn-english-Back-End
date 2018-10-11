/**
 * 
 */
package com.manutencao.learnenglish.ControllerTest;


import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.manutencao.learnenglish.repository.UserRepository;

/**
 * @author Marcelo Estevam
 *
 * @year 2018
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class UserEndpointTest {
	
	@Autowired
	private TestRestTemplate restTemplate;
	@LocalServerPort
	private int port;
	@MockBean
	private UserRepository useRepository;
	
	
	@TestConfiguration
	static class Confing{
		public RestTemplateBuilder restTemplateBuilder() {
			return new RestTemplateBuilder().basicAuthorization("marcelo", "12345");
		}
	}
	@Test
	public void ListUserTestCode403() {
		restTemplate.withBasicAuth("1", "1");
		ResponseEntity<String> respo = restTemplate.getForEntity("/user/users", String.class);
		Assertions.assertThat(respo.getStatusCodeValue()).isEqualTo(403);
	}
}
