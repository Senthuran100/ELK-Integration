# ELK-Integration
ELK Stack integration with the spring boot and adding correlation Id


### Steps to be followed to integrate with ELK
 * First install the [Elastic-Search](https://www.elastic.co/downloads/elasticsearch) , [Kibana](https://www.elastic.co/downloads/kibana) and [Logstash](https://www.elastic.co/downloads/logstash).
 * Then start the Elastic-Search.
> Go to the bin and type ./elasticsearch

> Note :- Run the '''./elasticsearch-reset-password -u elastic -i elastic''' to change the password.
 * Then start the Kibana.
> Go to the **config/kibana.yml** and uncomment the below line.
> 
> elasticsearch.hosts: ["http://localhost:9200"]

 * Access the below link to configure the kibana
> http://localhost:5601/?code=xxxxxx

 * Then start the logstash by adding a **logstash.conf** file in the **config** directory of the logstash. </br>

   input { </br>
       file { </br>
               path => "<PATH_FOR_THE_LOGS>" </br>
               start_position => "beginning" </br>
       } </br>
   } </br>
   output { </br>
   stdout { </br>
        codec => rubydebug </br>
   } </br>
   elasticsearch { </br>
       ssl => true </br>
       ssl_certificate_verification => false </br>
       hosts => ["https://localhost:9200"]  </br>
       user => "elastic" </br>
       password => "R03-tLdGun_TXX7*acEh" </br>
   } </br>
   } </br>

   * Use the following command to run the logstash
   > ./bin/logstash -f config/logstash.conf