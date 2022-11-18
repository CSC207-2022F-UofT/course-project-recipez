package gateways;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test Cases for the APICaller class
 */
public class JavaHttpGatewayTest {
    /**
     * Test for Recipe Search API call with ingredient list only
     */
    @Test
    public void UnfilteredAPICall() {
        String ingredients = "medium eggplant, green lentils, red pepper, onion, garlic, cumin powder, coriander powder, curry powder, rolled oats, olive oil";
        String expected = "{\"from\":1,\"to\":1,\"count\":1,\"_links\":{},\"hits\":[{\"recipe\":{\"label\":\"Eggplant & Lentil Fritters\",\"image\":\"https://edamam-product-images.s3.amazonaws.com/web-img/e59/e592b71f2af6b1e5cb0b784ae9919e3a.jpg?X-Amz-Security-Token=IQoJb3JpZ2luX2VjEEUaCXVzLWVhc3QtMSJIMEYCIQCITIAxzYzNooqinbPMORXVfN6g%2FWm%2Feo8dsZVfQ4MS9QIhAIRZNIYqOjw8d%2BVptKwn46fA2uwAlJc7rWDVn0oB1aJ4KswECE4QABoMMTg3MDE3MTUwOTg2IgzIoW95NGh%2FD5flCT8qqQQ0MN9tt6JMFuaMtB30aSdx4GZQQ4MfEHx38OMUvRmqSOREiArmsYFJDtNbiOO9MN9IpoJ6adwaSJn4iOgnOkhMEJTMwOkpBEWQ5P0HYq0eGdGJOX5aKJt%2Br0eOY%2FZfSIERwqNJ11U9nc1qMl2z9mkyC%2Bs8ZSflGRQ6VX3LW7%2BJpfVxZEXIj6e7MqKVWXbqKxbdnqyCOdkeM%2BjzLzOkZMdzZA9VcqdfX6kKb%2BEqXPEXHePgWDuhniOYAhYVo5vX9vdS0QHHclCpU5rVS48n3p25Y46G%2B%2BGgbBvUXZMXdIwEji0VwsX1l6jgs9%2FawkeJi8wWYImRvVPEwk%2FkWlfCcWx6zESb%2FoFp8cHRpeJpkIqoP2ay3jHRuNAKzxDyOnBkr%2F%2BA6uOSVTtK74F1G31zMRF5hxbh2VmSuJACi5t9njNmsxgt%2FbpWL0usQiETrzbzNgkaLA09G8T%2FfjU2kWuvzCPEPi4AjqLh7OXKAIHWNQV38wWFX2Aoyk5r3RkwLcvonTdcuzXIYIFq4NyJ4TuqOVFuOM%2FfnMK%2BFoVX4Bh2G2EUU8VlDmIBrLQDhzpfqo0jT0KRq%2BkOxfrqJe3ze2VsPkRg2bY451jCs8AxxC3v9XXWkL4C%2FeB6G67cFJQ7dSdeOFZyCvOvzBwU3z7TwAj43PQZQShwvO53XlJ%2FPTST1uUS%2BpY4nhNaCHTSlUmxZz6r1%2FMrueAnXNCwMyY0bx73E4F%2FAcu3HC3KG991MO3h35sGOqgBXSRemY2hDLW%2B75tIQfq51BXo0oUrj0AnEqSIGN57nRpvwlpYybYi2lYt6Uox61ZG2hhHQstIllSAvdFyKAEO6xKCNbW%2BHQnBnLXpOKfNFO7H1znai9XNEKh%2Bxu6s0gtJ3dHc7lVzZjtEjKeCd6R3agTpdLuJ%2BO0v7wmo4RI0acv8nzxOoOtLae2GRA7mMsuBEkD10OWjwjibnzg2GpqL3L0hYreFqHiv&X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Date=20221118T222512Z&X-Amz-SignedHeaders=host&X-Amz-Expires=3600&X-Amz-Credential=ASIASXCYXIIFJTAMKNCQ%2F20221118%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Signature=2d10b265136b8ee1c4bf47b702eca5e6468538852131e8c6e97f1dcb1c47365e\",\"url\":\"http://honestcooking.com/eggplant-lentil-fritters-recipe/\",\"yield\":4.0,\"ingredientLines\":[\"1 medium eggplant\",\"1 cup green lentils, boiled (with liquid removed)\",\"\u00BD cup red pepper, finely chopped\",\"\u00BD onion, finely chopped\",\"2 cloves of garlic, crushed\",\"1 teaspoon cumin powder\",\"1 tablespoon coriander powder\",\"\u00BD teaspoon curry powder\",\"4 tablespoons rolled oats\",\"2 tablespoons olive oil\",\"Salt & chili to taste\"],\"calories\":1208.7799999987456,\"totalWeight\":943.6359275191397,\"totalTime\":30.0},\"_links\":{\"self\":{\"title\":\"Self\",\"href\":\"https://api.edamam.com/api/recipes/v2/52c6d915f3486d9b091d0a1f883751a1?type=public&app_id=c863d4be&app_key=9c705fc2c472f935f32ea2e2c1494311\"}}}]}";
        JavaHttpGateway httpGateway = new JavaHttpGateway();
        String response = httpGateway.send(ingredients);
        Assertions.assertTrue(response.contains("Eggplant & Lentil Fritters"));
    }
}
