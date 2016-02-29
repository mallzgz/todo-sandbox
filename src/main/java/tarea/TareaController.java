package tarea;

import java.util.ArrayList;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

@RestController
public class TareaController {
	ArrayList<Tarea> tareas= new ArrayList<>();
	@RequestMapping(path="/todo/api/v1.0/tarea",method=RequestMethod.GET)
	public ArrayList<Tarea> listarTarea(){
		return tareas;
	}
	@RequestMapping(path="/todo/api/v1.0/tarea/{id}", method=RequestMethod.GET)
	public Tarea getTarea(@PathVariable("id") long id){
		Tarea tarea=new Tarea(id, "Titulo", "Descripcion", false);
		for (Tarea t : tareas){
			if (t.getId()== id) return tarea;
		}
		throw new NotFoundException();
	}
	@RequestMapping(path="/todo/api/v1.0/tarea",method=RequestMethod.POST)
	public ResponseEntity<Tarea> crearTarea(@RequestBody Tarea tarea){
		tarea.setId(tareas.size()+1);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setLocation(ServletUriComponentsBuilder		//MAGIA
				.fromCurrentRequest().path("/{id}")
				.buildAndExpand(tarea.getId()).toUri());
		return new ResponseEntity<Tarea>(tarea, httpHeaders, HttpStatus.CREATED);
	}
}
@ResponseStatus(HttpStatus.NOT_FOUND)
class NotFoundException extends RuntimeException {
	
}