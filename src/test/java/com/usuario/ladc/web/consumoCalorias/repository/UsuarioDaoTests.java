package com.usuario.ladc.web.consumoCalorias.repository;

import java.util.List;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.usuario.ladc.web.consumoCalorias.domain.*;


public class UsuarioDaoTests {

    private ApplicationContext context;
    private UsuarioDao usuarioDao;

    @Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("classpath:test-context.xml");
        usuarioDao = (UsuarioDao) context.getBean("usuarioDao");
    }

    @Test
    public void testGetProductList() {
        List<Usuario> products = usuarioDao.getListaUsuarios();
        assertEquals(products.size(), 3, 0);	   
    }

    @Test
    public void testSaveProduct() {
        List<Usuario> listaUsuarios = usuarioDao.getListaUsuarios();

        Usuario u = listaUsuarios.get(0);
        String price = u.getNombre();
        u.setNombre("Armando");
        usuarioDao.saveUsuario(u);

        List<Usuario> usuariosActualizados = usuarioDao.getListaUsuarios();
        Usuario u2 = usuariosActualizados.get(0);
        assertEquals(u2.getNombre(), "Armando");

        u2.setNombre(price);
        usuarioDao.saveUsuario(u2);
    }
    
    @Test
    public void iniciarSesionFallidoPorqueElUsuarioNoEstaRegistrado() {
    	String correo = "mmunocan@conscal.cl";
    	String clave = "holaMundo";
    	Usuario u = usuarioDao.getUsuario(correo, clave);
    	
    	assertNull(u);
    }
    
    @Test
    public void iniciarSesionCorrectoPorqueElUsuarioEstaRegistrado() {
    	String correo = "mesa@conscal.cl";
    	String clave = "1234";
    	Usuario u = usuarioDao.getUsuario(correo, clave);
    	
    	assertNotNull(u);
    }
}