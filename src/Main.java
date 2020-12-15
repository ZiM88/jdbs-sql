import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
        String connectionUrl = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC&useSSL=false";
        String userName = "root";
        String password = "Zim1350512kH";
        Class.forName("com.mysql.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection(connectionUrl, userName, password);
             Statement statement = connection.createStatement()) {
            System.out.println("We are connected");
            statement.executeUpdate("drop table books");
            statement.executeUpdate("create table if not exists books (id MEDIUMINT not null AUTO_INCREMENT, name char(30)not null,img BLOB,primary key (id));");
            statement.executeUpdate("insert into books set name = 'mysql'");
            statement.executeUpdate("insert into books set name = 'mybible'");
            ResultSet resultSet = statement.executeQuery("select * from books");
//
//            BufferedImage image = ImageIO.read(new File("autowp.ru_peugeot_607_53_1.jpeg"));
//            Blob blob = connection.createBlob();

//        try (OutputStream outputStream = blob.setBinaryStream(1)) {
//            ImageIO.write(image, "jpg", outputStream);
//        }
//
//        PreparedStatement statement1 = connection.prepareStatement("insert into books(name, img) values(?,?)");
//        statement1.setString(1, "inferno");
//        statement1.setBlob(2, blob);
//        statement1.execute();
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1));
                System.out.println(resultSet.getString(2));
                System.out.println("------------");
            }
        }
    }
}
