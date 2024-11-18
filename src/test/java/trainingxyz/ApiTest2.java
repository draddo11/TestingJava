package trainingxyz;

import models.Product;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class ApiTest2 {
    @Test
    public void getCategories() {
        String endpoint = "http://localhost:8888/api_testing/category/read.php";
        var response = given().when().get(endpoint).then();
        response.log().body();
    }

    @Test
    public void getProduct() {
        String endpoint ="http://localhost:8888/api_testing/product/read_one.php";
        var response =
                given().
                        queryParam("id", 1007).
                        when().
                        get(endpoint).
                        then().
                        assertThat().statusCode(200);

    }
    @Test
    public void createProduct(){
        String endpoint = "http://localhost:8888/api_testing/product/create.php";
        String body = """
                {
                        "name":"Gucci Sweatband",
                        "description":"Blue cooler cotton sweatband ",
                        "price":5 ,
                        "category_id": 3

                }
                """;
        var response = given().body(body).
                when().post(endpoint).
                then();
        response.log().body();
    }

    @Test
    public void updateProduct(){
        String endpoint = "http://localhost:8888/api_testing/product/update.php";
        String body = """
                      {
                        "id":1007,
                        "price":10
                      }
                       """;
        var response = given().body(body)
                .put(endpoint).then();
        response.log().body();
    }

    @Test
    public void deleteProduct(){
        String endpoint = "http://localhost:8888/api_testing/product/delete.php";
        String body= """
                {
                "id":1007
                }
                """;
        var response = given().body(body).when().delete(endpoint).then();
        response.log().body();
    }

    @Test
    public void createSerializedProduct(){
        String endpoint = "http://localhost:8888/api_testing/product/create.php";
        Product product = new Product(
                "Vodka Bottle",
                "Blue vodka bottle.Holds 2 Ounces",
                56,
                3
        );
        var response = given().body(product).when().delete(endpoint).then();
        response.log().body();
    }
}