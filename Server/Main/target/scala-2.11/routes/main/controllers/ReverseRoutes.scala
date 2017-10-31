
// @GENERATOR:play-routes-compiler
// @SOURCE:D:/NUI_4.0/Server/Main/conf/routes
// @DATE:Tue Oct 31 10:27:23 CET 2017

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:5
package controllers {

  // @LINE:43
  class ReverseTensorFlowController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:45
    def TensorFlowPreferencesPOST(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "TensorFlowPreferences")
    }
  
    // @LINE:43
    def TensorFlowMain(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "TensorFlowControl")
    }
  
    // @LINE:44
    def TensorFlowPreferences(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "TensorFlowPreferences")
    }
  
    // @LINE:46
    def TensorFlowConnect(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "TensorFlowConnect")
    }
  
    // @LINE:49
    def startTracking(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "TensorFlowStartTracking")
    }
  
    // @LINE:48
    def startTraining(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "TensorFlowStartTraining")
    }
  
    // @LINE:47
    def TensorFlowTestSet(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "TensorFlowTestSet")
    }
  
  }

  // @LINE:5
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:26
    def ShowUsers(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "ShowUsers")
    }
  
    // @LINE:33
    def ShowGesture(ID:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "ShowGesture/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("ID", ID)))
    }
  
    // @LINE:27
    def StartAddingAUser(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "AddingUser")
    }
  
    // @LINE:32
    def StartAddingAGesture(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "AddingGesture")
    }
  
    // @LINE:39
    def getJsonDeviceList(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "GetJsonDeviceList")
    }
  
    // @LINE:38
    def ShowDevice(ID:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "ShowDevice/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("ID", ID)))
    }
  
    // @LINE:29
    def getJsonUserList(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "GetJsonUserList")
    }
  
    // @LINE:37
    def StartAddingADevice(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "AddingDevice")
    }
  
    // @LINE:6
    def ws(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "ws")
    }
  
    // @LINE:36
    def ShowDevices(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "ShowDevices")
    }
  
    // @LINE:28
    def ShowUser(ID:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "ShowUser/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("ID", ID)))
    }
  
    // @LINE:31
    def ShowGestures(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "ShowGestures")
    }
  
    // @LINE:5
    def index(): Call = {
      
      Call("GET", _prefix)
    }
  
    // @LINE:34
    def getJsonGestureList(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "GetJsonGestureList")
    }
  
  }

  // @LINE:9
  class ReverseTrainingController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:16
    def ExportAllTrainingData(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "ExportAllTrainingData")
    }
  
    // @LINE:11
    def stopTraining(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "stopTraining")
    }
  
    // @LINE:17
    def ExportTrainingDataForUser(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "ExportTrainingDataForUser/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:22
    def ShowUserAggregateTrainingData(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "ShowUserAggregateTrainingData")
    }
  
    // @LINE:20
    def ShowSingleTrainingFrame(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "ShowSingleTrainingFrame/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:10
    def startTraining(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "startTraining")
    }
  
    // @LINE:21
    def ShowSessionAggregateTrainingData(id:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "ShowTrainingSession/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:15
    def ExportOptions(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "ShowExportOptions")
    }
  
    // @LINE:12
    def deleteTrainingData(UUID:java.util.UUID): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "deleteTrainingData/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[java.util.UUID]].unbind("UUID", UUID)))
    }
  
    // @LINE:9
    def Training(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "training")
    }
  
  }

  // @LINE:52
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:52
    def versioned(file:Asset): Call = {
      implicit val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public")))
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }


}
