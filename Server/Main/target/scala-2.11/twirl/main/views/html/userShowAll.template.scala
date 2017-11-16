
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

object userShowAll extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[util.List[User],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*3.2*/(deviceList: util.List[User]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*3.31*/("""
"""),_display_(/*4.2*/main("Nutzer")/*4.16*/ {_display_(Seq[Any](format.raw/*4.18*/("""
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

                var table = $('#user-table').DataTable( """),format.raw/*18.57*/("""{"""),format.raw/*18.58*/("""
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
                        """),format.raw/*29.25*/("""url:     '"""),_display_(/*29.36*/routes/*29.42*/.HomeController.getJsonUserList),format.raw/*29.73*/("""',
                        dataSrc: ''
                    """),format.raw/*31.21*/("""}"""),format.raw/*31.22*/(""",

                    columns: [
                        """),format.raw/*34.25*/("""{"""),format.raw/*34.26*/(""" """),format.raw/*34.27*/("""data: 'id' """),format.raw/*34.38*/("""}"""),format.raw/*34.39*/(""",
                        """),format.raw/*35.25*/("""{"""),format.raw/*35.26*/(""" """),format.raw/*35.27*/("""data: 'prename' """),format.raw/*35.43*/("""}"""),format.raw/*35.44*/(""",
                        """),format.raw/*36.25*/("""{"""),format.raw/*36.26*/(""" """),format.raw/*36.27*/("""data: 'surname' """),format.raw/*36.43*/("""}"""),format.raw/*36.44*/(""",
                        """),format.raw/*37.25*/("""{"""),format.raw/*37.26*/(""" """),format.raw/*37.27*/("""data: 'right_handed' """),format.raw/*37.48*/("""}"""),format.raw/*37.49*/(""",
                        """),format.raw/*50.27*/("""
                    """),format.raw/*51.21*/("""]

                """),format.raw/*53.17*/("""}"""),format.raw/*53.18*/(""");

                $('#user-table-body').on('dblclick', 'tr', function (e) """),format.raw/*55.73*/("""{"""),format.raw/*55.74*/("""
                    """),format.raw/*56.21*/("""var data = table.row( this ).data();
                    var id = data.id;
                    open("//"+window.location.host+"/ShowUser/"+id, "_self");
                """),format.raw/*59.17*/("""}"""),format.raw/*59.18*/(""");



            """),format.raw/*63.13*/("""}"""),format.raw/*63.14*/(""");

    </script>


""")))}/*68.2*/ {_display_(Seq[Any](format.raw/*68.4*/("""
    """),format.raw/*69.5*/("""<div class="container-fluid">


        <div class="table-responsive">
            <table id="user-table" class="table table-striped table-hover table-bordered">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Vorname</th>
                        <th>Nachname</th>
                        <th>Rechtshänder?</th>
                    </tr>
                </thead>
                <tbody id="user-table-body">

                </tbody>
            </table>
        </div>
    </div>

""")))}))
      }
    }
  }

  def render(deviceList:util.List[User]): play.twirl.api.HtmlFormat.Appendable = apply(deviceList)

  def f:((util.List[User]) => play.twirl.api.HtmlFormat.Appendable) = (deviceList) => apply(deviceList)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Thu Nov 16 13:50:48 CET 2017
                  SOURCE: D:/NUI_4.0/Server/Main/app/views/userShowAll.scala.html
                  HASH: 95dd3c06f56a0d60265d69778a8ed8cd06fb7bc7
                  MATRIX: 651->1|987->22|1111->51|1139->54|1161->68|1200->70|1232->76|1288->106|1302->112|1402->191|1466->229|1480->235|1574->308|1638->346|1652->352|1756->435|1829->482|1843->488|1942->566|2023->620|2038->626|2141->707|2222->761|2237->767|2331->839|2412->893|2427->899|2531->981|2631->1053|2660->1054|2706->1072|2814->1152|2843->1153|2893->1175|3006->1260|3035->1261|3089->1287|3195->1365|3224->1366|3285->1399|3314->1400|3368->1426|3402->1433|3417->1439|3481->1482|3532->1505|3561->1506|3618->1535|3647->1536|3701->1562|3739->1573|3754->1579|3806->1610|3895->1671|3924->1672|4013->1733|4042->1734|4071->1735|4110->1746|4139->1747|4194->1774|4223->1775|4252->1776|4296->1792|4325->1793|4380->1820|4409->1821|4438->1822|4482->1838|4511->1839|4566->1866|4595->1867|4624->1868|4673->1889|4702->1890|4757->2884|4807->2906|4856->2927|4885->2928|4991->3006|5020->3007|5070->3029|5270->3201|5299->3202|5349->3224|5378->3225|5422->3251|5461->3253|5494->3259
                  LINES: 24->1|29->3|34->3|35->4|35->4|35->4|36->5|36->5|36->5|36->5|37->6|37->6|37->6|38->7|38->7|38->7|40->9|40->9|40->9|41->10|41->10|41->10|42->11|42->11|42->11|43->12|43->12|43->12|46->15|46->15|47->16|49->18|49->18|50->19|52->21|52->21|53->22|55->24|55->24|56->25|56->25|57->26|57->26|57->26|57->26|58->27|58->27|59->28|59->28|60->29|60->29|60->29|60->29|62->31|62->31|65->34|65->34|65->34|65->34|65->34|66->35|66->35|66->35|66->35|66->35|67->36|67->36|67->36|67->36|67->36|68->37|68->37|68->37|68->37|68->37|69->50|70->51|72->53|72->53|74->55|74->55|75->56|78->59|78->59|82->63|82->63|87->68|87->68|88->69
                  -- GENERATED --
              */
          