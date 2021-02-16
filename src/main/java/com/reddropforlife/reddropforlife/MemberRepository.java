package com.reddropforlife.reddropforlife;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MemberRepository extends JpaRepository<Members, Long> {

    @Query("SELECT u FROM Members u WHERE u.email = ?1")
    Members findByEmail(String email);
}
