package com.usuario.ladc.web.consumoCalorias.domain;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.usuario.ladc.web.consumoCalorias.domain.Usuario;

public class UsuarioTests {

    private Usuario usuario;
    
    
    @Before
    public void setUp() throws Exception {
        usuario = new Usuario();
        ArrayList<Alimento> user1 = new ArrayList<Alimento>();
        Alimento a1 = new Alimento();
        Alimento a2 = new Alimento();
        Alimento a3 = new Alimento();
        a1.setId(1);
        a2.setId(2);
        a3.setId(3);
        a1.setNombre("Manzana");
        a2.setNombre("Apio");
        a3.setNombre("Papas fritas");
        user1.add(a1);
        user1.add(a2);
        user1.add(a3);
        usuario.setId(1);
        usuario.setNombre("Pedro");
        usuario.setApellido("Navaja");
        usuario.setClave("1234");
        //usuario.setAlimentos(user1);
    }
    /*
    @Test
    public void testCreacionUsuarioConListaDeAlimentos() {
       
    	assertEquals(1, usuario.getAlimentos().get(0).getId());
    	assertEquals(2, usuario.getAlimentos().get(1).getId());
    	assertEquals(3, usuario.getAlimentos().get(2).getId());
    	assertEquals("Manzana", usuario.getAlimentos().get(0).getNombre());
    	assertEquals("Apio", usuario.getAlimentos().get(1).getNombre());
    	assertEquals("Papas fritas", usuario.getAlimentos().get(2).getNombre());
    	assertEquals(1, usuario.getId(),0);
    	assertEquals("Pedro", usuario.getNombre());
    	assertEquals("Navaja", usuario.getApellido());
    	assertEquals("1234", usuario.getClave());
    }
	*/
}