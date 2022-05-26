package services;

import model.Candidate;
import model.Message;
import providers.CandidateProvider;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.ArrayList;


@Path("candidatos")
public class CandidateService {

    @POST
    @Path("create")
    @Consumes("application/json")
    public javax.ws.rs.core.Response create(Candidate candidate){
        try {
            candidate.getCandidato();
            candidate.getVotos();
            candidate.getId();
            candidate.getFoto();
            CandidateProvider provider = new CandidateProvider();
            provider.create(candidate);
            return Response.ok(new Message("operacion exitosa")).header("Content-Type","application/json").build();
        } catch (SQLException exception) {
            exception.printStackTrace();
            return Response.status(500).entity(new Message("operacion fallida")).header("Content-Type","application/json").build();
        }
    }

    @GET
    @Path("allCan")
    public javax.ws.rs.core.Response getAll(){
        try {
            CandidateProvider provider = new CandidateProvider();
            ArrayList<Candidate> candidates = provider.getAllCandidate();
            return javax.ws.rs.core.Response
                    .ok(candidates)
                    .header("Content-Type","application/json")
                    .build();
        } catch (SQLException exception) {
            exception.printStackTrace();
            return Response
                    .status(500)
                    .entity(new Message("operacion fallida"))
                    .header("Content-Type","application/json")
                    .build();
        }

    }


    @PUT
    @Path("addVote/{id}")
    public javax.ws.rs.core.Response addVote(@PathParam("id") int id){
        try {
            CandidateProvider provider = new CandidateProvider();
            Candidate candidate = provider.candidate(id);
            System.out.println("Candidato 1: "+candidate.getCandidato());
            provider.add1Vote(candidate.getId(),candidate);
            return  Response
                    .ok(new Message("operacion exitosa"))
                    .header("Content-Type","application/json")
                    .build();
        } catch (SQLException exception) {
            exception.printStackTrace();
            return Response.
                    status(500).
                    entity(new Message("operacion fallida")).
                    header("Content-Type","application/json").
                    build();
        }

    }
}
