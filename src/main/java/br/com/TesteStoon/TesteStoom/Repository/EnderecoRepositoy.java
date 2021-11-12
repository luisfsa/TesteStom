package br.com.TesteStoon.TesteStoom.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.TesteStoon.TesteStoom.Entity.Endereco;

public class EnderecoRepositoy {



@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> { }

}