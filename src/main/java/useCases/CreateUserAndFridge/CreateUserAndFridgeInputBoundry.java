package useCases.CreateUserAndFridge;

import entities.user.CommonUser;

public interface CreateUserAndFridgeInputBoundry {

   CommonUser create(CreateUserandFridgeRequestModel requestModel);

}
