package jsonplaceholder.api.service.ping;

import io.restassured.RestAssured;
import io.restassured.specification.ResponseSpecification;
import jsonplaceholder.api.constant.JSONEndpoint;
import restfulbooker.api.service.AbstractResourceService;

public class PingService extends AbstractResourceService {

    public String ping() {
        return get(JSONEndpoint.BASE_URI.getUrl())
                .body().asString();
    }

    @Override
    protected ResponseSpecification getResponseSpec() {
        return RestAssured.expect().contentType("text/html; charset=UTF-8");
    }
}
