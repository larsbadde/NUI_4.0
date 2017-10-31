
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
/*2.2*/import stats.SessionModell

object showSession extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[SessionModell,List[TrainingData],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*4.2*/(sm: SessionModell, frameList:  List[TrainingData]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*4.53*/("""
"""),_display_(/*5.2*/main("Session")/*5.17*/ {_display_(Seq[Any](format.raw/*5.19*/("""
    """),format.raw/*6.5*/("""<link rel="stylesheet" href='"""),_display_(/*6.35*/routes/*6.41*/.Assets.versioned("dataTables/DataTables-1.10.15/css/dataTables.bootstrap.css")),format.raw/*6.120*/("""'>
    <link rel="stylesheet" href='"""),_display_(/*7.35*/routes/*7.41*/.Assets.versioned("dataTables/Select-1.2.2/css/select.bootstrap.min.css")),format.raw/*7.114*/("""'>
    <link rel="stylesheet" href='"""),_display_(/*8.35*/routes/*8.41*/.Assets.versioned("dataTables/FixedHeader-3.1.2/css/fixedHeader.bootstrap.min.css")),format.raw/*8.124*/("""'>

    <script type='text/javascript' src='"""),_display_(/*10.42*/routes/*10.48*/.Assets.versioned("dataTables/DataTables-1.10.15/js/jquery.dataTables.min.js")),format.raw/*10.126*/("""'></script>
    <script type='text/javascript' src='"""),_display_(/*11.42*/routes/*11.48*/.Assets.versioned("dataTables/DataTables-1.10.15/js/dataTables.bootstrap.min.js")),format.raw/*11.129*/("""'></script>
    <script type='text/javascript' src='"""),_display_(/*12.42*/routes/*12.48*/.Assets.versioned("dataTables/Select-1.2.2/js/dataTables.select.min.js")),format.raw/*12.120*/("""'></script>
    <script type='text/javascript' src='"""),_display_(/*13.42*/routes/*13.48*/.Assets.versioned("dataTables/FixedHeader-3.1.2/js/dataTables.fixedHeader.min.js")),format.raw/*13.130*/("""'></script>

    <script >

            function openFrame(element)
            """),format.raw/*18.13*/("""{"""),format.raw/*18.14*/("""
                """),format.raw/*19.17*/("""open("//"+window.location.host+"/ShowSingleTrainingFrame/"+element.id, "_self");
            """),format.raw/*20.13*/("""}"""),format.raw/*20.14*/("""
    """),format.raw/*21.5*/("""</script>

""")))}/*23.2*/ {_display_(Seq[Any](format.raw/*23.4*/("""
    """),format.raw/*24.5*/("""<div class="container-fluid">


        <div class="table-responsive">
            <table id="session_table" class="table table-striped table-bordered table-responsive">
            <thead></thead>

            <tbody>
                <tr>
                    <td><strong>ID</strong></td>
                    <td>"""),_display_(/*34.26*/sm/*34.28*/.id),format.raw/*34.31*/("""</td>
                </tr>
                <tr>
                    <td><strong>Geste</strong></td>
                    <td> """),_display_(/*38.27*/sm/*38.29*/.gesture.id),format.raw/*38.40*/(""" """),_display_(/*38.42*/sm/*38.44*/.gesture.name),format.raw/*38.57*/(""" """),format.raw/*38.58*/("""</td>
                </tr>
                <tr>
                    <td><strong>User</strong></td>
                    <td>"""),_display_(/*42.26*/sm/*42.28*/.user.id),format.raw/*42.36*/(""" """),format.raw/*42.37*/(""": """),_display_(/*42.40*/sm/*42.42*/.user.prename),format.raw/*42.55*/(""" """),_display_(/*42.57*/sm/*42.59*/.user.surname),format.raw/*42.72*/(""" """),format.raw/*42.73*/("""</td>
                </tr>
                <tr>
                    <td><strong>Anzahl Einzelframe</strong></td>
                    <td>"""),_display_(/*46.26*/sm/*46.28*/.c_frames),format.raw/*46.37*/("""</td>
                </tr>
                <tr>
                    <td><strong>Dauer</strong></td>
                    <td>"""),_display_(/*50.26*/sm/*50.28*/.c_duration),format.raw/*50.39*/(""" """),format.raw/*50.40*/("""Sekunden</td>
                </tr>
                <tr>
                    <td><strong>durchschnittliche Frames pro Sekunden</strong></td>
                    <td>"""),_display_(/*54.26*/sm/*54.28*/.fps),format.raw/*54.32*/("""</td>
                </tr>

            </tbody>
        </table>
            <ul class="list-group" width="200">
            """),_display_(/*60.14*/for(frame <- frameList) yield /*60.37*/{_display_(Seq[Any](format.raw/*60.38*/("""
                """),format.raw/*61.17*/("""<li class="list-group-item" onclick="openFrame(this)" id="""),_display_(/*61.75*/frame/*61.80*/.id),format.raw/*61.83*/(""" """),format.raw/*61.84*/(""">Frame """),_display_(/*61.92*/frame/*61.97*/.id),format.raw/*61.100*/(""" """),format.raw/*61.101*/("""</li>
            """)))}),format.raw/*62.14*/("""
            """),format.raw/*63.13*/("""</ul>

        </div>
    </div>

""")))}))
      }
    }
  }

  def render(sm:SessionModell,frameList:List[TrainingData]): play.twirl.api.HtmlFormat.Appendable = apply(sm,frameList)

  def f:((SessionModell,List[TrainingData]) => play.twirl.api.HtmlFormat.Appendable) = (sm,frameList) => apply(sm,frameList)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Aug 28 14:26:32 CEST 2017
                  SOURCE: D:/NUI4.0/NUI4.0_Server/app/views/showSession.scala.html
                  HASH: 586cb3a5b72cf08d421ee0298bcca8776dc690ac
                  MATRIX: 651->1|675->20|1038->51|1184->102|1212->105|1235->120|1274->122|1306->128|1362->158|1376->164|1476->243|1540->281|1554->287|1648->360|1712->398|1726->404|1830->487|1904->534|1919->540|2019->618|2100->672|2115->678|2218->759|2299->813|2314->819|2408->891|2489->945|2504->951|2608->1033|2721->1118|2750->1119|2796->1137|2918->1231|2947->1232|2980->1238|3012->1252|3051->1254|3084->1260|3435->1584|3446->1586|3470->1589|3628->1720|3639->1722|3671->1733|3700->1735|3711->1737|3745->1750|3774->1751|3930->1880|3941->1882|3970->1890|3999->1891|4029->1894|4040->1896|4074->1909|4103->1911|4114->1913|4148->1926|4177->1927|4347->2070|4358->2072|4388->2081|4545->2211|4556->2213|4588->2224|4617->2225|4814->2395|4825->2397|4850->2401|5011->2535|5050->2558|5089->2559|5135->2577|5220->2635|5234->2640|5258->2643|5287->2644|5322->2652|5336->2657|5361->2660|5391->2661|5442->2681|5484->2695
                  LINES: 24->1|25->2|30->4|35->4|36->5|36->5|36->5|37->6|37->6|37->6|37->6|38->7|38->7|38->7|39->8|39->8|39->8|41->10|41->10|41->10|42->11|42->11|42->11|43->12|43->12|43->12|44->13|44->13|44->13|49->18|49->18|50->19|51->20|51->20|52->21|54->23|54->23|55->24|65->34|65->34|65->34|69->38|69->38|69->38|69->38|69->38|69->38|69->38|73->42|73->42|73->42|73->42|73->42|73->42|73->42|73->42|73->42|73->42|73->42|77->46|77->46|77->46|81->50|81->50|81->50|81->50|85->54|85->54|85->54|91->60|91->60|91->60|92->61|92->61|92->61|92->61|92->61|92->61|92->61|92->61|92->61|93->62|94->63
                  -- GENERATED --
              */
          