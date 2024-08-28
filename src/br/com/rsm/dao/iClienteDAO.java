package br.com.rsm.dao;

import br.com.rsm.domain.Cliente;

import java.util.Collection;

public interface iClienteDAO {

    public Boolean cadastrar(Cliente cliente);

    public Cliente excluir(Long cpf);

    public Cliente alterar(Cliente cliente);

    public Cliente consultar(Long cpf);

    public Collection<Cliente> buscarTodos();

}
