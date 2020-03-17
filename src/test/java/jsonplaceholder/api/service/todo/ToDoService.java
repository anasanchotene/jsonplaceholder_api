package jsonplaceholder.api.service.todo;

import jsonplaceholder.api.constant.JSONEndpoint;
import jsonplaceholder.api.dto.ToDo;
import restfulbooker.api.service.AbstractResourceService;
import java.util.List;

public class ToDoService  extends AbstractResourceService {

    public List<ToDo> getUserTodo (int userId) {
        return get(JSONEndpoint.TODOS.getUrl(userId)).jsonPath().getList(".", ToDo.class);
    }

    public boolean assertUserId (int userId, List<ToDo> toDos) {
        for (ToDo todo : toDos) {
            if (todo.userId != userId) return false;
        }

        return true;
    }

}