package com.reddropforlife.reddropforlife;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class MemberRepositoryTest {
    @Autowired
    private MemberRepository repo;

    @Autowired
    private TestEntityManager entityManager;

//    @Test
//    public void testCreateMember(){
//        Members members = new Members();
//
//        members.setFirstname("xyz");
//        members.setLastname("mno");
//        members.setEmail("xyz@gmail.com");
//        members.setPhone("01768254894");
//        members.setPassword("12345678");
//        members.setPhone2("123456789");
//        members.setCurrentAddress("Valuka, Mymensingh");
//        members.setBloodGrp("B+");
//        members.setLastDateofDonation("12 July 2020");
//        members.setAge(24);
//        members.setWeight(58.5F);
//        members.setHeight(136.5F);
//        members.setExceptions("No Exception");
//
//        Members savedmember = repo.save(members);
//
//        Members existMember = entityManager.find(Members.class, savedmember.getId());
//
//        assertThat(existMember.getEmail()).isEqualTo(members.getEmail());
//    }

    @Test
    public void testFindUserByEmail(){
        String email = "xyz@gmail.com";
        Members member = repo.findByEmail(email);
        assertThat(member).isNotNull();
    }
}
