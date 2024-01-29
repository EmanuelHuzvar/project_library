package sk.kasv.huzvar.library.db;

import sk.kasv.huzvar.library.member.Member;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Database {
    private final String SELECTALLMEMBERS = "SELECT * FROM reader";
    private final String URL = "jdbc:mysql://localhost";
    private final int PORT = 3306;
    private final String DBNAME = "librarykasv";
    private final String LOGIN = "root";
    private final String PASSWORD = "";
    private List<Member> members;

    private Connection getConnection(){
        try {
            Connection con = DriverManager.getConnection(
                    URL+":"+PORT+"/"+DBNAME,LOGIN,PASSWORD);
            return con;
        } catch (SQLException e) {
            System.out.println("Fatal error"+e.getMessage());
            return null;
        }


    }
    public boolean testJDBC(){
        Connection con = getConnection();
        if (con==null){
            System.out.println("FATAL ERROR. Connection failed !");
            return false;
        }
        else {
            System.out.println("OK. Connected succesfully !");
            return true;
        }

    }
    public List<Member> getAllMembers(){
        Connection con = getConnection();
        if (con==null) {
            return null;

        }
        try {
            members = new ArrayList<>();
            PreparedStatement ps = con.prepareStatement(SELECTALLMEMBERS);
            ResultSet rs =  ps.executeQuery();
            while (rs.next()){
                int id = rs.getInt("ID");
                String fname = rs.getString("fname");
                String lname = rs.getString("lname");
                Date date = rs.getDate("dateOfBirth");
                Member newMember = new Member(id,fname,lname,date);
                members.add(newMember);

            }
            con.close();

        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }

        return members;
    }
    public void addNewReader(Member member){
        Connection con = getConnection();
        if (con == null)
            return;
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO reader (fname, lname, dateOfBirth) VALUES (?,?)");
            ps.setString(1, member.getFirstName());
            ps.setString(2, member.getLastName());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    @Override
    public String toString() {
        String out = "";
        for (Member m : members){
            out+= m.getId() +" "+m.getFirstName()+" "+m.getLastName()+" "+m.getDate()+"\n";
        }
        return out;
    }
}


