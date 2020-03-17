package jsonplaceholder.api.constant;

import com.frameworkium.core.api.Endpoint;

public enum JSONEndpoint implements Endpoint {

    BASE_URI("https://jsonplaceholder.typicode.com"),
    POSTS("/posts/%d"),
    LIST("/posts/"),
    FILTERING("/posts?userId=%d"),
    COMMENTS("/posts/%d/comments"),
    TODOS("/users/%d/todos"),
    ALBUMS("/users/%d/albums"),
    USER_POSTS("/users/%d/posts"),
    PHOTOS("/albums/%d/photos"),
    WRONG_URL("/post");

    private String url;

    JSONEndpoint(String url) {
        this.url = url;
    }

    /**
     * @param params Arguments referenced by the format specifiers in the url.
     * @return A formatted String representing the URL of the given constant.
     */
    @Override
    public String getUrl(Object... params) {
        return String.format(url, params);
    }


}
