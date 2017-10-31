
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

object gestureShowAll extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[util.List[Gesture],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*3.2*/(deviceList: util.List[Gesture]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*3.34*/("""
"""),_display_(/*4.2*/main("Gesten")/*4.16*/ {_display_(Seq[Any](format.raw/*4.18*/("""
    """),format.raw/*5.5*/("""<link rel="stylesheet" href='"""),_display_(/*5.35*/routes/*5.41*/.Assets.versioned("dataTables/DataTables-1.10.15/css/dataTables.bootstrap.css")),format.raw/*5.120*/("""'>
    <link rel="stylesheet" href='"""),_display_(/*6.35*/routes/*6.41*/.Assets.versioned("dataTables/Select-1.2.2/css/select.bootstrap.min.css")),format.raw/*6.114*/("""'>
    <link rel="stylesheet" href='"""),_display_(/*7.35*/routes/*7.41*/.Assets.versioned("dataTables/FixedHeader-3.1.2/css/fixedHeader.bootstrap.min.css")),format.raw/*7.124*/("""'>

    <script type='text/javascript' src='"""),_display_(/*9.42*/routes/*9.48*/.Assets.versioned("dataTables/DataTables-1.10.15/js/jquery.dataTables.min.js")),format.raw/*9.126*/("""'></script>
    <script type='text/javascript' src='"""),_display_(/*10.42*/routes/*10.48*/.Assets.versioned("dataTables/DataTables-1.10.15/js/dataTables.bootstrap.min.js")),format.raw/*10.129*/("""'></script>
    <script type='text/javascript' src='"""),_display_(/*11.42*/routes/*11.48*/.Assets.versioned("dataTables/Select-1.2.2/js/dataTables.select.min.js")),format.raw/*11.120*/("""'></script>
    <script type='text/javascript' src='"""),_display_(/*12.42*/routes/*12.48*/.Assets.versioned("dataTables/FixedHeader-3.1.2/js/dataTables.fixedHeader.min.js")),format.raw/*12.130*/("""'></script>

    <script>
            $("document").ready(function() """),format.raw/*15.44*/("""{"""),format.raw/*15.45*/("""
                """),format.raw/*16.17*/("""// The DOM is ready!

                var table = $('#gesture-table').DataTable( """),format.raw/*18.60*/("""{"""),format.raw/*18.61*/("""
                    """),format.raw/*19.21*/("""pageLength: 10,
                    fixedHeader: true,
                    select: """),format.raw/*21.29*/("""{"""),format.raw/*21.30*/("""
                        """),format.raw/*22.25*/("""blurable: true,
                        style: 'single'
                    """),format.raw/*24.21*/("""}"""),format.raw/*24.22*/(""",
                    language: """),format.raw/*25.31*/("""{"""),format.raw/*25.32*/("""
                        """),format.raw/*26.25*/("""url: '"""),_display_(/*26.32*/routes/*26.38*/.Assets.versioned("dataTables/german.lang")),format.raw/*26.81*/("""'
                    """),format.raw/*27.21*/("""}"""),format.raw/*27.22*/(""",
                    ajax: """),format.raw/*28.27*/("""{"""),format.raw/*28.28*/("""
                        """),format.raw/*29.25*/("""url:     '"""),_display_(/*29.36*/routes/*29.42*/.HomeController.getJsonGestureList),format.raw/*29.76*/("""',
                        dataSrc: ''
                    """),format.raw/*31.21*/("""}"""),format.raw/*31.22*/(""",

                    columns: [
                        """),format.raw/*34.25*/("""{"""),format.raw/*34.26*/(""" """),format.raw/*34.27*/("""data: 'id' """),format.raw/*34.38*/("""}"""),format.raw/*34.39*/(""",
                        """),format.raw/*35.25*/("""{"""),format.raw/*35.26*/(""" """),format.raw/*35.27*/("""data: 'name' """),format.raw/*35.40*/("""}"""),format.raw/*35.41*/(""",
                        """),format.raw/*36.25*/("""{"""),format.raw/*36.26*/(""" """),format.raw/*36.27*/("""data: 'description' """),format.raw/*36.47*/("""}"""),format.raw/*36.48*/("""
                        """),format.raw/*49.27*/("""
                    """),format.raw/*50.21*/("""]

                """),format.raw/*52.17*/("""}"""),format.raw/*52.18*/(""");

                $('#gesture-table-body').on('dblclick', 'tr', function (e) """),format.raw/*54.76*/("""{"""),format.raw/*54.77*/("""
                    """),format.raw/*55.21*/("""var data = table.row( this ).data();
                    var id = data.id;
                    open("//"+window.location.host+"/ShowGesture/"+id, "_self");
                """),format.raw/*58.17*/("""}"""),format.raw/*58.18*/(""");



            """),format.raw/*62.13*/("""}"""),format.raw/*62.14*/(""");

    </script>


""")))}/*67.2*/ {_display_(Seq[Any](format.raw/*67.4*/("""
    """),format.raw/*68.5*/("""<div class="container-fluid">


        <div class="table-responsive">
            <table id="gesture-table" class="table table-striped table-hover table-bordered">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Kurzbeschreibung</th>
                    </tr>
                </thead>
                <tbody id="gesture-table-body">

                </tbody>
            </table>
        </div>
    </div>

""")))}))
      }
    }
  }

  def render(deviceList:util.List[Gesture]): play.twirl.api.HtmlFormat.Appendable = apply(deviceList)

  def f:((util.List[Gesture]) => play.twirl.api.HtmlFormat.Appendable) = (deviceList) => apply(deviceList)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Aug 28 14:26:32 CEST 2017
                  SOURCE: D:/NUI4.0/NUI4.0_Server/app/views/gestureShowAll.scala.html
                  HASH: 3801413cbf5153ed9b26bef80022699f2c75eec4
                  MATRIX: 651->1|993->22|1120->54|1148->57|1170->71|1209->73|1241->79|1297->109|1311->115|1411->194|1475->232|1489->238|1583->311|1647->349|1661->355|1765->438|1838->485|1852->491|1951->569|2032->623|2047->629|2150->710|2231->764|2246->770|2340->842|2421->896|2436->902|2540->984|2640->1056|2669->1057|2715->1075|2826->1158|2855->1159|2905->1181|3018->1266|3047->1267|3101->1293|3207->1371|3236->1372|3297->1405|3326->1406|3380->1432|3414->1439|3429->1445|3493->1488|3544->1511|3573->1512|3630->1541|3659->1542|3713->1568|3751->1579|3766->1585|3821->1619|3910->1680|3939->1681|4028->1742|4057->1743|4086->1744|4125->1755|4154->1756|4209->1783|4238->1784|4267->1785|4308->1798|4337->1799|4392->1826|4421->1827|4450->1828|4498->1848|4527->1849|4581->2842|4631->2864|4680->2885|4709->2886|4818->2967|4847->2968|4897->2990|5100->3165|5129->3166|5179->3188|5208->3189|5252->3215|5291->3217|5324->3223
                  LINES: 24->1|29->3|34->3|35->4|35->4|35->4|36->5|36->5|36->5|36->5|37->6|37->6|37->6|38->7|38->7|38->7|40->9|40->9|40->9|41->10|41->10|41->10|42->11|42->11|42->11|43->12|43->12|43->12|46->15|46->15|47->16|49->18|49->18|50->19|52->21|52->21|53->22|55->24|55->24|56->25|56->25|57->26|57->26|57->26|57->26|58->27|58->27|59->28|59->28|60->29|60->29|60->29|60->29|62->31|62->31|65->34|65->34|65->34|65->34|65->34|66->35|66->35|66->35|66->35|66->35|67->36|67->36|67->36|67->36|67->36|68->49|69->50|71->52|71->52|73->54|73->54|74->55|77->58|77->58|81->62|81->62|86->67|86->67|87->68
                  -- GENERATED --
              */
          