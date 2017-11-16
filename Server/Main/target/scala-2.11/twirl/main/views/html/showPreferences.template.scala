
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
/*3.2*/import services.rnn.TensorFlowGlobalValues.Preferences

object showPreferences extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[Preferences,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*4.2*/(preferences: Preferences):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*4.28*/("""
"""),_display_(/*5.2*/main("TensorFlow_Preferences")/*5.32*/ {_display_(Seq[Any](format.raw/*5.34*/("""
    """),format.raw/*6.5*/("""<link rel="stylesheet" href='"""),_display_(/*6.35*/routes/*6.41*/.Assets.versioned("dataTables/DataTables-1.10.15/css/dataTables.bootstrap.css")),format.raw/*6.120*/("""'>
    <link rel="stylesheet" href='"""),_display_(/*7.35*/routes/*7.41*/.Assets.versioned("dataTables/Select-1.2.2/css/select.bootstrap.min.css")),format.raw/*7.114*/("""'>
    <link rel="stylesheet" href='"""),_display_(/*8.35*/routes/*8.41*/.Assets.versioned("dataTables/FixedHeader-3.1.2/css/fixedHeader.bootstrap.min.css")),format.raw/*8.124*/("""'>

    <script type='text/javascript' src='"""),_display_(/*10.42*/routes/*10.48*/.Assets.versioned("dataTables/DataTables-1.10.15/js/jquery.dataTables.min.js")),format.raw/*10.126*/("""'></script>
    <script type='text/javascript' src='"""),_display_(/*11.42*/routes/*11.48*/.Assets.versioned("dataTables/DataTables-1.10.15/js/dataTables.bootstrap.min.js")),format.raw/*11.129*/("""'></script>
    <script type='text/javascript' src='"""),_display_(/*12.42*/routes/*12.48*/.Assets.versioned("dataTables/Select-1.2.2/js/dataTables.select.min.js")),format.raw/*12.120*/("""'></script>
    <script type='text/javascript' src='"""),_display_(/*13.42*/routes/*13.48*/.Assets.versioned("dataTables/FixedHeader-3.1.2/js/dataTables.fixedHeader.min.js")),format.raw/*13.130*/("""'></script>

    <script>

        function save_preferences() """),format.raw/*17.37*/("""{"""),format.raw/*17.38*/("""
            """),format.raw/*18.13*/("""alert("save")
        """),format.raw/*19.9*/("""}"""),format.raw/*19.10*/("""

    """),format.raw/*21.5*/("""</script>

    <style>
    .onoffswitch """),format.raw/*24.18*/("""{"""),format.raw/*24.19*/("""
        """),format.raw/*25.9*/("""position: relative; width: 90px;
        -webkit-user-select:none; -moz-user-select:none; -ms-user-select: none;
    """),format.raw/*27.5*/("""}"""),format.raw/*27.6*/("""
    """),format.raw/*28.5*/(""".onoffswitch-checkbox """),format.raw/*28.27*/("""{"""),format.raw/*28.28*/("""
        """),format.raw/*29.9*/("""display: none;
    """),format.raw/*30.5*/("""}"""),format.raw/*30.6*/("""
    """),format.raw/*31.5*/(""".onoffswitch-label """),format.raw/*31.24*/("""{"""),format.raw/*31.25*/("""
        """),format.raw/*32.9*/("""display: block; overflow: hidden; cursor: pointer;
        border: 2px solid #999999; border-radius: 20px;
    """),format.raw/*34.5*/("""}"""),format.raw/*34.6*/("""
    """),format.raw/*35.5*/(""".onoffswitch-inner """),format.raw/*35.24*/("""{"""),format.raw/*35.25*/("""
        """),format.raw/*36.9*/("""display: block; width: 200%; margin-left: -100%;
        transition: margin 0.3s ease-in 0s;
    """),format.raw/*38.5*/("""}"""),format.raw/*38.6*/("""
    """),format.raw/*39.5*/(""".onoffswitch-inner:before, .onoffswitch-inner:after """),format.raw/*39.57*/("""{"""),format.raw/*39.58*/("""
        """),format.raw/*40.9*/("""display: block; float: left; width: 50%; height: 30px; padding: 0; line-height: 30px;
        font-size: 14px; color: white; font-family: Trebuchet, Arial, sans-serif; font-weight: bold;
        box-sizing: border-box;
    """),format.raw/*43.5*/("""}"""),format.raw/*43.6*/("""
    """),format.raw/*44.5*/(""".onoffswitch-inner:before """),format.raw/*44.31*/("""{"""),format.raw/*44.32*/("""
        """),format.raw/*45.9*/("""content: "ON";
        padding-left: 10px;
        background-color: #34A7C1; color: #FFFFFF;
    """),format.raw/*48.5*/("""}"""),format.raw/*48.6*/("""
    """),format.raw/*49.5*/(""".onoffswitch-inner:after """),format.raw/*49.30*/("""{"""),format.raw/*49.31*/("""
        """),format.raw/*50.9*/("""content: "OFF";
        padding-right: 10px;
        background-color: #EEEEEE; color: #999999;
        text-align: right;
    """),format.raw/*54.5*/("""}"""),format.raw/*54.6*/("""
    """),format.raw/*55.5*/(""".onoffswitch-switch """),format.raw/*55.25*/("""{"""),format.raw/*55.26*/("""
        """),format.raw/*56.9*/("""display: block; width: 18px; margin: 6px;
        background: #FFFFFF;
        position: absolute; top: 0; bottom: 0;
        right: 56px;
        border: 2px solid #999999; border-radius: 20px;
        transition: all 0.3s ease-in 0s;
    """),format.raw/*62.5*/("""}"""),format.raw/*62.6*/("""
    """),format.raw/*63.5*/(""".onoffswitch-checkbox:checked + .onoffswitch-label .onoffswitch-inner """),format.raw/*63.75*/("""{"""),format.raw/*63.76*/("""
        """),format.raw/*64.9*/("""margin-left: 0;
    """),format.raw/*65.5*/("""}"""),format.raw/*65.6*/("""
    """),format.raw/*66.5*/(""".onoffswitch-checkbox:checked + .onoffswitch-label .onoffswitch-switch """),format.raw/*66.76*/("""{"""),format.raw/*66.77*/("""
        """),format.raw/*67.9*/("""right: 0px;
    """),format.raw/*68.5*/("""}"""),format.raw/*68.6*/("""


    """),format.raw/*71.5*/("""</style>




""")))}/*76.2*/ {_display_(Seq[Any](format.raw/*76.4*/("""
    """),format.raw/*77.5*/("""<div class="container-fluname">

        <h2><img src=""""),_display_(/*79.24*/routes/*79.30*/.Assets.versioned("images/tensorFlow_raw.png")),format.raw/*79.76*/("""" height="50"> Einstellungen  </h2>
        <div class="table-responsive">
            <table name="frame_table" class="table table-striped table-bordered table-responsive">
                <thead></thead>

                <tbody name="frame-table-body">
                    <form action = '"""),_display_(/*85.38*/routes/*85.44*/.TensorFlowController.TensorFlowPreferencesPOST()),format.raw/*85.93*/("""' method="post">

                        <td>

                            <button name="submit" type="submit" value="Submit" class="btn btn-primary">Submit</button>

                        </td>

                        <tr>
                            <td><strong>NR_OF_EPOCHS</strong></td>
                            <td name="NR_OF_EPOCHS"><input name ="NR_OF_EPOCHS" type="number" value="""),_display_(/*95.102*/preferences/*95.113*/.NR_OF_EPOCHS),format.raw/*95.126*/("""></input></td>
                        </tr>
                        <tr>
                            <td><strong>NR_OF_STEPS</strong></td>
                            <td name="NR_OF_STEPS"><input name="NR_OF_STEPS" type="number" value="""),_display_(/*99.99*/preferences/*99.110*/.NR_OF_STEPS),format.raw/*99.122*/("""></input></td>
                        </tr>
                        <tr>
                            <td><strong>NR_OF_LAYERS</strong></td>
                            <td name="NR_OF_LAYERS"><input name="NR_OF_LAYERS" type="number" value="""),_display_(/*103.101*/preferences/*103.112*/.NR_OF_LAYERS),format.raw/*103.125*/("""></input></td>
                        </tr>
                        <tr>
                            <td><strong>NR_OF_NEURONS</strong></td>
                            <td name="NR_OF_NEURONS"><input name="NR_OF_NEURONS" type="number" value="""),_display_(/*107.103*/preferences/*107.114*/.NR_OF_NEURONS),format.raw/*107.128*/("""></input></td>
                        </tr>
                        <tr>
                            <td><strong>NR_OF_OUTPUTS</strong></td>
                            <td name="NR_OF_OUTPUTS"><input name="NR_OF_OUTPUTS" type="number" value="""),_display_(/*111.103*/preferences/*111.114*/.NR_OF_OUTPUTS),format.raw/*111.128*/("""></input></td>
                        </tr>
                        <tr>
                            <td><strong>NR_OF_INPUTS</strong></td>
                            <td name="NR_OF_INPUTS"><input name="NR_OF_INPUTS" type="number" value="""),_display_(/*115.101*/preferences/*115.112*/.NR_OF_INPUTS),format.raw/*115.125*/("""></input></td>
                        </tr>
                        <tr>
                            <td><strong>BATCH_SIZE</strong></td>
                            <td name="BATCH_SIZE"><input name="BATCH_SIZE" type="number" value="""),_display_(/*119.97*/preferences/*119.108*/.BATCH_SIZE),format.raw/*119.119*/("""></input></td>
                        </tr>
                        <tr>
                            <td><strong>PREPROCESS_COLLAPSE_REPEATED</strong></td>
                            <td name="PREPROCESS_COLLAPSE_REPEATED"><input name="PREPROCESS_COLLAPSE_REPEATED" type="text" value="""),_display_(/*123.131*/preferences/*123.142*/.PREPROCESS_COLLAPSE_REPEATED),format.raw/*123.171*/("""></input>

                            </td>
                        </tr>
                        <tr>
                            <td><strong>CTC_MERGE_REPEATED</strong></td>
                            <td name="CTC_MERGE_REPEATED"><input name="CTC_MERGE_REPEATED" type="text" value="""),_display_(/*129.111*/preferences/*129.122*/.CTC_MERGE_REPEATED),format.raw/*129.141*/("""></input></td>
                        </tr>
                        <tr>
                            <td><strong>APPLY_DROPOUT</strong></td>
                            <td name="APPLY_DROPOUT"><input name="APPLY_DROPOUT" type="text" value="""),_display_(/*133.101*/preferences/*133.112*/.APPLY_DROPOUT),format.raw/*133.126*/("""></input></td>
                        </tr>
                        <tr>
                            <td><strong>KEEP_PROB</strong></td>
                            <td name="KEEP_PROB"><input name="KEEP_PROB" type="number" step="0.1" value="""),_display_(/*137.106*/preferences/*137.117*/.KEEP_PROB),format.raw/*137.127*/("""></input></td>
                        </tr>
                        <tr>
                            <td><strong>ACTIVATION</strong></td>
                            <td name="ACTIVATION"><input name="ACTIVATION" type="text" value="""),_display_(/*141.95*/preferences/*141.106*/.ACTIVATION),format.raw/*141.117*/("""></input></td>
                        </tr>
                        <tr>
                            <td><strong>LEARNING_RATE</strong></td>
                            <td name="LEARNING_RATE"><input name="LEARNING_RATE" type="number" step="0.0001" value="""),_display_(/*145.117*/preferences/*145.128*/.LEARNING_RATE),format.raw/*145.142*/("""></input></td>
                        </tr>
                        <tr>
                            <td><strong>OPTIMIZER</strong></td>
                            <td name="OPTIMIZER"><input name="OPTIMIZER" type="text" value="""),_display_(/*149.93*/preferences/*149.104*/.OPTIMIZER),format.raw/*149.114*/("""></input></td>
                        </tr>
                        <tr>
                            <td><strong>MOMENTUM</strong></td>
                            <td name="MOMENTUM"><input name="MOMENTUM" type="number" step="0.1" value="""),_display_(/*153.104*/preferences/*153.115*/.MOMENTUM),format.raw/*153.124*/("""></input></td>
                        </tr>
                        <tr>
                            <td><strong>EPSILON</strong></td>
                            <td name="EPSILON"><input name="EPSILON" type="number" step="0.00000001" value="""),_display_(/*157.109*/preferences/*157.120*/.EPSILON),format.raw/*157.128*/("""></input></td>
                        </tr>
                        <tr>
                            <td><strong>DECAY_1</strong></td>
                            <td name="DECAY_1"><input name="DECAY_1" type="number" step="0.1" value="""),_display_(/*161.102*/preferences/*161.113*/.DECAY_1),format.raw/*161.121*/("""></input></td>
                        </tr>
                        <tr>
                            <td><strong>DECAY_2</strong></td>
                            <td name="DECAY_2"><input name="DECAY_2" type="number" step="0.0001" value="""),_display_(/*165.105*/preferences/*165.116*/.DECAY_2),format.raw/*165.124*/("""></input></td>
                        </tr>
                        <tr>
                            <td><strong>USE_LOCKING</strong></td>
                            <td name="USE_LOCKING"><input name="USE_LOCKING" type="text" value="""),_display_(/*169.97*/preferences/*169.108*/.USE_LOCKING),format.raw/*169.120*/("""></input></td>
                        </tr>
                        <tr>
                            <td><strong>CENTERED</strong></td>
                            <td name="CENTERED"><input name="CENTERED" type="text" value="""),_display_(/*173.91*/preferences/*173.102*/.CENTERED),format.raw/*173.111*/("""></input></td>
                        </tr>

                        <tr>
                            <td><strong>MIN_ACC</strong></td>
                            <td name="MIN_ACC"><input name="MIN_ACC" type="number" step="0.0001" value="""),_display_(/*178.105*/preferences/*178.116*/.MIN_ACC),format.raw/*178.124*/("""></input></td>
                        </tr>
                        <tr>
                            <td><strong>MAX_FKP</strong></td>
                            <td name="MAX_FKP"><input name="MAX_FKP" type="number" step="0.0001" value="""),_display_(/*182.105*/preferences/*182.116*/.MAX_FKP),format.raw/*182.124*/("""></input></td>
                        </tr>
                        <tr>
                            <td><strong>MAX_EPOCHS_SICNE_LAST_MAX</strong></td>
                            <td name="MAX_EPOCHS_SICNE_LAST_MAX"><input name="MAX_EPOCHS_SICNE_LAST_MAX" type="number" value="""),_display_(/*186.127*/preferences/*186.138*/.MAX_EPOCHS_SICNE_LAST_MAX),format.raw/*186.164*/("""></input></td>
                        </tr>
                        <tr>
                            <td><strong>MAX_TIMES_MAX_REACHED</strong></td>
                            <td name="MAX_TIMES_MAX_REACHED"><input name="MAX_TIMES_MAX_REACHED" type="number" value="""),_display_(/*190.119*/preferences/*190.130*/.MAX_TIMES_MAX_REACHED),format.raw/*190.152*/("""></input></td>
                        </tr>


                        <td>

                            <button name="submit" type="submit" value="Submit" class="btn btn-primary">Submit</button>

                        </td>

                    </form>






                </tbody>
            </table>

        </div>
    </div>
""")))}))
      }
    }
  }

  def render(preferences:Preferences): play.twirl.api.HtmlFormat.Appendable = apply(preferences)

  def f:((Preferences) => play.twirl.api.HtmlFormat.Appendable) = (preferences) => apply(preferences)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Thu Nov 16 13:50:48 CET 2017
                  SOURCE: D:/NUI_4.0/Server/Main/app/views/showPreferences.scala.html
                  HASH: 3059f1a7002b59447af97e95e1068f2dcd3f3897
                  MATRIX: 651->1|675->22|1049->79|1170->105|1198->108|1236->138|1275->140|1307->146|1363->176|1377->182|1477->261|1541->299|1555->305|1649->378|1713->416|1727->422|1831->505|1905->552|1920->558|2020->636|2101->690|2116->696|2219->777|2300->831|2315->837|2409->909|2490->963|2505->969|2609->1051|2704->1118|2733->1119|2775->1133|2825->1156|2854->1157|2889->1165|2960->1208|2989->1209|3026->1219|3172->1338|3200->1339|3233->1345|3283->1367|3312->1368|3349->1378|3396->1398|3424->1399|3457->1405|3504->1424|3533->1425|3570->1435|3710->1548|3738->1549|3771->1555|3818->1574|3847->1575|3884->1585|4010->1684|4038->1685|4071->1691|4151->1743|4180->1744|4217->1754|4470->1980|4498->1981|4531->1987|4585->2013|4614->2014|4651->2024|4779->2125|4807->2126|4840->2132|4893->2157|4922->2158|4959->2168|5117->2299|5145->2300|5178->2306|5226->2326|5255->2327|5292->2337|5565->2583|5593->2584|5626->2590|5724->2660|5753->2661|5790->2671|5838->2692|5866->2693|5899->2699|5998->2770|6027->2771|6064->2781|6108->2798|6136->2799|6173->2809|6210->2828|6249->2830|6282->2836|6367->2894|6382->2900|6449->2946|6774->3244|6789->3250|6859->3299|7293->3705|7314->3716|7349->3729|7618->3971|7639->3982|7673->3994|7947->4239|7969->4250|8005->4263|8282->4511|8304->4522|8341->4536|8618->4784|8640->4795|8677->4809|8951->5054|8973->5065|9009->5078|9276->5317|9298->5328|9332->5339|9652->5630|9674->5641|9726->5670|10048->5963|10070->5974|10112->5993|10387->6239|10409->6250|10446->6264|10722->6511|10744->6522|10777->6532|11042->6769|11064->6780|11098->6791|11389->7053|11411->7064|11448->7078|11710->7312|11732->7323|11765->7333|12038->7577|12060->7588|12092->7597|12369->7845|12391->7856|12422->7864|12692->8105|12714->8116|12745->8124|13018->8368|13040->8379|13071->8387|13339->8627|13361->8638|13396->8650|13655->8881|13677->8892|13709->8901|13984->9147|14006->9158|14037->9166|14310->9410|14332->9421|14363->9429|14676->9713|14698->9724|14747->9750|15048->10022|15070->10033|15115->10055
                  LINES: 24->1|25->3|30->4|35->4|36->5|36->5|36->5|37->6|37->6|37->6|37->6|38->7|38->7|38->7|39->8|39->8|39->8|41->10|41->10|41->10|42->11|42->11|42->11|43->12|43->12|43->12|44->13|44->13|44->13|48->17|48->17|49->18|50->19|50->19|52->21|55->24|55->24|56->25|58->27|58->27|59->28|59->28|59->28|60->29|61->30|61->30|62->31|62->31|62->31|63->32|65->34|65->34|66->35|66->35|66->35|67->36|69->38|69->38|70->39|70->39|70->39|71->40|74->43|74->43|75->44|75->44|75->44|76->45|79->48|79->48|80->49|80->49|80->49|81->50|85->54|85->54|86->55|86->55|86->55|87->56|93->62|93->62|94->63|94->63|94->63|95->64|96->65|96->65|97->66|97->66|97->66|98->67|99->68|99->68|102->71|107->76|107->76|108->77|110->79|110->79|110->79|116->85|116->85|116->85|126->95|126->95|126->95|130->99|130->99|130->99|134->103|134->103|134->103|138->107|138->107|138->107|142->111|142->111|142->111|146->115|146->115|146->115|150->119|150->119|150->119|154->123|154->123|154->123|160->129|160->129|160->129|164->133|164->133|164->133|168->137|168->137|168->137|172->141|172->141|172->141|176->145|176->145|176->145|180->149|180->149|180->149|184->153|184->153|184->153|188->157|188->157|188->157|192->161|192->161|192->161|196->165|196->165|196->165|200->169|200->169|200->169|204->173|204->173|204->173|209->178|209->178|209->178|213->182|213->182|213->182|217->186|217->186|217->186|221->190|221->190|221->190
                  -- GENERATED --
              */
          