
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
                        <tr>
                            <td><strong>NR_OF_EPOCHS</strong></td>
                            <td name="NR_OF_EPOCHS"><input name ="NR_OF_EPOCHS" type="number" value="""),_display_(/*88.102*/preferences/*88.113*/.NR_OF_EPOCHS),format.raw/*88.126*/("""></input></td>
                        </tr>
                        <tr>
                            <td><strong>NR_OF_STEPS</strong></td>
                            <td name="NR_OF_STEPS"><input name="NR_OF_STEPS" type="number" value="""),_display_(/*92.99*/preferences/*92.110*/.NR_OF_STEPS),format.raw/*92.122*/("""></input></td>
                        </tr>
                        <tr>
                            <td><strong>NR_OF_LAYERS</strong></td>
                            <td name="NR_OF_LAYERS"><input name="NR_OF_LAYERS" type="number" value="""),_display_(/*96.101*/preferences/*96.112*/.NR_OF_LAYERS),format.raw/*96.125*/("""></input></td>
                        </tr>
                        <tr>
                            <td><strong>NR_OF_NEURONS</strong></td>
                            <td name="NR_OF_NEURONS"><input name="NR_OF_NEURONS" type="number" value="""),_display_(/*100.103*/preferences/*100.114*/.NR_OF_NEURONS),format.raw/*100.128*/("""></input></td>
                        </tr>
                        <tr>
                            <td><strong>NR_OF_OUTPUTS</strong></td>
                            <td name="NR_OF_OUTPUTS"><input name="NR_OF_OUTPUTS" type="number" value="""),_display_(/*104.103*/preferences/*104.114*/.NR_OF_OUTPUTS),format.raw/*104.128*/("""></input></td>
                        </tr>
                        <tr>
                            <td><strong>NR_OF_INPUTS</strong></td>
                            <td name="NR_OF_INPUTS"><input name="NR_OF_INPUTS" type="number" value="""),_display_(/*108.101*/preferences/*108.112*/.NR_OF_INPUTS),format.raw/*108.125*/("""></input></td>
                        </tr>
                        <tr>
                            <td><strong>BATCH_SIZE</strong></td>
                            <td name="BATCH_SIZE"><input name="BATCH_SIZE" type="number" value="""),_display_(/*112.97*/preferences/*112.108*/.BATCH_SIZE),format.raw/*112.119*/("""></input></td>
                        </tr>
                        <tr>
                            <td><strong>PREPROCESS_COLLAPSE_REPEATED</strong></td>
                            <td name="PREPROCESS_COLLAPSE_REPEATED"><input name="PREPROCESS_COLLAPSE_REPEATED" type="text" value="""),_display_(/*116.131*/preferences/*116.142*/.PREPROCESS_COLLAPSE_REPEATED),format.raw/*116.171*/("""></input>

                            </td>
                        </tr>
                        <tr>
                            <td><strong>CTC_MERGE_REPEATED</strong></td>
                            <td name="CTC_MERGE_REPEATED"><input name="CTC_MERGE_REPEATED" type="text" value="""),_display_(/*122.111*/preferences/*122.122*/.CTC_MERGE_REPEATED),format.raw/*122.141*/("""></input></td>
                        </tr>
                        <tr>
                            <td><strong>APPLY_DROPOUT</strong></td>
                            <td name="APPLY_DROPOUT"><input name="APPLY_DROPOUT" type="text" value="""),_display_(/*126.101*/preferences/*126.112*/.APPLY_DROPOUT),format.raw/*126.126*/("""></input></td>
                        </tr>
                        <tr>
                            <td><strong>KEEP_PROB</strong></td>
                            <td name="KEEP_PROB"><input name="KEEP_PROB" type="number" step="0.1" value="""),_display_(/*130.106*/preferences/*130.117*/.KEEP_PROB),format.raw/*130.127*/("""></input></td>
                        </tr>
                        <tr>
                            <td><strong>ACTIVATION</strong></td>
                            <td name="ACTIVATION"><input name="ACTIVATION" type="text" value="""),_display_(/*134.95*/preferences/*134.106*/.ACTIVATION),format.raw/*134.117*/("""></input></td>
                        </tr>
                        <tr>
                            <td><strong>LEARNING_RATE</strong></td>
                            <td name="LEARNING_RATE"><input name="LEARNING_RATE" type="number" step="0.0001" value="""),_display_(/*138.117*/preferences/*138.128*/.LEARNING_RATE),format.raw/*138.142*/("""></input></td>
                        </tr>
                        <tr>
                            <td><strong>OPTIMIZER</strong></td>
                            <td name="OPTIMIZER"><input name="OPTIMIZER" type="text" value="""),_display_(/*142.93*/preferences/*142.104*/.OPTIMIZER),format.raw/*142.114*/("""></input></td>
                        </tr>
                        <tr>
                            <td><strong>MOMENTUM</strong></td>
                            <td name="MOMENTUM"><input name="MOMENTUM" type="number" step="0.1" value="""),_display_(/*146.104*/preferences/*146.115*/.MOMENTUM),format.raw/*146.124*/("""></input></td>
                        </tr>
                        <tr>
                            <td><strong>EPSILON</strong></td>
                            <td name="EPSILON"><input name="EPSILON" type="number" step="0.00000001" value="""),_display_(/*150.109*/preferences/*150.120*/.EPSILON),format.raw/*150.128*/("""></input></td>
                        </tr>
                        <tr>
                            <td><strong>DECAY_1</strong></td>
                            <td name="DECAY_1"><input name="DECAY_1" type="number" step="0.1" value="""),_display_(/*154.102*/preferences/*154.113*/.DECAY_1),format.raw/*154.121*/("""></input></td>
                        </tr>
                        <tr>
                            <td><strong>DECAY_2</strong></td>
                            <td name="DECAY_2"><input name="DECAY_2" type="number" step="0.0001" value="""),_display_(/*158.105*/preferences/*158.116*/.DECAY_2),format.raw/*158.124*/("""></input></td>
                        </tr>
                        <tr>
                            <td><strong>USE_LOCKING</strong></td>
                            <td name="USE_LOCKING"><input name="USE_LOCKING" type="text" value="""),_display_(/*162.97*/preferences/*162.108*/.USE_LOCKING),format.raw/*162.120*/("""></input></td>
                        </tr>
                        <tr>
                            <td><strong>CENTERED</strong></td>
                            <td name="CENTERED"><input name="CENTERED" type="text" value="""),_display_(/*166.91*/preferences/*166.102*/.CENTERED),format.raw/*166.111*/("""></input></td>
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
                  DATE: Mon Oct 16 15:21:54 CEST 2017
                  SOURCE: D:/NUI4.0/NUI4.0_Server/app/views/showPreferences.scala.html
                  HASH: a924aab723e94e3d7289a316994a4f0fd4528ab5
                  MATRIX: 651->1|675->22|1049->79|1170->105|1198->108|1236->138|1275->140|1307->146|1363->176|1377->182|1477->261|1541->299|1555->305|1649->378|1713->416|1727->422|1831->505|1905->552|1920->558|2020->636|2101->690|2116->696|2219->777|2300->831|2315->837|2409->909|2490->963|2505->969|2609->1051|2704->1118|2733->1119|2775->1133|2825->1156|2854->1157|2889->1165|2960->1208|2989->1209|3026->1219|3172->1338|3200->1339|3233->1345|3283->1367|3312->1368|3349->1378|3396->1398|3424->1399|3457->1405|3504->1424|3533->1425|3570->1435|3710->1548|3738->1549|3771->1555|3818->1574|3847->1575|3884->1585|4010->1684|4038->1685|4071->1691|4151->1743|4180->1744|4217->1754|4470->1980|4498->1981|4531->1987|4585->2013|4614->2014|4651->2024|4779->2125|4807->2126|4840->2132|4893->2157|4922->2158|4959->2168|5117->2299|5145->2300|5178->2306|5226->2326|5255->2327|5292->2337|5565->2583|5593->2584|5626->2590|5724->2660|5753->2661|5790->2671|5838->2692|5866->2693|5899->2699|5998->2770|6027->2771|6064->2781|6108->2798|6136->2799|6173->2809|6210->2828|6249->2830|6282->2836|6367->2894|6382->2900|6449->2946|6774->3244|6789->3250|6859->3299|7104->3516|7125->3527|7160->3540|7429->3782|7450->3793|7484->3805|7757->4050|7778->4061|7813->4074|8090->4322|8112->4333|8149->4347|8426->4595|8448->4606|8485->4620|8759->4865|8781->4876|8817->4889|9084->5128|9106->5139|9140->5150|9460->5441|9482->5452|9534->5481|9856->5774|9878->5785|9920->5804|10195->6050|10217->6061|10254->6075|10530->6322|10552->6333|10585->6343|10850->6580|10872->6591|10906->6602|11197->6864|11219->6875|11256->6889|11518->7123|11540->7134|11573->7144|11846->7388|11868->7399|11900->7408|12177->7656|12199->7667|12230->7675|12500->7916|12522->7927|12553->7935|12826->8179|12848->8190|12879->8198|13147->8438|13169->8449|13204->8461|13463->8692|13485->8703|13517->8712
                  LINES: 24->1|25->3|30->4|35->4|36->5|36->5|36->5|37->6|37->6|37->6|37->6|38->7|38->7|38->7|39->8|39->8|39->8|41->10|41->10|41->10|42->11|42->11|42->11|43->12|43->12|43->12|44->13|44->13|44->13|48->17|48->17|49->18|50->19|50->19|52->21|55->24|55->24|56->25|58->27|58->27|59->28|59->28|59->28|60->29|61->30|61->30|62->31|62->31|62->31|63->32|65->34|65->34|66->35|66->35|66->35|67->36|69->38|69->38|70->39|70->39|70->39|71->40|74->43|74->43|75->44|75->44|75->44|76->45|79->48|79->48|80->49|80->49|80->49|81->50|85->54|85->54|86->55|86->55|86->55|87->56|93->62|93->62|94->63|94->63|94->63|95->64|96->65|96->65|97->66|97->66|97->66|98->67|99->68|99->68|102->71|107->76|107->76|108->77|110->79|110->79|110->79|116->85|116->85|116->85|119->88|119->88|119->88|123->92|123->92|123->92|127->96|127->96|127->96|131->100|131->100|131->100|135->104|135->104|135->104|139->108|139->108|139->108|143->112|143->112|143->112|147->116|147->116|147->116|153->122|153->122|153->122|157->126|157->126|157->126|161->130|161->130|161->130|165->134|165->134|165->134|169->138|169->138|169->138|173->142|173->142|173->142|177->146|177->146|177->146|181->150|181->150|181->150|185->154|185->154|185->154|189->158|189->158|189->158|193->162|193->162|193->162|197->166|197->166|197->166
                  -- GENERATED --
              */
          