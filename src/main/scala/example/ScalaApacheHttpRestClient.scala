package example

import java.nio.charset.StandardCharsets

import org.apache.http.HttpStatus
import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.HttpClients
import org.apache.http.util.EntityUtils

object Sample {

  def runSample() = {
    println("*** runSample *** start ***")

    val charset = StandardCharsets.UTF_8

    val httpclient = HttpClients.createDefault()

    val request = new HttpGet(
      "https://postman-echo.com/get?foo1=bar1&foo2=bar2")

    val response = httpclient.execute(request)

    val status = response.getStatusLine().getStatusCode()
    println(Console.GREEN + "HTTP status:" + status + Console.RESET)
    println()

    if (status == HttpStatus.SC_OK) {
      val responseData = EntityUtils.toString(response.getEntity, charset)
      println(Console.CYAN + responseData + Console.RESET)
    }

    if (response != null) {
      response.close()
    }
    if (httpclient != null) {
      httpclient.close()
    }

    println("*** runSample *** end ***")
  }
}

// -----------------------------------------------------------------------
object ScalaApacheHttpRestClient {
  def main(args: Array[String]) {
    println("*** Starting ***")

    Sample.runSample()

    println("*** Finished ***")
  }
}
