package jsonplaceholder.api.tests;

import com.frameworkium.core.api.tests.BaseAPITest;
import jdk.jfr.Description;
import jsonplaceholder.api.dto.Photo;
import jsonplaceholder.api.service.photo.PhotoService;
import org.testng.annotations.Test;

import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static org.testng.Assert.assertTrue;

public class PhotoTest extends BaseAPITest {

    @Description("Get photos from specific album")
    @Test(enabled =  true)
    public void getAlbumPhotos () {
        int albumId = 1;
        PhotoService service = new PhotoService();
        List<Photo> photos = service.getUserAlbums(albumId);

        assertThat(photos).isNotNull();
        assertThat(photos).isNotEmpty();
        assertTrue(service.assertAlbumId(albumId, photos));
    }

}
