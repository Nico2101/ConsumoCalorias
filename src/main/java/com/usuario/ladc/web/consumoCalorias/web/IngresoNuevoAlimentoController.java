package com.usuario.ladc.web.consumoCalorias.web;
import java.util.List;
import com.usuario.ladc.web.consumoCalorias.domain.*;
import com.usuario.ladc.web.consumoCalorias.repository.*;
import com.usuario.ladc.web.consumoCalorias.service.*;

import java.io.IOException;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IngresoNuevoAlimentoController {

    protected final Log logger = LogFactory.getLog(getClass());
    
    @Autowired
    private CategoriaDao categoriaDao;
    
    @Autowired
    private ConsumoDao consumoDao;
   
    @Autowired
    private AlimentoDao alimentoDao;
    
    public void setConsumoDao(ConsumoDao consumoDao) {
        this.consumoDao = consumoDao;
    }
    
    public void setAlimentoDao(AlimentoDao alimentoDao) {
        this.alimentoDao = alimentoDao;
    }

    public void setCategoriaDao(CategoriaDao categoriaDao) {
        this.categoriaDao = categoriaDao;
    }
    
    @RequestMapping(value="IngresoNuevoAlimento.htm", method = RequestMethod.GET)
    public ModelAndView recargarFormularioIngresoNuevoAlimento(HttpServletRequest request,FormularioIngresoNuevoAlimento formularioAntiguo) throws ServletException{
    	HttpSession session = request.getSession(true);
		Usuario u = (Usuario) session.getAttribute("usuario");
		if(u != null){
			ModelAndView vista = new ModelAndView("IngresoNuevoAlimento");
			FormularioIngresoNuevoAlimento form = formularioAntiguo == null ? new FormularioIngresoNuevoAlimento() : formularioAntiguo;
	    	vista.addObject(form);
	    	vista.addObject("listaCategorias",categoriaDao.getListaCategorias());
	    	vista.addObject("usuario",u);
	    	return vista;
		}else{
			return new ModelAndView("salir");
		}
    }
    
    @RequestMapping(value="IngresoNuevoAlimento.htm", method = RequestMethod.POST)
    public ModelAndView guardarAlimento(HttpServletRequest request, @Valid FormularioIngresoNuevoAlimento formulario, @Valid FormularioIngresoAlimento formulario2,BindingResult result) throws ServletException, IOException	
    {
    	HttpSession session = request.getSession(true);
		Usuario u = (Usuario) session.getAttribute("usuario");
		if(u != null){
	        if (result.hasErrors()) {
	        	return recargarFormularioIngresoNuevoAlimento(request, formulario);
	        }
	        
	        int categoria = formulario.getCategoria();
	        String nombre = formulario.getNombre();
	        float cantidad = formulario.getCantidad();
	        String medida = formulario.getMedida();
	        int calorias = formulario.getCalorias();
	        
	        System.out.println("categoria: "+categoria+"\nId nombre: "+nombre+"\ncantidad: "+cantidad+"\nmedida: "+medida+"\ncalorias: "+calorias);
	        
	        //Insertar resto de la lógica
	        
	        Categoria c = new Categoria();
	        c=categoriaDao.getCategoria(categoria);
	        
	        Alimento a = new Alimento();
	        a.setCategoria(c);
	        a.setNombre(nombre);
	        a.setCantidad(cantidad);
	        a.setMedida(medida);
	        a.setCalorias(calorias);
	        a.setUsuario(u);
	        alimentoDao.saveAlimento(a);
	        
    		ModelAndView vista = new ModelAndView("ingresoAlimento");
    		int sumaCalorias=calcularTotalCaloriasDiarias(u.getId());
			vista.addObject("sumaCalorias", sumaCalorias);
			int maxCalorias=u.getMaxCalorias();
			int porcentajeCalorias=calcularProcentajeCaloriasDiarias(maxCalorias,u.getId());
			vista.addObject("porcentajeCalorias", porcentajeCalorias);
    		vista.addObject("usuario", u);
    		vista.addObject(formulario2);
    		
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