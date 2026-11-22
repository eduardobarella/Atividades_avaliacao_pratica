package com.example.produtos;

// Eduardo Barella — RA 24088000-2

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class ProdutoControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    // CT04 — POST /produtos: HTTP 200 com ID, nome e preço
    @Test
    void CT04_postProduto_deveRetornarProdutoComId() throws Exception {
        mockMvc.perform(post("/produtos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"nome\":\"Mouse\",\"preco\":80.0}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").isNumber())
                .andExpect(jsonPath("$.nome").value("Mouse"))
                .andExpect(jsonPath("$.preco").value(80.0));
    }

    // CT05 — GET /produtos/{id}: retorna o produto cadastrado via POST
    @Test
    void CT05_getProdutoPorId_deveRetornarProdutoCadastrado() throws Exception {
        MvcResult resultado = mockMvc.perform(post("/produtos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"nome\":\"Monitor\",\"preco\":1200.0}"))
                .andExpect(status().isOk())
                .andReturn();

        long id = objectMapper.readTree(resultado.getResponse().getContentAsString()).get("id").asLong();

        mockMvc.perform(get("/produtos/" + id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id))
                .andExpect(jsonPath("$.nome").value("Monitor"))
                .andExpect(jsonPath("$.preco").value(1200.0));
    }
}
