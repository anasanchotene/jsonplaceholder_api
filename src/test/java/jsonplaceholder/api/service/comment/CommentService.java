package jsonplaceholder.api.service.comment;

import jsonplaceholder.api.constant.JSONEndpoint;
import jsonplaceholder.api.dto.Comment;
import restfulbooker.api.service.AbstractResourceService;
import java.util.List;

public class CommentService extends AbstractResourceService{
    public List<Comment> getPostComments(int postId) {
        return get(JSONEndpoint.COMMENTS.getUrl(postId)).jsonPath().getList(".", Comment.class);
    }

    public boolean assertPostId(int postId, List<Comment> response) {

        for (Comment comment : response) {
            if (comment.postId != postId) return false;
        }
        return true;
    }
}
