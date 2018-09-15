package com.manutencao.learnenglish.repositoryTest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.manutencao.learnenglish.models.User;
import com.manutencao.learnenglish.repository.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

	@Autowired
	private UserRepository repository;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void createUserPersistTest() {

		User user = new User("marcelo", "marcelo", "123456");
		this.repository.save(user);
		assertThat(user.getId()).isNotNull();
		assertThat(user.getName()).isEqualTo("marcelo");
		assertThat(user.getUsername()).isEqualTo("marcelo");
		assertThat(user.getPassword()).isNotNull();
	}

	@Test
	public void deleteUserTest() {
		User user = new User("marcelo", "marcelo", "123456");
		this.repository.save(user);
		repository.delete(user);
		assertThat(repository.findById(user.getId())).isNull();
	}

	@Test
	public void updateUserTest() {
		User user = new User("marcelo", "marcelo", "123456");

		this.repository.save(user);
		user.setName("marcelo2");
		user.setUsername("marcelo22");
		this.repository.save(user);
		user = repository.findById(user.getId());
		assertThat(user.getName()).isEqualTo("marcelo2");
		assertThat(user.getUsername()).isEqualTo("marcelo22");
	}

	@Test
	public void findusernameUserTest() {
		User user = new User("marcelo", "marcelo", "123456");
		this.repository.save(user);
		assertThat(repository.findByUsername(user.getUsername())).isNotNull();
	}

}
