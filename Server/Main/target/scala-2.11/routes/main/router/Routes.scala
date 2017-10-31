
// @GENERATOR:play-routes-compiler
// @SOURCE:D:/NUI_4.0/Server/Main/conf/routes
// @DATE:Tue Oct 31 10:27:23 CET 2017

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:5
  HomeController_1: controllers.HomeController,
  // @LINE:9
  TrainingController_0: controllers.TrainingController,
  // @LINE:43
  TensorFlowController_3: controllers.TensorFlowController,
  // @LINE:52
  Assets_2: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:5
    HomeController_1: controllers.HomeController,
    // @LINE:9
    TrainingController_0: controllers.TrainingController,
    // @LINE:43
    TensorFlowController_3: controllers.TensorFlowController,
    // @LINE:52
    Assets_2: controllers.Assets
  ) = this(errorHandler, HomeController_1, TrainingController_0, TensorFlowController_3, Assets_2, "/")

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_1, TrainingController_0, TensorFlowController_3, Assets_2, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.HomeController.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ws""", """controllers.HomeController.ws"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """training""", """controllers.TrainingController.Training"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """startTraining""", """controllers.TrainingController.startTraining"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """stopTraining""", """controllers.TrainingController.stopTraining"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """deleteTrainingData/""" + "$" + """UUID<[^/]+>""", """controllers.TrainingController.deleteTrainingData(UUID:java.util.UUID)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ShowExportOptions""", """controllers.TrainingController.ExportOptions"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ExportAllTrainingData""", """controllers.TrainingController.ExportAllTrainingData"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ExportTrainingDataForUser/""" + "$" + """id<[^/]+>""", """controllers.TrainingController.ExportTrainingDataForUser(id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ShowSingleTrainingFrame/""" + "$" + """id<[^/]+>""", """controllers.TrainingController.ShowSingleTrainingFrame(id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ShowTrainingSession/""" + "$" + """id<[^/]+>""", """controllers.TrainingController.ShowSessionAggregateTrainingData(id:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ShowUserAggregateTrainingData""", """controllers.TrainingController.ShowUserAggregateTrainingData"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ShowUsers""", """controllers.HomeController.ShowUsers"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """AddingUser""", """controllers.HomeController.StartAddingAUser"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ShowUser/""" + "$" + """ID<[^/]+>""", """controllers.HomeController.ShowUser(ID:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """GetJsonUserList""", """controllers.HomeController.getJsonUserList"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ShowGestures""", """controllers.HomeController.ShowGestures"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """AddingGesture""", """controllers.HomeController.StartAddingAGesture"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ShowGesture/""" + "$" + """ID<[^/]+>""", """controllers.HomeController.ShowGesture(ID:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """GetJsonGestureList""", """controllers.HomeController.getJsonGestureList"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ShowDevices""", """controllers.HomeController.ShowDevices"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """AddingDevice""", """controllers.HomeController.StartAddingADevice"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ShowDevice/""" + "$" + """ID<[^/]+>""", """controllers.HomeController.ShowDevice(ID:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """GetJsonDeviceList""", """controllers.HomeController.getJsonDeviceList"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """TensorFlowControl""", """controllers.TensorFlowController.TensorFlowMain"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """TensorFlowPreferences""", """controllers.TensorFlowController.TensorFlowPreferences"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """TensorFlowPreferences""", """controllers.TensorFlowController.TensorFlowPreferencesPOST"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """TensorFlowConnect""", """controllers.TensorFlowController.TensorFlowConnect"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """TensorFlowTestSet""", """controllers.TensorFlowController.TensorFlowTestSet"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """TensorFlowStartTraining""", """controllers.TensorFlowController.startTraining"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """TensorFlowStartTracking""", """controllers.TensorFlowController.startTracking"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:5
  private[this] lazy val controllers_HomeController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_HomeController_index0_invoker = createInvoker(
    HomeController_1.index,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "index",
      Nil,
      "GET",
      this.prefix + """""",
      """""",
      Seq()
    )
  )

  // @LINE:6
  private[this] lazy val controllers_HomeController_ws1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ws")))
  )
  private[this] lazy val controllers_HomeController_ws1_invoker = createInvoker(
    HomeController_1.ws,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "ws",
      Nil,
      "GET",
      this.prefix + """ws""",
      """""",
      Seq()
    )
  )

  // @LINE:9
  private[this] lazy val controllers_TrainingController_Training2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("training")))
  )
  private[this] lazy val controllers_TrainingController_Training2_invoker = createInvoker(
    TrainingController_0.Training,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TrainingController",
      "Training",
      Nil,
      "GET",
      this.prefix + """training""",
      """ training related""",
      Seq()
    )
  )

  // @LINE:10
  private[this] lazy val controllers_TrainingController_startTraining3_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("startTraining")))
  )
  private[this] lazy val controllers_TrainingController_startTraining3_invoker = createInvoker(
    TrainingController_0.startTraining,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TrainingController",
      "startTraining",
      Nil,
      "POST",
      this.prefix + """startTraining""",
      """""",
      Seq()
    )
  )

  // @LINE:11
  private[this] lazy val controllers_TrainingController_stopTraining4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("stopTraining")))
  )
  private[this] lazy val controllers_TrainingController_stopTraining4_invoker = createInvoker(
    TrainingController_0.stopTraining,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TrainingController",
      "stopTraining",
      Nil,
      "GET",
      this.prefix + """stopTraining""",
      """""",
      Seq()
    )
  )

  // @LINE:12
  private[this] lazy val controllers_TrainingController_deleteTrainingData5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deleteTrainingData/"), DynamicPart("UUID", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TrainingController_deleteTrainingData5_invoker = createInvoker(
    TrainingController_0.deleteTrainingData(fakeValue[java.util.UUID]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TrainingController",
      "deleteTrainingData",
      Seq(classOf[java.util.UUID]),
      "GET",
      this.prefix + """deleteTrainingData/""" + "$" + """UUID<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:15
  private[this] lazy val controllers_TrainingController_ExportOptions6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ShowExportOptions")))
  )
  private[this] lazy val controllers_TrainingController_ExportOptions6_invoker = createInvoker(
    TrainingController_0.ExportOptions,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TrainingController",
      "ExportOptions",
      Nil,
      "GET",
      this.prefix + """ShowExportOptions""",
      """ Data Export""",
      Seq()
    )
  )

  // @LINE:16
  private[this] lazy val controllers_TrainingController_ExportAllTrainingData7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ExportAllTrainingData")))
  )
  private[this] lazy val controllers_TrainingController_ExportAllTrainingData7_invoker = createInvoker(
    TrainingController_0.ExportAllTrainingData,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TrainingController",
      "ExportAllTrainingData",
      Nil,
      "GET",
      this.prefix + """ExportAllTrainingData""",
      """""",
      Seq()
    )
  )

  // @LINE:17
  private[this] lazy val controllers_TrainingController_ExportTrainingDataForUser8_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ExportTrainingDataForUser/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TrainingController_ExportTrainingDataForUser8_invoker = createInvoker(
    TrainingController_0.ExportTrainingDataForUser(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TrainingController",
      "ExportTrainingDataForUser",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """ExportTrainingDataForUser/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:20
  private[this] lazy val controllers_TrainingController_ShowSingleTrainingFrame9_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ShowSingleTrainingFrame/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TrainingController_ShowSingleTrainingFrame9_invoker = createInvoker(
    TrainingController_0.ShowSingleTrainingFrame(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TrainingController",
      "ShowSingleTrainingFrame",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """ShowSingleTrainingFrame/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:21
  private[this] lazy val controllers_TrainingController_ShowSessionAggregateTrainingData10_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ShowTrainingSession/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TrainingController_ShowSessionAggregateTrainingData10_invoker = createInvoker(
    TrainingController_0.ShowSessionAggregateTrainingData(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TrainingController",
      "ShowSessionAggregateTrainingData",
      Seq(classOf[String]),
      "GET",
      this.prefix + """ShowTrainingSession/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:22
  private[this] lazy val controllers_TrainingController_ShowUserAggregateTrainingData11_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ShowUserAggregateTrainingData")))
  )
  private[this] lazy val controllers_TrainingController_ShowUserAggregateTrainingData11_invoker = createInvoker(
    TrainingController_0.ShowUserAggregateTrainingData,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TrainingController",
      "ShowUserAggregateTrainingData",
      Nil,
      "GET",
      this.prefix + """ShowUserAggregateTrainingData""",
      """""",
      Seq()
    )
  )

  // @LINE:26
  private[this] lazy val controllers_HomeController_ShowUsers12_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ShowUsers")))
  )
  private[this] lazy val controllers_HomeController_ShowUsers12_invoker = createInvoker(
    HomeController_1.ShowUsers,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "ShowUsers",
      Nil,
      "GET",
      this.prefix + """ShowUsers""",
      """ User related""",
      Seq()
    )
  )

  // @LINE:27
  private[this] lazy val controllers_HomeController_StartAddingAUser13_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("AddingUser")))
  )
  private[this] lazy val controllers_HomeController_StartAddingAUser13_invoker = createInvoker(
    HomeController_1.StartAddingAUser,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "StartAddingAUser",
      Nil,
      "GET",
      this.prefix + """AddingUser""",
      """""",
      Seq()
    )
  )

  // @LINE:28
  private[this] lazy val controllers_HomeController_ShowUser14_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ShowUser/"), DynamicPart("ID", """[^/]+""",true)))
  )
  private[this] lazy val controllers_HomeController_ShowUser14_invoker = createInvoker(
    HomeController_1.ShowUser(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "ShowUser",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """ShowUser/""" + "$" + """ID<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:29
  private[this] lazy val controllers_HomeController_getJsonUserList15_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("GetJsonUserList")))
  )
  private[this] lazy val controllers_HomeController_getJsonUserList15_invoker = createInvoker(
    HomeController_1.getJsonUserList,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "getJsonUserList",
      Nil,
      "GET",
      this.prefix + """GetJsonUserList""",
      """""",
      Seq()
    )
  )

  // @LINE:31
  private[this] lazy val controllers_HomeController_ShowGestures16_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ShowGestures")))
  )
  private[this] lazy val controllers_HomeController_ShowGestures16_invoker = createInvoker(
    HomeController_1.ShowGestures,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "ShowGestures",
      Nil,
      "GET",
      this.prefix + """ShowGestures""",
      """ Gesture related""",
      Seq()
    )
  )

  // @LINE:32
  private[this] lazy val controllers_HomeController_StartAddingAGesture17_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("AddingGesture")))
  )
  private[this] lazy val controllers_HomeController_StartAddingAGesture17_invoker = createInvoker(
    HomeController_1.StartAddingAGesture,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "StartAddingAGesture",
      Nil,
      "GET",
      this.prefix + """AddingGesture""",
      """""",
      Seq()
    )
  )

  // @LINE:33
  private[this] lazy val controllers_HomeController_ShowGesture18_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ShowGesture/"), DynamicPart("ID", """[^/]+""",true)))
  )
  private[this] lazy val controllers_HomeController_ShowGesture18_invoker = createInvoker(
    HomeController_1.ShowGesture(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "ShowGesture",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """ShowGesture/""" + "$" + """ID<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:34
  private[this] lazy val controllers_HomeController_getJsonGestureList19_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("GetJsonGestureList")))
  )
  private[this] lazy val controllers_HomeController_getJsonGestureList19_invoker = createInvoker(
    HomeController_1.getJsonGestureList,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "getJsonGestureList",
      Nil,
      "GET",
      this.prefix + """GetJsonGestureList""",
      """""",
      Seq()
    )
  )

  // @LINE:36
  private[this] lazy val controllers_HomeController_ShowDevices20_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ShowDevices")))
  )
  private[this] lazy val controllers_HomeController_ShowDevices20_invoker = createInvoker(
    HomeController_1.ShowDevices,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "ShowDevices",
      Nil,
      "GET",
      this.prefix + """ShowDevices""",
      """ Device related""",
      Seq()
    )
  )

  // @LINE:37
  private[this] lazy val controllers_HomeController_StartAddingADevice21_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("AddingDevice")))
  )
  private[this] lazy val controllers_HomeController_StartAddingADevice21_invoker = createInvoker(
    HomeController_1.StartAddingADevice,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "StartAddingADevice",
      Nil,
      "GET",
      this.prefix + """AddingDevice""",
      """""",
      Seq()
    )
  )

  // @LINE:38
  private[this] lazy val controllers_HomeController_ShowDevice22_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ShowDevice/"), DynamicPart("ID", """[^/]+""",true)))
  )
  private[this] lazy val controllers_HomeController_ShowDevice22_invoker = createInvoker(
    HomeController_1.ShowDevice(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "ShowDevice",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """ShowDevice/""" + "$" + """ID<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:39
  private[this] lazy val controllers_HomeController_getJsonDeviceList23_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("GetJsonDeviceList")))
  )
  private[this] lazy val controllers_HomeController_getJsonDeviceList23_invoker = createInvoker(
    HomeController_1.getJsonDeviceList,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "getJsonDeviceList",
      Nil,
      "GET",
      this.prefix + """GetJsonDeviceList""",
      """""",
      Seq()
    )
  )

  // @LINE:43
  private[this] lazy val controllers_TensorFlowController_TensorFlowMain24_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("TensorFlowControl")))
  )
  private[this] lazy val controllers_TensorFlowController_TensorFlowMain24_invoker = createInvoker(
    TensorFlowController_3.TensorFlowMain,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TensorFlowController",
      "TensorFlowMain",
      Nil,
      "GET",
      this.prefix + """TensorFlowControl""",
      """ TensorFlow related""",
      Seq()
    )
  )

  // @LINE:44
  private[this] lazy val controllers_TensorFlowController_TensorFlowPreferences25_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("TensorFlowPreferences")))
  )
  private[this] lazy val controllers_TensorFlowController_TensorFlowPreferences25_invoker = createInvoker(
    TensorFlowController_3.TensorFlowPreferences,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TensorFlowController",
      "TensorFlowPreferences",
      Nil,
      "GET",
      this.prefix + """TensorFlowPreferences""",
      """""",
      Seq()
    )
  )

  // @LINE:45
  private[this] lazy val controllers_TensorFlowController_TensorFlowPreferencesPOST26_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("TensorFlowPreferences")))
  )
  private[this] lazy val controllers_TensorFlowController_TensorFlowPreferencesPOST26_invoker = createInvoker(
    TensorFlowController_3.TensorFlowPreferencesPOST,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TensorFlowController",
      "TensorFlowPreferencesPOST",
      Nil,
      "POST",
      this.prefix + """TensorFlowPreferences""",
      """""",
      Seq()
    )
  )

  // @LINE:46
  private[this] lazy val controllers_TensorFlowController_TensorFlowConnect27_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("TensorFlowConnect")))
  )
  private[this] lazy val controllers_TensorFlowController_TensorFlowConnect27_invoker = createInvoker(
    TensorFlowController_3.TensorFlowConnect,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TensorFlowController",
      "TensorFlowConnect",
      Nil,
      "GET",
      this.prefix + """TensorFlowConnect""",
      """""",
      Seq()
    )
  )

  // @LINE:47
  private[this] lazy val controllers_TensorFlowController_TensorFlowTestSet28_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("TensorFlowTestSet")))
  )
  private[this] lazy val controllers_TensorFlowController_TensorFlowTestSet28_invoker = createInvoker(
    TensorFlowController_3.TensorFlowTestSet,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TensorFlowController",
      "TensorFlowTestSet",
      Nil,
      "GET",
      this.prefix + """TensorFlowTestSet""",
      """""",
      Seq()
    )
  )

  // @LINE:48
  private[this] lazy val controllers_TensorFlowController_startTraining29_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("TensorFlowStartTraining")))
  )
  private[this] lazy val controllers_TensorFlowController_startTraining29_invoker = createInvoker(
    TensorFlowController_3.startTraining,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TensorFlowController",
      "startTraining",
      Nil,
      "GET",
      this.prefix + """TensorFlowStartTraining""",
      """""",
      Seq()
    )
  )

  // @LINE:49
  private[this] lazy val controllers_TensorFlowController_startTracking30_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("TensorFlowStartTracking")))
  )
  private[this] lazy val controllers_TensorFlowController_startTracking30_invoker = createInvoker(
    TensorFlowController_3.startTracking,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TensorFlowController",
      "startTracking",
      Nil,
      "GET",
      this.prefix + """TensorFlowStartTracking""",
      """""",
      Seq()
    )
  )

  // @LINE:52
  private[this] lazy val controllers_Assets_versioned31_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned31_invoker = createInvoker(
    Assets_2.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:5
    case controllers_HomeController_index0_route(params) =>
      call { 
        controllers_HomeController_index0_invoker.call(HomeController_1.index)
      }
  
    // @LINE:6
    case controllers_HomeController_ws1_route(params) =>
      call { 
        controllers_HomeController_ws1_invoker.call(HomeController_1.ws)
      }
  
    // @LINE:9
    case controllers_TrainingController_Training2_route(params) =>
      call { 
        controllers_TrainingController_Training2_invoker.call(TrainingController_0.Training)
      }
  
    // @LINE:10
    case controllers_TrainingController_startTraining3_route(params) =>
      call { 
        controllers_TrainingController_startTraining3_invoker.call(TrainingController_0.startTraining)
      }
  
    // @LINE:11
    case controllers_TrainingController_stopTraining4_route(params) =>
      call { 
        controllers_TrainingController_stopTraining4_invoker.call(TrainingController_0.stopTraining)
      }
  
    // @LINE:12
    case controllers_TrainingController_deleteTrainingData5_route(params) =>
      call(params.fromPath[java.util.UUID]("UUID", None)) { (UUID) =>
        controllers_TrainingController_deleteTrainingData5_invoker.call(TrainingController_0.deleteTrainingData(UUID))
      }
  
    // @LINE:15
    case controllers_TrainingController_ExportOptions6_route(params) =>
      call { 
        controllers_TrainingController_ExportOptions6_invoker.call(TrainingController_0.ExportOptions)
      }
  
    // @LINE:16
    case controllers_TrainingController_ExportAllTrainingData7_route(params) =>
      call { 
        controllers_TrainingController_ExportAllTrainingData7_invoker.call(TrainingController_0.ExportAllTrainingData)
      }
  
    // @LINE:17
    case controllers_TrainingController_ExportTrainingDataForUser8_route(params) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_TrainingController_ExportTrainingDataForUser8_invoker.call(TrainingController_0.ExportTrainingDataForUser(id))
      }
  
    // @LINE:20
    case controllers_TrainingController_ShowSingleTrainingFrame9_route(params) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_TrainingController_ShowSingleTrainingFrame9_invoker.call(TrainingController_0.ShowSingleTrainingFrame(id))
      }
  
    // @LINE:21
    case controllers_TrainingController_ShowSessionAggregateTrainingData10_route(params) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_TrainingController_ShowSessionAggregateTrainingData10_invoker.call(TrainingController_0.ShowSessionAggregateTrainingData(id))
      }
  
    // @LINE:22
    case controllers_TrainingController_ShowUserAggregateTrainingData11_route(params) =>
      call { 
        controllers_TrainingController_ShowUserAggregateTrainingData11_invoker.call(TrainingController_0.ShowUserAggregateTrainingData)
      }
  
    // @LINE:26
    case controllers_HomeController_ShowUsers12_route(params) =>
      call { 
        controllers_HomeController_ShowUsers12_invoker.call(HomeController_1.ShowUsers)
      }
  
    // @LINE:27
    case controllers_HomeController_StartAddingAUser13_route(params) =>
      call { 
        controllers_HomeController_StartAddingAUser13_invoker.call(HomeController_1.StartAddingAUser)
      }
  
    // @LINE:28
    case controllers_HomeController_ShowUser14_route(params) =>
      call(params.fromPath[Long]("ID", None)) { (ID) =>
        controllers_HomeController_ShowUser14_invoker.call(HomeController_1.ShowUser(ID))
      }
  
    // @LINE:29
    case controllers_HomeController_getJsonUserList15_route(params) =>
      call { 
        controllers_HomeController_getJsonUserList15_invoker.call(HomeController_1.getJsonUserList)
      }
  
    // @LINE:31
    case controllers_HomeController_ShowGestures16_route(params) =>
      call { 
        controllers_HomeController_ShowGestures16_invoker.call(HomeController_1.ShowGestures)
      }
  
    // @LINE:32
    case controllers_HomeController_StartAddingAGesture17_route(params) =>
      call { 
        controllers_HomeController_StartAddingAGesture17_invoker.call(HomeController_1.StartAddingAGesture)
      }
  
    // @LINE:33
    case controllers_HomeController_ShowGesture18_route(params) =>
      call(params.fromPath[Long]("ID", None)) { (ID) =>
        controllers_HomeController_ShowGesture18_invoker.call(HomeController_1.ShowGesture(ID))
      }
  
    // @LINE:34
    case controllers_HomeController_getJsonGestureList19_route(params) =>
      call { 
        controllers_HomeController_getJsonGestureList19_invoker.call(HomeController_1.getJsonGestureList)
      }
  
    // @LINE:36
    case controllers_HomeController_ShowDevices20_route(params) =>
      call { 
        controllers_HomeController_ShowDevices20_invoker.call(HomeController_1.ShowDevices)
      }
  
    // @LINE:37
    case controllers_HomeController_StartAddingADevice21_route(params) =>
      call { 
        controllers_HomeController_StartAddingADevice21_invoker.call(HomeController_1.StartAddingADevice)
      }
  
    // @LINE:38
    case controllers_HomeController_ShowDevice22_route(params) =>
      call(params.fromPath[Long]("ID", None)) { (ID) =>
        controllers_HomeController_ShowDevice22_invoker.call(HomeController_1.ShowDevice(ID))
      }
  
    // @LINE:39
    case controllers_HomeController_getJsonDeviceList23_route(params) =>
      call { 
        controllers_HomeController_getJsonDeviceList23_invoker.call(HomeController_1.getJsonDeviceList)
      }
  
    // @LINE:43
    case controllers_TensorFlowController_TensorFlowMain24_route(params) =>
      call { 
        controllers_TensorFlowController_TensorFlowMain24_invoker.call(TensorFlowController_3.TensorFlowMain)
      }
  
    // @LINE:44
    case controllers_TensorFlowController_TensorFlowPreferences25_route(params) =>
      call { 
        controllers_TensorFlowController_TensorFlowPreferences25_invoker.call(TensorFlowController_3.TensorFlowPreferences)
      }
  
    // @LINE:45
    case controllers_TensorFlowController_TensorFlowPreferencesPOST26_route(params) =>
      call { 
        controllers_TensorFlowController_TensorFlowPreferencesPOST26_invoker.call(TensorFlowController_3.TensorFlowPreferencesPOST)
      }
  
    // @LINE:46
    case controllers_TensorFlowController_TensorFlowConnect27_route(params) =>
      call { 
        controllers_TensorFlowController_TensorFlowConnect27_invoker.call(TensorFlowController_3.TensorFlowConnect)
      }
  
    // @LINE:47
    case controllers_TensorFlowController_TensorFlowTestSet28_route(params) =>
      call { 
        controllers_TensorFlowController_TensorFlowTestSet28_invoker.call(TensorFlowController_3.TensorFlowTestSet)
      }
  
    // @LINE:48
    case controllers_TensorFlowController_startTraining29_route(params) =>
      call { 
        controllers_TensorFlowController_startTraining29_invoker.call(TensorFlowController_3.startTraining)
      }
  
    // @LINE:49
    case controllers_TensorFlowController_startTracking30_route(params) =>
      call { 
        controllers_TensorFlowController_startTracking30_invoker.call(TensorFlowController_3.startTracking)
      }
  
    // @LINE:52
    case controllers_Assets_versioned31_route(params) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned31_invoker.call(Assets_2.versioned(path, file))
      }
  }
}
