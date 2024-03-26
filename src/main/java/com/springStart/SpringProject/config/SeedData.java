package com.springStart.SpringProject.config;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.springStart.SpringProject.models.Account;
import com.springStart.SpringProject.models.Authority;
import com.springStart.SpringProject.models.Post;
import com.springStart.SpringProject.services.AccountService;
import com.springStart.SpringProject.services.AuthorityService;
import com.springStart.SpringProject.services.PostService;
import com.springStart.SpringProject.util.constants.Privillages;
import com.springStart.SpringProject.util.constants.Roles;

@Component
public class SeedData implements CommandLineRunner {

    @Autowired
    private PostService postService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private AuthorityService authorityService;

    @Override
    public void run(String... args) throws Exception {

        for (Privillages auth : Privillages.values()) {
            Authority authority = new Authority();
            authority.setId(auth.getId());
            authority.setName(auth.getPrivillage());
            authorityService.save(authority);

        }

        Account account01 = new Account();
        Account account02 = new Account();
        Account account03 = new Account();
        Account account04 = new Account();

        account01.setEmail("user@user.com");
        account01.setPassword("pass987");
        account01.setFirstname("User");
        account01.setLastname("lastname");
        account01.setAge(25);
        account01.setDate_of_birth(LocalDate.parse("1990-01-01"));
        account01.setGender("Male");

        account02.setEmail("admin@admin.com");
        account02.setPassword("pass987");
        account02.setFirstname("Admin");
        account02.setLastname("lastname");
        account02.setRole(Roles.ADMIN.getRole());
        account02.setAge(25);
        account02.setDate_of_birth(LocalDate.parse("1990-01-01"));
        account02.setGender("Famale");

        account03.setEmail("editor@editor.com");
        account03.setPassword("pass987");
        account03.setFirstname("Editor");
        account03.setLastname("lastname");
        account03.setRole(Roles.EDITOR.getRole());
        account03.setAge(55);
        account03.setDate_of_birth(LocalDate.parse("1975-01-01"));
        account03.setGender("Male");

        account04.setEmail("super_editor@editor.com");
        account04.setPassword("pass987");
        account04.setFirstname("Editor");
        account04.setLastname("lastname");
        account04.setRole(Roles.EDITOR.getRole());
        account04.setAge(40);
        account04.setDate_of_birth(LocalDate.parse("1980-01-01"));
        account04.setGender("Female");

        Set<Authority> authorities = new HashSet<>();
        authorityService.findById(Privillages.ACCESS_ADMIN_PANEL.getId()).ifPresent(authorities::add);
        authorityService.findById(Privillages.RESET_ANY_USER_PASSWORD.getId()).ifPresent(authorities::add);
        account04.setAuthorities(authorities);

        accountService.save(account01);
        accountService.save(account02);
        accountService.save(account03);
        accountService.save(account04);

        List<Post> posts = postService.findAll();
        if (posts.size() == 0) {
            Post post01 = new Post();
            post01.setTitle("NBA defence-no Longer?");
            post01.setBody(
                    """
                               nba Defence is no more
                            """);
            post01.setAccount(account01);
            postService.save(post01);

            Post post02 = new Post();
            post02.setTitle("Kobe the best?");
            post02.setBody(
                    """

                              <h3><strong>Kobe was the best player?</strong></h3>
                              <p><a href="https://upload.wikimedia.org/wikipedia/commons/thumb/5/56/Kobe_Bryant_2014.jpg/360px-Kobe_Bryant_2014.jpg"></a></p><p>&nbsp;</p><p>Kobe was best player in NBA</p>

                            """);

            post02.setAccount(account02);
            postService.save(post02);

            Post post03 = new Post();
            post03.setTitle("MJ was the best?");
            post03.setBody(
                    """
                            Why Mj was the best?
                             """);
            post03.setAccount(account01);
            postService.save(post03);

            Post post04 = new Post();
            post04.setTitle("Lebron the best?");
            post04.setBody(
                    """
                            why Lebron is the best?
                                """);

            post04.setAccount(account02);
            postService.save(post04);

            Post post05 = new Post();
            post05.setTitle("NBA gettin Team in Sietle?");
            post05.setBody(
                    """
                            new team in NBA?

                                """);
            post05.setAccount(account01);
            postService.save(post05);

            Post post06 = new Post();
            post06.setTitle("Games in Australia?");
            post06.setBody(
                    """
                            NBA will play games in AU

                                """);

            post06.setAccount(account02);
            postService.save(post06);

        }

    }

}
