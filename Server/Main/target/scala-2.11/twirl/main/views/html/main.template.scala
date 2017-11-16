
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

object main extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[String,Html,Html,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(title: String)(header: Html)(content: Html):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.46*/("""

"""),format.raw/*3.1*/("""<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link rel="stylesheet" href='"""),_display_(/*9.39*/routes/*9.45*/.Assets.versioned("bootstrap-3.3.7-dist/css/bootstrap.css")),format.raw/*9.104*/("""'>


        <script type='text/javascript' src='"""),_display_(/*12.46*/routes/*12.52*/.Assets.versioned("javascripts/jquery-3.2.1.js")),format.raw/*12.100*/("""'></script>
        <script type='text/javascript' src='"""),_display_(/*13.46*/routes/*13.52*/.Assets.versioned("bootstrap-3.3.7-dist/js/bootstrap.js")),format.raw/*13.109*/("""'></script>



        """),format.raw/*17.62*/("""


        """),format.raw/*20.9*/("""<title>"""),_display_(/*20.17*/title),format.raw/*20.22*/("""</title>

        """),_display_(/*22.10*/header),format.raw/*22.16*/("""

    """),format.raw/*24.5*/("""</head>


    <body>
        <header class="bs-docs-nav navbar navbar-inverse navbar-static-top" id="top">
            <meta charset="utf-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <div class="container">
                <div class="navbar-header">
                    <button aria-controls="bs-navbar" aria-expanded="false" class="navbar-toggle collapsed" data-target="#bs-navbar" data-toggle="collapse" type="button">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="/" style="font-family: sans-serif">NUI4.0</a>
                </div>
                <nav class="navbar-collapse collapse" id="bs-navbar" aria-expanded="false" style="height: 1px;">
                    <ul class="nav navbar-nav">


                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"> <span class="glyphicon glyphicon-road" aria-hidden="true"></span>  Training    <span class="caret"></span></a>
                            <ul class="dropdown-menu">

                                <li><a name="internalLink" href=""""),_display_(/*50.67*/routes/*50.73*/.TrainingController.Training),format.raw/*50.101*/("""">Trainingsdaten erzeugen</a></li>

                                <li role="separator" class="divider"></li>
                                <li class="dropdown-header">Bestehende Trainingsdaten</li>
                                <li><a name="internalLink" href=""""),_display_(/*54.67*/routes/*54.73*/.TrainingController.ShowUserAggregateTrainingData),format.raw/*54.122*/("""">Trainingsdaten sichten</a></li>
                                <li><a name="internalLink" href=""""),_display_(/*55.67*/routes/*55.73*/.TrainingController.ExportOptions),format.raw/*55.106*/("""">Trainingsdaten exportieren</a></li>


                            </ul>

                        </li>





                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                                <span class="glyphicon glyphicon-cog" aria-hidden="true"></span> Verwaltung<span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li class="dropdown-header">Nutzerverwaltung</li>
                                <li><a href=""""),_display_(/*71.47*/routes/*71.53*/.HomeController.ShowUsers),format.raw/*71.78*/("""">Alle Nutzer anzeigen</a></li>
                                <li><a href=""""),_display_(/*72.47*/routes/*72.53*/.HomeController.StartAddingAUser),format.raw/*72.85*/("""">Nutzer hinzufügen</a></li>

                                <li role="separator" class="divider"></li>
                                <li class="dropdown-header">Gestenverwaltung</li>
                                <li><a href=""""),_display_(/*76.47*/routes/*76.53*/.HomeController.ShowGestures),format.raw/*76.81*/("""">Alle Gesten anzeigen</a></li>
                                <li><a href=""""),_display_(/*77.47*/routes/*77.53*/.HomeController.StartAddingAGesture),format.raw/*77.88*/("""">Geste hinzufügen</a></li>

                                <li role="separator" class="divider"></li>
                                <li class="dropdown-header">Deviceverwaltung</li>
                                <li><a href=""""),_display_(/*81.47*/routes/*81.53*/.HomeController.ShowDevices),format.raw/*81.80*/("""">Alle Devices anzeigen</a></li>
                                <li><a href=""""),_display_(/*82.47*/routes/*82.53*/.HomeController.StartAddingADevice),format.raw/*82.87*/("""">Device hinzufügen</a></li>


                            </ul>
                        </li>


                    </ul>

                    <ul class="nav navbar-nav navbar-right">

                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"> <img src=""""),_display_(/*94.157*/routes/*94.163*/.Assets.versioned("images/tensorFlow_raw.png")),format.raw/*94.209*/("""" height="20">  TensorFlow   <span class="caret"></span></a>
                            <ul class="dropdown-menu">

                                <li class="dropdown-header">Maintenace</li>
                                <li><a name="internalLink" href=""""),_display_(/*98.67*/routes/*98.73*/.TensorFlowController.TensorFlowMain),format.raw/*98.109*/("""">TensorFlow Control</a></li>
                                <li><a name="internalLink" href=""""),_display_(/*99.67*/routes/*99.73*/.TensorFlowController.TensorFlowConnect),format.raw/*99.112*/("""">Reconnect to TensorFlowServer</a></li>
                                <li><a name="internalLink" href=""""),_display_(/*100.67*/routes/*100.73*/.TensorFlowController.TensorFlowTestSet),format.raw/*100.112*/("""">Test Sequence</a></li>
                                <li><a name="internalLink" href=""""),_display_(/*101.67*/routes/*101.73*/.TensorFlowController.TensorFlowPreferences),format.raw/*101.116*/(""" """),format.raw/*101.117*/("""">Einstellungen</a></li>

                                <li role="separator" class="divider"></li>
                                <li class="dropdown-header">...</li>



                            </ul>

                        </li>




                    </ul>
                </nav>
            </div>
        </header>


        <div class="container">
        """),_display_(/*122.10*/content),format.raw/*122.17*/("""
        """),format.raw/*123.9*/("""</div>

    </body>
</html>
"""))
      }
    }
  }

  def render(title:String,header:Html,content:Html): play.twirl.api.HtmlFormat.Appendable = apply(title)(header)(content)

  def f:((String) => (Html) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (title) => (header) => (content) => apply(title)(header)(content)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Thu Nov 16 13:50:47 CET 2017
                  SOURCE: D:/NUI_4.0/Server/Main/app/views/main.scala.html
                  HASH: a92dd265d62e0e43d8d427cfaf69d65d8bfd709a
                  MATRIX: 957->1|1096->45|1126->49|1380->277|1394->283|1474->342|1554->395|1569->401|1639->449|1724->507|1739->513|1818->570|1873->650|1914->664|1949->672|1975->677|2023->698|2050->704|2085->712|3650->2250|3665->2256|3715->2284|4014->2556|4029->2562|4100->2611|4228->2712|4243->2718|4298->2751|4964->3390|4979->3396|5025->3421|5131->3500|5146->3506|5199->3538|5463->3775|5478->3781|5527->3809|5633->3888|5648->3894|5704->3929|5967->4165|5982->4171|6030->4198|6137->4278|6152->4284|6207->4318|6635->4718|6651->4724|6719->4770|7009->5033|7024->5039|7082->5075|7206->5172|7221->5178|7282->5217|7418->5325|7434->5331|7496->5370|7616->5462|7632->5468|7698->5511|7729->5512|8149->5904|8178->5911|8216->5921
                  LINES: 28->1|33->1|35->3|41->9|41->9|41->9|44->12|44->12|44->12|45->13|45->13|45->13|49->17|52->20|52->20|52->20|54->22|54->22|56->24|82->50|82->50|82->50|86->54|86->54|86->54|87->55|87->55|87->55|103->71|103->71|103->71|104->72|104->72|104->72|108->76|108->76|108->76|109->77|109->77|109->77|113->81|113->81|113->81|114->82|114->82|114->82|126->94|126->94|126->94|130->98|130->98|130->98|131->99|131->99|131->99|132->100|132->100|132->100|133->101|133->101|133->101|133->101|154->122|154->122|155->123
                  -- GENERATED --
              */
          