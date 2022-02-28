package Akka.Poc.mongoDB

import Akka.Poc.model.User
import com.typesafe.config.{Config, ConfigFactory}
import org.bson.codecs.configuration.CodecRegistries._
import org.bson.codecs.configuration.CodecRegistry
import org.mongodb.scala.MongoClient.DEFAULT_CODEC_REGISTRY
import org.mongodb.scala._
import org.mongodb.scala.bson.codecs.Macros._


object Mongo {
  lazy val config: Config = ConfigFactory.load()
  lazy val mongoClient: MongoClient = MongoClient(config.getString("mongo.uri"))
  lazy val codecRegistry: CodecRegistry = fromRegistries(fromProviders(classOf[User]), DEFAULT_CODEC_REGISTRY)
  lazy val database: MongoDatabase = mongoClient.getDatabase(config.getString("mongo.database")).withCodecRegistry(codecRegistry)

  lazy val userCollection: MongoCollection[User] = database.getCollection[User]("users")
  println()
}