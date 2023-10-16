package ArchiVet.DAO.MySQL;

import ArchiVet.DAO.DAO;
import ArchiVet.Modelo.Mascota;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MySQL_Mascota extends DAO {

    private final String INSERT = "INSERT INTO mascota(NOMBRE, ESPECIE, RAZA, COLOR, SEXO, AÑO_NACIMIENTO, ID_propietario) VALUES(?, ?, ?, ?, ?, ?, ?)";

    public boolean insertarMascota(Mascota mascota) {
        boolean resultado = false;
        try {
            PreparedStatement prep = connection.prepare(INSERT);
            prep.setString(1, mascota.getNombre());
            prep.setString(2, mascota.getEspecie());
            prep.setString(3, mascota.getRaza());
            prep.setString(4, mascota.getColor());
            prep.setString(5, mascota.getSexo());
            prep.setInt(6, mascota.getAnio());
            prep.setInt(7, mascota.getId_propietario());

            resultado = prep.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } 
        return resultado;
    }

}
