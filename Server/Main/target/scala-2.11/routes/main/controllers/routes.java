
// @GENERATOR:play-routes-compiler
// @SOURCE:D:/NUI_4.0/Server/Main/conf/routes
// @DATE:Tue Oct 31 10:27:23 CET 2017

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseTensorFlowController TensorFlowController = new controllers.ReverseTensorFlowController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseHomeController HomeController = new controllers.ReverseHomeController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseTrainingController TrainingController = new controllers.ReverseTrainingController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseAssets Assets = new controllers.ReverseAssets(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseTensorFlowController TensorFlowController = new controllers.javascript.ReverseTensorFlowController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseHomeController HomeController = new controllers.javascript.ReverseHomeController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseTrainingController TrainingController = new controllers.javascript.ReverseTrainingController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseAssets Assets = new controllers.javascript.ReverseAssets(RoutesPrefix.byNamePrefix());
  }

}
