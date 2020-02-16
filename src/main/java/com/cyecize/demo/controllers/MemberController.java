package com.cyecize.demo.controllers;

import com.cyecize.demo.entities.Member;
import com.cyecize.demo.services.MemberService;
import java.util.Collection;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@ApplicationScoped
@Path("/members")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MemberController {

  private MemberService memberService;

  public MemberController() {

  }

  @Inject
  public MemberController(MemberService memberService) {
    this.memberService = memberService;
  }

  @GET
  public Collection<Member> findAllMembers() {
    return this.memberService.findAllMembers();
   // throw new RuntimeException("test");
  }

  @GET
  @Path("/direction/{direction}")
  public Collection<Member> findByDirection(@PathParam("direction") String direction) {
    return this.memberService.findAllMembers(direction);
  }

  @GET
  @Path("/{id}")
  public Member findOneById(@PathParam("id") int id) {
    return this.memberService.findById(id);
  }

  @POST
  public Member createNewMember(
      @NotNull @QueryParam("name") String name,
      @QueryParam("direction") String direction) {
    return this.memberService.addNewMember(name, direction);
  }
}
