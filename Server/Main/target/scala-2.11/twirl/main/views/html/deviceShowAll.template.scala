
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

object deviceShowAll extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[util.List[Device],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*3.2*/(deviceList: util.List[Device]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*3.33*/("""
"""),_display_(/*4.2*/main("Devices")/*4.17*/ {_display_(Seq[Any](format.raw/*4.19*/("""
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

                var table = $('#devices-table').DataTable( """),format.raw/*18.60*/("""{"""),format.raw/*18.61*/("""
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
                        """),format.raw/*29.25*/("""url:     '"""),_display_(/*29.36*/routes/*29.42*/.HomeController.getJsonDeviceList),format.raw/*29.75*/("""',
                        dataSrc: ''
                    """),format.raw/*31.21*/("""}"""),format.raw/*31.22*/(""",

                    columns: [
                        """),format.raw/*34.25*/("""{"""),format.raw/*34.26*/(""" """),format.raw/*34.27*/("""data: 'id' """),format.raw/*34.38*/("""}"""),format.raw/*34.39*/(""",
                        """),format.raw/*35.25*/("""{"""),format.raw/*35.26*/(""" """),format.raw/*35.27*/("""data: 'name' """),format.raw/*35.40*/("""}"""),format.raw/*35.41*/(""",
                        """),format.raw/*36.25*/("""{"""),format.raw/*36.26*/(""" """),format.raw/*36.27*/("""data: 'description' """),format.raw/*36.47*/("""}"""),format.raw/*36.48*/("""
                        """),format.raw/*49.27*/("""
                    """),format.raw/*50.21*/("""]

                """),format.raw/*52.17*/("""}"""),format.raw/*52.18*/(""");

                $('#device-table-body').on('dblclick', 'tr', function (e) """),format.raw/*54.75*/("""{"""),format.raw/*54.76*/("""
                    """),format.raw/*55.21*/("""var data = table.row( this ).data();
                    var id = data.id;
                    open("//"+window.location.host+"/ShowDevice/"+id, "_self");
                """),format.raw/*58.17*/("""}"""),format.raw/*58.18*/(""");



            """),format.raw/*62.13*/("""}"""),format.raw/*62.14*/(""");

    </script>


""")))}/*67.2*/ {_display_(Seq[Any](format.raw/*67.4*/("""
    """),format.raw/*68.5*/("""<div class="container-fluid">


        <div class="table-responsive">
            <table id="devices-table" class="table table-striped table-hover table-bordered">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Beschreibung</th>
                    </tr>
                </thead>
                <tbody id="device-table-body">

                </tbody>
            </table>
        </div>
    </div>

""")))}))
      }
    }
  }

  def render(deviceList:util.List[Device]): play.twirl.api.HtmlFormat.Appendable = apply(deviceList)

  def f:((util.List[Device]) => play.twirl.api.HtmlFormat.Appendable) = (deviceList) => apply(deviceList)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Thu Nov 16 13:50:47 CET 2017
                  SOURCE: D:/NUI_4.0/Server/Main/app/views/deviceShowAll.scala.html
                  HASH: f96edbc7322b63135a47a20a64a2758832f2bf24
                  MATRIX: 651->1|991->22|1117->53|1145->56|1168->71|1207->73|1239->79|1295->109|1309->115|1409->194|1473->232|1487->238|1581->311|1645->349|1659->355|1763->438|1836->485|1850->491|1949->569|2030->623|2045->629|2148->710|2229->764|2244->770|2338->842|2419->896|2434->902|2538->984|2638->1056|2667->1057|2713->1075|2824->1158|2853->1159|2903->1181|3016->1266|3045->1267|3099->1293|3205->1371|3234->1372|3295->1405|3324->1406|3378->1432|3412->1439|3427->1445|3491->1488|3542->1511|3571->1512|3628->1541|3657->1542|3711->1568|3749->1579|3764->1585|3818->1618|3907->1679|3936->1680|4025->1741|4054->1742|4083->1743|4122->1754|4151->1755|4206->1782|4235->1783|4264->1784|4305->1797|4334->1798|4389->1825|4418->1826|4447->1827|4495->1847|4524->1848|4578->2841|4628->2863|4677->2884|4706->2885|4814->2965|4843->2966|4893->2988|5095->3162|5124->3163|5174->3185|5203->3186|5247->3212|5286->3214|5319->3220
                  LINES: 24->1|29->3|34->3|35->4|35->4|35->4|36->5|36->5|36->5|36->5|37->6|37->6|37->6|38->7|38->7|38->7|40->9|40->9|40->9|41->10|41->10|41->10|42->11|42->11|42->11|43->12|43->12|43->12|46->15|46->15|47->16|49->18|49->18|50->19|52->21|52->21|53->22|55->24|55->24|56->25|56->25|57->26|57->26|57->26|57->26|58->27|58->27|59->28|59->28|60->29|60->29|60->29|60->29|62->31|62->31|65->34|65->34|65->34|65->34|65->34|66->35|66->35|66->35|66->35|66->35|67->36|67->36|67->36|67->36|67->36|68->49|69->50|71->52|71->52|73->54|73->54|74->55|77->58|77->58|81->62|81->62|86->67|86->67|87->68
                  -- GENERATED --
              */
          