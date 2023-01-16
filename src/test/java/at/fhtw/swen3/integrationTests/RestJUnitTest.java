package at.fhtw.swen3.integrationTests;

import at.fhtw.swen3.persistence.entities.ParcelEntity;
import org.junit.experimental.categories.Category;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application.properties")
@Category(Integration.class)
@SpringBootTest(classes = Integration.class)
class RestJUnitTest {

    @Autowired
    private MockMvc mockMvc;

    String workingDirectory = System.getProperty("user.dir");

    @Test
    void submitParcelFail() throws Exception {
        String parcel = new String(Files.readAllBytes(Paths.get(workingDirectory +"/JsonData/ParcelFail.txt")));


        mockMvc.perform(post("/parcel")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(parcel)
                    .characterEncoding("utf-8"))
                .andExpect(status().isBadRequest());

    }

    @Test
    void postParcel() throws Exception {
        mockMvc.perform(post("/parcel")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"weight\": 992,\n" +
                                "\"recipient\": {\n" +
                                "\"name\": \"Amal Mostafa\",\n" +
                                "\"street\": \"Lugeck 4\",\n" +
                                "\"postalCode\": \"A-1010\",\n" +
                                "\"city\": \"Vienna\",\n" +
                                "\"country\": \"Austria\"\n" +
                                "},\n" +
                                "\"sender\": {\n" +
                                "\"name\": \"Hi Name\",\n" +
                                "\"street\": \"Leobendorferstraße 1\",\n" +
                                "\"postalCode\": \"A-2111\",\n" +
                                "\"city\": \"Tresdorf\",\n" +
                                "\"country\": \"Austria\"\n" +
                                "}}")
                        .characterEncoding("utf-8"))
                        .andExpect(status().isCreated());


    }

    @Test
    void exportWarehousesFail() throws Exception {
        mockMvc.perform(get("/warehouse"))
                .andExpect(status().isNotFound());
    }


}
