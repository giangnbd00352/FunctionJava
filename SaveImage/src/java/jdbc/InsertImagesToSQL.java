/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import java.sql.*;
import java.io.*;
/**
 *
 * @author B.Rengg
 */
public class InsertImagesToSQL {
    public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/imagedb", "root", "");

			File file = new File("C:\\Users\\B.Rengg\\Pictures\\Camera Roll\\giaynam.jpg");
			FileInputStream fis = new FileInputStream(file);

			PreparedStatement ps = con.prepareStatement("insert into person (id,Name,image_data,image_file_name) values(?,?,?,?)");
                        ps.setInt(1, 2);
			ps.setString(2, "giay nam");
			ps.setBinaryStream(3, fis, (int) file.length());
                        ps.setString(4, "suc vat");
			ps.executeUpdate();

			ps.close();
			fis.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
}
