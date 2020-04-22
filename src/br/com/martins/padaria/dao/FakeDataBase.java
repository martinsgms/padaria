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
    
}
