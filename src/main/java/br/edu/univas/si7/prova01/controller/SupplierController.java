package br.edu.univas.si7.prova01.controller;

import java.net.URI;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import br.edu.univas.si7.prova01.dto.SupplierDTO;
import br.edu.univas.si7.prova01.service.SupplierService;

@RestController
@RequestMapping("/suppliers")
@Controller
public class SupplierController {

	@Autowired
	private SupplierService service;

	@GetMapping("")
	public ResponseEntity<List<SupplierDTO>> findAll() {
		List<SupplierDTO> list = service.findAll().stream().map(c -> new SupplierDTO(c)).collect(Collectors.toList());
		return ResponseEntity.ok().body(list);
	}

	@GetMapping("/{id}")
	public ResponseEntity<SupplierDTO> find(@PathVariable long id) {
		Supplier supplier = (Supplier) service.findById(id);
		return ResponseEntity.ok().body(new SupplierDTO());
	}

	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Void> createSupplier(@Valid @RequestBody SupplierDTO supplier) {
		long newSupplierId = service.createSupplier(service.toSupplier(supplier));

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newSupplierId).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateSupplier(@Valid @RequestBody SupplierDTO supplier, @PathVariable long id) {
		service.updateSupplier(service.toSupplier(supplier), id);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteSupplier(@PathVariable long id) {
		service.deleteSupplier(id);
	}

}
