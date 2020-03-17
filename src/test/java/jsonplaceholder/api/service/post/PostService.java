package jsonplaceholder.api.service.post;

import jsonplaceholder.api.constant.JSONEndpoint;
import jsonplaceholder.api.dto.Post;
import restfulbooker.api.service.AbstractResourceService;
import java.util.List;

public class PostService extends AbstractResourceService {
    public List<Post> getUserPost (int userId) {
        return get(JSONEndpoint.USER_POSTS.getUrl(userId)).jsonPath().getList(".", Post.class);
    }

    public boolean assertUserId (int userId, List<Post> posts) {
        for (Post post : posts) {
            if (post.userId != userId) return false;
        }
        return true;
    }
}

