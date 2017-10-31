
// @GENERATOR:play-routes-compiler
// @SOURCE:D:/NUI_4.0/Server/Main/conf/routes
// @DATE:Tue Oct 31 10:27:23 CET 2017


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
