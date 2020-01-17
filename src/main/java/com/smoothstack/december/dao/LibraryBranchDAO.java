package com.smoothstack.december.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smoothstack.december.entity.*;

@Repository
public interface LibraryBranchDAO extends JpaRepository<LibraryBranch, Long> {
}
