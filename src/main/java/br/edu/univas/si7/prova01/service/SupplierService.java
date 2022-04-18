package br.edu.univas.si7.prova01.service;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import br.edu.univas.si7.prova01.dto.SupplierDTO;
import br.edu.univas.si7.prova01.exception.InvalidDataException;
import br.edu.univas.si7.prova01.exception.ObjectNotFoundException;
import br.edu.univas.si7.prova01.model.Supplier;
import br.edu.univas.si7.prova01.repository.SupplierRepository;

@Service
public class SupplierService {

	@Autowired
	private SupplierRepository repo;

	public List<Supplier> findAll() {
		return repo.findAll();
	}

	public Supplier findById(long id) {
		Optional<Supplier> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Supplier " + id + " not found."));
	}

	public long createSupplier(Supplier supplier) {
		Optional<Supplier> existingSupplier = repo.findById(supplier.getCnpj());
		if (existingSupplier.isPresent()) {
			throw new InvalidDataException("Supplier already exist with this id: " + supplier.getCnpj());
		}
		repo.save(supplier);
		return supplier.getCnpj();
	}

	public Supplier toSupplier(SupplierDTO supplier) {
		return new Supplier(supplier.getName(), 0, null, null, 0);
	}

	public void updateSupplier(Supplier supplier, long id) {
		if (supplier == null) {
			throw new InvalidDataException("INVALID SUPPLIER ID.");
		}
		Supplier existingObj = findById(id);
		updateData(existingObj, supplier);
		repo.save(supplier);
	}

	private void updateData(Supplier existingObj, Supplier supplier) {
		existingObj.setName(supplier.getName());
	}

	public void deleteSupplier(long id) {
		if (Objects.isNull(id)) {
			throw new InvalidDataException("Supplier id can not be null.");
		}
		Supplier cust = findById(id);
		try {
			repo.delete(cust);
		} catch (DataIntegrityViolationException e) {
			throw new InvalidDataException("Can not delete a Supplier");
		}
	}
}
