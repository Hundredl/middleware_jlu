package javaee.jpa.one.service;

import javaee.jpa.one.entity.Mentor;


import java.util.List;

public interface MentorService {
    List<Mentor> findAll();

    void add(Mentor mentor);

    void delete(Integer id);

    void update(Integer id, Mentor mentor);
}
