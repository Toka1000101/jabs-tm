package com.trainning.module1.practical.task.repository;

import com.trainning.module1.practical.task.entitty.AppUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class AppUserRepositoryTest {

    @Autowired
    private AppUserRepository appUserRepository;

    @Test
    void testSaveEntity() {

        String userName = "testUsername";
        String password = "testUserPassword";

        AppUser appUser = AppUser.builder()
                .username(userName)
                .password(password)
                .build();

        appUserRepository.save(appUser);

        AppUser userFromDb = appUserRepository.findByUsername(userName);

        assertNotNull(userFromDb.getId());
        assertEquals(userFromDb.getUsername(), userName);
        assertEquals(userFromDb.getPassword(), password);

    }

}