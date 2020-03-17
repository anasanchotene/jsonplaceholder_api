package jsonplaceholder.api.dto;

import com.frameworkium.core.api.dto.AbstractDTO;

public class Post  extends AbstractDTO<Post> {
    public int userId;
    public int id;
    public String title;
    public String body;
}
