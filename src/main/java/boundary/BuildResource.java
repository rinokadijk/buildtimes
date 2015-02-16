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
import java.util.Map;
import static java.util.stream.Collectors.*;
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

    @GET
    @Path("builds/cumulative")
    @Produces(MediaType.APPLICATION_JSON)
    public CumulativeResult getDurationGroupedByScriptName() {
        Map<String, Integer> buildsByScriptName = buildService.findAll()
                .stream()
                .collect(
                        groupingBy(
                                BuildResult::getScriptName,
                                reducing(
                                        0,
                                        BuildResult::getDuration,
                                        Integer::sum
                                )
                        )
                );
        return new CumulativeResult(buildsByScriptName);
    }
    
}
