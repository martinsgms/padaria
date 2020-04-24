package br.com.martins.padaria.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.martins.padaria.model.Cliente;

public class FakeDataBase {

    private static List<Cliente> clientes = new ArrayList<Cliente>();
    private static Integer idGenerator = 0;

    public void create(Cliente cliente) {

        cliente.setId(++idGenerator);
        clientes.add(cliente);
    }

    public List<Cliente> findAll() {
        return clientes;
    }

    public Cliente findById(Integer id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null;
    }
    
    public void delete(Integer id) {
        Cliente cliente = findById(id);
        
        if(cliente != null) 
            clientes.remove(cliente);
    }

}
