package controllers;

import Srevice.EsProductService;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;

import javax.inject.Inject;
import java.awt.*;
import java.io.IOException;

public class EsProductController extends Controller {

    @Inject
    private EsProductService esProductService;


    public Result getProductById(String id) throws IOException {
        String result = esProductService.getByProductId(id);
        return ok(result);
    }

    public Result getBySpecId(String specId) throws IOException {
        String result = esProductService.getBySpecId(specId);
        return ok(result);
    }

    public Result addProduct(Http.Request request) throws IOException {
        esProductService.addProduct(request);
        return ok("ProductData Added Successfully");

    }
}
