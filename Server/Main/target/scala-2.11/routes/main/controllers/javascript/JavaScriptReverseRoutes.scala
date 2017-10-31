
// @GENERATOR:play-routes-compiler
// @SOURCE:D:/NUI_4.0/Server/Main/conf/routes
// @DATE:Tue Oct 31 10:27:23 CET 2017

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:5
package controllers.javascript {

  // @LINE:43
  class ReverseTensorFlowController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:45
    def TensorFlowPreferencesPOST: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TensorFlowController.TensorFlowPreferencesPOST",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "TensorFlowPreferences"})
        }
      """
    )
  
    // @LINE:43
    def TensorFlowMain: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TensorFlowController.TensorFlowMain",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "TensorFlowControl"})
        }
      """
    )
  
    // @LINE:44
    def TensorFlowPreferences: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TensorFlowController.TensorFlowPreferences",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "TensorFlowPreferences"})
        }
      """
    )
  
    // @LINE:46
    def TensorFlowConnect: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TensorFlowController.TensorFlowConnect",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "TensorFlowConnect"})
        }
      """
    )
  
    // @LINE:49
    def startTracking: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TensorFlowController.startTracking",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "TensorFlowStartTracking"})
        }
      """
    )
  
    // @LINE:48
    def startTraining: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TensorFlowController.startTraining",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "TensorFlowStartTraining"})
        }
      """
    )
  
    // @LINE:47
    def TensorFlowTestSet: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TensorFlowController.TensorFlowTestSet",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "TensorFlowTestSet"})
        }
      """
    )
  
  }

  // @LINE:5
  class ReverseHomeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:26
    def ShowUsers: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.ShowUsers",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ShowUsers"})
        }
      """
    )
  
    // @LINE:33
    def ShowGesture: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.ShowGesture",
      """
        function(ID0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ShowGesture/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("ID", ID0))})
        }
      """
    )
  
    // @LINE:27
    def StartAddingAUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.StartAddingAUser",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "AddingUser"})
        }
      """
    )
  
    // @LINE:32
    def StartAddingAGesture: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.StartAddingAGesture",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "AddingGesture"})
        }
      """
    )
  
    // @LINE:39
    def getJsonDeviceList: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.getJsonDeviceList",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "GetJsonDeviceList"})
        }
      """
    )
  
    // @LINE:38
    def ShowDevice: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.ShowDevice",
      """
        function(ID0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ShowDevice/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("ID", ID0))})
        }
      """
    )
  
    // @LINE:29
    def getJsonUserList: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.getJsonUserList",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "GetJsonUserList"})
        }
      """
    )
  
    // @LINE:37
    def StartAddingADevice: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.StartAddingADevice",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "AddingDevice"})
        }
      """
    )
  
    // @LINE:6
    def ws: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.ws",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ws"})
        }
      """
    )
  
    // @LINE:36
    def ShowDevices: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.ShowDevices",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ShowDevices"})
        }
      """
    )
  
    // @LINE:28
    def ShowUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.ShowUser",
      """
        function(ID0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ShowUser/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("ID", ID0))})
        }
      """
    )
  
    // @LINE:31
    def ShowGestures: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.ShowGestures",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ShowGestures"})
        }
      """
    )
  
    // @LINE:5
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
    // @LINE:34
    def getJsonGestureList: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.getJsonGestureList",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "GetJsonGestureList"})
        }
      """
    )
  
  }

  // @LINE:9
  class ReverseTrainingController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:16
    def ExportAllTrainingData: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TrainingController.ExportAllTrainingData",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ExportAllTrainingData"})
        }
      """
    )
  
    // @LINE:11
    def stopTraining: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TrainingController.stopTraining",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "stopTraining"})
        }
      """
    )
  
    // @LINE:17
    def ExportTrainingDataForUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TrainingController.ExportTrainingDataForUser",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ExportTrainingDataForUser/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:22
    def ShowUserAggregateTrainingData: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TrainingController.ShowUserAggregateTrainingData",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ShowUserAggregateTrainingData"})
        }
      """
    )
  
    // @LINE:20
    def ShowSingleTrainingFrame: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TrainingController.ShowSingleTrainingFrame",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ShowSingleTrainingFrame/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:10
    def startTraining: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TrainingController.startTraining",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "startTraining"})
        }
      """
    )
  
    // @LINE:21
    def ShowSessionAggregateTrainingData: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TrainingController.ShowSessionAggregateTrainingData",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ShowTrainingSession/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:15
    def ExportOptions: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TrainingController.ExportOptions",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ShowExportOptions"})
        }
      """
    )
  
    // @LINE:12
    def deleteTrainingData: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TrainingController.deleteTrainingData",
      """
        function(UUID0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteTrainingData/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[java.util.UUID]].javascriptUnbind + """)("UUID", UUID0))})
        }
      """
    )
  
    // @LINE:9
    def Training: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TrainingController.Training",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "training"})
        }
      """
    )
  
  }

  // @LINE:52
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:52
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }


}
