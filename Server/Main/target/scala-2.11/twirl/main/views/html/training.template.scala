
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import java.lang._
import java.util._
import scala.collection.JavaConverters._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import play.data._
import play.core.j.PlayFormsMagicForJava._
/*1.2*/import com.fasterxml.jackson.databind.JsonNode
/*2.2*/import java.util
/*3.2*/import helper._

object training extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template7[String,List[Gesture],List[User],List[Device],List[String],String,List[Long],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*4.2*/(UUID: String, gestures: List[Gesture], users: List[User], devices: List[Device], infos: List[String], lastUUID: String, lastSession: List[Long]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*4.147*/("""

"""),_display_(/*6.2*/main("Training")/*6.18*/ {_display_(Seq[Any](format.raw/*6.20*/("""
  """),format.raw/*7.3*/("""<script type='text/javascript' src='"""),_display_(/*7.40*/routes/*7.46*/.Assets.versioned("javascripts/custom/training.scala.js")),format.raw/*7.103*/("""'></script>
  <script type='text/javascript' src='"""),_display_(/*8.40*/routes/*8.46*/.Assets.versioned("javascripts/jquery-3.2.1.js")),format.raw/*8.94*/("""'></script>
  <script type='text/javascript' src='"""),_display_(/*9.40*/routes/*9.46*/.Assets.versioned("javascripts/custom/training.scala.js")),format.raw/*9.103*/("""'></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <style> </style>


""")))}/*14.2*/ {_display_(Seq[Any](format.raw/*14.4*/("""
  """),format.raw/*15.3*/("""<img src='"""),_display_(/*15.14*/routes/*15.20*/.Assets.versioned("images/pylone.jpg")),format.raw/*15.58*/("""' alt="140x140" class="img-rounded" height="280" width="280" align="center">


  <form>
  <div class="form-group">
    <label for="InputUUID">UUID für Trainingsdatensatz</label>
    <input type="String" class="form-control" id="InputUUID" value="""),_display_(/*21.69*/UUID),format.raw/*21.73*/(""" """),format.raw/*21.74*/("""readonly>
  </div>
  <div class="form-group">
    <label for="InputUser">Nutzer</label>
    <select class="form-control" id="InputUser">
    """),_display_(/*26.6*/for(user <- users) yield /*26.24*/ {_display_(Seq[Any](format.raw/*26.26*/("""
      """),format.raw/*27.7*/("""<option id="""),_display_(/*27.19*/user/*27.23*/.id),format.raw/*27.26*/(""">"""),_display_(/*27.28*/user/*27.32*/.prename),format.raw/*27.40*/("""  """),_display_(/*27.43*/user/*27.47*/.surname),format.raw/*27.55*/("""</option>

    """)))}),format.raw/*29.6*/("""

    """),format.raw/*31.5*/("""</select>
  </div>
    <div class="form-group">
      <label  for="InputGesture">Geste</label>
      <select class="form-control" id="InputGesture">
      """),_display_(/*36.8*/for(gesture <- gestures) yield /*36.32*/ {_display_(Seq[Any](format.raw/*36.34*/("""
        """),format.raw/*37.9*/("""<option id="""),_display_(/*37.21*/gesture/*37.28*/.id),format.raw/*37.31*/(""" """),format.raw/*37.32*/(""">"""),_display_(/*37.34*/gesture/*37.41*/.name),format.raw/*37.46*/("""</option>
      """)))}),format.raw/*38.8*/("""

      """),format.raw/*40.7*/("""</select>
    </div>
    <div class="form-group">
      <label for="InputUser">Device</label>
      <select class="form-control" id="InputDevice">
      """),_display_(/*45.8*/for(device <- devices) yield /*45.30*/ {_display_(Seq[Any](format.raw/*45.32*/("""
        """),format.raw/*46.9*/("""<option id="""),_display_(/*46.21*/device/*46.27*/.id),format.raw/*46.30*/(""">"""),_display_(/*46.32*/device/*46.38*/.name),format.raw/*46.43*/("""                   """),format.raw/*46.62*/("""-- """),_display_(/*46.66*/device/*46.72*/.description),format.raw/*46.84*/(""" """),format.raw/*46.85*/("""</option>
      """)))}),format.raw/*47.8*/("""

      """),format.raw/*49.7*/("""</select>
    </div>




    <button id="startstop" type="button" class="btn btn-success btn-lg btn-block" onclick="keypress()">Starten und Stoppen der Aufzeichnung mit der Leertaste</button>

    <br>

    <i id="spinner" class="fa" style="font-size:24px" ></i>
  </form>


    """),_display_(/*63.6*/if(infos.isEmpty)/*63.23*/ {_display_(Seq[Any](format.raw/*63.25*/("""

    """)))}/*65.7*/else/*65.12*/{_display_(Seq[Any](format.raw/*65.13*/("""

      """),format.raw/*67.7*/("""<div class="panel panel-default">
        <div class="panel-heading">Letztes Training</div>
        <div class="panel-body">
      <div class="list-group">
        <a class="list-group-item"><h4>UUID: """),_display_(/*71.47*/lastUUID),format.raw/*71.55*/("""</h4></a>
      """),_display_(/*72.8*/for(info <- infos) yield /*72.26*/ {_display_(Seq[Any](format.raw/*72.28*/("""
        """),format.raw/*73.9*/("""<a class="list-group-item">"""),_display_(/*73.37*/info),format.raw/*73.41*/("""</a>
      """)))}),format.raw/*74.8*/("""
      """),format.raw/*75.7*/("""</div>
        </div>
        <div class="panel-footer">
            <!-- Indicates a dangerous or potentially negative action -->
          <button type="button" class="btn btn-danger" onclick="deleteTD('"""),_display_(/*79.76*/lastUUID),format.raw/*79.84*/("""')">Trainingsdatensatz löschen</button>
        </div>
      </div>
    """)))}),format.raw/*82.6*/("""

    """),_display_(/*84.6*/if(lastSession==null)/*84.27*/ {_display_(Seq[Any](format.raw/*84.29*/("""

    """)))}/*86.7*/else/*86.12*/{_display_(Seq[Any](format.raw/*86.13*/("""

      """),format.raw/*88.7*/("""<script>
        g= document.getElementById("InputGesture");
        d= document.getElementById("InputDevice");
        g.selectedIndex="""),_display_(/*91.26*/lastSession(0)),format.raw/*91.40*/(""";
        d.selectedIndex="""),_display_(/*92.26*/lastSession(1)),format.raw/*92.40*/(""";
      </script>

    """)))}),format.raw/*95.6*/("""




""")))}))
      }
    }
  }

  def render(UUID:String,gestures:List[Gesture],users:List[User],devices:List[Device],infos:List[String],lastUUID:String,lastSession:List[Long]): play.twirl.api.HtmlFormat.Appendable = apply(UUID,gestures,users,devices,infos,lastUUID,lastSession)

  def f:((String,List[Gesture],List[User],List[Device],List[String],String,List[Long]) => play.twirl.api.HtmlFormat.Appendable) = (UUID,gestures,users,devices,infos,lastUUID,lastSession) => apply(UUID,gestures,users,devices,infos,lastUUID,lastSession)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Thu Nov 16 13:50:48 CET 2017
                  SOURCE: D:/NUI_4.0/Server/Main/app/views/training.scala.html
                  HASH: a2a6ae7a1d5d9eeeef53fef67b47b66d6af8616f
                  MATRIX: 651->1|705->50|729->69|1121->87|1362->232|1392->237|1416->253|1455->255|1485->259|1548->296|1562->302|1640->359|1718->411|1732->417|1800->465|1878->517|1892->523|1970->580|2143->735|2182->737|2213->741|2251->752|2266->758|2325->796|2604->1048|2629->1052|2658->1053|2831->1200|2865->1218|2905->1220|2940->1228|2979->1240|2992->1244|3016->1247|3045->1249|3058->1253|3087->1261|3117->1264|3130->1268|3159->1276|3207->1294|3242->1302|3429->1463|3469->1487|3509->1489|3546->1499|3585->1511|3601->1518|3625->1521|3654->1522|3683->1524|3699->1531|3725->1536|3773->1554|3810->1564|3995->1723|4033->1745|4073->1747|4110->1757|4149->1769|4164->1775|4188->1778|4217->1780|4232->1786|4258->1791|4305->1810|4336->1814|4351->1820|4384->1832|4413->1833|4461->1851|4498->1861|4818->2155|4844->2172|4884->2174|4911->2184|4924->2189|4963->2190|5000->2200|5233->2406|5262->2414|5306->2432|5340->2450|5380->2452|5417->2462|5472->2490|5497->2494|5540->2507|5575->2515|5812->2725|5841->2733|5947->2809|5982->2818|6012->2839|6052->2841|6079->2851|6092->2856|6131->2857|6168->2867|6335->3007|6370->3021|6425->3049|6460->3063|6517->3090
                  LINES: 24->1|25->2|26->3|31->4|36->4|38->6|38->6|38->6|39->7|39->7|39->7|39->7|40->8|40->8|40->8|41->9|41->9|41->9|46->14|46->14|47->15|47->15|47->15|47->15|53->21|53->21|53->21|58->26|58->26|58->26|59->27|59->27|59->27|59->27|59->27|59->27|59->27|59->27|59->27|59->27|61->29|63->31|68->36|68->36|68->36|69->37|69->37|69->37|69->37|69->37|69->37|69->37|69->37|70->38|72->40|77->45|77->45|77->45|78->46|78->46|78->46|78->46|78->46|78->46|78->46|78->46|78->46|78->46|78->46|78->46|79->47|81->49|95->63|95->63|95->63|97->65|97->65|97->65|99->67|103->71|103->71|104->72|104->72|104->72|105->73|105->73|105->73|106->74|107->75|111->79|111->79|114->82|116->84|116->84|116->84|118->86|118->86|118->86|120->88|123->91|123->91|124->92|124->92|127->95
                  -- GENERATED --
              */
          