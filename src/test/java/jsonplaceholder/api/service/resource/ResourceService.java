package jsonplaceholder.api.service.resource;

import io.restassured.response.Response;
import jsonplaceholder.api.constant.JSONEndpoint;
import jsonplaceholder.api.dto.resource.Resource;
import restfulbooker.api.service.AbstractResourceService;

import java.util.List;

public class ResourceService extends AbstractResourceService {

    int firstUserId = 1;
    int lastUserId = 10;
    int firstId = 1;
    int lastId = 100;

    public Resource getResource(int id) {
        return get(JSONEndpoint.POST.getUrl(id)).as(Resource.class);
    }

    public List<Resource> getResourcesList() {
        return get(JSONEndpoint.LIST.getUrl()).jsonPath().getList(".", Resource.class);
    }

    public Resource createResource(Resource resource) {
        return post(resource, JSONEndpoint.LIST.getUrl()).as(Resource.class);
    }

    public Response deleteResource(int id) {
        return getRequestSpec().delete(JSONEndpoint.POST.getUrl(id));
    }

    public List<Resource> filterResources(int userId) {
        return get(JSONEndpoint.FILTERING.getUrl(userId)).jsonPath().getList(".", Resource.class);
    }

    public Response getWrongUrlResource() {
        return getRequestSpec().delete(JSONEndpoint.WRONG_URL.getUrl());
    }

    public Response getInvalidPostId() {
        System.out.println(JSONEndpoint.POST.getUrl(lastId+1));
        return getRequestSpec().delete(JSONEndpoint.POST.getUrl(lastId+1));
    }

    public Response getInvalidUserId(){
        return getRequestSpec().delete(JSONEndpoint.FILTERING.getUrl(lastUserId+1));
    }

    public Resource updateResourcePut(int id, Resource resource) {
        return getRequestSpec().contentType("application/json; charset=UTF-8").body(resource).put(JSONEndpoint.POST.getUrl(id)).as(Resource.class);
    }

    public Resource updateResourceTitlePatch(int id, Resource resource) {
        String patchBody = "{\"title\": \"" + resource.title + "\"}";
        return getRequestSpec().contentType("application/json; charset=UTF-8").body(patchBody).patch(JSONEndpoint.POST.getUrl(id)).as(Resource.class);
    }

    public boolean assertAllUsers(List<Resource> response) {
        String responseString = response.toString();

        for (int i = firstUserId; i <= lastUserId; i++) {
            if (!responseString.contains("userId=" + i)) return false;
        }

        return true;
    }

    public boolean assertAllIds(List<Resource> response) {
        String responseString = response.toString();

        for (int i = firstId; i <= lastId; i++) {
            if (!responseString.contains("id=" + i)) return false;
        }

        return true;
    }

    public boolean assertUserId(int userId, List<Resource> response) {
        for (Resource resource : response) {
            if (resource.userId != userId) return false;
        }

        return true;
    }

}
