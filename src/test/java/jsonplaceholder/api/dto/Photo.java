package jsonplaceholder.api.dto;

import com.frameworkium.core.api.dto.AbstractDTO;

public class Photo extends AbstractDTO<Photo> {
    public int albumId;
    public int id;
    public String title;
    public String url;
    public String thumbnailUrl;
}
