package app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.app.entities.Task;
import com.app.entities.User;
import com.app.services.TaskService;
import com.app.services.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
class SistemZaRaspodeluZadatakaApplicationTests {

	@Autowired
	private UserService userService;

	@Autowired
	private TaskService taskService;
	
	@BeforeEach
	public void initDb() {
		{
			User newUser = new User("testUser@mail.com", "testUser", "123456");
			userService.createUser(newUser);
		}
		{
			User newUser = new User("testAdmin@mail.com", "testAdmin", "123456");
			userService.createUser(newUser);
		}
		
		Task userTask = new Task("30/12/2020", "8:00", "16:00", "Uradi posao");
		User user = userService.findOne("testUser@mail.com");
		taskService.addTask(userTask, user);
	}
	
	@Test
	public void testUser() {
		User user = userService.findOne("testUser@mail.com");
		assertNotNull(user);
		
		User admin = userService.findOne("testAdmin@mail.com");
		assertEquals(admin.getEmail(), "testAdmin@mail.com");
	}
	
	@Test
	public void testTask() {
		User user = userService.findOne("testUser@mail.com");
		List<Task> task = taskService.findUserTask(user);
		assertNotNull(task);
	}
}











