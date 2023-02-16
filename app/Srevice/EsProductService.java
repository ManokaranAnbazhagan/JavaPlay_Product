package Srevice;

import com.fasterxml.jackson.databind.JsonNode;
import config.Connection;
import org.apache.http.protocol.HTTP;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import play.mvc.Http;

import javax.inject.Inject;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class EsProductService {
    @Inject
    private Connection connection;

    public void addProduct(Http.Request request) throws IOException {
        JsonNode body = request.body().asJson();
        String id = body.get("id").asText();
        String name = body.get("name").asText();
        String description = body.get("description").asText();
        String specId = body.get("specId").asText();
        String specName = body.get("specName").asText();
        String specValue = body.get("specValue").asText();

        Map<String, Object> productMap = new HashMap<>();
        productMap.put("id", id);
        productMap.put("name", name);
        productMap.put("description", description);

        Map<String, Object> specMap = new HashMap<>();
        specMap.put("specId", specId);
        specMap.put("specName", specName);
        specMap.put("specValue", specValue);

        IndexRequest indexRequest = new IndexRequest("product", "_doc", id).source(productMap);
        IndexRequest indexRequest0 = new IndexRequest("specification", "_doc", specId).source(specMap);

        IndexResponse indexResponse = connection.getRestHighLevelClient().index(indexRequest, RequestOptions.DEFAULT);
        IndexResponse indexResponse0 = connection.getRestHighLevelClient().index(indexRequest0, RequestOptions.DEFAULT);


    }

    public String getByProductId(String id) throws IOException {
        GetRequest request = new GetRequest("product", "_doc", id);
        GetResponse response = connection.getRestHighLevelClient().get(request, RequestOptions.DEFAULT);
        String result = response.getSourceAsString();
        return result;
    }

    public String getBySpecId(String specId) throws IOException {
        GetRequest request = new GetRequest("specification", "_doc", specId);
        GetResponse response = connection.getRestHighLevelClient().get(request, RequestOptions.DEFAULT);
        String result = response.getSourceAsString();
        return result;

    }
}
