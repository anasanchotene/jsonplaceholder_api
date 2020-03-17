package jsonplaceholder.api.service.photo;

import jsonplaceholder.api.constant.JSONEndpoint;
import jsonplaceholder.api.dto.Photo;
import restfulbooker.api.service.AbstractResourceService;
import java.util.List;

public class PhotoService extends AbstractResourceService {
    public List<Photo> getUserAlbums (int albumId) {
        return get(JSONEndpoint.PHOTOS.getUrl(albumId)).jsonPath().getList(".", Photo.class);
    }

    public boolean assertAlbumId (int albumId, List<Photo> photos) {
        for (Photo photo : photos) {
            if (photo.albumId != albumId) return false;
        }
        return true;
    }
}

