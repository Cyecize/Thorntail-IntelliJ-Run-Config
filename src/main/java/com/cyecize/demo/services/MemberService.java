package com.cyecize.demo.services;

import com.cyecize.demo.entities.Member;
import java.util.List;

public interface MemberService {

  Member addNewMember(String username, String direction);

  Member findById(int id);

  List<Member> findAllMembers(String direction);

  List<Member> findAllMembers();
}
