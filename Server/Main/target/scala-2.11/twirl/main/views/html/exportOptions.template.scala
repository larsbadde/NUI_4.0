
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
/*1.2*/import java.util

object exportOptions extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[util.List[User],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(UserList: util.List[User]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.29*/("""

"""),_display_(/*4.2*/main("Export Options")/*4.24*/ {_display_(Seq[Any](format.raw/*4.26*/("""
    """),format.raw/*5.5*/("""<script type='text/javascript' src='"""),_display_(/*5.42*/routes/*5.48*/.Assets.versioned("javascripts/custom/training.scala.js")),format.raw/*5.105*/("""'></script>
    <script type='text/javascript' src='"""),_display_(/*6.42*/routes/*6.48*/.Assets.versioned("javascripts/jquery-3.2.1.js")),format.raw/*6.96*/("""'></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
""")))}/*8.2*/ {_display_(Seq[Any](format.raw/*8.4*/("""


    """),format.raw/*11.5*/("""<div class="panel panel-default">



        <div class="panel-body">
            <h3>Alle Daten exportien</h3>
            Alle Trainingsdaten werden exportiert, unabhängig von Nutzer oder anderen Einschränkungren.
            <br>
            <br>
            <span class="label label-danger"><strong>Achtung!</strong> Der Export kann abhängig von der Datenmenge einige Zeit dauern.</span>
            <br>
            <br>
                <a type="button" class="btn btn-success" href='"""),_display_(/*23.65*/routes/*23.71*/.TrainingController.ExportAllTrainingData),format.raw/*23.112*/("""'>OK <span class="glyphicon glyphicon-ok" aria-hidden="true"></span></a>
        </div>

    </div>

    <br>
    <br>

    <div class="panel panel-default">

        <div class="panel-body">
            <h3>Daten für speziellen Nutzer exportieren</h3>
            <br>
            <img src='"""),_display_(/*36.24*/routes/*36.30*/.Assets.versioned("images/uc.jpg")),format.raw/*36.64*/("""' alt="140x140" class="img-rounded" height="120" width="120" align="center">
            <br>
            <span class="label label-warning"><strong>Achtung!</strong> Der Export kann abhängig von der Datenmenge einige Zeit dauern.</span>
            <br>
            <br>
            <div class="list-group" width="200">

                """),_display_(/*43.18*/for(user <- UserList) yield /*43.39*/ {_display_(Seq[Any](format.raw/*43.41*/("""
                    """),format.raw/*44.21*/("""<a href=""""),_display_(/*44.31*/routes/*44.37*/.TrainingController.ExportTrainingDataForUser(user.id)),format.raw/*44.91*/("""" id="""),_display_(/*44.97*/user/*44.101*/.id),format.raw/*44.104*/(""" """),format.raw/*44.105*/("""class="list-group-item">"""),_display_(/*44.130*/user/*44.134*/.id),format.raw/*44.137*/("""      """),_display_(/*44.144*/user/*44.148*/.prename),format.raw/*44.156*/(""" """),_display_(/*44.158*/user/*44.162*/.surname),format.raw/*44.170*/(""" """),format.raw/*44.171*/("""</a>
                """)))}),format.raw/*45.18*/("""


            """),format.raw/*48.13*/("""</div>
        </div>

    </div>

""")))}),format.raw/*53.2*/("""
"""))
      }
    }
  }

  def render(UserList:util.List[User]): play.twirl.api.HtmlFormat.Appendable = apply(UserList)

  def f:((util.List[User]) => play.twirl.api.HtmlFormat.Appendable) = (UserList) => apply(UserList)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Thu Nov 16 13:50:47 CET 2017
                  SOURCE: D:/NUI_4.0/Server/Main/app/views/exportOptions.scala.html
                  HASH: f3cd1f5bc97836e16b8f1420535f981237bb78ff
                  MATRIX: 651->1|989->20|1111->47|1141->52|1171->74|1210->76|1242->82|1305->119|1319->125|1397->182|1477->236|1491->242|1559->290|1709->423|1747->425|1784->435|2313->937|2328->943|2391->984|2724->1290|2739->1296|2794->1330|3166->1675|3203->1696|3243->1698|3293->1720|3330->1730|3345->1736|3420->1790|3453->1796|3467->1800|3492->1803|3522->1804|3575->1829|3589->1833|3614->1836|3649->1843|3663->1847|3693->1855|3723->1857|3737->1861|3767->1869|3797->1870|3851->1893|3897->1911|3968->1952
                  LINES: 24->1|29->2|34->2|36->4|36->4|36->4|37->5|37->5|37->5|37->5|38->6|38->6|38->6|40->8|40->8|43->11|55->23|55->23|55->23|68->36|68->36|68->36|75->43|75->43|75->43|76->44|76->44|76->44|76->44|76->44|76->44|76->44|76->44|76->44|76->44|76->44|76->44|76->44|76->44|76->44|76->44|76->44|76->44|77->45|80->48|85->53
                  -- GENERATED --
              */
          