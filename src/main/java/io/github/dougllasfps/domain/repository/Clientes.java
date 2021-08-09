package io.github.dougllasfps.domain.repository;

import io.github.dougllasfps.domain.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface Clientes extends JpaRepository<Cliente, Integer> {

    List<Cliente> findByNomeLike(String cli);

    @Query(value = "SELECT c FROM Cliente c WHERE c.nome LIKE :nome ")
    List<Cliente> encontrarPorNome(@Param("nome") String nome);

    @Query(value = "SELECT * FROM Cliente c WHERE c.nome LIKE '%:nome%' ", nativeQuery = true)
    List<Cliente> encontrarPorNomeSqlNativo(@Param("nome") String nome);

    List<Cliente> findByNomeLikeOrIdOrderById(String nome, Integer id);

    boolean existsByNome(String nome);

    @Query(" delete from Cliente c where c.nome = :nome")
    @Modifying
    void deleteByNome(String nome);
}
