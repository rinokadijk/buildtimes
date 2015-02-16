package boundary;

import control.BuildService;
import entity.BuildResult;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import java.util.Date;
import java.util.List;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("")
public class BuildResource {

    @Inject
    private BuildService buildService;

    @GET
    @Path("build")
    public Response saveBuild(@QueryParam(value = "script") String scriptName, @QueryParam(value = "duration") int duration, @QueryParam(value = "user") String userName, @QueryParam(value = "failure") boolean isFailure) {
        if (scriptName == null || duration < 1 || userName == null) {
            return Response.accepted().build();
        }
        BuildResult build = new BuildResult(scriptName, duration, new Date(), userName, !isFailure);
        buildService.save(build);
        return Response.ok().build();
    }

    @GET
    @Path("builds")
    @Produces(MediaType.APPLICATION_JSON)
    public List<BuildResult> getAllBuilds() {
        return buildService.findAll();
    }

}
