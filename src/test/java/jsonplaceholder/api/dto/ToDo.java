package jsonplaceholder.api.dto;

import com.frameworkium.core.api.dto.AbstractDTO;

public class ToDo extends AbstractDTO<ToDo> {
    public int userId;
    public int id;
    public String title;
    public boolean completed;
}
