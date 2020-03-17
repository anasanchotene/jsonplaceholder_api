package jsonplaceholder.api.service.album;

import jsonplaceholder.api.constant.JSONEndpoint;
import jsonplaceholder.api.dto.Album;
import restfulbooker.api.service.AbstractResourceService;
import java.util.List;

public class AlbumService extends AbstractResourceService {
    public List<Album> getUserAlbums (int userId) {
        return get(JSONEndpoint.ALBUMS.getUrl(userId)).jsonPath().getList(".", Album.class);
    }

    public boolean assertUserId (int userId, List<Album> albums) {

        for (Album album : albums) {
            if (album.userId != userId) return false;
        }
        return true;
    }
}
