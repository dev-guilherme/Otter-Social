package br.com.otter.otter_social.DAO;

import br.com.otter.otter_social.model.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface InterfaceUsuario extends CrudRepository<Usuario, Integer> {

}
