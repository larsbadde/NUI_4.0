
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

object index extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](_display_(/*1.2*/main("Training")/*1.18*/ {_display_(Seq[Any](format.raw/*1.20*/("""
    """),format.raw/*2.5*/("""<script type='text/javascript' src='"""),_display_(/*2.42*/routes/*2.48*/.Assets.versioned("javascripts/custom/training.scala.js")),format.raw/*2.105*/("""'></script>
    <script type='text/javascript' src='"""),_display_(/*3.42*/routes/*3.48*/.Assets.versioned("javascripts/jquery-3.2.1.js")),format.raw/*3.96*/("""'></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
""")))}/*5.2*/ {_display_(Seq[Any](format.raw/*5.4*/("""
    """),format.raw/*6.5*/("""<h1>Willkommen beim Natural User Interface 4.0</h1>
    <br>
    <img src='"""),_display_(/*8.16*/routes/*8.22*/.Assets.versioned("images/hand_image01.png")),format.raw/*8.66*/("""' alt="140x140" class="img-rounded" height="200"  align="center">
    <br>
    <h5><span class="glyphicon glyphicon-copyright-mark" aria-hidden="true"></span> by Lars Badde</h5>

""")))}),format.raw/*12.2*/("""
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
                  DATE: Thu Nov 16 13:50:47 CET 2017
                  SOURCE: D:/NUI_4.0/Server/Main/app/views/index.scala.html
                  HASH: 15b5149d2337e44ae80484e9daf8d512e622d582
                  MATRIX: 1030->1|1054->17|1093->19|1125->25|1188->62|1202->68|1280->125|1360->179|1374->185|1442->233|1592->366|1630->368|1662->374|1766->452|1780->458|1844->502|2058->686
                  LINES: 33->1|33->1|33->1|34->2|34->2|34->2|34->2|35->3|35->3|35->3|37->5|37->5|38->6|40->8|40->8|40->8|44->12
                  -- GENERATED --
              */
          