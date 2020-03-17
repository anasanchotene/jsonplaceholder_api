package jsonplaceholder.api.tests;

import com.frameworkium.core.api.tests.BaseAPITest;
import com.frameworkium.core.common.retry.RetryFlakyTest;
import jdk.jfr.Description;
import jsonplaceholder.api.dto.Comment;
import jsonplaceholder.api.dto.resource.Resource;
import jsonplaceholder.api.service.resource.ResourceService;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import jsonplaceholder.api.service.ping.PingService;

import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static org.testng.Assert.assertTrue;

@Test(retryAnalyzer = RetryFlakyTest.class)
public class ResourceTest extends BaseAPITest {

    @BeforeClass
    public void pingService() {
        assertThat(new PingService().ping()).contains("JSONPlaceholder - Fake online REST API for developers");
    }

    @Description("Create new resource and insert on the list")
    @Test (enabled =  true)
    public void createResource() {
       ResourceService service = new ResourceService();
       Resource resource = Resource.newInstance();
       Resource resourceResponse = service.createResource(resource);

        assertThat(resourceResponse).isNotNull();
        assertThat(resourceResponse).isInstanceOf(Resource.class);
        assertThat(resourceResponse.title).isEqualTo(resource.title);
    }

    @Description("Get specific resource - 1")
    @Test (enabled =  true)
    public void getResource() {
        ResourceService service = new ResourceService();
        Resource resource = Resource.buildResource(1, 1, "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
                "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto");

        Resource resourceResponse = service.getResource(1);

        assertThat(resourceResponse).isNotNull();
        assertThat(resourceResponse).isInstanceOf(Resource.class);
        assertThat(resourceResponse).isEqualTo(resource);
    }

    @Description("List all 100 resources available")
    @Test (enabled =  true)
    public void listAllResources() {
        ResourceService service = new ResourceService();
        List<Resource> resourcesResponse = service.getResourcesList();

        assertThat(resourcesResponse).isNotEmpty();
        assertThat(resourcesResponse).isNotNull();
        assertTrue(service.assertAllUsers(resourcesResponse));
        assertTrue(service.assertAllIds(resourcesResponse));
    }

    @Description("Delete specific resource - 1")
    @Test (enabled = true)
    public void deleteResource () {
        ResourceService service = new ResourceService();
        int resourceId = 1;

        assertThat(service.deleteResource(resourceId).then().statusCode(HttpStatus.SC_OK));
    }

    @Description("Filter resources by user id - 1")
    @Test (enabled =  true)
    public void filterResource () {
        int userId = 1;
        ResourceService service = new ResourceService();
        List<Resource> resourcesResponse = service.filterResources(userId);

        assertThat(resourcesResponse).isNotEmpty();
        assertThat(resourcesResponse).isNotNull();
        assertTrue(service.assertUserId(userId, resourcesResponse));
    }

    @Description("Try to access wrong url")
    @Test (enabled =  true)
    public void getWrongURL() {
        ResourceService service = new ResourceService();
        assertThat(service.getWrongUrlResource().then().statusCode(HttpStatus.SC_NOT_FOUND));
    }

    @Description("Update resource using patch")
    @Test (enabled =  true)
    public void updateResourceTitle_Patch () {
        int id = 1;
        ResourceService service = new ResourceService();
        Resource newResource =  Resource.buildResource(1, id, "new title",
                "new body");
        Resource updateResource = service.updateResourceTitlePatch(id, newResource);

        assertThat(updateResource).isNotNull();
        assertThat(updateResource).isInstanceOf(Resource.class);
        assertThat(updateResource.title).isEqualTo(newResource.title);
    }

    @Description("Update resource using put")
    @Test (enabled =  true)
    public void updateResource_Put () {
        int id = 1;
        ResourceService service = new ResourceService();
        Resource newResource =  Resource.buildResource(1, id, "new title",
                "new body");
        Resource updateResource = service.updateResourcePut(id, newResource);

        assertThat(updateResource).isNotNull();
        assertThat(updateResource).isInstanceOf(Resource.class);
        assertThat(updateResource).isEqualTo(newResource);
    }


}
