import jakarta.persistence.EntityManager;
import model.Camion;
import model.Coche;
import model.Moto;

public class TestData {
    public static void insertarDatos() {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();

        Coche coche = new Coche();
        coche.setMarca("Toyota");
        coche.setModelo("Corolla");
        coche.setAnio(2020);
        coche.setPrecio(20000);
        coche.setPuertas(4);
        coche.setPlazas(5);

        Moto moto = new Moto();
        moto.setMarca("Yamaha");
        moto.setModelo("YZF-R3");
        moto.setAnio(2022);
        moto.setPrecio(6000);
        moto.setCilindrada(321);
        moto.setTipo("Deportiva");

        Camion camion = new Camion();
        camion.setMarca("Volvo");
        camion.setModelo("FH16");
        camion.setAnio(2019);
        camion.setPrecio(80000);
        camion.setCarga(20000);
        camion.setEjes(3);

        em.persist(coche);
        em.persist(moto);
        em.persist(camion);

        em.getTransaction().commit();
        em.close();
    }
}
