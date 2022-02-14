package Scala.learning.testExercise

import org.mongodb.scala.bson.collection.mutable.Document
import org.mongodb.scala.{MongoClient, MongoCollection, MongoDatabase}

object MongoFactory extends App {
  val uri:String="mongodb+srv://sai-charan:test@cluster0.gdn7t.mongodb.net"
  System.setProperty("org.mongodb.async.type","netty")
  val client:MongoClient=MongoClient(uri)
  val db:MongoDatabase=client.getDatabase("scalatest")
  val collection:MongoCollection[Document]=db.getCollection("my-coll")
  val document:Document=Document("_id"->1,"x"->1)
//  val insertObservable:SingleObservable[InsertOneResult]=collection.insertOne(document)
//  insertObservable.subscribe(new SingleObservable[InsertOneResult]  {
//    override def onNext(result: Completed): Unit = println(s"onNext: $result")
//    override def onError(e: Throwable): Unit = println(s"onError: $e")
//    override def onComplete(): Unit = println("onComplete")
//  })
  val result=collection.insertOne(document)
  val a =collection.find().first()
}
