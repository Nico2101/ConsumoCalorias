package com.usuario.ladc.web.consumoCalorias.web;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
import com.lowagie.text.html.simpleparser.HTMLWorker;
import com.lowagie.text.pdf.PdfWriter;
import com.usuario.ladc.web.consumoCalorias.domain.Categoria;
import com.usuario.ladc.web.consumoCalorias.domain.Consumo;
import com.usuario.ladc.web.consumoCalorias.domain.Usuario;
import com.usuario.ladc.web.consumoCalorias.repository.CategoriaDao;
import com.usuario.ladc.web.consumoCalorias.repository.ConsumoDao;
import com.usuario.ladc.web.consumoCalorias.repository.UsuarioDao;
import com.usuario.ladc.web.consumoCalorias.service.HtmlInformeTotalUsuarios;

@Controller
public class informeUsuariosController {
	@Autowired
    private UsuarioDao usuarioDao;
    
    public void setUsuarioDao(UsuarioDao usuarioDao) {
        this.usuarioDao = usuarioDao;
    }
    

    @RequestMapping(value="informeUsuarios.htm")
	 public ModelAndView generarInformeConsumoCalorias(HttpServletRequest request, HttpServletResponse response,HtmlInformeTotalUsuarios contenido){
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
					//System.out.println(nombreYApellido[0] + " "+nombreYApellido[1]);
					datosUsuario.add(nombreYApellido);
				}
				
				
			}
			vista.addObject("datosUsuario",datosUsuario);
		
			vista.addObject("usuario", u);
			vista.addObject("totalUsuarios", totalUsuarios);
			vista.addObject(contenido);
	    	return vista;
		}else{
			return new ModelAndView("salir");
		}
	 }
	
	
	@RequestMapping(value="generarPDFTotalUsuarios.htm", method = RequestMethod.POST)
	 public ModelAndView generarPDF(@Valid HtmlInformeTotalUsuarios formulario, BindingResult result, HttpServletRequest request, HttpServletResponse response) throws Exception{
		 HttpSession session = request.getSession(true);
		 Usuario u = (Usuario) session.getAttribute("usuario");
		 if(u != null){
			 
			 String nombreFichero = "informeTotalUsuarios.pdf";
			 //Rescatar HTML
			 String contenido = formulario.getContenido();
			 
			 
			 //Escribir PDF
			 Document document = new Document(PageSize.A4); 
		     PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(new File(nombreFichero))); 
		     document.open(); 
		     document.addAuthor("Nutricion y vida saludable"); 
		     document.addCreator("Sistema de control de calorias"); 
		     document.addCreationDate(); 
		     document.addTitle("Informe de uso de la plataforma"); 
		     HTMLWorker htmlWorker = new HTMLWorker(document); 
		     htmlWorker.parse(new StringReader(contenido)); 
		     document.close(); 
		     
		     //Descargar PDF
	         response.setContentType("application/pdf");
	         response.setHeader("Content-Disposition", "attachment; filename=\""   + nombreFichero+ "\"");
	         FileInputStream is = new FileInputStream(nombreFichero);
	         IOUtils.copy(is, response.getOutputStream());
	         response.flushBuffer();
	         return new ModelAndView("generarPDFTotalUsuarios");
			 
		 }else{
			 return new ModelAndView("salir");
		 }
	 }
	
	
}
