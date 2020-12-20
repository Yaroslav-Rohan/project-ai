package com.project.Band_Search.repository;

import com.project.Band_Search.models.PrimarySkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrimarySkillRepository extends JpaRepository<PrimarySkill, Long> {
}
