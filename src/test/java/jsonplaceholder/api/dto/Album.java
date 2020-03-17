package jsonplaceholder.api.dto;

import com.frameworkium.core.api.dto.AbstractDTO;

public class Album extends AbstractDTO<Album> {
    public int userId;
    public int id;
    public String title;
}
