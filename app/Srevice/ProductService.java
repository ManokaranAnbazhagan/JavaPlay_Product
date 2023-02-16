package Srevice;

import Entity.Product;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import config.MysqlConfig;
import play.libs.Json;
import play.mvc.Http;

import javax.inject.Inject;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class ProductService {
    private HashMap<Long , Product> product = new HashMap<>();
    @Inject
    public MysqlConfig mysqlConfig;

    public void addProduct1(Http.Request request) throws IOException, SQLException {
        JsonNode jsonNode = request.body().asJson();
        int id = jsonNode.get("id").asInt();
        String name = jsonNode.get("name").asText();
        int spec_id = jsonNode.get("spec_id").asInt();
        PreparedStatement preparedStatement = mysqlConfig.getConnection().prepareStatement("insert into product(id, name ,spec_id) values(?,?,?)");
        preparedStatement.setInt(1, id);
        preparedStatement.setString(2, name);
        preparedStatement.setInt(3, spec_id);
        preparedStatement.executeUpdate();
    }

    public String getByUserId(int id) throws SQLException{
        PreparedStatement preparedStatement = mysqlConfig.getConnection().prepareStatement("select * from product where id=?");
        preparedStatement.setInt(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();
        ObjectNode result = Json.newObject();
        while ((resultSet.next())){
            int userid = resultSet.getInt("id");
            String user_name =resultSet.getString("name");
            int spec_id = resultSet.getInt("spec_id");
            result.put("user_id",userid);
            result.put("user_name",user_name);
            result.put("spec_id",spec_id);
        }
        return result.toString();
    }

//    public HashMap<Long, Product> getProduct() {
//        return product;
//    }
//
//    public void setProduct(HashMap<Long, Product> product) {
//        this.product = product;
//    }
}