package ru.pcs.example.javashop;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles(profiles = "test")
@SpringBootTest
public class JavashopApplicationTests {

    @Test
    void contextLoads() {
    }

}
