package helpers

import com.google.inject._
import com.sun.javafx.binding.Logging
import org.mongodb.scala.{MongoClient, MongoDatabase}
import play.Configuration
import play.api.inject.ApplicationLifecycle

import scala.concurrent.Future

trait GlobalSingleton {}

@Singleton
class Global @Inject()(applicationLifecycle: ApplicationLifecycle) extends Logging{
  val mongoClient: MongoClient = MongoClient()

  // get handle to "mydb" database
  val database: MongoDatabase = mongoClient.getDatabase("mydb")
  // other initialize code here
  applicationLifecycle.addStopHook { () =>
    Future.successful(mongoClient.close())
  }
}


class ConfigureModules extends AbstractModule {
  override def configure() = { // or without override
    println("configure called")
    bind(classOf[Logging]).to(classOf[Global]).asEagerSingleton()
  }
}







