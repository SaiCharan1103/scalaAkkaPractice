package Akka.test.employee

import com.mongodb.MongoCredential.createCredential
import com.mongodb.{MongoClientSettings, MongoCredential, ServerAddress}
import org.bson.codecs.configuration.CodecRegistries
import org.bson.codecs.configuration.CodecRegistries.fromRegistries
import org.bson.codecs.jsr310.LocalDateTimeCodec
import org.mongodb.scala.MongoClient.DEFAULT_CODEC_REGISTRY
import org.mongodb.scala.{MongoClient, MongoDatabase}
import scala.collection.JavaConverters.asJavaIterableConverter


object MongoClientSettings {
  private val javaCodecs = CodecRegistries.fromCodecs(
    new LocalDateTimeCodec())
  val user: String = "root"
  val password: Array[Char] = "example".toCharArray
  val source: String = "admin"
  private val credential: MongoCredential = createCredential(user, source, password)

//  val settings: MongoClientSettings = MongoClientSettings.builder()
//    .applyToClusterSettings(b => b.hosts(List(new ServerAddress("localhost")).asJava))
//    .credential(credential)
//   .codecRegistry(fromRegistries(registry, javaCodecs, DEFAULT_CODEC_REGISTRY))
//    .build()
//
//  val client: MongoClient = MongoClient(settings)
//
//  val database: MongoDatabase = client.getDatabase("testdatabase")
}

