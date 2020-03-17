package jsonplaceholder.api.dto.resource;

import com.frameworkium.core.api.dto.AbstractDTO;

import java.util.concurrent.ThreadLocalRandom;

public class Resource extends AbstractDTO<Resource> {

    public long userId;
    public long id;
    public String title;
    public String body;

    public static Resource newInstance() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int randInt = random.nextInt();

        Resource resource = new Resource();
        resource.userId = 1;
        resource.title = "name" + randInt;
        resource.body = "A story of survival and of transformation, this riveting resource has sparked many a reader's interest in venturing into the wild.";
        return resource;
    }

    public static Resource buildResource(int userId, int id, String title, String body) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int randInt = random.nextInt();

        Resource resource = new Resource();
        resource.userId = userId;
        resource.id = id;
        resource.title = title;
        resource.body = body;
        return resource;
    }

}
