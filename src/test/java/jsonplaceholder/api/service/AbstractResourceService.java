package restfulbooker.api.service;

import com.frameworkium.core.api.services.BaseService;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.ExtractableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import jsonplaceholder.api.constant.JSONEndpoint;
import org.apache.http.HttpStatus;

/** Base Service for RestfulBooker specific services. */
public abstract class AbstractResourceService extends BaseService {

    /**
     * @return a Rest Assured {@link RequestSpecification} with the baseUri
     *         (and anything else required by most Capture services).
     */
    @Override
    protected RequestSpecification getRequestSpec() {
        return RestAssured.given()
                .baseUri(JSONEndpoint.BASE_URI.getUrl())
                .relaxedHTTPSValidation() // trusts even invalid certs
                // .log().all() // uncomment to log each request
                .contentType("application/json")
                .accept("application/json");
    }

    /**
     * @return a Rest Assured {@link ResponseSpecification} with basic checks
     *         (and anything else required by most services).
    **/
    @Override
    protected ResponseSpecification getResponseSpec() {
        return RestAssured.expect().response();
    }

    protected ExtractableResponse post(Object body, String url) {
        return request(Method.POST, body, url);
    }

}
