package use_cases.searchUseCase;

/**
 * SearchInputBoundary interface
 */
public interface SearchInputBoundary {
    SearchResponseModel search(SearchRequestModel requestModel);
}
