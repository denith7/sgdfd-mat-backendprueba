package pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.service.ws;

import pe.edu.unmsm.sgdfd.mat.backend.mantenimientos.model.reponse.ReniecResponse;

public interface ReniecService {

	ReniecResponse buscarPorNumeroDNI(String numeroDNI);
}
