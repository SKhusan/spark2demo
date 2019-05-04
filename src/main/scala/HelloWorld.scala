import org.apache.log4j.{Level, Logger}
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Author: Khusen Sharipov
  * Date: Март 15, 2019
  * Time: 11:47
  */
object HelloWorld {
  def main(args: Array[String]): Unit = {
    Logger.getLogger("spark2demo").setLevel(Level.ERROR)
    val conf = new SparkConf().setAppName("wordcounts").setMaster("local")
    val sc = new SparkContext(conf)

    val lines = sc.textFile(getClass.getClassLoader.getResource("word_count.txt").getFile)
    val words = lines.flatMap(_.split(" "))
    val counts = words.countByValue()
    for ((word, count) <- counts){
      println(word + " " + count)
    }
  }
}
