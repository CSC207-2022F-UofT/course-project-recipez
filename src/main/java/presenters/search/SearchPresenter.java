package presenters.search;

import use_cases.searchUseCase.SearchResponseModel;

public interface SearchPresenter {
    SearchResponseModel prepareSuccessView(SearchResponseModel searchResponse);

    SearchResponseModel prepareFailView(String error);
}
