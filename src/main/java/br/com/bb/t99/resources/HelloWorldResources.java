package br.com.bb.t99.resources;

import br.com.bb.t99.services.HorarioService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static java.lang.String.format;

@Path("/hello")
@RequestScoped
public class HelloWorldResources {
    @Inject
    HorarioService horarioService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response hello() {
        return Response.status(Response.Status.OK).entity("Hello!").build();
    }

    @GET
    @Path("/{nome}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response helloName(@PathParam("nome") String nome) {
        return Response
                .status(Response.Status.OK)
                .entity("Hello " + nome)
                .build();
    }

    @GET
    @Path("/{nome}/horario")
    @Produces(MediaType.TEXT_PLAIN)
    public Response helloNameAndTime(@PathParam("nome") String nome) {
        return Response
                .status(Response.Status.OK)
                .entity(format("Hello %s! Agora são %s, não esqueça!", nome, horarioService.horaAtual()))
                .build();
    }
}