package entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test Cases for the RequestURLUtilsTest class
 */
public class RequestURLFactoryTest {
    /**
     * Test for creating API access URL with ingredient list only
     */
    @Test
    public void createUnfilteredSearchURL() {
        RequestURLFactory requestURLFactory = new RequestURLFactory();
        String ingredients = "medium eggplant, green lentils, red pepper, onion, garlic, cumin powder, coriander powder, curry powder, rolled oats, olive oil";
        String expected = "https://api.edamam.com/api/recipes/v2?type=any&q=medium%20eggplant%2C%20green%20lentils%2C%20red%20pepper%2C%20onion%2C%20garlic%2C%20cumin%20powder%2C%20coriander%20powder%2C%20curry%20powder%2C%20rolled%20oats%2C%20olive%20oil&app_id=c863d4be&app_key=9c705fc2c472f935f32ea2e2c1494311&field=label&field=url&field=yield&field=ingredientLines&field=calories&field=totalWeight&field=totalTime";
        Assertions.assertEquals(
                expected,
                requestURLFactory.createRequestURL(ingredients).getUrl()
        );
    }
}
