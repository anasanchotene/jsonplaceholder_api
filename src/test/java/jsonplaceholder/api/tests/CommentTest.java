package jsonplaceholder.api.tests;

import jdk.jfr.Description;
import jsonplaceholder.api.dto.Comment;
import jsonplaceholder.api.service.comment.CommentService;
import jsonplaceholder.api.service.ping.PingService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static org.testng.Assert.assertTrue;

public class CommentTest {

    @BeforeClass
    public void pingService() {
        assertThat(new PingService().ping()).contains("JSONPlaceholder - Fake online REST API for developers");
    }

    @Description("Retrieves comments from a specific post - 1")
    @Test(enabled =  true)
    public void getPostComments () {
        int postId = 1;
        CommentService service = new CommentService();
        List<Comment> commentsResponse = service.getPostComments(postId);

        assertThat(commentsResponse).isNotEmpty();
        assertThat(commentsResponse).isNotNull();
        assertTrue(service.assertPostId(postId, commentsResponse));
    }

}
