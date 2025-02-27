import dao.VehiculoDAO;
import dto.VehiculoDTO;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        TestData.insertarDatos(); // Inserta datos de prueba

        VehiculoDAO vehiculoDAO = new VehiculoDAO(JPAUtil.getEntityManager());
        List<VehiculoDTO> vehiculos = vehiculoDAO.obterVehiculos();

        for (VehiculoDTO v : vehiculos) {
            System.out.println("ID: " + v.getIdVehiculo() +
                    ", Marca: " + v.getMarca() +
                    ", Modelo: " + v.getModelo() +
                    ", Año: " + v.getAno() +
                    ", Precio: " + v.getPrecio() +
                    ", Tipo: " + v.getTipo());
        }

        JPAUtil.close();
    }
}
