package dao;

import dto.VehiculoDTO;
import jakarta.persistence.EntityManager;

import java.util.List;

public class VehiculoDAO {
    private EntityManager entityManager;

    public VehiculoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<VehiculoDTO> obterVehiculos(){
        String jpql= "SELECT new VehiculoDTO(v.idVehiculo, v.marca, v.modelo, v.ano, v.precio, TYPE(v).name) FROM Vehiculo v";
        return entityManager.createQuery(jpql, VehiculoDTO.class).getResultList();
    }

}
