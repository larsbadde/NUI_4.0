
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

object showHandFrame extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[TrainingData,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*3.2*/(trainingData: TrainingData):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*3.30*/("""
"""),_display_(/*4.2*/main("Einzelframe")/*4.21*/ {_display_(Seq[Any](format.raw/*4.23*/("""
    """),format.raw/*5.5*/("""<link rel="stylesheet" href='"""),_display_(/*5.35*/routes/*5.41*/.Assets.versioned("dataTables/DataTables-1.10.15/css/dataTables.bootstrap.css")),format.raw/*5.120*/("""'>
    <link rel="stylesheet" href='"""),_display_(/*6.35*/routes/*6.41*/.Assets.versioned("dataTables/Select-1.2.2/css/select.bootstrap.min.css")),format.raw/*6.114*/("""'>
    <link rel="stylesheet" href='"""),_display_(/*7.35*/routes/*7.41*/.Assets.versioned("dataTables/FixedHeader-3.1.2/css/fixedHeader.bootstrap.min.css")),format.raw/*7.124*/("""'>

    <script type='text/javascript' src='"""),_display_(/*9.42*/routes/*9.48*/.Assets.versioned("dataTables/DataTables-1.10.15/js/jquery.dataTables.min.js")),format.raw/*9.126*/("""'></script>
    <script type='text/javascript' src='"""),_display_(/*10.42*/routes/*10.48*/.Assets.versioned("dataTables/DataTables-1.10.15/js/dataTables.bootstrap.min.js")),format.raw/*10.129*/("""'></script>
    <script type='text/javascript' src='"""),_display_(/*11.42*/routes/*11.48*/.Assets.versioned("dataTables/Select-1.2.2/js/dataTables.select.min.js")),format.raw/*11.120*/("""'></script>
    <script type='text/javascript' src='"""),_display_(/*12.42*/routes/*12.48*/.Assets.versioned("dataTables/FixedHeader-3.1.2/js/dataTables.fixedHeader.min.js")),format.raw/*12.130*/("""'></script>

    <script>
        function openSession(element)
        """),format.raw/*16.9*/("""{"""),format.raw/*16.10*/("""
            """),format.raw/*17.13*/("""open("//"+window.location.host+"/ShowTrainingSession/"+document.getElementById("session_id").innerHTML, "_self");
        """),format.raw/*18.9*/("""}"""),format.raw/*18.10*/("""
        """),format.raw/*19.9*/("""function skip(how) """),format.raw/*19.28*/("""{"""),format.raw/*19.29*/("""
            """),format.raw/*20.13*/("""open("//"+window.location.host+"/ShowSingleTrainingFrame/"+parseInt(parseInt(document.getElementById("td_id").innerHTML)+how).toString(), "_self");
        """),format.raw/*21.9*/("""}"""),format.raw/*21.10*/("""
        """),format.raw/*22.9*/("""</script>

""")))}/*24.2*/ {_display_(Seq[Any](format.raw/*24.4*/("""
    """),format.raw/*25.5*/("""<div class="container-fluid">


        <div class="btn-group">
            <button class="btn btn-default" type="button" onclick="skip(-1)"><span class="glyphicon glyphicon-menu-left" aria-hidden="true"></span></button>
            <button class="btn btn-default" type="button" onclick="skip(1)"><span class="glyphicon glyphicon-menu-right" aria-hidden="true"></span></button>
            <br>
        </div>

        <br>
        <div class="table-responsive">
            <table id="frame_table" class="table table-striped table-bordered table-responsive">
                <thead></thead>

                <tbody id="frame-table-body">
                    <tr>
                        <td><strong>ID</strong></td>
                        <td id="td_id">"""),_display_(/*42.41*/trainingData/*42.53*/.id),format.raw/*42.56*/("""</td>
                    </tr>
                    <tr>
                        <td><strong>User</strong></td>
                        <td>"""),_display_(/*46.30*/trainingData/*46.42*/.user.prename),format.raw/*46.55*/("""  """),_display_(/*46.58*/trainingData/*46.70*/.user.surname),format.raw/*46.83*/("""  """),format.raw/*46.85*/("""(ID: """),_display_(/*46.91*/trainingData/*46.103*/.user.id),format.raw/*46.111*/(""", rechtshändig: """),_display_(/*46.128*/trainingData/*46.140*/.user.right_handed),format.raw/*46.158*/(""")</td>
                    </tr>
                    <tr  >
                        <td><strong>SessionID</strong></td>
                        <td id="session_id" ondblclick="openSession(this)">"""),_display_(/*50.77*/trainingData/*50.89*/.SessionID),format.raw/*50.99*/("""</td>
                    </tr>
                    <tr>
                        <td><strong>Geste</strong></td>
                        <td> """),_display_(/*54.31*/trainingData/*54.43*/.gesture.id),format.raw/*54.54*/(""" """),_display_(/*54.56*/trainingData/*54.68*/.gesture.name),format.raw/*54.81*/(""" """),format.raw/*54.82*/("""</td>
                    </tr>
                    <tr>
                        <td><strong>Device</strong></td>
                        <td>"""),_display_(/*58.30*/trainingData/*58.42*/.device.id),format.raw/*58.52*/(""" """),format.raw/*58.53*/(""": """),_display_(/*58.56*/trainingData/*58.68*/.device.name),format.raw/*58.80*/("""</td>
                    </tr>
                    <tr>
                        <td><strong>HandID</strong></td>
                        <td>"""),_display_(/*62.30*/trainingData/*62.42*/.HandID),format.raw/*62.49*/("""</td>
                    </tr>
                    <tr>
                        <td><strong>timestamp</strong></td>
                        <td>"""),_display_(/*66.30*/trainingData/*66.42*/.timestamp),format.raw/*66.52*/("""</td>
                    </tr>
                    <tr>
                        <td><strong>isRight</strong></td>
                        <td>"""),_display_(/*70.30*/trainingData/*70.42*/.isRight),format.raw/*70.50*/("""</td>
                    </tr>
                    <tr>
                        <td><strong>Handposition [X, Y, Z]</strong></td>
                        <td>"""),_display_(/*74.30*/trainingData/*74.42*/.HandPosition_X),format.raw/*74.57*/("""</td>
                        <td>"""),_display_(/*75.30*/trainingData/*75.42*/.HandPosition_Y),format.raw/*75.57*/("""</td>
                        <td>"""),_display_(/*76.30*/trainingData/*76.42*/.HandPosition_Z),format.raw/*76.57*/("""</td>
                    </tr>
                    <tr>
                        <td><strong>PalmNormal [pitch, yaw, roll] </strong></td>
                        <td>"""),_display_(/*80.30*/trainingData/*80.42*/.PalmNormal_pitch),format.raw/*80.59*/("""</td>
                        <td>"""),_display_(/*81.30*/trainingData/*81.42*/.PalmNormal_yaw),format.raw/*81.57*/("""</td>
                        <td>"""),_display_(/*82.30*/trainingData/*82.42*/.PalmNormal_roll),format.raw/*82.58*/("""</td>
                    </tr>
                    <tr>
                        <td><strong>grabAngle</strong></td>
                        <td>"""),_display_(/*86.30*/trainingData/*86.42*/.grabAngle),format.raw/*86.52*/("""</td>
                    </tr>
                    <tr>
                        <td><strong>pinchDistance</strong></td>
                        <td>"""),_display_(/*90.30*/trainingData/*90.42*/.pinchDistance),format.raw/*90.56*/("""</td>
                    </tr>
                    <tr>
                        <th>Finger</th>
                    </tr>
                    <tr>
                        <th></th>
                        <th>Daumen</th>
                    </tr>
                    <tr>
                        <td><strong>Richtung [pitch, yaw, roll] </strong></td>
                        <td>"""),_display_(/*101.30*/trainingData/*101.42*/.THUMB_Direction_pitch),format.raw/*101.64*/("""</td>
                        <td>"""),_display_(/*102.30*/trainingData/*102.42*/.THUMB_Direction_yaw),format.raw/*102.62*/("""</td>
                        <td>"""),_display_(/*103.30*/trainingData/*103.42*/.THUMB_Direction_roll),format.raw/*103.63*/("""</td>
                    </tr>
                    <tr>
                        <td><strong>Position (Distal) [X, Y, Z]</strong></td>
                        <td>"""),_display_(/*107.30*/trainingData/*107.42*/.THUMB_Center_X),format.raw/*107.57*/("""</td>
                        <td>"""),_display_(/*108.30*/trainingData/*108.42*/.THUMB_Center_Y),format.raw/*108.57*/("""</td>
                        <td>"""),_display_(/*109.30*/trainingData/*109.42*/.THUMB_Center_Z),format.raw/*109.57*/("""</td>
                    </tr>
                    <tr>
                        <th></th>
                        <th>Zeigefinger</th>
                    </tr>
                    <tr>
                        <td><strong>Richtung [pitch, yaw, roll]</strong></td>
                        <td>"""),_display_(/*117.30*/trainingData/*117.42*/.INDEX_Direction_pitch),format.raw/*117.64*/("""</td>
                        <td>"""),_display_(/*118.30*/trainingData/*118.42*/.INDEX_Direction_yaw),format.raw/*118.62*/("""</td>
                        <td>"""),_display_(/*119.30*/trainingData/*119.42*/.INDEX_Direction_roll),format.raw/*119.63*/("""</td>
                    </tr>
                    <tr>
                        <td><strong>Position (Distal) [X, Y, Z]</strong></td>
                        <td>"""),_display_(/*123.30*/trainingData/*123.42*/.INDEX_Center_X),format.raw/*123.57*/("""</td>
                        <td>"""),_display_(/*124.30*/trainingData/*124.42*/.INDEX_Center_Y),format.raw/*124.57*/("""</td>
                        <td>"""),_display_(/*125.30*/trainingData/*125.42*/.INDEX_Center_Z),format.raw/*125.57*/("""</td>
                    </tr>
                    <tr>
                        <th></th>
                        <th>Mittelfinger</th>
                    </tr>
                    <tr>
                        <td><strong>Richtung [pitch, yaw, roll]</strong></td>
                        <td>"""),_display_(/*133.30*/trainingData/*133.42*/.MIDDLE_Direction_pitch),format.raw/*133.65*/("""</td>
                        <td>"""),_display_(/*134.30*/trainingData/*134.42*/.MIDDLE_Direction_yaw),format.raw/*134.63*/("""</td>
                        <td>"""),_display_(/*135.30*/trainingData/*135.42*/.MIDDLE_Direction_roll),format.raw/*135.64*/("""</td>
                    </tr>
                    <tr>
                        <td><strong>Position (Distal) [X, Y, Z]</strong></td>
                        <td>"""),_display_(/*139.30*/trainingData/*139.42*/.MIDDLE_Center_X),format.raw/*139.58*/("""</td>
                        <td>"""),_display_(/*140.30*/trainingData/*140.42*/.MIDDLE_Center_Y),format.raw/*140.58*/("""</td>
                        <td>"""),_display_(/*141.30*/trainingData/*141.42*/.MIDDLE_Center_Z),format.raw/*141.58*/("""</td>
                    </tr>
                    <tr>
                        <th></th>
                        <th>Ringfinger</th>
                    </tr>
                    <tr>
                        <td><strong>Richtung [pitch, yaw, roll]</strong></td>
                        <td>"""),_display_(/*149.30*/trainingData/*149.42*/.RING_Direction_pitch),format.raw/*149.63*/("""</td>
                        <td>"""),_display_(/*150.30*/trainingData/*150.42*/.RING_Direction_yaw),format.raw/*150.61*/("""</td>
                        <td>"""),_display_(/*151.30*/trainingData/*151.42*/.RING_Direction_roll),format.raw/*151.62*/("""</td>
                    </tr>
                    <tr>
                        <td><strong>Position (Ditsal) [X, Y, Z]</strong></td>
                        <td>"""),_display_(/*155.30*/trainingData/*155.42*/.RING_Center_X),format.raw/*155.56*/("""</td>
                        <td>"""),_display_(/*156.30*/trainingData/*156.42*/.RING_Center_Y),format.raw/*156.56*/("""</td>
                        <td>"""),_display_(/*157.30*/trainingData/*157.42*/.RING_Center_Z),format.raw/*157.56*/("""</td>
                    </tr>
                    <tr>
                        <th></th>
                        <th>Pinky</th>
                    </tr>
                    <tr>
                        <td><strong>Richtung [pitch, yaw, roll]</strong></td>
                        <td>"""),_display_(/*165.30*/trainingData/*165.42*/.PINKY_Direction_pitch),format.raw/*165.64*/("""</td>
                        <td>"""),_display_(/*166.30*/trainingData/*166.42*/.PINKY_Direction_yaw),format.raw/*166.62*/("""</td>
                        <td>"""),_display_(/*167.30*/trainingData/*167.42*/.PINKY_Direction_roll),format.raw/*167.63*/("""</td>
                    </tr>
                    <tr>
                        <td><strong>Position (Distal) [X, Y, Z]</strong></td>
                        <td>"""),_display_(/*171.30*/trainingData/*171.42*/.PINKY_Center_X),format.raw/*171.57*/("""</td>
                        <td>"""),_display_(/*172.30*/trainingData/*172.42*/.PINKY_Center_Y),format.raw/*172.57*/("""</td>
                        <td>"""),_display_(/*173.30*/trainingData/*173.42*/.PINKY_Center_Z),format.raw/*173.57*/("""</td>
                    </tr>

                </tbody>
            </table>

        </div>
    </div>

""")))}))
      }
    }
  }

  def render(trainingData:TrainingData): play.twirl.api.HtmlFormat.Appendable = apply(trainingData)

  def f:((TrainingData) => play.twirl.api.HtmlFormat.Appendable) = (trainingData) => apply(trainingData)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Aug 28 14:26:32 CEST 2017
                  SOURCE: D:/NUI4.0/NUI4.0_Server/app/views/showHandFrame.scala.html
                  HASH: 6964f8f8d5feb69fe9d3da040051fc8dc4f6b489
                  MATRIX: 651->1|986->22|1109->50|1137->53|1164->72|1203->74|1235->80|1291->110|1305->116|1405->195|1469->233|1483->239|1577->312|1641->350|1655->356|1759->439|1832->486|1846->492|1945->570|2026->624|2041->630|2144->711|2225->765|2240->771|2334->843|2415->897|2430->903|2534->985|2637->1061|2666->1062|2708->1076|2858->1199|2887->1200|2924->1210|2971->1229|3000->1230|3042->1244|3226->1401|3255->1402|3292->1412|3324->1426|3363->1428|3396->1434|4197->2208|4218->2220|4242->2223|4414->2368|4435->2380|4469->2393|4499->2396|4520->2408|4554->2421|4584->2423|4617->2429|4639->2441|4669->2449|4714->2466|4736->2478|4776->2496|5003->2696|5024->2708|5055->2718|5229->2865|5250->2877|5282->2888|5311->2890|5332->2902|5366->2915|5395->2916|5569->3063|5590->3075|5621->3085|5650->3086|5680->3089|5701->3101|5734->3113|5908->3260|5929->3272|5957->3279|6134->3429|6155->3441|6186->3451|6361->3599|6382->3611|6411->3619|6601->3782|6622->3794|6658->3809|6721->3845|6742->3857|6778->3872|6841->3908|6862->3920|6898->3935|7096->4106|7117->4118|7155->4135|7218->4171|7239->4183|7275->4198|7338->4234|7359->4246|7396->4262|7573->4412|7594->4424|7625->4434|7806->4588|7827->4600|7862->4614|8282->5006|8304->5018|8348->5040|8412->5076|8434->5088|8476->5108|8540->5144|8562->5156|8605->5177|8801->5345|8823->5357|8860->5372|8924->5408|8946->5420|8983->5435|9047->5471|9069->5483|9106->5498|9436->5800|9458->5812|9502->5834|9566->5870|9588->5882|9630->5902|9694->5938|9716->5950|9759->5971|9955->6139|9977->6151|10014->6166|10078->6202|10100->6214|10137->6229|10201->6265|10223->6277|10260->6292|10591->6595|10613->6607|10658->6630|10722->6666|10744->6678|10787->6699|10851->6735|10873->6747|10917->6769|11113->6937|11135->6949|11173->6965|11237->7001|11259->7013|11297->7029|11361->7065|11383->7077|11421->7093|11750->7394|11772->7406|11815->7427|11879->7463|11901->7475|11942->7494|12006->7530|12028->7542|12070->7562|12266->7730|12288->7742|12324->7756|12388->7792|12410->7804|12446->7818|12510->7854|12532->7866|12568->7880|12892->8176|12914->8188|12958->8210|13022->8246|13044->8258|13086->8278|13150->8314|13172->8326|13215->8347|13411->8515|13433->8527|13470->8542|13534->8578|13556->8590|13593->8605|13657->8641|13679->8653|13716->8668
                  LINES: 24->1|29->3|34->3|35->4|35->4|35->4|36->5|36->5|36->5|36->5|37->6|37->6|37->6|38->7|38->7|38->7|40->9|40->9|40->9|41->10|41->10|41->10|42->11|42->11|42->11|43->12|43->12|43->12|47->16|47->16|48->17|49->18|49->18|50->19|50->19|50->19|51->20|52->21|52->21|53->22|55->24|55->24|56->25|73->42|73->42|73->42|77->46|77->46|77->46|77->46|77->46|77->46|77->46|77->46|77->46|77->46|77->46|77->46|77->46|81->50|81->50|81->50|85->54|85->54|85->54|85->54|85->54|85->54|85->54|89->58|89->58|89->58|89->58|89->58|89->58|89->58|93->62|93->62|93->62|97->66|97->66|97->66|101->70|101->70|101->70|105->74|105->74|105->74|106->75|106->75|106->75|107->76|107->76|107->76|111->80|111->80|111->80|112->81|112->81|112->81|113->82|113->82|113->82|117->86|117->86|117->86|121->90|121->90|121->90|132->101|132->101|132->101|133->102|133->102|133->102|134->103|134->103|134->103|138->107|138->107|138->107|139->108|139->108|139->108|140->109|140->109|140->109|148->117|148->117|148->117|149->118|149->118|149->118|150->119|150->119|150->119|154->123|154->123|154->123|155->124|155->124|155->124|156->125|156->125|156->125|164->133|164->133|164->133|165->134|165->134|165->134|166->135|166->135|166->135|170->139|170->139|170->139|171->140|171->140|171->140|172->141|172->141|172->141|180->149|180->149|180->149|181->150|181->150|181->150|182->151|182->151|182->151|186->155|186->155|186->155|187->156|187->156|187->156|188->157|188->157|188->157|196->165|196->165|196->165|197->166|197->166|197->166|198->167|198->167|198->167|202->171|202->171|202->171|203->172|203->172|203->172|204->173|204->173|204->173
                  -- GENERATED --
              */
          