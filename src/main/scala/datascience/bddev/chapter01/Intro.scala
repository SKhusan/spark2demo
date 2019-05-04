package datascience.bddev.chapter01

import java.util.Date

import breeze.linalg.DenseVector

import scala.util.Random

/**
  * Author: Khusen Sharipov
  * Date: 02/05/2019
  * Time: 16:09
  */
object Intro {
  def main(args: Array[String]): Unit = {
    val random = Random
    val vowelsLower = "aeiou"
    val vowelsUppper = vowelsLower.toUpperCase
    val consonantsLower = "bcdfghjklmnpqrstvwxz"
    val consonantsUpper = consonantsLower.toUpperCase

    def generateName: String = {
      var name = String.valueOf(consonantsUpper.charAt(random.nextInt(consonantsLower.length)))
      name += vowelsLower.charAt(random.nextInt(vowelsLower.length))
      name += consonantsLower.charAt(random.nextInt(consonantsLower.length))
      String.valueOf(name)
    }

    def generateLastName: String = {
      var lastName = String.valueOf(consonantsUpper.charAt(random.nextInt(consonantsLower.length)))
      lastName += vowelsLower.charAt(random.nextInt(vowelsLower.length))
      lastName += consonantsLower.charAt(random.nextInt(consonantsLower.length))
      lastName += vowelsLower.charAt(random.nextInt(vowelsLower.length))
      lastName += consonantsLower.charAt(random.nextInt(consonantsLower.length))
      String.valueOf(lastName)
    }

    def generateGender: Char = {
      val genders = List('M', 'F')
      genders(random.nextInt(2))
    }

    def generateAge: Int = {
      val ages = List.range(18, 30)
      val randomAge = ages(random.nextInt(ages.length))
      randomAge
    }


    def generateFaculityName: String = {
      val faculties = List("IT", "Management", "Sales", "Service")
      faculties(random.nextInt(faculties.length))
    }

    def generateAdmissionDate: Date = {
      val years = List.range(2000, 2018, 1)
      val date = new Date(s"${years(random.nextInt(years.length))}/09/01")
      date
    }

    /*def generatedAvgScores: Double = {
      val scores = List.range(5.0, 10.0, 0.5)
      scores(random.nextInt(scores.length))
    }*//*


    def generatedStudents: List[Student] = {
      List.fill(100)(new Student(generateName + " " + generateLastName,
        generateAge,
        generateGender,
        generateAdmissionDate,
        generateFaculityName,
        random.nextDouble,
        random.nextBoolean
      ))
    }*/

   /* val students = generatedStudents.slice(0, 10)
    students.foreach(student => println(student))*/

    val studentsVector = DenseVector.fill[Student](100)(
      new Student(generateName + " " + generateLastName,
      generateAge,
      generateGender,
      generateAdmissionDate,
      generateFaculityName,
        BigDecimal(random.nextDouble).setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble,
      random.nextBoolean
    ))

    //println(studentsVector(-1))

    val subVector = studentsVector(3 until 10)
    subVector.data.foreach(println)

  }


}
