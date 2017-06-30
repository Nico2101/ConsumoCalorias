package com.usuario.ladc.web.consumoCalorias.web;
import com.usuario.ladc.web.consumoCalorias.domain.*;
import com.usuario.ladc.web.consumoCalorias.repository.ConsumoDao;
import com.usuario.ladc.web.consumoCalorias.repository.UsuarioDao;
import com.usuario.ladc.web.consumoCalorias.service.*;

import java.util.List;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class InicioController {



	protected final Log logger = LogFactory.getLog(getClass());
	@Autowired
    private ConsumoDao consumoDao;
	
	public void setConsumoDao(ConsumoDao consumoDao) {
	        this.consumoDao = consumoDao;
	    }

	@RequestMapping(value="inicio.htm")
	public ModelAndView cargarPaginaInicio(HttpServletRequest request) throws ServletException{
		HttpSession session = request.getSession(true);
		Usuario u = (Usuario) session.getAttribute("usuario");
		if(u != null){
			ModelAndView vista = new ModelAndView("inicio");
			vista.addObject("usuario", u);
			int sumaCalorias=calcularTotalCaloriasDiarias(u.getId());
			int maxCalorias=u.getMaxCalorias();
			int porcentajeCalorias=calcularProcentajeCaloriasDiarias(maxCalorias,u.getId());
			vista.addObject("porcentajeCalorias", porcentajeCalorias);
			vista.addObject("sumaCalorias", sumaCalorias);
			return vista;
		}else{
			return new ModelAndView("salir");
		}
		
	}
	
	@RequestMapping(value="inicioAdministrador.htm")
	public ModelAndView cargarPaginaInicioAdministrador(HttpServletRequest request) throws ServletException{
		HttpSession session = request.getSession(true);
		Usuario u = (Usuario) session.getAttribute("usuario");
		if(u != null){
			ModelAndView vista = new ModelAndView("inicioAdministrador");
			vista.addObject("usuario", u);
			return vista;
		}else{
			return new ModelAndView("salir");
		}
		
	}
	
	public int calcularTotalCaloriasDiarias(int id_usuario){
		Date fechaHoy = new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String fechaFormat=sdf.format(fechaHoy);
		
		List <Consumo> ConsumoUsuarioHoy=consumoDao.listaConsumoHoyPorUsuario(id_usuario,fechaFormat);
		int suma=0;
		float calorias=0;
		for (Consumo c :  ConsumoUsuarioHoy){
			calorias= c.getPorcion()*c.getAlimento().getCalorias()/c.getAlimento().getCantidad();
			suma+=calorias;
		}
		
		return suma;
	}
	public int calcularProcentajeCaloriasDiarias(int maxCalorias, int id_usuario){
    	int porcentaje=0;
    	int totalCaloriasDiarias=calcularTotalCaloriasDiarias(id_usuario);
    	porcentaje= totalCaloriasDiarias*100/maxCalorias;
    	return porcentaje;
    }
   
	
}