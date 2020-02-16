package com.cyecize.demo.services;

import com.cyecize.demo.entities.Member;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import org.wildfly.swarm.spi.runtime.annotations.ConfigurationValue;

@ApplicationScoped
public class MemberServiceImpl implements MemberService {

  private static int ID_COUNT = 0;

  private final Map<Integer, Member> membersDb;

  private String defaultDirection;

  public MemberServiceImpl() {
    this.membersDb = new HashMap<>();
  }

  @Inject
  public MemberServiceImpl(
      @ConfigurationValue("members.default-direction") String defaultDirection) {
    this();
    this.defaultDirection = defaultDirection;
  }

  @Override
  public Member addNewMember(String username, String direction) {
    if (direction == null) {
      direction = this.defaultDirection;
    }

    final Member member = new Member(++ID_COUNT, username, direction);

    this.membersDb.put(member.getId(), member);

    return member;
  }

  @Override
  public Member findById(int id) {
    return this.membersDb.get(id);
  }

  @Override
  public List<Member> findAllMembers(String direction) {
    return this.membersDb.values()
        .stream()
        .filter(member -> member.getDirection().equalsIgnoreCase(direction))
        .collect(Collectors.toList());
  }

  @Override
  public List<Member> findAllMembers() {
    return new ArrayList<>(this.membersDb.values());
  }
}
