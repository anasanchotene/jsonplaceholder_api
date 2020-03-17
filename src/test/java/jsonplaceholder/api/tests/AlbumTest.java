package jsonplaceholder.api.tests;

import com.frameworkium.core.api.tests.BaseAPITest;
import jdk.jfr.Description;
import jsonplaceholder.api.dto.Album;
import jsonplaceholder.api.service.album.AlbumService;
import org.testng.annotations.Test;

import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static org.testng.Assert.assertTrue;

public class AlbumTest extends BaseAPITest {

    @Description("Get albums from specific user")
    @Test(enabled =  true)
    public void getUserAlbums () {
        int userId = 1;
        AlbumService service = new AlbumService();
        List<Album> albums = service.getUserAlbums(userId);

        assertThat(albums).isNotNull();
        assertThat(albums).isNotEmpty();
        assertTrue(service.assertUserId(userId, albums));
    }

}
