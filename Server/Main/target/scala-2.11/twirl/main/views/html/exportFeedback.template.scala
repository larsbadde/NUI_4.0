
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

object exportFeedback extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[Boolean,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(success: Boolean, path: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.34*/("""
"""),_display_(/*3.2*/main("ExportFeedback")/*3.24*/ {_display_(Seq[Any](format.raw/*3.26*/("""
    """),format.raw/*4.5*/("""<script type='text/javascript' src='"""),_display_(/*4.42*/routes/*4.48*/.Assets.versioned("javascripts/custom/training.scala.js")),format.raw/*4.105*/("""'></script>
    <script type='text/javascript' src='"""),_display_(/*5.42*/routes/*5.48*/.Assets.versioned("javascripts/jquery-3.2.1.js")),format.raw/*5.96*/("""'></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
""")))}/*7.2*/ {_display_(Seq[Any](format.raw/*7.4*/("""
    """),_display_(/*8.6*/if(!success)/*8.18*/ {_display_(Seq[Any](format.raw/*8.20*/("""
        """),format.raw/*9.9*/("""<div class="alert alert-danger" role="alert">Fehler beim Export: + """),_display_(/*9.77*/path),format.raw/*9.81*/("""</div>
    """)))}/*10.7*/else/*10.12*/{_display_(Seq[Any](format.raw/*10.13*/("""
        """),format.raw/*11.9*/("""<div class="alert alert-success" role="alert"><span class="glyphicon glyphicon-thumbs-up" aria-hidden="true"></span>   Export erfolgreich! </div>
    """)))}),format.raw/*12.6*/("""
""")))}),format.raw/*13.2*/("""
"""))
      }
    }
  }

  def render(success:Boolean,path:String): play.twirl.api.HtmlFormat.Appendable = apply(success,path)

  def f:((Boolean,String) => play.twirl.api.HtmlFormat.Appendable) = (success,path) => apply(success,path)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Aug 28 14:26:31 CEST 2017
                  SOURCE: D:/NUI4.0/NUI4.0_Server/app/views/exportFeedback.scala.html
                  HASH: d3fa8e22e6f9945abdbe1d244f5bd0754194305e
                  MATRIX: 965->3|1092->35|1120->38|1150->60|1189->62|1221->68|1284->105|1298->111|1376->168|1456->222|1470->228|1538->276|1688->409|1726->411|1758->418|1778->430|1817->432|1853->442|1947->510|1971->514|2002->528|2015->533|2054->534|2091->544|2273->696|2306->699
                  LINES: 28->2|33->2|34->3|34->3|34->3|35->4|35->4|35->4|35->4|36->5|36->5|36->5|38->7|38->7|39->8|39->8|39->8|40->9|40->9|40->9|41->10|41->10|41->10|42->11|43->12|44->13
                  -- GENERATED --
              */
          