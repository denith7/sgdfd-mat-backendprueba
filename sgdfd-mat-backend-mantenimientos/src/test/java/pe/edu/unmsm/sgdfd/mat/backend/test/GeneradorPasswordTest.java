package pe.edu.unmsm.sgdfd.mat.backend.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class GeneradorPasswordTest {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {

		BCryptPasswordEncoder  bc = new BCryptPasswordEncoder(); 
		Connection con;
		PreparedStatement sen;
		ResultSet res;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = java.sql.DriverManager.getConnection("jdbc:oracle:thin:@172.16.242.26:1521:ora11g", "BD_SGDFD_MAT",
				"unm5m_$g6f6#_#m4t");
		sen = con.prepareStatement("select codigo_alumno from mae_usuario");
		res = sen.executeQuery();
		List<String> lista = new ArrayList<>();
		while (res.next()) {
			lista.add(res.getString(1));
		}
		
		lista.forEach(codigo -> {
			String update = "update mae_usuario set contrasenia = ?,  contrasenia_dES= ? where codigo_alumno = ? ";
			try (PreparedStatement sen2 = con.prepareStatement(update) ){
				String result = RandomStringUtils.random(10, 0, 20, true, true, "qw32rfHIJk9iQ8Ud7h0X".toCharArray());
				sen2.setString(1, bc.encode(result));
				sen2.setString(2, result);
				sen2.setString(3, codigo);
				sen2.execute();
				System.out.println("u: " + codigo + "p: " + result);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

	}

}
