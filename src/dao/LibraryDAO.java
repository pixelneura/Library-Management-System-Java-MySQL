package dao;

import java.sql.*;
import java.util.*;
import model.Book;
import model.Issue;
import util.DBConnection;

public class LibraryDAO {
    static Scanner sc = new Scanner(System.in);

    public void addBook() {
        Connection c = null;
        PreparedStatement ps = null;
        try {
            c = DBConnection.getConnection();
            ps = c.prepareStatement("INSERT INTO books (name, author, code, total, subject) VALUES (?, ?, ?, ?, ?)");

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
        } catch (SQLException e) {
            System.out.println("Error adding book: " + e.getMessage());
        } finally {
            try {
                if (ps != null) ps.close();
                if (c != null) c.close();
            } catch (SQLException e) {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }
    }

    public void updateBook() {
        Connection c = null;
        PreparedStatement ps = null;
        try {
            c = DBConnection.getConnection();
            System.out.println("Enter Book Code to Update Total:");
            String code = sc.next();
            System.out.println("Enter New Total:");
            int total = sc.nextInt();

            ps = c.prepareStatement("UPDATE books SET total=? WHERE code=?");
            ps.setInt(1, total);
            ps.setString(2, code);

            ps.executeUpdate();
            System.out.println("Book Updated Successfully.");
        } catch (SQLException e) {
            System.out.println("Error updating book: " + e.getMessage());
        } finally {
            try {
                if (ps != null) ps.close();
                if (c != null) c.close();
            } catch (SQLException e) {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }
    }

    public void deleteBook() {
        Connection c = null;
        PreparedStatement ps = null;
        try {
            c = DBConnection.getConnection();
            System.out.println("Enter Book Code to Delete:");
            String code = sc.next();

            ps = c.prepareStatement("DELETE FROM books WHERE code=?");
            ps.setString(1, code);

            ps.executeUpdate();
            System.out.println("Book Deleted Successfully.");
        } catch (SQLException e) {
            System.out.println("Error deleting book: " + e.getMessage());
        } finally {
            try {
                if (ps != null) ps.close();
                if (c != null) c.close();
            } catch (SQLException e) {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }
    }

    public void viewBooks() {
        Connection c = null;
        Statement s = null;
        ResultSet rs = null;
        try {
            c = DBConnection.getConnection();
            s = c.createStatement();
            rs = s.executeQuery("SELECT * FROM books");

            System.out.println("|-----------------------------------------------|");
            System.out.println("|Name|Author|Code|Total|Subject|");
            System.out.println("|-----------------------------------------------|");
            while (rs.next()) {
                System.out.println("|" + rs.getString(1) + "|" + rs.getString(2) + "|" + rs.getString(3) + "|" + rs.getInt(4) + "|" + rs.getString(5) + "|");
            }
            System.out.println("|-----------------------------------------------|");
        } catch (SQLException e) {
            System.out.println("Error viewing books: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (s != null) s.close();
                if (c != null) c.close();
            } catch (SQLException e) {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }
    }

    public void issuedBooks() {
        Connection c = null;
        Statement s = null;
        ResultSet rs = null;
        try {
            c = DBConnection.getConnection();
            s = c.createStatement();
            rs = s.executeQuery("SELECT issue.*, books.name FROM books JOIN issue ON books.code=issue.code");

            System.out.println("|-----------------------------------------------|");
            System.out.println("|RegNo|Name|Code|Issue Date|Book Name|");
            System.out.println("|-----------------------------------------------|");
            while (rs.next()) {
                System.out.println("|" + rs.getString(1) + "|" + rs.getString(2) + "|" + rs.getString(3) + "|" + rs.getString(4) + "|" + rs.getString(5) + "|");
            }
            System.out.println("|-----------------------------------------------|");
        } catch (SQLException e) {
            System.out.println("Error viewing issued books: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (s != null) s.close();
                if (c != null) c.close();
            } catch (SQLException e) {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }
    }
}
