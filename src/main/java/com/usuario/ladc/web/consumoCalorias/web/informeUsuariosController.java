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
			List<String[]> datosUsuario = new ArrayList<String[]>();
			int totalUsuarios=usuarios.size()-1;
	
			ModelAndView vista = new ModelAndView("informeUsuarios");
			String nombre="";
			
			int i=0;
			for(Usuario user:usuarios){
				if(user.getId()!=0){
					String nombreYApellido[]=new String [2];
					nombreYApellido[0]=user.getNombre();
					nombreYApellido[1]=user.getApellido();
					System.out.println(nombreYApellido[0] + " "+nombreYApellido[1]);
					datosUsuario.add(nombreYApellido);
				}
				
				
			}
			vista.addObject("datosUsuario",datosUsuario);
		
			vista.addObject("usuario", u);
			vista.addObject("totalUsuarios", totalUsuarios);
	    	return vista;
		}else{
			return new ModelAndView("salir");
		}
	 }
	
	
}
