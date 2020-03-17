package jsonplaceholder.api.tests;

import com.frameworkium.core.api.tests.BaseAPITest;
import jdk.jfr.Description;
import jsonplaceholder.api.dto.Post;
import jsonplaceholder.api.service.post.PostService;
import org.testng.annotations.Test;

import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static org.testng.Assert.assertTrue;

public class PostTest extends BaseAPITest {

    @Description("Get post from specific users")
    @Test(enabled =  true)
    public void getUserPosts () {
        int userId = 1;
        PostService service = new PostService();
        List<Post> posts = service.getUserPost(userId);

        assertThat(posts).isNotNull();
        assertThat(posts).isNotEmpty();
        assertTrue(service.assertUserId(userId, posts));
    }
}
