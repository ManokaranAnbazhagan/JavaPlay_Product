package controllers;

import Srevice.ProductService;
import com.google.inject.Inject;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;

import java.io.IOException;
import java.sql.SQLException;


public class ProductController extends Controller {
    @Inject
    private ProductService productService;
    public Result addProduct1(Http.Request request)throws SQLException, IOException{
        productService.addProduct1(request);
        return ok("Add Successfully");
    }

    public Result getByUserId(int user_id) throws SQLException{
        String result = productService.getByUserId(user_id);
        return ok(result);
    }
}
//
//    public final ProductService productService;
//    public final FormFactory dataFrom;
//    @Inject
//    private MysqlConfig mysqlConfig;
//
//    @Inject
//    private Data db;
//    HashMap<Integer, String> productMap = new HashMap<>();
//    public ProductController(ProductService productService, FormFactory dataFrom) {
//        this.productService = productService;
//        this.dataFrom = dataFrom;
//    }
//    public Result getProductInfo() throws SQLException {
//        PreparedStatement statement = mysqlConfig.getConnection().prepareStatement("select * from Product");
//        ResultSet resultSet = statement.executeQuery();
//        HashMap<Integer, String> productMap = new HashMap<>();
//
//        AbstractIterator<Object> resultSetsultSet;
//      //resultSetsultSet  while (resultSetsultSet.next())
//        {
//            int id = resultSet.getInt("id");
//            String name = resultSet.getString("name");
//            int specId = resultSet.getInt("specId");
//            productMap.put(id,name);
//
//        }
//        this.productMap= productMap;
//        return ok((Content) productMap);
//    }
//
//}
