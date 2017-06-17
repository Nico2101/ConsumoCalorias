package com.usuario.ladc.web.consumoCalorias.web;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.servlet.ServletException;

import org.junit.Test;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import com.usuario.ladc.web.consumoCalorias.service.FormularioLoggin;


public class LogginControllerTests {

    @Test
    public void testQueRedireccionaAlLoggin() throws Exception{		
        LogginController controller = new LogginController();
        ModelAndView modelAndView = controller.recargarFormularioLoggin(null,null, false);		
        
        assertEquals("loggin2", modelAndView.getViewName());
        assertNotNull(modelAndView.getModel());
        
    }
    
    @Test
    public void testQueReaccionaAUnLogginFallido() throws ServletException, IOException{
    	LogginController controller = new LogginController();
    	FormularioLoggin form = new FormularioLoggin();
    	form.setCorreo("mmunocan@conscal.cl");
    	form.setClave("holaMundo");
    	ModelAndView respuesta = controller.formularioCargado(form,null,null,null);
    	
    	assertEquals("loggin2", respuesta.getViewName());
    }
    
    @Test
    public void testQueReaccionaAUnLogginCorrecto() throws ServletException, IOException{
    	LogginController controller = new LogginController();
    	FormularioLoggin form = new FormularioLoggin();
    	form.setCorreo("mesa@conscal.cl");
    	form.setClave("1234");
    	ModelAndView respuesta = controller.formularioCargado(form,null,null,null);
    	
    	assertEquals("inicio", respuesta.getViewName());
    	assertEquals("mesa@conscal.cl",respuesta.getModel().get("usuario"));
    	assertEquals("1234",respuesta.getModel().get("clave"));
    }

}