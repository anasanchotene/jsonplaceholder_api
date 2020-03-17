package jsonplaceholder.api.dto;

import com.frameworkium.core.api.dto.AbstractDTO;

public class Comment extends AbstractDTO<Comment> {
    public int postId;
    public int id;
    public String name;
    public String email;
    public String body;
}
