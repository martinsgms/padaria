package br.com.martins.padaria.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.martins.padaria.model.Cliente;
import br.com.martins.padaria.model.Usuario;

public class FakeDataBase {

    private static List<Cliente> clientes = new ArrayList<>();
    private static List<Usuario> usuarios = new ArrayList<>();
    private static Integer idGenerator = 0;
    
    static {
        create(new Cliente("gabriel", new Date()));
        create(new Cliente("maria", new Date()));

        create(new Usuario("admin", "admin"));
    }
    
    public static void create(Cliente cliente) {
        cliente.setId(++idGenerator);
        clientes.add(cliente);
        
    }
    
    public static void create(Usuario usuario) {
        usuario.setId(++idGenerator);
        usuarios.add(usuario);
        
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
    
    public Usuario findUser(String login, String senha) {
        for (Usuario usuario : usuarios) {
            if (usuario.verifyUser(login, senha)) {
                return usuario;
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
