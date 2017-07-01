package com.usuario.ladc.web.consumoCalorias.web;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.usuario.ladc.web.consumoCalorias.domain.Categoria;
import com.usuario.ladc.web.consumoCalorias.domain.Consumo;
import com.usuario.ladc.web.consumoCalorias.domain.Usuario;
import com.usuario.ladc.web.consumoCalorias.repository.CategoriaDao;
import com.usuario.ladc.web.consumoCalorias.repository.ConsumoDao;
import com.usuario.ladc.web.consumoCalorias.repository.UsuarioDao;

@Controller
public class informeUsuariosController {
	@Autowired
    private UsuarioDao usuarioDao;
    
    public void setUsuarioDao(UsuarioDao usuarioDao) {
        this.usuarioDao = usuarioDao;
    }
    

	@RequestMapping(value="informeUsuarios.htm")
	 public ModelAndView generarInformeConsumoCalorias(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession(true);
		Usuario u = (Usuario) session.getAttribute("usuario");
		if(u != null){
			
			List <Usuario> usuarios= usuarioDao.getListaUsuarios();
			
			int totalUsuarios=usuarios.size()-1;
	
			ModelAndView vista = new ModelAndView("informeUsuarios");
		
			vista.addObject("usuario", u);
			vista.addObject("totalUsuarios", totalUsuarios);
	    	return vista;
		}else{
			return new ModelAndView("salir");
		}
	 }
	
	
}
