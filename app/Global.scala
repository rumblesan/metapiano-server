import play.api.GlobalSettings

import com.rumblesan.puredata.PureData
import play.api.Play.current

import play.api.GlobalSettings

import play.api.Application

object Global extends GlobalSettings {

  override def onStart(app: Application) {
    val pdExe = current.configuration.getString("patchwerk.puredata").get
    val port = current.configuration.getInt("patchwerk.port").get
    val patch = current.configuration.getString("patchwerk.patch").get
    val paths = current.configuration.getString("patchwerk.paths").get.split(",").toList
    val extras = List.empty[String]

    PureData.startPD(pdExe, port, patch, paths, extras)
  }

}