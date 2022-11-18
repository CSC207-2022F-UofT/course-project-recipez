package useCases;

public class FilterInteractor implements FilterInputBoundary {

    @Override
    public FilterResponseModel create(FilterRequestModel filterInputs) {
        return new FilterResponseModel("http");
    };
}
