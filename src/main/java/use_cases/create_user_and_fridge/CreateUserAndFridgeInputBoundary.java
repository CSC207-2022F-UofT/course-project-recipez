package use_cases.create_user_and_fridge;

/**
 * Interface Create User and Fridge Input Boundary
 */
public interface CreateUserAndFridgeInputBoundary {
      /**
       * @param requestModel takes in a request model
       */
      void create(CreateUserAndFridgeRequestModel requestModel);

}
