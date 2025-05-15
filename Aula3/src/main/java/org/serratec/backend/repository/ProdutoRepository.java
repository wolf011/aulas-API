package org.serratec.backend.repository;

import org.serratec.backend.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //Hoje em dia, é opcional porque ele já entende isso de maneira automática, se estiver vazio.
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
