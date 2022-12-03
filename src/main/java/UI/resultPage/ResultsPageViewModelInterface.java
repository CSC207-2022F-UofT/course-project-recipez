package UI.resultPage;

import java.util.ArrayList;
import java.util.Dictionary;

/**
 * View Model Interface for Results Page
 */

public interface ResultsPageViewModelInterface {
    void resultsSuccess(ArrayList<Dictionary<String, Object>> recipes);
    void resultsFailure(String errorMessage);
}

