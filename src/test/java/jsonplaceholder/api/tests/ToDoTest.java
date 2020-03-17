package jsonplaceholder.api.tests;

import com.frameworkium.core.api.tests.BaseAPITest;
import jsonplaceholder.api.dto.ToDo;
import jsonplaceholder.api.service.ping.PingService;
import jsonplaceholder.api.service.todo.ToDoService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static org.testng.Assert.assertTrue;

public class ToDoTest extends BaseAPITest {

    @BeforeClass
    public void pingService() {
        assertThat(new PingService().ping()).contains("JSONPlaceholder - Fake online REST API for developers");
    }

    @Test
    private void getUserTodos() {
        int userId = 1;
        ToDoService service = new ToDoService();
        List<ToDo> todos = service.getUserTodo(userId);

        assertThat(todos).isNotNull();
        assertThat(todos).isNotEmpty();
        assertTrue(service.assertUserId(userId, todos));

    }

}
