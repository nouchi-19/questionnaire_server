package jp.ac.dendai.sie.usd.filter;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

public class EncodingFilter implements ContainerRequestFilter {
    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        MediaType mediaType = requestContext.getMediaType();
        if (mediaType != null) {
            if (mediaType.equals(MediaType.APPLICATION_JSON)) {
                requestContext.getHeaders().putSingle("Content-Type", MediaType.APPLICATION_JSON + "; charset=utf-8");
            }
        }
    }
}
