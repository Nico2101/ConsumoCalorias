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

@Controller
public class InformeCaloriasController {
	
	 @Autowired
	 private CategoriaDao categoriaDao;
	 @Autowired
	 private ConsumoDao consumoDao;
	 
	 public void serCategoriaDao(CategoriaDao categoriaDao) {
        this.categoriaDao = categoriaDao;
    }
	 
	 public void setConsumoDao(ConsumoDao consumoDao) {
        this.consumoDao = consumoDao;
    }
	
	 @RequestMapping(value="informeCalorias.htm")
	 public ModelAndView generarInformeConsumoCalorias(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession(true);
		Usuario u = (Usuario) session.getAttribute("usuario");
		if(u != null){
			List<Categoria> listaDeCategorias = categoriaDao.getListaCategorias();
			
			//Armar fechas de borde
			Date hoy = new Date();	
			int mesAnterior = hoy.getMonth();
			int mesActual = mesAnterior + 1;
			int añoActual = 1900 + hoy.getYear();
			int añoAnterior = mesAnterior == 0 ? añoActual - 1 : añoActual;
			
			String fechaInicial = añoAnterior+"-"+formatearMes(mesAnterior)+"-01";
			String fechaFinal = añoActual+"-"+formatearMes(mesActual)+"-01";
			List<String[]> promedioConsumoPorCategoria = new ArrayList<String[]>();
			
			int caloriasTotales = 0;
			
			for(Categoria c : listaDeCategorias){
				//Obtener los consumos por cada categoria
				List<Consumo> resultado = consumoDao.getConsumosDeUnUsuarioYUnaCategoria(u.getId(), c.getId(), fechaInicial, fechaFinal);
				String [] dato = new String[2];
				dato[0] = c.getNombre();
				//Obtener el promedio de dichos consumos
				float totalCaloriasCategoria = 0;
				int promedioCategoria = 0;
				
				for(Consumo cons : resultado){
					totalCaloriasCategoria += (cons.getPorcion() * cons.getAlimento().getCalorias() / cons.getAlimento().getCantidad());
				}
				
				caloriasTotales += totalCaloriasCategoria;
				
				promedioCategoria = (int) totalCaloriasCategoria / dias(mesAnterior);
				
				dato[1] = ""+promedioCategoria;
				promedioConsumoPorCategoria.add(dato);
			}
			int promedioTotal = caloriasTotales / dias(mesAnterior);
			
			ModelAndView vista = new ModelAndView("informeCalorias");
			vista.addObject("promedioConsumoPorCategoria",promedioConsumoPorCategoria);
			vista.addObject("cabecera",generarCabecera(mesAnterior,añoAnterior));
			vista.addObject("promedioTotal", promedioTotal);
			vista.addObject("usuario", u);
	    	return vista;
		}else{
			return new ModelAndView("salir");
		}
	 }
	 
	 @RequestMapping(value="application/{informe}")
	 public String descargarInforme(@PathVariable("informe") String informe){
		 return "application/"+informe;
	 }
	 
	 //Función que retorna el numero de días que tiene el mes
	 private int dias(int mes){
		 if(mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 0)
			 return 31;
		 else if(mes == 2)	return 2;
		 else return 30;
	 }
	 
	 //Función que genera una cabecera indicando el mes (con palabras) y el año del informe
	 private String generarCabecera(int mes, int año){
		 String salida = "";
		 switch(mes){
		 case 0:
			 salida+="Diciembre";
			 break;
		 case 1:
			 salida+="Enero";
			 break;
		 case 2:
			 salida+="Febrero";
			 break;
		 case 3:
			 salida+="Marzo";
			 break;
		 case 4:
			 salida+="Abri";
			 break;
		 case 5:
			 salida+="Mayo";
			 break;
		 case 6:
			 salida+="Junio";
			 break;
		 case 7:
			 salida+="Julio";
			 break;
		 case 8:
			 salida+="Agosto";
			 break;
		 case 9:
			 salida+="Septiembre";
			 break;
		 case 10:
			 salida+="Octubre";
			 break;
		 case 11:
			 salida+="Noviembre";
			 break;
		 default:
			 break;
		 }
		 salida+=" "+año;
		 return salida;
	 }
	 
	 
	 //Función que se encarga de ponerle el cero a la izquierda al mes
	 private String formatearMes(int mes){
		 String mesFormateado = "";
		 if(mes > 9){
			mesFormateado += mes;
		}else{
			if(mes > 0){
				mesFormateado += "0"+ mes;
			}else{
				//El mes es diciembre
				mesFormateado += "12";
			}
		}
		return mesFormateado;
	 }
}
