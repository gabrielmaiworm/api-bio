package br.com.biomob.restcontroller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/geocoding")
public class GetAdress {

  @GetMapping("/address")
  public String getAddress(
      @RequestParam("lat") double lat,
      @RequestParam("lng") double lng
  ) {
    try {
      // Cria a URL da requisição
      String urlString = String.format(
          "https://nominatim.openstreetmap.org/reverse?format=jsonv2&lat=%s&lon=%s",
          lat, lng
      );
      URL url = new URL(urlString);

      // Faz a requisição HTTP e lê a resposta
      URLConnection connection = url.openConnection();
      BufferedReader in = new BufferedReader(
          new InputStreamReader(connection.getInputStream())
      );
      StringBuilder response = new StringBuilder();
      String inputLine;
      while ((inputLine = in.readLine()) != null) {
        response.append(inputLine);
      }
      in.close();

      // Analisa a resposta em formato JSON
      JSONObject json = new JSONObject(response.toString());
      System.out.println(json); 
      if (json != null) {
    	  JSONObject result = new JSONObject(response.toString());
    	  
          // Obtém o endereço completo
          String endereço = result.getString("address");
          System.out.println(endereço);
        return endereço;
      } else {
        return "Não foi possível obter o endereço.";
      }
    } catch (Exception e) {
      return "Ocorreu um erro ao obter o endereço.";
    }
  }
}

