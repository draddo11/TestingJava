package trainingxyz;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class ApiTest {

    @Test
    public void getCategories() {
        String endpoint = "http://localhost:8888/api_testing/category/read.php";
        var response = given().when().get(endpoint).then();
        response.log().body();
    }

    @Test
    public void getProduct() {
        String endpoint = "http://localhost:8888/api_testing/category/read_one.php";
        var response =
                given().
                        queryParam("id", 2).
                        when().
                        get(endpoint)
                        .then();
        response.log().body();
        }
    @Test
    public void createProduct(){
        String endpoint = "http://localhost:8888/api_testing/product/read_one.php";
        String body = """
                {
                        "name":" Vodka Bottle ",
                        "description":"Blue vodka bottle.Holds 2 Ounces"
                        "category_id": 3

                }
                """;
        var response = given().body(body).
                        when().post(endpoint).
                        then();
        response.log().body();
    }
}

