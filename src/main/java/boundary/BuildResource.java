package boundary;

import control.BuildService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("")
public class BuildResource {

    @Inject
    private BuildService buildService;

    @GET
    @Path("build")
    public Response saveBuild(@QueryParam(value = "script") String scriptName, @QueryParam(value = "duration") int duration, @QueryParam(value = "user") String userName, @QueryParam(value = "failure") boolean isFailure) {
        Build build = new Build(scriptName, userName, duration, !isFailure);
        buildService.save(build);
        return Response.ok().build();
    }

    @GET
    @Path("build/all")
    public Response getAllBuilds() {
        Build build = new Build();
        buildService.save(build);
        return Response.ok().build();
    }

}
