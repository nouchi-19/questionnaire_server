package jp.ac.dendai.sie.usd.filter;

        import javax.ws.rs.container.ContainerRequestContext;
        import javax.ws.rs.container.ContainerResponseContext;
        import javax.ws.rs.container.ContainerResponseFilter;
        import javax.ws.rs.core.MultivaluedMap;
        import java.io.IOException;

public class CORSResponseFilter implements ContainerResponseFilter {
    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
        MultivaluedMap<String, Object> headers = responseContext.getHeaders();

        headers.add("Access-Control-Allow-Origin", "*");
        headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
        headers.add("Access-Control-Allow-Headers", "Content-Type");
    }
}
