package com.va.week6.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.va.week6.model.Student;

public class StudentDao {

// method for inserting values to db using preparedstatement. 	
	public int registerStudent(Student student) throws ClassNotFoundException {

		// create SQL statement
		String INSERT_USERS_SQL = " INSERT INTO student" + " ( id, first_name, last_name,  grade) VALUES "
				+ "(?, ? ,?, ?);";
		int result = 0;
		Class.forName("com.mysql.cj.jdbc.Driver");

		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/week6", "root",
				"YourPass")) {
			// prepared statements..
			// week6 is schema/db name - change as per your db, "root" remains same , your
			// pass as per ur db
			PreparedStatement ps = connection.prepareStatement(INSERT_USERS_SQL);
			ps.setInt(1, 2);
			ps.setString(2, student.getFirstname());
			ps.setString(3, student.getLastname());
			ps.setString(4, student.getGrade());

			System.out.println(ps);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
		return result;
	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {

				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();

				}
			}

		}

	}
}
