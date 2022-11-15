package useCases.searchUseCase;

import java.io.IOException;

public interface SearchInputBoundary {
    SearchResponseModel search(SearchRequestModel requestModel) throws IOException, InterruptedException ;
}
