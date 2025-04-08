package dao;

import java.sql.*;
import java.util.*;
import model.Book;
import model.Issue;
import util.DBConnection;

public class LibraryDAO {
	static Scanner sc = new Scanner(System.in);

	public void addBook() throws Exception {
		Connection c = DBConnection.getConnection();
		PreparedStatement ps = c.prepareStatement("INSERT INTO books VALUES (?, ?, ?, ?, ?)");

		Book b = new Book();
		System.out.println("Enter Book Name:");
		b.setName(sc.next());
		System.out.println("Enter Author:");
		b.setAuthor(sc.next());
		System.out.println("Enter Code:");
		b.setCode(sc.next());
		System.out.println("Enter Total:");
		b.setTotal(sc.nextInt());
		System.out.println("Enter Subject:");
		b.setSubject(sc.next());

		ps.setString(1, b.getName());
		ps.setString(2, b.getAuthor());
		ps.setString(3, b.getCode());
		ps.setInt(4, b.getTotal());
		ps.setString(5, b.getSubject());

		ps.executeUpdate();
		System.out.println("Book Added Successfully.");
	}

	public void updateBook() throws Exception {
		Connection c = DBConnection.getConnection();
		System.out.println("Enter Book Code to Update Total:");
		String code = sc.next();
		System.out.println("Enter New Total:");
		int total = sc.nextInt();

		PreparedStatement ps = c.prepareStatement("UPDATE books SET total=? WHERE code=?");
		ps.setInt(1, total);
		ps.setString(2, code);

		ps.executeUpdate();
		System.out.println("Book Updated Successfully.");
	}

	public void deleteBook() throws Exception {
		Connection c = DBConnection.getConnection();
		System.out.println("Enter Book Code to Delete:");
		String code = sc.next();

		PreparedStatement ps = c.prepareStatement("DELETE FROM books WHERE code=?");
		ps.setString(1, code);

		ps.executeUpdate();
		System.out.println("Book Deleted Successfully.");
	}

	public void viewBooks() throws Exception {
		Connection c = DBConnection.getConnection();
		Statement s = c.createStatement();
		ResultSet rs = s.executeQuery("SELECT * FROM books");

		System.out.println("|-----------------------------------------------|");
		System.out.println("|Name|Author|Code|Total|Subject|");
		System.out.println("|-----------------------------------------------|");
		while (rs.next()) {
			System.out.println("|" + rs.getString(1) + "|" + rs.getString(2) + "|" + rs.getString(3) + "|" + rs.getInt(4) + "|" + rs.getString(5) + "|");
		}
		System.out.println("|-----------------------------------------------|");
	}

	public void issuedBooks() throws Exception {
		Connection c = DBConnection.getConnection();
		Statement s = c.createStatement();
		ResultSet rs = s.executeQuery("SELECT issue.*, books.name FROM books JOIN issue ON books.code=issue.code");

		System.out.println("|-----------------------------------------------|");
		System.out.println("|RegNo|Name|Code|Issue Date|Book Name|");
		System.out.println("|-----------------------------------------------|");
		while (rs.next()) {
			System.out.println("|" + rs.getString(1) + "|" + rs.getString(2) + "|" + rs.getString(3) + "|" + rs.getString(4) + "|" + rs.getString(5) + "|");
		}
		System.out.println("|-----------------------------------------------|");
	}
}
