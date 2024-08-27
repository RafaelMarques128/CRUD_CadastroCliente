package br.com.rsm.dao;

import br.com.rsm.domain.Cliente;

import javax.swing.text.StyledEditorKit;
import java.util.Collection;
import java.util.Collections;

public interface iClienteDAO {

    public Boolean cadastrar(Cliente cliente);

    public void excluir(Long cpf);

    public void alterar(Cliente cliente);

    public Cliente consultar(Long cpf);

    public Collection<Cliente> buscarTodos();

}
