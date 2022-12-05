package presenters.search;

import use_cases.searchusecase.SearchResponseModel;

public interface SearchPresenter {
    void prepareSuccessView(SearchResponseModel searchResponse);

    void prepareFailView(String error);
}
