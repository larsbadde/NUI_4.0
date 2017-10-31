
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

object tensorFlowMain extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](_display_(/*3.2*/main("TensorFlow")/*3.20*/ {_display_(Seq[Any](format.raw/*3.22*/("""
    """),format.raw/*4.5*/("""<script type='text/javascript' src='"""),_display_(/*4.42*/routes/*4.48*/.Assets.versioned("javascripts/custom/training.scala.js")),format.raw/*4.105*/("""'></script>
    <script type='text/javascript' src='"""),_display_(/*5.42*/routes/*5.48*/.Assets.versioned("javascripts/jquery-3.2.1.js")),format.raw/*5.96*/("""'></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
""")))}/*7.2*/ {_display_(Seq[Any](format.raw/*7.4*/("""

    """),format.raw/*9.5*/("""<a name="internalLink" href=""""),_display_(/*9.35*/routes/*9.41*/.TensorFlowController.startTraining),format.raw/*9.76*/("""">Train</a>
    <br>
    <br>
    <a name="internalLink" href=""""),_display_(/*12.35*/routes/*12.41*/.TensorFlowController.startTracking),format.raw/*12.76*/("""">Track</a>

""")))}),format.raw/*14.2*/("""
"""))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Oct 16 15:43:56 CEST 2017
                  SOURCE: D:/NUI4.0/NUI4.0_Server/app/views/tensorFlowMain.scala.html
                  HASH: 60fac63439c5b2f56a0a683907e74c1fc56cf6d0
                  MATRIX: 1039->5|1065->23|1104->25|1136->31|1199->68|1213->74|1291->131|1371->185|1385->191|1453->239|1603->372|1641->374|1675->382|1731->412|1745->418|1800->453|1894->520|1909->526|1965->561|2011->577
                  LINES: 33->3|33->3|33->3|34->4|34->4|34->4|34->4|35->5|35->5|35->5|37->7|37->7|39->9|39->9|39->9|39->9|42->12|42->12|42->12|44->14
                  -- GENERATED --
              */
          