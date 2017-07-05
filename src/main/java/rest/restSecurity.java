package rest;

import org.glassfish.jersey.internal.util.Base64;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by ahmed on 7/5/2017.
 */

@Provider
public class restSecurity implements ContainerRequestFilter {

    private static final String AUTHORIZATION_HEADER_KEY = "Authorization";

    private static final String AUTHORIZATION_HEADER_PREFIX = "Basic ";
    private static final String SECURED_URL_PATH = "students";

    public void filter(ContainerRequestContext containerRequestContext) throws IOException {

        System.out.println("Done11");
        System.out.println(containerRequestContext.getUriInfo().getPath());
        if (containerRequestContext.getUriInfo().getPath().contains(SECURED_URL_PATH)) {
            System.out.println("Done1");

            List<String> authHeader = containerRequestContext.getHeaders().get(AUTHORIZATION_HEADER_KEY);
            if (authHeader!=null && authHeader.size() > 0) {

                String authToken = authHeader.get(0);
                authToken = authToken.replaceFirst(AUTHORIZATION_HEADER_PREFIX, "");

                String desocedString = Base64.decodeAsString(authToken);
                StringTokenizer stringTokenizer = new StringTokenizer(desocedString, ":");

                String username = stringTokenizer.nextToken();
                String password = stringTokenizer.nextToken();
                if (username.equalsIgnoreCase("ahmed") && password.equalsIgnoreCase("123456")) {

                    return;
                }

            }

        Response unResponse =
                Response.status(Response.Status.UNAUTHORIZED).entity("User cannot to access to rest Api ....").build();

        containerRequestContext.abortWith(unResponse);
        }

    }
}
