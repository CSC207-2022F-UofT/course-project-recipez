package presenters.search;

import use_cases.searchusecase.SearchResponseModel;

public interface SearchPresenter {
    SearchResponseModel prepareSuccessView(SearchResponseModel searchResponse);

    SearchResponseModel prepareFailView(String error);
}
