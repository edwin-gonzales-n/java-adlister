import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.mysql.jdbc.Driver;

public class MySQLAdsDao implements Ads{

//    static final String Driver = "com.mysql.jdbc.Driver";
    private Connection connection = null;
//    Config config = new Config();

    public MySQLAdsDao(Config config) {
        try {
//            Class.forName(Driver);
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(config.getUrl(),config.getUser(),config.getPassword());

        } catch (SQLException e) {
            throw new RuntimeException("Error connection to DB.", e);
        }
    }

    @Override
    public List<Ad> all() {
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("select * from ads");
            return createAdsFromResults(resultSet);
        }  catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }

    @Override
    public Long insert(Ad ad) {
        try  {
            Statement statement = connection.createStatement();
            statement.executeUpdate(createInsertQuery(ad), Statement.RETURN_GENERATED_KEYS);
            ResultSet resultSet = statement.getGeneratedKeys();
            resultSet.next();
            return resultSet.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad,", e);
        }
    }

    private String createInsertQuery(Ad ad){
        return String.format("insert into ads(user_id, title, description) values" +
                "(\"%s\",\"%s\",\"%s\")", ad.getUserId(), ad.getTitle(), ad.getDescription());
    }

    private Ad extractAd(ResultSet resultSet) throws SQLException {
        return new Ad(resultSet.getLong("id"),
                resultSet.getLong("user_id"),
                resultSet.getString("title"),
                resultSet.getString("description"));
    }


    private List<Ad> createAdsFromResults (ResultSet resultSet) throws SQLException{
        List<Ad> ads = new ArrayList<>();
        while (resultSet.next()){
            ads.add(extractAd(resultSet));
        }
        return ads;
    }
}
